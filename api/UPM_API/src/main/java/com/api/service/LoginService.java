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
	 * 登录验证
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	@Transactional(rollbackFor = APIException.class)
	public RespJson login(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			// 密码
			String password = (String) param.get("password");
			// 密码加密
			password = EncryptionUtils.getMD5(password);
			param.put("password", password);
			
			// 根据用户名和密码获取用户信息
			UserEntity user = userDao.getUser(param);
			if (user == null) {
				return RespJsonFactory.buildWarning("用户名或密码错误");
			} else {
				if (!user.isValidate()) {
					// 操作状态
					return RespJsonFactory.buildWarning("该用户无权登录");
				} else {
					// 获取当前时间
					Date nowDate = DateUtils.getCurrentDateTime();
					
					OperateLogEntity operateLog = new OperateLogEntity();
					// 操作日志编码
					operateLog.setId(PrimaryKeyUtils.uniqueId());
					// 操作模块名称
					operateLog.setModelName(DictConstants.OPERATE_MODEL_LOGIN);
					// 操作动作
					operateLog.setAction(DictConstants.OPERATE_ACTION_LOGIN);
					// 操作对象编码
					operateLog.setObjId(user.getLoginName());
					// 操作对象名称
					operateLog.setObjName(user.getLoginName());
					// 操作者
					operateLog.setCreateUserLoginName(user.getLoginName());
					// 操作时间
					operateLog.setCreateDateTime(nowDate);
					operateLogDao.save(operateLog);
					
					user.setLatestLoginDateTime(nowDate);
					userDao.updateLatestLoginDateTime(user);
					
					HttpSession session = request.getSession();
					session.setAttribute(SysConstants.SESSION_USER, user);
					return RespJsonFactory.buildSuccess();
				}
			}
		} catch (Exception e) {
			logger.error("账号密码验证异常", e);
			throw new APIException("账号密码验证异常:" + e.getMessage());
		}
	}

	/**
	 * 登出
	 * 
	 * @param request
	 * @return
	 */
	public void logout(HttpServletRequest request) throws APIException{
		request.getSession().invalidate();
	}

}
