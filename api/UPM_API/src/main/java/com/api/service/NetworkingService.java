package com.api.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.constant.DictConstants;
import com.api.constant.DictTypeConstants;
import com.api.constant.SysConstants;
import com.api.dao.NetworkingDao;
import com.api.dto.NetworkingDto;
import com.api.entity.AreaEntity;
import com.api.entity.NetworkingEntity;
import com.api.entity.OperateLogEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.util.DateUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * ���ι���ҵ������
 * 
 * @author HCK
 *
 */
@Service
public class NetworkingService extends BaseService {

	@Resource
	private NetworkingDao networkingDao;

	/**
	 * ��ȡ�����б�
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	@Override
	public RespJson list(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			List<NetworkingEntity> networkingList = networkingDao.list(param);
			JSONArray jsonArray = new JSONArray();
			for (NetworkingEntity networking : networkingList) {
				NetworkingDto networkingDto = new NetworkingDto();
				networkingDto.setId(networking.getId());
				networkingDto.setName(networking.getName());
				networkingDto.setStartIp(networking.getStartIp());
				networkingDto.setEndIp(networking.getEndIp());
				networkingDto.setVlanId(String.valueOf(networking.getVlanId()));
				networkingDto.setPrefix(String.valueOf(networking.getPrefix()));
				networkingDto.setGateway(networking.getGateway());
				networkingDto.setEnabled(networking.isEnabled());
				networkingDto.setEnabledText(
						getTextByCode(DictTypeConstants.STATUS_ENABLED, String.valueOf(networking.isEnabled())));
				networkingDto.setAreaId(networking.getArea().getId());
				networkingDto.setAreaName(networking.getArea().getName());
				networkingDto.setCreateDateTime(DateUtils.dateTimeToString(networking.getCreateDateTime()));
				networkingDto.setCreateLoginUserName(networking.getCreateUserLoginName());
				jsonArray.add(networkingDto);
			}
			return RespJsonFactory.buildSuccess(jsonArray);
		} catch (Exception e) {
			logger.error("���β�ѯ�쳣", e);
			throw new APIException("���β�ѯ�쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson get(HttpServletRequest request, String id) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ��������
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson save(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);

			// ���α���
			String networkingId = PrimaryKeyUtils.uniqueId();
			// վ�����
			String siteId = (String) param.get("siteId");
			// �������
			String areaId = (String) param.get("areaId");
			// ��������
			String networkingName = (String) param.get("name");
			// ��������
			String type = (String) param.get("type");
			// ��ʼIP
			String startIp = (String) param.get("startIp");
			// ����IP
			String endIp = (String) param.get("endIp");
			// ���vlanID
			Integer vlanId = (Integer) param.get("vlanId");
			// ����
			Integer prefix = (Integer) param.get("prefix");
			// ����
			String gateway = (String) param.get("gateway");

			// ���������־
			OperateLogEntity operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_NETWORKING,
					DictConstants.OPERATE_ACTION_ADD, networkingId, networkingName, user.getLoginName());

			NetworkingEntity networking = new NetworkingEntity();
			networking.setId(networkingId);
			AreaEntity area = new AreaEntity();
			area.setId(areaId);
			networking.setArea(area);
			networking.setName(networkingName);
			networking.setType(type);
			networking.setStartIp(startIp);
			networking.setEndIp(endIp);
			networking.setVlanId(vlanId);
			networking.setPrefix(prefix);
			networking.setGateway(gateway);
			networking.setEnabled(true);
			networking.setCreateDateTime(operateLog.getCreateDateTime());
			networking.setCreateUserLoginName(user.getLoginName());
			networkingDao.save(networking);

			JSONObject paramJson = new JSONObject();
			paramJson.put("start", startIp);
			paramJson.put("end", endIp);
			paramJson.put("prefix", prefix);
			paramJson.put("gateway", gateway);
			paramJson.put("vlan_id", vlanId);
			String url = "/" + SysConstants.URL_VERSION + "/networkings/" + networkingId + "/ips";
			RespJson httpRespJson = sendHttpPost(session, siteId, SysConstants.URL_TYPE_MANAGE, url, paramJson.toJSONString());
			if (httpRespJson.getResult() == RespJson.SUCCESS) {
				return RespJsonFactory.buildSuccess("���������ɹ�");
			} else {
				throw new APIException(httpRespJson.getMsg());
			}
		} catch (Exception e) {
			logger.error("���������쳣", e);
			throw new APIException("���������쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����ɾ��
	 * 
	 * @param request
	 * @param id
	 * @return
	 * @throws APIException
	 */
	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson remove(HttpServletRequest request, String id) throws APIException {
		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);

			NetworkingEntity networking = networkingDao.get(id);
			if (networking == null) {
				return RespJsonFactory.buildWarning("�������ѱ������û�ɾ��");
			} else {
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_NETWORKING, DictConstants.OPERATE_ACTION_DELETE, id,
						networking.getName(), user.getLoginName());
				
				networkingDao.remove(id);

				String url = "/" + SysConstants.URL_VERSION + "/networkings/" + id + "/ips";
				RespJson httpRespJson = sendHttpDelete(session, networking.getArea().getSite().getId(),
						SysConstants.URL_TYPE_MANAGE, url);
				if (httpRespJson.getResult() == RespJson.SUCCESS) {
					return RespJsonFactory.buildSuccess("����ɾ���ɹ�");
				} else {
					throw new APIException(httpRespJson.getMsg());
				}
			}
		} catch (Exception e) {
			logger.error("����ɾ���쳣", e);
			throw new APIException("����ɾ���쳣:" + e.getMessage());
		}
	}

}
