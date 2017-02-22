package com.api.service;

import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.api.dao.OperateLogDao;
import com.api.exception.APIException;
import com.api.util.RespJson;

public abstract class BaseService {
	
	@Resource
	protected OperateLogDao operateLogDao;
	
	/**
	 * ��־����
	 */
	protected Logger logger = Logger.getLogger(getClass());

	/**
	 * ����վ������ȡhttpUrl
	 * 
	 * @param siteId
	 * @return
	 * @throws APIException
	 */
	public Map<String, String> getHttpUrlBySiteId(String siteId) throws APIException {
		return null;
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
