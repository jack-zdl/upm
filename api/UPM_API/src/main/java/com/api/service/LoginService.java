package com.api.service;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.api.constant.DictConstants;
import com.api.constant.SysConstants;
import com.api.dao.OperateLogDao;
import com.api.dao.UserDao;
import com.api.entity.OperateLogEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.util.DateUtils;
import com.api.util.EncryptionUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

@Service
public class LoginService {

	private static Logger logger = Logger.getLogger(LoginService.class);

	@Resource
	private UserDao userDao;

	@Resource
	private OperateLogDao operateLogDao;

	/**
	 * ��¼��֤
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	@Transactional(rollbackFor = APIException.class)
	public RespJson login(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			// ����
			String password = (String) param.get("password");
			// �������
			password = EncryptionUtils.getMD5(password);
			param.put("password", password);
			
			// �����û����������ȡ�û���Ϣ
			UserEntity user = userDao.getUser(param);
			if (user == null) {
				return RespJsonFactory.buildWarning("�û������������");
			} else {
				// ��ȡ��ǰʱ��
				Date nowDate = DateUtils.getCurrentDateTime();
				
				OperateLogEntity operateLog = new OperateLogEntity();
				// ������־����
				operateLog.setId(PrimaryKeyUtils.uniqueId());
				// ����ģ������
				operateLog.setOperateModelName(DictConstants.OPERATE_MODEL_LOGIN);
				// ��������
				operateLog.setOperateAction(DictConstants.OPERATE_ACTION_LOGIN);
				// �����������
				operateLog.setOperateObjId(user.getLoginName());
				// ������������
				operateLog.setOperateObjName(user.getLoginName());
				// ������
				operateLog.setOperateLoginName(user.getLoginName());
				// ����ʱ��
				operateLog.setOperateDateTime(nowDate);
				
				if (!user.isValidate()) {
					// ����״̬
					operateLog.setOperateStatus(DictConstants.OPERATE_STATUS_FAILURE);
					operateLogDao.save(operateLog);
					return RespJsonFactory.buildWarning("���û���Ȩ��¼");
				} else {
					// ����״̬
					operateLog.setOperateStatus(DictConstants.OPERATE_STATUS_OK);
					operateLogDao.save(operateLog);
					
					user.setLatestLoginDateTime(nowDate);
					userDao.updateLatestLoginDateTime(user);
					
					HttpSession session = request.getSession();
					session.setAttribute(SysConstants.SESSION_USER, user);
					return RespJsonFactory.buildSuccess();
				}
			}
		} catch (Exception e) {
			logger.error("�˺�������֤�쳣", e);
			throw new APIException("�˺�������֤�쳣");
		}
	}

	/**
	 * �ǳ�
	 * 
	 * @param request
	 * @return
	 */
	public void logout(HttpServletRequest request) throws APIException{
		request.getSession().invalidate();
	}
//	public void logout(HttpServletRequest request) throws APIException{
//		try {
//			JSONObject json = new JSONObject();
//			json.put("username", "admin");
//			json.put("password", "000000");
//			String a = null;
//			if (a.equals("123")) {
//				System.out.println("xxxxx");
//			}
//			HttpClientUtils.sendHttpPost("http://192.168.224.1:8080/UPM_API/login/login", json.toJSONString());
//		} catch (OtherAPIException e) {
//			logger.error("�˺�������֤�쳣", e);
//			throw new APIException("���ýӿ��쳣");
//		} catch (Exception e) {
//			logger.error("�˺�������֤�쳣", e);
//			throw new APIException("�˺�������֤�쳣xxxxx");
//		}
//		//request.getSession().invalidate();
//	}

}
