package com.api.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.api.constant.DictConstants;
import com.api.constant.DictTypeConstants;
import com.api.constant.SysConstants;
import com.api.dto.SiteDto;
import com.api.entity.OperateLogEntity;
import com.api.entity.SiteEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.exception.HttpConnectionException;
import com.api.util.HttpClientUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;
import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.State;
import com.orbitz.consul.model.health.HealthCheck;

/**
 * վ�����ҵ������
 * 
 * @author HCK
 *
 */
@Service
public class SiteService extends BaseService {

	/**
	 * ��ȡվ���б�
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 * @throws APIException
	 *             API�쳣
	 */
	@Override
	public RespJson list(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			List<SiteEntity> siteList = siteDao.list(param);
			JSONArray jsonArray = new JSONArray();
			for (SiteEntity site : siteList) {
				SiteDto siteDto = new SiteDto();
				siteDto.setId(site.getId());
				siteDto.setName(site.getName());
				siteDto.setRegionCode(site.getRegionCode());
				siteDto.setRegionText(getTextByCode(DictTypeConstants.REGION, site.getRegionCode()));
				String[] consulIpArr = site.getConsulIps().split(";");

				int critical_mgm_count = 0;
				int passing_mgm_count = 0;
				int critical_hs_count = 0;
				int passing_hs_count = 0;

				Consul consul = null;
				for (String consulIp : consulIpArr) {
					HostAndPort hostAndPort = HostAndPort.fromParts(consulIp, site.getConsulPort());
					try {
						consul = Consul.builder().withHostAndPort(hostAndPort).build();
						break;
					} catch (Exception e) {

					}
				}
				if (consul != null) {
					HealthClient healthClient = consul.healthClient();
					List<HealthCheck> healthCheck_criticalList = healthClient.getChecksByState(State.FAIL)
							.getResponse();
					for (HealthCheck healthCheck : healthCheck_criticalList) {
						if (healthCheck.getServiceName().get().startsWith(site.getMgmPrefix())) {
							critical_mgm_count++;
						} else if (healthCheck.getServiceName().get().startsWith(site.getHorusServerPrefix())) {
							critical_hs_count++;
						}
					}

					List<HealthCheck> healthCheck_passingList = healthClient.getChecksByState(State.PASS).getResponse();
					for (HealthCheck healthCheck : healthCheck_passingList) {
						if (healthCheck.getServiceName().get().startsWith(site.getMgmPrefix())) {
							passing_mgm_count++;
						} else if (healthCheck.getServiceName().get().startsWith(site.getHorusServerPrefix())) {
							passing_hs_count++;
						}
					}
				}
				if (critical_mgm_count == 0 && passing_mgm_count != 0) {
					siteDto.setMgmStatusCode(DictConstants.STATUS_MGM_PASSING);
					siteDto.setMgmStatusText(
							getTextByCode(DictTypeConstants.STATUS_MGM, String.valueOf(DictConstants.STATUS_MGM_PASSING)));
				} else if (critical_mgm_count != 0 && passing_mgm_count != 0) {
					siteDto.setMgmStatusCode(DictConstants.STATUS_MGM_WARNING);
					siteDto.setMgmStatusText(
							getTextByCode(DictTypeConstants.STATUS_MGM, String.valueOf(DictConstants.STATUS_MGM_WARNING)));
				} else {
					siteDto.setMgmStatusCode(DictConstants.STATUS_MGM_CRITICAL);
					siteDto.setMgmStatusText(
							getTextByCode(DictTypeConstants.STATUS_MGM, String.valueOf(DictConstants.STATUS_MGM_CRITICAL)));
				}

				if (critical_hs_count == 0 && passing_hs_count != 0) {
					siteDto.setHsStatusCode(DictConstants.STATUS_HS_PASSING);
					siteDto.setHsStatusText(
							getTextByCode(DictTypeConstants.STATUS_HS, String.valueOf(DictConstants.STATUS_HS_PASSING)));
				} else if (critical_hs_count != 0 && passing_hs_count != 0) {
					siteDto.setHsStatusCode(DictConstants.STATUS_HS_WARNING);
					siteDto.setHsStatusText(
							getTextByCode(DictTypeConstants.STATUS_HS, String.valueOf(DictConstants.STATUS_HS_WARNING)));
				} else {
					siteDto.setHsStatusCode(DictConstants.STATUS_HS_CRITICAL);
					siteDto.setHsStatusText(
							getTextByCode(DictTypeConstants.STATUS_HS, String.valueOf(DictConstants.STATUS_HS_CRITICAL)));
				}
				jsonArray.add(siteDto);
			}
			return RespJsonFactory.buildSuccess(jsonArray);
		} catch (Exception e) {
			logger.error("վ���ѯ�쳣", e);
			throw new APIException("վ���ѯ�쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson get(HttpServletRequest request, String id) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * վ������
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 * @throws APIException
	 *             API�쳣
	 */
	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson save(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);

			// վ�����
			String siteId = PrimaryKeyUtils.uniqueId();
			// վ������
			String siteName = (String) param.get("name");
			// �������
			String regionCode = (String) param.get("regionCode");
			// consul��Ⱥ��ַ
			String consulIps = (String) param.get("consulIps");
			// consul��Ⱥ�˿�
			Integer consulPort = (Integer) param.get("consulPort");
			// consulͨѶ����
			String consulToken = (String) param.get("consulToken");
			// ��Դ���������֤֤��
			String mgmCa = (String) param.get("mgmCa");
			// ��ع��������֤֤��
			String horusServerCa = (String) param.get("horusServerCa");
			// ��Դ�����������
			String mgmPrefix = (String) param.get("mgmPrefix");
			// ��ع����������
			String horusServerPrefix = (String) param.get("horusServerPrefix");

			// ���������־
			OperateLogEntity operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_SITE,
					DictConstants.OPERATE_ACTION_REGISTER, siteId, siteName, user.getLoginName());

			Map<String, String> httpUrlMap = getHttpUrl(consulIps, consulPort, mgmPrefix, horusServerPrefix);
			if (httpUrlMap.get(SysConstants.HTTPURL_MANAGE) == null
					&& httpUrlMap.get(SysConstants.HTTPURL_MONITOR) == null) {
				logger.error("consul���������쳣.");
				return RespJsonFactory.buildFailure("consul���������쳣.");
			} else if (httpUrlMap.get(SysConstants.HTTPURL_MANAGE) == null
					&& httpUrlMap.get(SysConstants.HTTPURL_MONITOR) != null) {
				logger.error("�������������쳣.");
				return RespJsonFactory.buildFailure("�������������쳣.");
			} else if (httpUrlMap.get(SysConstants.HTTPURL_MANAGE) != null
					&& httpUrlMap.get(SysConstants.HTTPURL_MONITOR) == null) {
				logger.error("������������쳣.");
				return RespJsonFactory.buildFailure("������������쳣.");
			} else {
				try {
					RespJson respJson = HttpClientUtils
							.sendHttpGet(httpUrlMap.get(SysConstants.HTTPURL_MANAGE).toString() + "/_ping");
					if (respJson.getResult() != RespJson.SUCCESS) {
						logger.error("�������������쳣.");
						return RespJsonFactory.buildFailure("�������������쳣.");
					}
				} catch (HttpConnectionException e) {
					logger.error("���������쳣.");
					return RespJsonFactory.buildFailure("���������쳣.");
				}

				// try {
				// RespJson respJson = HttpClientUtils
				// .sendHttpGet(httpUrlMap.get(SysConstants.HTTPURL_MONITOR).toString()
				// + "/_ping");
				// if (respJson.getResult() != RespJson.SUCCESS) {
				// logger.error("������������쳣.");
				// return RespJsonFactory.buildFailure("������������쳣.");
				// }
				// } catch (HttpConnectionException e) {
				// logger.error("���������쳣.");
				// return RespJsonFactory.buildFailure("���������쳣.");
				// }
			}

			SiteEntity site = new SiteEntity();
			site.setId(siteId);
			site.setName(siteName);
			site.setRegionCode(regionCode);
			site.setConsulIps(consulIps);
			site.setConsulPort(consulPort);
			site.setConsulToken(consulToken);
			site.setMgmCa(mgmCa);
			site.setHorusServerCa(horusServerCa);
			site.setMgmPrefix(mgmPrefix);
			site.setHorusServerPrefix(horusServerPrefix);
			site.setCreateDateTime(operateLog.getCreateDateTime());
			site.setCreateUserLoginName(user.getLoginName());
			siteDao.save(site);

			return RespJsonFactory.buildSuccess();

		} catch (Exception e) {
			logger.error("վ��ע���쳣", e);
			throw new APIException("վ��ע���쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * վ��ע��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param id
	 *            վ�����
	 * @return �������
	 * @throws APIException
	 *             API�쳣
	 */
	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson remove(HttpServletRequest request, String id) throws APIException {
		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);
			SiteEntity site = siteDao.get(id);
			if (site == null) {
				return RespJsonFactory.buildWarning("��վ���ѱ������û�ע��");
			} else {
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_SITE, DictConstants.OPERATE_ACTION_DEREGISTER, id,
						site.getName(), user.getLoginName());

				siteDao.remove(id);
				return RespJsonFactory.buildSuccess("վ��ע���ɹ�");
			}
		} catch (Exception e) {
			logger.error("վ��ע���쳣", e);
			throw new APIException("վ��ע���쳣:" + e.getMessage());
		}
	}

}
