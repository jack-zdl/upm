package com.api.service;

import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.constant.DictConstants;
import com.api.constant.DictTypeConstants;
import com.api.constant.SysConstants;
import com.api.dao.DefinitionSubServDao;
import com.api.dao.DefinitionSubServSoftwareDao;
import com.api.dao.SubServSoftwareImageDao;
import com.api.dao.SubTaskDao;
import com.api.dao.TaskDao;
import com.api.dto.FileDto;
import com.api.dto.SubServSoftwareImageDto;
import com.api.entity.DefinitionSubServEntity;
import com.api.entity.DefinitionSubServSoftwareEntity;
import com.api.entity.OperateLogEntity;
import com.api.entity.SiteEntity;
import com.api.entity.SubServSoftwareImageEntity;
import com.api.entity.SubTaskEntity;
import com.api.entity.TaskEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.util.DateUtils;
import com.api.util.FileUtils;
import com.api.util.HttpClientUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;
import com.api.util.SpringContextUtils;

/**
 * ����������ҵ������
 * 
 * @author HCK
 *
 */
@Service
public class SoftwareImageService extends BaseService {

	@Value("#{configProperties['file.path']}")
	private String filePath;

	@Value("#{configProperties['file.suffix']}")
	private String suffix;

	@Resource
	private SubServSoftwareImageDao subServSoftwareImageDao;

	@Resource
	private DefinitionSubServSoftwareDao definitionSubServSoftwareDao;
	
	@Resource
	private DefinitionSubServDao definitionSubServDao;
	
	@Resource
	private TaskDao taskDao;
	
	@Resource
	private SubTaskDao subTaskDao;
	
	/**
	 * ��ȡ��������ļ��б�
	 * 
	 * @param request
	 * @return
	 */
	public List<FileDto> listSoftwareImageFile(HttpServletRequest request, Map<String, Object> param) {
		// �ӷ�������������
		String dfSubServId = (String) param.get("definitionSubServId");
		DefinitionSubServEntity dfSubServ = definitionSubServDao.get(dfSubServId);
		List<FileDto> fileDtoList = new ArrayList<FileDto>();
		String imageFilePath = "";
		if (filePath.endsWith("/")) {
			imageFilePath = filePath + dfSubServ.getName();
		} else {
			imageFilePath = filePath + "/" + dfSubServ.getName();
		}
		List<File> fileList = FileUtils.getFileList(imageFilePath, suffix);
		for (File file : fileList) {
			FileDto fileDto = new FileDto();
			fileDto.setName(file.getName());
			long size = file.length();
			DecimalFormat df = new DecimalFormat("#,###");
			double d = size / 1024.0;
			if (d < 1) {
				d = 1;
			}
			fileDto.setSize(df.format(d) + "KB");
			fileDtoList.add(fileDto);
		}
		return fileDtoList;
	}

	/**
	 * ��ȡ��������б�
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	@Override
	public RespJson list(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			List<SubServSoftwareImageEntity> subServSoftwareImageList = subServSoftwareImageDao.list(param);
			JSONArray jsonArray = new JSONArray();
			for (SubServSoftwareImageEntity softwareImage : subServSoftwareImageList) {
				SubServSoftwareImageDto softwareImageDto = new SubServSoftwareImageDto();
				softwareImageDto.setId(softwareImage.getId());
				softwareImageDto
						.setName(softwareImage.getDefinitionSubServSoftware().getDefinitionSubServ().getName());
				softwareImageDto
						.setIcon(softwareImage.getDefinitionSubServSoftware().getDefinitionSubServ().getIcon());
				softwareImageDto.setMajorVersion(
						String.valueOf(softwareImage.getDefinitionSubServSoftware().getMajorVersion()));
				softwareImageDto.setMinorVersion(
						String.valueOf(softwareImage.getDefinitionSubServSoftware().getMinorVersion()));
				softwareImageDto.setPatchVersion(String.valueOf(softwareImage.getPatchVersion()));
				softwareImageDto.setVersion(softwareImageDto.getMajorVersion() + "."
						+ softwareImageDto.getMinorVersion() + "." + softwareImageDto.getPatchVersion());
				softwareImageDto.setEnabled(softwareImage.isEnabled());
				softwareImageDto.setEnabledText(
						getTextByCode(DictTypeConstants.STATUS_ENABLED, String.valueOf(softwareImage.isEnabled())));
				TaskEntity task = taskDao.getLatestTaskByObjId(softwareImage.getId());
				if (task != null) {
					softwareImageDto.setStatus(task.getStatus());
					softwareImageDto.setStatusText(getTextByCode(DictTypeConstants.TASK_STATUS, task.getStatus()));
				}
				softwareImageDto.setCreateDateTime(DateUtils.dateTimeToString(softwareImage.getCreateDateTime()));
				softwareImageDto.setCreateLoginUserName(softwareImage.getCreateUserLoginName());
				jsonArray.add(softwareImageDto);
			}
			return RespJsonFactory.buildSuccess(jsonArray);
		} catch (Exception e) {
			logger.error("��������ѯ�쳣", e);
			throw new APIException("��������ѯ�쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson get(HttpServletRequest request, String id) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * �����������
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

			// ����������
			String softwareImageId = PrimaryKeyUtils.uniqueId();
			// �ӷ�������������
			String dfSubServSoftwareId = (String) param.get("definitionSubServSoftwareId");
			if (StringUtils.isBlank(dfSubServSoftwareId)) {
				return RespJsonFactory.buildFailure("�������Ϊ��");
			}
			
			// �޶��汾��
			Integer patchVersion = (Integer) param.get("patchVersion");
			if (patchVersion == null) {
				return RespJsonFactory.buildFailure("�����汾����Ϊ��");
			}
			
			// վ�����
			String siteId = (String) param.get("siteId");
			
			String loginName = user.getLoginName();

			DefinitionSubServSoftwareEntity dfSubServSoftware = definitionSubServSoftwareDao.get(dfSubServSoftwareId);
			
			String subServName = dfSubServSoftware.getDefinitionSubServ().getName();
			String objName = subServName + "-" + dfSubServSoftware.getMajorVersion() + "."
					+ dfSubServSoftware.getMinorVersion() + "." + patchVersion;
			
			String imagePath = null;
			if (filePath.endsWith("/")) {
				imagePath = filePath + subServName + "/" +  objName + "." + suffix.replaceFirst(".", "");
			} else {
				imagePath = filePath + "/" + subServName + "/" + objName + "." + suffix.replaceFirst(".", "");
			}
			
			File file = new File(imagePath);
			if (!file.exists()) {
				return RespJsonFactory.buildFailure("�ð汾��Ӧ��������񲻴���");
			}
			
			OperateLogEntity operateLog = null;
			try {
				// ���������־
				operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_SOFTWAREIMAGE,
						DictConstants.OPERATE_ACTION_ADD, softwareImageId, objName, loginName);
				logger.info("��(" + loginName + ")�����������_" + objName + "��-���������־������");
			} catch (Exception e) {
				logger.error("������������쳣:�����������־�쳣��", e);
				throw new APIException("������������쳣:�����������־�쳣��");
			}

			SubServSoftwareImageEntity subServSoftwareImage = new SubServSoftwareImageEntity();
			subServSoftwareImage.setId(softwareImageId);
			subServSoftwareImage.setDefinitionSubServSoftware(dfSubServSoftware);
			subServSoftwareImage.setPatchVersion(patchVersion);
			SiteEntity site = new SiteEntity();
			site.setId(siteId);
			subServSoftwareImage.setSite(site);
			subServSoftwareImage.setEnabled(true);
			subServSoftwareImage.setCreateDateTime(operateLog.getCreateDateTime());
			subServSoftwareImage.setCreateUserLoginName(user.getLoginName());
			
			try {
				subServSoftwareImageDao.save(subServSoftwareImage);
				logger.info("��(" + loginName + ")�����������_" + objName + "��-�����ӷ���������񡣡���");
			} catch (Exception e) {
				logger.error("������������쳣:���������������Ϣ�쳣��", e);
				throw new APIException("������������쳣:���������������Ϣ�쳣��");
			}
			
			TaskEntity task = new TaskEntity();
			task.setId(PrimaryKeyUtils.uniqueId());
			task.setObjType(DictConstants.TASK_OBJ_TYPE_SOFTWAREIMAGE);
			task.setObjId(softwareImageId);
			task.setActionType(DictConstants.TASK_ACTION_TYPE_CREATE);
			task.setStartDateTime(operateLog.getCreateDateTime());
			task.setStatus(DictConstants.TASK_STATUS_CREATE_NO);
			task.setOperateLog(operateLog);
			task.setCreateUserLoginName(user.getLoginName());
			try {
				taskDao.save(task);
				logger.info("��(" + loginName + ")�����������_" + objName + "��-�������񡣡���");
			} catch (Exception e) {
				logger.error("������������쳣:�����������쳣��", e);
				throw new APIException("������������쳣:�����������쳣��");
			}
			
			SubTaskEntity subTask = new SubTaskEntity();
			subTask.setId(PrimaryKeyUtils.uniqueId());
			subTask.setObjType(DictConstants.TASK_OBJ_TYPE_SOFTWAREIMAGE);
			subTask.setObjId(softwareImageId);
			subTask.setActionType(DictConstants.TASK_ACTION_TYPE_CREATE);
			subTask.setAsync(true);
			subTask.setStartDateTime(task.getStartDateTime());
			subTask.setStatus(DictConstants.TASK_STATUS_CREATE_NO);
			String url = "/" + SysConstants.URL_VERSION + "/softwares/images";
			subTask.setUrl(url);
			subTask.setMethodType(HttpClientUtils.METHOD_POST);
			JSONObject jsonParam = new JSONObject();
			jsonParam.put("name", dfSubServSoftware.getDefinitionSubServ().getName());
			jsonParam.put("major_version", dfSubServSoftware.getMajorVersion());
			jsonParam.put("minor_version", dfSubServSoftware.getMinorVersion());
			jsonParam.put("patch_version", patchVersion);
			jsonParam.put("image_path", imagePath);
			subTask.setParam(jsonParam.toJSONString());
			subTask.setPriority(1);
			subTask.setTask(task);
			
			try {
				subTaskDao.save(subTask);
				logger.info("��(" + loginName + ")�����������_" + objName + "��-���������񡣡���");
			} catch (Exception e) {
				logger.error("������������쳣:�������������쳣��", e);
				throw new APIException("������������쳣:�������������쳣��");
			}
			
			ThreadPoolTaskExecutor taskExecutor = (ThreadPoolTaskExecutor) SpringContextUtils.getBeanById("threadPool");
			taskExecutor.execute(new Runnable() {
				@Override
				public void run() {
					logger.info("��(" + loginName + ")�����������_" + objName + "��-���������̡߳�����");
					
					RespJson httpRespJson_create = null;
					try {
						subTask.setStatus(DictConstants.TASK_STATUS_CREATE_RUNNING);
						subTaskDao.update(subTask);
						logger.info("��(" + loginName + ")�����������_" + objName + "��-����������״̬(������)������");
						
						task.setStatus(DictConstants.TASK_STATUS_CREATE_RUNNING);
						taskDao.update(task);
						logger.info("��(" + loginName + ")�����������_" + objName + "��-��������״̬(������)������");
						
						logger.info("��(" + loginName + ")�����������_" + objName + "��-���ô����ӿڡ�����");
						httpRespJson_create = sendHttpPost(session, siteId, SysConstants.URL_TYPE_MANAGE, url, jsonParam.toJSONString());
						if (httpRespJson_create.getResult() == RespJson.SUCCESS) {
							logger.info("��(" + loginName + ")�����������_" + objName + "��-���ô����ӿڳɹ�������");
							
							JSONObject resJson_create = ((JSONObject)httpRespJson_create.getData());
							String relateId = resJson_create.getString("id");
							String relateTaskId = resJson_create.getString("task_id");
							subServSoftwareImage.setRelateId(relateId);
							subServSoftwareImageDao.update(subServSoftwareImage);
							
							logger.info("��(" + loginName + ")�����������_" + objName + "��-"
									+ "�����ӷ�����������_���¹������롾relateId = " + relateId + "��������");
							
							subTask.setRelateTaskId(relateTaskId);
							subTaskDao.update(subTask);
							
							logger.info("��(" + loginName + ")�����������_" + objName + "��-"
									+ "�����������_���¹���������롾relateTaskId = " + relateTaskId +"��");
							
							logger.info("��(" + loginName + ")�����������_" + objName + "��-"
									+ "����ѯ��������״̬��������Ӧ��������״̬��������");
							
							RespJson httpRespJson_task = null;
							int relateTaskStatus = DictConstants.SUBTASK_STATUS_RUNNING;
							String taskUrl = "/" + SysConstants.URL_VERSION + "/tasks/" + relateTaskId;
							// �ɹ�
							while (relateTaskStatus == DictConstants.SUBTASK_STATUS_RUNNING) {
								logger.info("��(" + loginName + ")�����������_" + objName + "��-���������ѯ�ӿڡ�����");
								
								httpRespJson_task = sendHttpGet(session, siteId, SysConstants.URL_TYPE_MANAGE, taskUrl);
								if (httpRespJson_task.getResult() == RespJson.SUCCESS) {
									logger.info("��(" + loginName + ")�����������_" + objName + "��-���������ѯ�ӿڳɹ�������");
									
									JSONObject resJson_task = ((JSONObject)httpRespJson_task.getData());
									
									relateTaskStatus = resJson_task.getIntValue("status");
									subTask.setRelateTaskStatus(relateTaskStatus);
									subTask.setRelateTaskMsg(resJson_task.getString("errors"));
									subTaskDao.update(subTask);
									
									logger.info("��(" + loginName + ")�����������_" + objName + "��-"
											+ "�����������_�������������״̬��relateTaskStatus = " + relateTaskStatus + "��������:");
									
									if (relateTaskStatus == DictConstants.SUBTASK_STATUS_RUNNING) {
										Thread.sleep(SysConstants.SEARCH_FREQUENCY_SOFTWAREIMAGE_CREATE);
									}
								} else {
									logger.info("��(" + loginName + ")�����������_" + objName + "��-���������ѯ�ӿ��쳣������");
									break;
								}
							}
							
							subTask.setEndDateTime(new Date());
							subTask.setRelateTaskStatus(relateTaskStatus);
							task.setEndDateTime(subTask.getEndDateTime());
							if (relateTaskStatus == DictConstants.SUBTASK_STATUS_DONE) {
								logger.info("��(" + loginName + ")�����������_" + objName + "��-�����ɹ�������");
								
								subTask.setStatus(DictConstants.TASK_STATUS_CREATE_SUCCESS);
								task.setStatus(DictConstants.TASK_STATUS_CREATE_SUCCESS);
								
							} else {
								logger.info("��(" + loginName + ")�����������_" + objName + "��-����ʧ�ܡ�����");
								
								subTask.setStatus(DictConstants.TASK_STATUS_CREATE_FAILURE);
								task.setStatus(DictConstants.TASK_STATUS_CREATE_FAILURE);
							}
							subTaskDao.update(subTask);
							
							logger.info("��(" + loginName + ")�����������_" + objName + "��-"
									+ "�����������_����������״̬�����ʱ�䡾status = " + subTask.getStatus() 
									+ "; endDateTime = " + subTask.getEndDateTime() + "��������");
							
							taskDao.update(task);
							
							logger.info("��(" + loginName + ")�����������_" + objName + "��-"
									+ "���������_��������״̬�����ʱ�䡾status = " + task.getStatus() 
									+ "; endDateTime = " + task.getEndDateTime() + "��������");
							
						} else {
							throw new Exception(httpRespJson_create.getMsg());
						}
					} catch (Exception e) {
						e.printStackTrace();
						logger.info("��(" + loginName + ")�����������_" + objName + "��-���ô����ӿ��쳣:" + e.getMessage() + "������");
						subTask.setStatus(DictConstants.TASK_STATUS_CREATE_FAILURE);
						subTask.setEndDateTime(new Date());
						subTaskDao.update(subTask);
						
						logger.info("��(" + loginName + ")�����������_" + objName + "��-"
								+ "�����������_����������״̬�����ʱ�䡾status = " + subTask.getStatus() 
								+ "; endDateTime = " + subTask.getEndDateTime() + "��������");
						
						task.setStatus(DictConstants.TASK_STATUS_CREATE_FAILURE);
						task.setEndDateTime(subTask.getEndDateTime());
						taskDao.update(task);
						
						logger.info("��(" + loginName + ")�����������_" + objName + "��-"
								+ "���������_��������״̬�����ʱ�䡾status = " + task.getStatus() 
								+ "; endDateTime = " + task.getEndDateTime() + "��������");
					} 
				}
			});
			
			return RespJsonFactory.buildSuccess();
		} catch (Exception e) {
			logger.error("������������쳣", e);
			throw new APIException("������������쳣:" + e.getMessage());
		}
	}

	@Override
	public RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �������ɾ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param id
	 *            ����������
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
			SubServSoftwareImageEntity subServSoftwareImage = subServSoftwareImageDao.get(id);
			if (subServSoftwareImage == null) {
				return RespJsonFactory.buildWarning("����������ѱ������û�ɾ��");
			} else {
				String objName = subServSoftwareImage.getDefinitionSubServSoftware().getDefinitionSubServ().getName() 
						+ "_" 
						+ subServSoftwareImage.getDefinitionSubServSoftware().getMajorVersion() 
						+ "."
						+ subServSoftwareImage.getDefinitionSubServSoftware().getMinorVersion() 
						+ "."
						+ subServSoftwareImage.getPatchVersion();
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_SOFTWAREIMAGE, DictConstants.OPERATE_ACTION_DELETE, id,
						objName, user.getLoginName());

				subServSoftwareImageDao.remove(id);

				if (StringUtils.isNotBlank(subServSoftwareImage.getRelateId())) {
					String url = "/" + SysConstants.URL_VERSION + "/softwares/images/" + subServSoftwareImage.getRelateId();
					RespJson httpRespJson = sendHttpDelete(session, subServSoftwareImage.getSite().getId(),
							SysConstants.URL_TYPE_MANAGE, url);
					if (httpRespJson.getResult() != RespJson.SUCCESS) {
						throw new APIException(httpRespJson.getMsg());
					}
				}
				return RespJsonFactory.buildSuccess("�������ɾ���ɹ�");
			}
		} catch (Exception e) {
			logger.error("�������ɾ���쳣", e);
			throw new APIException("�������ɾ���쳣:" + e.getMessage());
		}
	}
}
