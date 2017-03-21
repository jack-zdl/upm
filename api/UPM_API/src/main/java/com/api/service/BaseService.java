package com.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.api.constant.SysConstants;
import com.api.dao.OperateLogDao;
import com.api.dao.SiteDao;
import com.api.entity.DefinitionEntity;
import com.api.entity.DictEntity;
import com.api.entity.DictTypeEntity;
import com.api.entity.OperateLogEntity;
import com.api.entity.SiteEntity;
import com.api.exception.APIException;
import com.api.exception.HttpClientException;
import com.api.exception.HttpConnectionException;
import com.api.util.DateUtils;
import com.api.util.HttpClientUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;
import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.State;
import com.orbitz.consul.model.health.HealthCheck;
import com.orbitz.consul.model.health.ServiceHealth;

public abstract class BaseService {

	@Resource
	protected OperateLogDao operateLogDao;

	@Resource
	protected SiteDao siteDao;

	@Resource
	protected DictTypeService dictTypeService;
	
	@Resource
	protected DefinitionService definitionService;

	/**
	 * ��־����
	 */
	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * ����վ������ȡhttpUrl
	 * 
	 * @param siteId
	 *            վ�����
	 * @return ����ӿںͼ�ؽӿ�url��ֵ�ԡ�SysConstants.MANAGEHTTPURL:����ӿ�url
	 *         SysConstants.MONITORHTTPURL:��ؽӿ�url
	 */
	public Map<String, String> getHttpUrlBySiteId(String siteId) {
		SiteEntity site = siteDao.get(siteId);
		if (site != null) {
			String consulIps = site.getConsulIps();
			int consulPort = site.getConsulPort();
			String mgmPrefix = site.getMgmPrefix();
			String horusServerPrefix = site.getHorusServerPrefix();
			return getHttpUrl(consulIps, consulPort, mgmPrefix, horusServerPrefix);
		}
		return null;
	}

	/**
	 * ����consul��ַ,�˿�,��Դ������������ͼ�ع������������ȡhttpUrl
	 * 
	 * @param consulIps
	 *            consul��ַ
	 * @param consulPort
	 *            consul�˿�
	 * @param mgmPrefix
	 *            ��Դ�����������
	 * @param horusServerPrefix
	 *            ��ع����������
	 * @return
	 */
	public Map<String, String> getHttpUrl(String consulIps, int consulPort, String mgmPrefix,
			String horusServerPrefix) {
		Map<String, String> httpUrlMap = new HashMap<String, String>();
		String[] consulIpArr = consulIps.split(";");
		Consul consul = null;
		for (String consulIp : consulIpArr) {
			HostAndPort hostAndPort = HostAndPort.fromParts(consulIp, consulPort);
			try {
				consul = Consul.builder().withHostAndPort(hostAndPort).build();
				break;
			} catch (Exception e) {

			}
		}
		if (consul != null) {
			HealthClient healthClient = consul.healthClient();
			List<HealthCheck> healthCheckList = healthClient.getChecksByState(State.PASS).getResponse();

			for (HealthCheck healthCheck : healthCheckList) {
				if (healthCheck.getServiceName().get().startsWith(mgmPrefix)) {
					List<ServiceHealth> serviceHealthList = healthClient
							.getHealthyServiceInstances(healthCheck.getServiceName().get()).getResponse();
					for (ServiceHealth serviceHealth : serviceHealthList) {
						if (serviceHealth.getService().getService().equals(healthCheck.getServiceName().get())) {
							String manageHttpUrl = "http://" + serviceHealth.getService().getAddress() + ":"
									+ serviceHealth.getService().getPort();
							httpUrlMap.put(SysConstants.HTTPURL_MANAGE, manageHttpUrl);
							break;
						}
					}
					break;
				}
			}

			for (HealthCheck healthCheck : healthCheckList) {
				if (healthCheck.getServiceName().get().startsWith(horusServerPrefix)) {
					List<ServiceHealth> serviceHealthList = healthClient
							.getHealthyServiceInstances(healthCheck.getServiceName().get()).getResponse();
					for (ServiceHealth serviceHealth : serviceHealthList) {
						if (serviceHealth.getService().getService().equals(healthCheck.getServiceName().get())) {
							String monitorHttpUrl = "http://" + serviceHealth.getService().getAddress() + ":"
									+ serviceHealth.getService().getPort();
							httpUrlMap.put(SysConstants.HTTPURL_MONITOR, monitorHttpUrl);
							break;
						}
					}
					break;
				}
			}
		}
		return httpUrlMap;
	}

	/**
	 * ����httpGet����
	 * 
	 * @param session
	 *            HttpSession ����
	 * @param siteId
	 *            վ�����
	 * @param interfaceType
	 *            �ӿ�����
	 * @param url
	 *            �ӿ�url
	 * @return ������
	 * @throws HttpConnectionException
	 *             http�����쳣
	 * @throws HttpClientException
	 *             httpClient�쳣
	 */
	public RespJson sendHttpGet(HttpSession session, String siteId, String interfaceType, String url)
			throws HttpConnectionException, HttpClientException {
		return sendHttp(session, siteId, interfaceType, url, HttpClientUtils.METHOD_GET, null);
	}

	/**
	 * ����httpPost�Ĵ�������
	 * 
	 * @param session
	 *            HttpSession ����
	 * @param siteId
	 *            վ�����
	 * @param interfaceType
	 *            �ӿ�����
	 * @param url
	 *            �ӿ�url
	 * @param jsonParam
	 *            ����
	 * @return ������
	 * @throws HttpConnectionException
	 *             http�����쳣
	 * @throws HttpClientException
	 *             httpClient�쳣
	 */
	public RespJson sendHttpPost(HttpSession session, String siteId, String interfaceType, String url,
			String jsonParam) throws HttpConnectionException, HttpClientException {
		return sendHttp(session, siteId, interfaceType, url, HttpClientUtils.METHOD_POST, jsonParam);
	}

	/**
	 * ����httpPut����
	 * 
	 * @param session
	 *            HttpSession ����
	 * @param siteId
	 *            վ�����
	 * @param interfaceType
	 *            �ӿ�����
	 * @param url
	 *            �ӿ�url
	 * @param jsonParam
	 *            ����
	 * @return ������
	 * @throws HttpConnectionException
	 *             http�����쳣
	 * @throws HttpClientException
	 *             httpClient�쳣
	 */
	public RespJson sendHttpPut(HttpSession session, String siteId, String interfaceType, String url, String jsonParam)
			throws HttpConnectionException, HttpClientException {
		return sendHttp(session, siteId, interfaceType, url, HttpClientUtils.METHOD_PUT, jsonParam);
	}

	/**
	 * ����httpDelete����
	 * 
	 * @param session
	 *            HttpSession ����
	 * @param siteId
	 *            վ�����
	 * @param interfaceType
	 *            �ӿ�����
	 * @param url
	 *            �ӿ�url
	 * @return ������
	 * @throws HttpConnectionException
	 *             http�����쳣
	 * @throws HttpClientException
	 *             httpClient�쳣
	 */
	public RespJson sendHttpDelete(HttpSession session, String siteId, String interfaceType, String url)
			throws HttpConnectionException, HttpClientException {
		return sendHttp(session, siteId, interfaceType, url, HttpClientUtils.METHOD_DELETE, null);
	}

	@SuppressWarnings("unchecked")
	private RespJson sendHttp(HttpSession session, String siteId, String interfaceType, String url, String methodName, 
			String jsonParam) throws HttpConnectionException, HttpClientException {
		RespJson httpRespJson = null;
		Map<String, String> httpurl_map = (Map<String, String>) session.getAttribute(SysConstants.SESSION_HTTPURL_MAP);
		if (httpurl_map == null) {
			httpurl_map = getHttpUrlBySiteId(siteId);
			String httpUrl = null;
			if (SysConstants.URL_TYPE_MANAGE.equals(interfaceType)) {
				httpUrl = httpurl_map.get(SysConstants.HTTPURL_MANAGE);
			} else if (SysConstants.URL_TYPE_MONITOR.equals(interfaceType)) {
				httpUrl = httpurl_map.get(SysConstants.HTTPURL_MONITOR);
			}
			if (httpUrl == null) {
				return RespJsonFactory.buildFailure("�����쳣");
			} else {
				httpUrl = httpUrl + url;
				session.setAttribute(SysConstants.SESSION_HTTPURL_MAP, httpurl_map);
				if (HttpClientUtils.METHOD_POST.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpPost(httpUrl, jsonParam);
				} else if (HttpClientUtils.METHOD_PUT.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpPut(httpUrl, jsonParam);
				} else if (HttpClientUtils.METHOD_DELETE.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpDelete(httpUrl);
				} else if (HttpClientUtils.METHOD_GET.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpGet(httpUrl);
				}
			}
		} else {
			String httpUrl = null;
			if (SysConstants.URL_TYPE_MANAGE.equals(interfaceType)) {
				httpUrl = httpurl_map.get(SysConstants.HTTPURL_MANAGE);
			} else if (SysConstants.URL_TYPE_MONITOR.equals(interfaceType)) {
				httpUrl = httpurl_map.get(SysConstants.HTTPURL_MONITOR);
			}
			try {
				httpUrl = httpUrl + url;
				if (HttpClientUtils.METHOD_POST.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpPost(httpUrl, jsonParam);
				} else if (HttpClientUtils.METHOD_PUT.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpPut(httpUrl, jsonParam);
				} else if (HttpClientUtils.METHOD_DELETE.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpDelete(httpUrl);
				} else if (HttpClientUtils.METHOD_GET.equals(methodName)) {
					httpRespJson = HttpClientUtils.sendHttpGet(httpUrl);
				}
			} catch (HttpConnectionException e) {
				httpurl_map = getHttpUrlBySiteId(siteId);
				if (SysConstants.URL_TYPE_MANAGE.equals(interfaceType)) {
					httpUrl = httpurl_map.get(SysConstants.HTTPURL_MANAGE);
				} else if (SysConstants.URL_TYPE_MONITOR.equals(interfaceType)) {
					httpUrl = httpurl_map.get(SysConstants.HTTPURL_MONITOR);
				}
				if (httpUrl == null) {
					return RespJsonFactory.buildFailure("�����쳣");
				} else {
					httpUrl = httpUrl + url;
					if (HttpClientUtils.METHOD_POST.equals(methodName)) {
						httpRespJson = HttpClientUtils.sendHttpPost(httpUrl, jsonParam);
					} else if (HttpClientUtils.METHOD_PUT.equals(methodName)) {
						httpRespJson = HttpClientUtils.sendHttpPut(httpUrl, jsonParam);
					} else if (HttpClientUtils.METHOD_DELETE.equals(methodName)) {
						httpRespJson = HttpClientUtils.sendHttpDelete(httpUrl);
					} else if (HttpClientUtils.METHOD_GET.equals(methodName)) {
						httpRespJson = HttpClientUtils.sendHttpGet(httpUrl);
					}
				}
			}
		}
		return httpRespJson;
	}

	/**
	 * ���ݱ������ͺͱ����ȡ��ʾ����
	 * 
	 * @param codeType
	 *            ��������
	 * @param code
	 *            ����
	 * @return ��ʾ����
	 */
	public String getTextByCode(String codeType, String code) {
		List<DictTypeEntity> dictTypeList = dictTypeService.listDictTypeFromCache();
		for (DictTypeEntity dictType : dictTypeList) {
			if (dictType.getCode().equals(codeType)) {
				List<DictEntity> dictList = dictType.getDictList();
				for (DictEntity dict : dictList) {
					if (dict.getCode().equals(code)) {
						return dict.getName();
					}
				}
				return null;
			}
		}
		return null;
	}
	
	/**
	 * ��ȡ�������
	 * 
	 * @param dictCode
	 * @return
	 */
	public String getDefinitionCode(String dictCode) {
		List<DefinitionEntity> definitionList = definitionService.listFromCache();
		for (DefinitionEntity definition : definitionList) {
			if (definition.getDictCode().equals(dictCode)) {
				return definition.getCode();
			}
		}
		return null;
	}

	/**
	 * ���������־
	 * 
	 * @param modelName
	 *            ����ģ������
	 * @param action
	 *            ��������
	 * @param objId
	 *            �����������
	 * @param objName
	 *            ������������
	 * @param createUserLoginName
	 *            ������
	 * @return ������־����
	 */
	public OperateLogEntity saveOperateLog(String modelName, String action, String objId, String objName,
			String createUserLoginName) {
		OperateLogEntity operateLog = new OperateLogEntity();
		operateLog.setId(PrimaryKeyUtils.uniqueId());
		operateLog.setModelName(modelName);
		operateLog.setAction(action);
		operateLog.setObjId(objId);
		operateLog.setObjName(objName);
		operateLog.setCreateDateTime(DateUtils.getCurrentDateTime());
		operateLog.setCreateUserLoginName(createUserLoginName);
		operateLogDao.save(operateLog);
		return operateLog;
	}

	/**
	 * ���²�����־
	 * 
	 * @param operateLog
	 *            ������־����
	 */
	public void updateOperateLog(OperateLogEntity operateLog) {
		operateLogDao.update(operateLog);
	}

	/**
	 * ��ȡ�б�
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	public abstract RespJson list(HttpServletRequest request, Map<String, Object> param) throws APIException;

	/**
	 * ��ȡ��������
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	public abstract RespJson get(HttpServletRequest request, String id) throws APIException;

	/**
	 * ����
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	public abstract RespJson save(HttpServletRequest request, Map<String, Object> param) throws APIException;

	/**
	 * ����
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	public abstract RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException;

	/**
	 * ɾ��
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws APIException
	 */
	public abstract RespJson remove(HttpServletRequest request, String id) throws APIException;

}
