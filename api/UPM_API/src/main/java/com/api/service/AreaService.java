package com.api.service;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.alibaba.fastjson.JSONArray;
import com.api.constant.DictConstants;
import com.api.constant.DictTypeConstants;
import com.api.constant.SysConstants;
import com.api.dao.AreaDao;
import com.api.dto.AreaDto;
import com.api.entity.AreaEntity;
import com.api.entity.OperateLogEntity;
import com.api.entity.SiteEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.util.DateUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * �������ҵ������
 * 
 * @author HCK
 *
 */
@Service("areaService")
public class AreaService extends BaseService {

	@Resource
	private AreaDao areaDao;

	/**
	 * ��ȡ�����б�
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
			List<AreaEntity> areaList = areaDao.list(param);
			JSONArray jsonArray = new JSONArray();
			for (AreaEntity area : areaList) {
				AreaDto areaDto = new AreaDto();
				areaDto.setId(area.getId());
				areaDto.setName(area.getName());
				areaDto.setDescription(area.getDescription());
				areaDto.setEnabled(area.isEnabled());
				areaDto.setEnabledText(
						getTextByCode(DictTypeConstants.STATUS_ENABLED, String.valueOf(area.isEnabled())));
				areaDto.setCreateDateTime(DateUtils.dateTimeToString(area.getCreateDateTime()));
				areaDto.setCreateLoginUserName(area.getCreateUserLoginName());
				jsonArray.add(areaDto);
			}
			return RespJsonFactory.buildSuccess(jsonArray);
		} catch (Exception e) {
			logger.error("�����ѯ�쳣", e);
			throw new APIException("�����ѯ�쳣:" + e.getMessage());
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

			// �������
			String areaId = PrimaryKeyUtils.uniqueId();
			// ��������
			String areaName = (String) param.get("name");
			// ��������
			String description = (String) param.get("description");
			// վ�����
			String siteId = (String) param.get("siteId");

			// ���������־
			OperateLogEntity operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_AREA,
					DictConstants.OPERATE_ACTION_ADD, areaId, areaName, user.getLoginName());

			AreaEntity area = new AreaEntity();
			area.setId(areaId);
			area.setName(areaName);
			area.setDescription(description);
			area.setEnabled(true);
			area.setCreateDateTime(operateLog.getCreateDateTime());
			area.setCreateUserLoginName(user.getLoginName());
			SiteEntity site = new SiteEntity();
			site.setId(siteId);
			area.setSite(site);

			areaDao.save(area);

			return RespJsonFactory.buildSuccess();
		} catch (Exception e) {
			logger.error("���������쳣", e);
			throw new APIException("���������쳣:" + e.getMessage());
		}
	}

	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ����ɾ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param id
	 *            �������
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
			AreaEntity area = areaDao.get(id);
			if (area == null) {
				return RespJsonFactory.buildWarning("�������ѱ������û�ɾ��");
			} else {
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_AREA, DictConstants.OPERATE_ACTION_DELETE, id,
						area.getName(), user.getLoginName());

				areaDao.remove(id);
				return RespJsonFactory.buildSuccess("����ɾ���ɹ�");
			}
		} catch (Exception e) {
			logger.error("����ɾ���쳣", e);
			throw new APIException("����ɾ���쳣:" + e.getMessage());
		}
	}

}
