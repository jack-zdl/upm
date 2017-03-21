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
import com.api.dao.NfsBackupDao;
import com.api.dto.NfsBackupDto;
import com.api.entity.NfsBackupEntity;
import com.api.entity.OperateLogEntity;
import com.api.entity.SiteEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.util.DateUtils;
import com.api.util.NumberUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * ���ݴ洢����ҵ������
 * 
 * @author HCK
 *
 */
@Service("nfsBackupService")
public class NfsBackupService extends BaseService {

	@Resource
	private NfsBackupDao nfsBackupDao;

	/**
	 * ��ȡ���ݴ洢�б�
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
			List<NfsBackupEntity> nfsBackupList = nfsBackupDao.list(param);
			String siteId = (String) param.get("siteId");
			HttpSession session = request.getSession();
			JSONArray jsonArray = new JSONArray();
			for (NfsBackupEntity nfsBackup : nfsBackupList) {
				NfsBackupDto nfsBackupDto = new NfsBackupDto();
				nfsBackupDto.setId(nfsBackup.getId());
				nfsBackupDto.setName(nfsBackup.getName());
				nfsBackupDto.setEnabled(nfsBackup.isEnabled());
				nfsBackupDto.setEnabledText(
						getTextByCode(DictTypeConstants.STATUS_ENABLED, String.valueOf(nfsBackup.isEnabled())));
				nfsBackupDto.setNfsIp(nfsBackup.getNfsIp());
				nfsBackupDto.setNfsDir(nfsBackup.getNfsDir());
				nfsBackupDto.setNfsMountDir(nfsBackup.getNfsMountDir());
				nfsBackupDto.setNfsMountOpts(nfsBackup.getNfsMountOpts());
				nfsBackupDto.setCreateDateTime(DateUtils.dateTimeToString(nfsBackup.getCreateDateTime()));
				nfsBackupDto.setCreateLoginUserName(nfsBackup.getCreateUserLoginName());
				
				String url = "/" + SysConstants.URL_VERSION + "/nfs_backups/space?nfs_ip=" + nfsBackup.getNfsIp() 
						+ "&nfs_dir=" + nfsBackup.getNfsDir() 
						+ "&nfs_mount_dir=" + nfsBackup.getNfsMountDir()
						+ "&nfsMountOpts=" + nfsBackup.getNfsMountOpts();
				RespJson httpRespJson = sendHttpGet(session, siteId, SysConstants.URL_TYPE_MANAGE, url);
				if (httpRespJson.getResult() == RespJson.SUCCESS) {
					String totalSpace = NumberUtils.byteToG(((JSONObject) httpRespJson.getData()).getLongValue("total_space"));
					nfsBackupDto.setTotalSpace(totalSpace);
					String freeSpace = NumberUtils.byteToG(((JSONObject) httpRespJson.getData()).getLongValue("free_space"));
					nfsBackupDto.setFreeSpace(freeSpace);
				} else {
					throw new APIException(httpRespJson.getMsg());
				}
				jsonArray.add(nfsBackupDto);
			}
			return RespJsonFactory.buildSuccess(jsonArray);
		} catch (Exception e) {
			logger.error("���ݴ洢��ѯ�쳣", e);
			throw new APIException("���ݴ洢��ѯ�쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson get(HttpServletRequest request, String id) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���ݴ洢����
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

			// ���ݴ洢����
			String nfsBackupId = PrimaryKeyUtils.uniqueId();
			// ���ݴ洢����
			String nfsBackupName = (String) param.get("name");
			// վ�����
			String siteId = (String) param.get("siteId");
			// nfs��ַ
			String nfsIp = (String) param.get("nfsIp");
			// nfsԴĿ¼
			String nfsDir = (String) param.get("nfsDir");
			// nfs����Ŀ¼
			String nfsMountDir = (String) param.get("nfsMountDir");
			// nfs���ز���
			String nfsMountOpts = (String) param.get("nfsMountOpts");
			
			// ���������־
			OperateLogEntity operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_NFSBACKUP,
					DictConstants.OPERATE_ACTION_ADD, nfsBackupId, nfsBackupName, user.getLoginName());

			NfsBackupEntity nfsBackup = new NfsBackupEntity();
			nfsBackup.setId(nfsBackupId);
			nfsBackup.setName(nfsBackupName);
			nfsBackup.setNfsIp(nfsIp);
			nfsBackup.setNfsDir(nfsDir);
			nfsBackup.setNfsMountDir(nfsMountDir);
			nfsBackup.setNfsMountOpts(nfsMountOpts);
			nfsBackup.setEnabled(true);
			nfsBackup.setCreateDateTime(operateLog.getCreateDateTime());
			nfsBackup.setCreateUserLoginName(user.getLoginName());
			SiteEntity site = new SiteEntity();
			site.setId(siteId);
			nfsBackup.setSite(site);
			nfsBackupDao.save(nfsBackup);
			
			String url = "/" + SysConstants.URL_VERSION + "/nfs_backups/space?nfs_ip=" + nfsIp 
					+ "&nfs_dir=" + nfsDir 
					+ "&nfs_mount_dir=" + nfsMountDir
					+ "&nfsMountOpts=" + nfsMountOpts;
			RespJson httpRespJson = sendHttpGet(session, siteId, SysConstants.URL_TYPE_MANAGE, url);
			if (httpRespJson.getResult() == RespJson.SUCCESS) {
				return RespJsonFactory.buildSuccess("���ݴ洢�����ɹ�");
			} else {
				throw new APIException(httpRespJson.getMsg());
			}

		} catch (Exception e) {
			logger.error("���ݴ洢�����쳣", e);
			throw new APIException("���ݴ洢�����쳣:" + e.getMessage());
		}
	}

	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * ���ݴ洢ɾ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param id
	 *            ���ݴ洢����
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

			NfsBackupEntity nfsBackup = nfsBackupDao.get(id);
			if (nfsBackup == null) {
				return RespJsonFactory.buildWarning("�ñ��ݴ洢�ѱ������û�ɾ��");
			} else {
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_NFSBACKUP, DictConstants.OPERATE_ACTION_DELETE, id,
						nfsBackup.getName(), user.getLoginName());

				nfsBackupDao.remove(id);
				return RespJsonFactory.buildSuccess("���ݴ洢ɾ���ɹ�");
			}
		} catch (Exception e) {
			logger.error("���ݴ洢ɾ���쳣", e);
			throw new APIException("���ݴ洢ɾ���쳣:" + e.getMessage());
		}
	}

}
