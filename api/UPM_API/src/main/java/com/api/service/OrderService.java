package com.api.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.api.constant.DictConstants;
import com.api.constant.DictTypeConstants;
import com.api.constant.SysConstants;
import com.api.dao.AreaDao;
import com.api.dao.ClusterDao;
import com.api.dao.DefinitionSubServArchDao;
import com.api.dao.DefinitionSubServDao;
import com.api.dao.DefinitionSubServNicDao;
import com.api.dao.DefinitionSubServUnitScaleDao;
import com.api.dao.NetworkingDao;
import com.api.dao.NfsBackupDao;
import com.api.dao.OrderDao;
import com.api.dao.ServDao;
import com.api.dao.SubOrderDao;
import com.api.dao.SubOrderNicDao;
import com.api.dao.SubOrderUserDao;
import com.api.dao.SubServDao;
import com.api.dao.SubServNicDao;
import com.api.dao.SubServSoftwareImageDao;
import com.api.dao.SubServUserDao;
import com.api.dao.SubTaskDao;
import com.api.dao.TaskDao;
import com.api.dto.OrderDto;
import com.api.entity.ClusterEntity;
import com.api.entity.DefinitionServEntity;
import com.api.entity.DefinitionSubServArchEntity;
import com.api.entity.DefinitionSubServEntity;
import com.api.entity.DefinitionSubServNicEntity;
import com.api.entity.DefinitionSubServSoftwareEntity;
import com.api.entity.DefinitionSubServUnitScaleEntity;
import com.api.entity.DefinitionUserRoleEntity;
import com.api.entity.NetworkingEntity;
import com.api.entity.NfsBackupEntity;
import com.api.entity.OperateLogEntity;
import com.api.entity.OrderEntity;
import com.api.entity.SiteEntity;
import com.api.entity.SubOrderEntity;
import com.api.entity.SubOrderNicEntity;
import com.api.entity.SubOrderUserEntity;
import com.api.entity.SubServSoftwareImageEntity;
import com.api.entity.SubTaskEntity;
import com.api.entity.TaskEntity;
import com.api.entity.UserEntity;
import com.api.exception.APIException;
import com.api.util.DateUtils;
import com.api.util.HttpClientUtils;
import com.api.util.NumberUtils;
import com.api.util.PrimaryKeyUtils;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * ��������ҵ������
 * 
 * @author HCK
 *
 */
@Service("orderService")
public class OrderService extends BaseService {

	@Resource
	private OrderDao orderDao;
	
	@Resource
	private SubOrderDao subOrderDao;
	
	@Resource
	private SubOrderNicDao subOrderNicDao;
	
	@Resource
	private SubOrderUserDao subOrderUserDao;
	
	@Resource
	private DefinitionSubServDao definitionSubServDao;
	
	@Resource
	private SubServSoftwareImageDao subServSoftwareImageDao;
	
	@Resource
	private DefinitionSubServArchDao definitionSubServArchDao;

	@Resource
	private DefinitionSubServUnitScaleDao definitionSubServUnitScaleDao;
	
	@Resource
	private DefinitionSubServNicDao definitionSubServNicDao;
	
	@Resource
	private AreaDao areaDao;
	
	@Resource
	private TaskDao taskDao;
	
	@Resource
	private SubTaskDao subTaskDao;
	
	@Resource
	private NfsBackupDao nfsBackupDao;
	
	@Resource
	private NetworkingDao networkingDao;
	
	@Resource
	private ClusterDao clusterDao;
	
	@Resource
	private ServDao servDao;
	
	@Resource
	private SubServDao subServDao;
	
	@Resource
	private SubServNicDao subServNicDao;
	
	@Resource
	private SubServUserDao subServUserDao;
	
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
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);
			if (user.getUserRole().getCode().equals("tenant")) {
				param.put("createUserLoginName", user.getLoginName());
			}
			param.put("primary", true);
			List<OrderEntity> orderList = orderDao.list(param);
			JSONArray jsonArray = new JSONArray();
			for (OrderEntity order : orderList) {
				OrderDto orderDto = new OrderDto();
				orderDto.setId(order.getId());
				orderDto.setServBusinessName(order.getServBusinessName());
				orderDto.setSiteName(order.getSite().getName());
				orderDto.setCreateLoginUserName(order.getCreateUserLoginName());
				orderDto.setCreateDateTime(DateUtils.dateTimeToString(order.getCreateDateTime()));
				SubOrderEntity primarySubOrder = order.getSubOrderList().get(0);
				orderDto.setDataDirSize(NumberUtils.toG(primarySubOrder.getDataDirSize()));
				SubServSoftwareImageEntity subServSoftwareImage = primarySubOrder.getSubServSoftwareImage();
				DefinitionSubServSoftwareEntity dfSubServSoftware = subServSoftwareImage.getDefinitionSubServSoftware();
				String softwareName = primarySubOrder.getDefinitionSubServ().getName() + "_" + dfSubServSoftware.getMajorVersion() + "."
						+ dfSubServSoftware.getMinorVersion() + "." + subServSoftwareImage.getPatchVersion();
				orderDto.setSoftwareName(softwareName);
				orderDto.setArchName(primarySubOrder.getDefinitionSubServArch().getName());
				orderDto.setScaleName(primarySubOrder.getDefinitionSubServUnitScale().getName());
				orderDto.setStatus(order.getStatus());
				orderDto.setStatusText(getTextByCode(DictTypeConstants.ORDER_STATUS, order.getStatus()));
				orderDto.setDefinitionServId(order.getDefinitionServ().getId());
				jsonArray.add(orderDto);
			}
			return RespJsonFactory.buildSuccess(jsonArray);
		} catch (Exception e) {
			logger.error("������ѯ�쳣", e);
			throw new APIException("������ѯ�쳣:" + e.getMessage());
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

			// ���������
			String dfServId = (String) param.get("definitionServId");
			// վ�����
			String siteId = (String) param.get("siteId");
			// ����ҵ�����
			String servBusinessCode = (String) param.get("servBusinessCode");
			// ����ҵ������
			String servBusinessName = (String) param.get("servBusinessName");
			// ����Ŀ¼����
			Integer dataDirSize = (Integer) param.get("dataDirSize");
			// ����Ŀ¼����
			String dataDirDeviceType = (String) param.get("dataDirDeviceType");
			// ��󱸷ݿռ�
			Integer maxBackupSpace = (Integer) param.get("maxBackupSpace");
			// �����ļ���������
			Integer backupFilesRetention = (Integer) param.get("backupFilesRetention");
			// �����ӷ�������������
			String subServSoftwareImageId = (String) param.get("subServSoftwareImageId");
			// �ӷ���ܹ��������
			String dfSubServArchId = (String) param.get("definitionSubServArchId");
			// �ӷ���Ԫ��ģ�������
			String dfSubServUnitScaleId = (String) param.get("definitionSubServUnitScaleId");
			// ��������
			String orderId = PrimaryKeyUtils.uniqueId();
			
			// ���������־
			OperateLogEntity operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_ORDER,
					DictConstants.OPERATE_ACTION_ADD, orderId, servBusinessName, user.getLoginName());
			
			// ���湤��
			OrderEntity order = new OrderEntity();
			order.setId(orderId);
			DefinitionServEntity dfServ = new DefinitionServEntity();
			dfServ.setId(dfServId);
			order.setDefinitionServ(dfServ);
			SiteEntity site = new SiteEntity();
			site.setId(siteId);
			order.setSite(site);
			Map<String, Object> areaMap = new HashMap<String, Object>();
			areaMap.put("siteId", siteId);
			areaMap.put("enabled", true);
			// Ĭ��ѡ��һ�����õ�����
			order.setArea(areaDao.list(areaMap).get(0));
			order.setServBusinessCode(servBusinessCode);
			order.setServBusinessName(servBusinessName);
			order.setType(DictConstants.ORDER_TYPE_CREATE);
			order.setStatus(DictConstants.ORDER_STATUS_UNAPPROVED);
			order.setCreateDateTime(operateLog.getCreateDateTime());
			order.setCreateUserLoginName(user.getLoginName());
			orderDao.save(order);
			
			// ���ݷ���������ȡ�÷������µ��ӷ�����
			// һ��������N���ӷ��񹹳ɣ�ÿ���ӷ����Ӧһ���ӹ���
			List<DefinitionSubServEntity> dfSubServList = definitionSubServDao.list(param);
			for (DefinitionSubServEntity dfSubServ : dfSubServList){
				SubOrderEntity subOrder = new SubOrderEntity();
				subOrder.setId(PrimaryKeyUtils.uniqueId());
				subOrder.setDefinitionSubServ(dfSubServ);
				// �ж��ǲ�����Ҫ�ӷ���
				if (dfSubServ.isPrimary()) {
					SubServSoftwareImageEntity subServSoftwareImage = new SubServSoftwareImageEntity();
					subServSoftwareImage.setId(subServSoftwareImageId);
					subOrder.setSubServSoftwareImage(subServSoftwareImage);
					subOrder.setDefinitionSubServArch(definitionSubServArchDao.get(dfSubServArchId));
					subOrder.setDefinitionSubServUnitScale(definitionSubServUnitScaleDao.get(dfSubServUnitScaleId));
					subOrder.setDataDirSize(dataDirSize);
					subOrder.setDataDirDeviceType(dataDirDeviceType);
					subOrder.setMaxBackupSpace(maxBackupSpace);
					subOrder.setBackupFilesRetention(backupFilesRetention);
				} else {
					Map<String, Object> subServSoftwareImageParamMap = new HashMap<String, Object>();
					subServSoftwareImageParamMap.put("siteId", siteId);
					subServSoftwareImageParamMap.put("definitionSubServId", dfSubServ.getId());
					subServSoftwareImageParamMap.put("enabled", true);
					List<SubServSoftwareImageEntity> subServSoftwareImageList = 
							subServSoftwareImageDao.listSubServSoftwareImageVersion(subServSoftwareImageParamMap);
					subOrder.setSubServSoftwareImage(subServSoftwareImageList.get(0));
					subOrder.setDefinitionSubServArch(dfSubServ.getDefaultDefinitionSubServArch());
					subOrder.setDefinitionSubServUnitScale(dfSubServ.getDefaultDefinitionSubServUnitScale());
					subOrder.setDataDirSize(dfSubServ.getDefaultDataDirSize());
					subOrder.setDataDirDeviceType(dfSubServ.getDefaultDataDirDeviceType());
					subOrder.setMaxBackupSpace(dfSubServ.getDefaultMaxBackupSpace());
					subOrder.setBackupFilesRetention(dfSubServ.getDefaultBackupFilesRetention());
				}
				subOrder.setLogDirSize(dfSubServ.getDefaultLogDirSize());
				subOrder.setLogDirDeviceType(dfSubServ.getDefaultLogDirDeviceType());
				subOrder.setOrder(order);
				subOrderDao.save(subOrder);
				
				// �����ӹ����û�
				if (dfSubServ.isUserManager()) {
					// ���������û�
					String username = (String) param.get("username");
					String password = (String) param.get("password");
					String dfUserRoleId = (String) param.get("definitionUserRoleId");
					SubOrderUserEntity subOrderDataUser = new SubOrderUserEntity();
					subOrderDataUser.setId(PrimaryKeyUtils.uniqueId());
					subOrderDataUser.setSubOrder(subOrder);
					subOrderDataUser.setUsername(username);
					subOrderDataUser.setPassword(password);
					DefinitionUserRoleEntity dfUserRole = new DefinitionUserRoleEntity();
					dfUserRole.setId(dfUserRoleId);
					subOrderDataUser.setDefinitionUserRole(dfUserRole);
					subOrderDataUser.setOwner(user.getLoginName());
					subOrderUserDao.save(subOrderDataUser);
				}
				
				if (dfSubServ.getDefaultRootUsername() != null 
						&& !dfSubServ.getDefaultRootUsername().trim().equals("")) {
					// �������Ա�û�
					SubOrderUserEntity subOrderRootUser = new SubOrderUserEntity();
					subOrderRootUser.setId(PrimaryKeyUtils.uniqueId());
					subOrderRootUser.setSubOrder(subOrder);
					subOrderRootUser.setUsername(dfSubServ.getDefaultRootUsername());
					subOrderRootUser.setPassword(dfSubServ.getDefaultRootPassword());
					DefinitionUserRoleEntity dfUserRole_root = new DefinitionUserRoleEntity();
					dfUserRole_root.setId(dfSubServ.getDefaultRootUserRoleId());
					subOrderRootUser.setDefinitionUserRole(dfUserRole_root);
					subOrderRootUser.setOwner("root");
					subOrderUserDao.save(subOrderRootUser);
					
					// �������û�
					SubOrderUserEntity subOrderMonitorUser = new SubOrderUserEntity();
					subOrderMonitorUser.setId(PrimaryKeyUtils.uniqueId());
					subOrderMonitorUser.setSubOrder(subOrder);
					subOrderMonitorUser.setUsername(dfSubServ.getDefaultMonitorUsername());
					subOrderMonitorUser.setPassword(dfSubServ.getDefaultMonitorPassword());
					DefinitionUserRoleEntity dfUserRole_monitor = new DefinitionUserRoleEntity();
					dfUserRole_monitor.setId(dfSubServ.getDefaultMonitorUserRoleId());
					subOrderMonitorUser.setDefinitionUserRole(dfUserRole_monitor);
					subOrderMonitorUser.setOwner("root");
					subOrderUserDao.save(subOrderMonitorUser);
					
					// ���渴���û�
					SubOrderUserEntity subOrderReplicationUser = new SubOrderUserEntity();
					subOrderReplicationUser.setId(PrimaryKeyUtils.uniqueId());
					subOrderReplicationUser.setSubOrder(subOrder);
					subOrderReplicationUser.setUsername(dfSubServ.getDefaultReplicationUsername());
					subOrderReplicationUser.setPassword(dfSubServ.getDefaultReplicationPassword());
					DefinitionUserRoleEntity dfUserRole_replication = new DefinitionUserRoleEntity();
					dfUserRole_replication.setId(dfSubServ.getDefaultReplicationUserRoleId());
					subOrderReplicationUser.setDefinitionUserRole(dfUserRole_replication);
					subOrderReplicationUser.setOwner("root");
					subOrderUserDao.save(subOrderReplicationUser);
				}
				
				// ��������δ��ȫȷ������������δ�͹���һ��ʹ��һ��sql���ʵ��
				// �����ӹ�������
				Map<String, Object> subServNicMap = new HashMap<String, Object>();
				subServNicMap.put("defitionSubServId", dfSubServ.getId());
				List<DefinitionSubServNicEntity> dfSubServNicList = definitionSubServNicDao.list(subServNicMap);
				for (DefinitionSubServNicEntity dfSubServNic : dfSubServNicList){
					SubOrderNicEntity subOrderNic = new SubOrderNicEntity();
					subOrderNic.setId(PrimaryKeyUtils.uniqueId());
					subOrderNic.setSubOrder(subOrder);
					subOrderNic.setNicPhyType(dfSubServNic.getNicPhyType());
					subOrderNic.setNicHaType(dfSubServNic.getNicHaType());
					subOrderNic.setNetworkBandWidth(dfSubServNic.getNetworkBandWidth());
					subOrderNicDao.save(subOrderNic);
				}
			}
			return RespJsonFactory.buildSuccess("���������ɹ�");
		} catch (Exception e) {
			logger.error("���������쳣", e);
			throw new APIException("���������쳣:" + e.getMessage());
		}
	}

	/**
	 * �����༭
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
//	@SuppressWarnings("unchecked")
	@Override
	@Transactional(rollbackFor = APIException.class)
	public RespJson update(HttpServletRequest request, Map<String, Object> param) throws APIException {
//		try {
//			HttpSession session = request.getSession();
//			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);
//			String id = (String)param.get("id");
//			OrderEntity order = orderDao.get(id);
//			if (order == null) {
//				return RespJsonFactory.buildWarning("�ù����ѱ������û�ɾ��");
//			} else {
//				// ���������־
//				saveOperateLog(DictConstants.OPERATE_MODEL_ORDER, DictConstants.OPERATE_ACTION_UPDATE, order.getId(),
//						order.getServBusinessName(), user.getLoginName());
//				
//				String siteId = (String) param.get("siteId");
//				if (!order.getSite().getId().equals(siteId)) {
//					String areaId = (String) param.get("areaId");
//					AreaEntity area = null;
//					if (StringUtils.isNotBlank(areaId)) {
//						area = new AreaEntity();
//						area.setId(areaId);
//					} else {
//						Map<String, Object> areaMap = new HashMap<String, Object>();
//						areaMap.put("siteId", siteId);
//						areaMap.put("enabled", true);
//						area = areaDao.list(areaMap).get(0);
//					}
//					order.setArea(area);
//				}
//				
//				String servBusinessCode = (String) param.get("servBusinessCode");
//				if (StringUtils.isNotBlank(servBusinessCode)) {
//					order.setServBusinessCode(servBusinessCode);
//				}
//				
//				String servBusinessName = (String) param.get("servBusinessName");
//				if (StringUtils.isNotBlank(servBusinessName)) {
//					order.setServBusinessName(servBusinessName);
//				}
//				orderDao.update(order);
//				List<Map<String, Object>> dfSubServList = (List<Map<String, Object>>) param.get("definitionSubServ");
//				List<SubOrderEntity> subOrderList = order.getSubOrderList();
//				for (SubOrderEntity  subOrder : subOrderList) {
//					for (Map<String, Object> map : dfSubServList) {
//						if (map.get("id").equals(subOrder.getDefinitionSubServ().getId())) {
//							String dfUserRoleId = (String) map.get("definitionUserRoleId");
//							if (StringUtils.isNotBlank(dfUserRoleId)) {
//								String username = (String) map.get("username");
//								String password = (String) map.get("password");
//								SubOrderUserEntity subOrderUser = new SubOrderUserEntity();
//								subOrderUser.setSubOrder(subOrder);
//								subOrderUser.setUsername(username);
//								subOrderUser.setPassword(password);
//								DefinitionUserRoleEntity dfUserRole = new DefinitionUserRoleEntity();
//								dfUserRole.setId(dfUserRoleId);
//								subOrderUser.setDefinitionUserRole(dfUserRole);
//								subOrderUserDao.update(subOrderUser);
//							}
//							String subServSoftwareImageId = (String) map.get("subServSoftwareImageId");
//							if (StringUtils.isNotBlank(subServSoftwareImageId)) {
//								SubServSoftwareImageEntity subServSoftwareImage = new SubServSoftwareImageEntity();
//								subServSoftwareImage.setId(subServSoftwareImageId);
//								subOrder.setSubServSoftwareImage(subServSoftwareImage);	
//							}
//							
//							String dfSubServArchId = (String) map.get("definitionSubServArchId");
//							if (StringUtils.isNotBlank(dfSubServArchId)) {
//								DefinitionSubServArchEntity dfSubServArch = new DefinitionSubServArchEntity();
//								dfSubServArch.setId(dfSubServArchId);
//								subOrder.setDefinitionSubServArch(dfSubServArch);
//							}
//							
//							String dfSubServUnitScaleId = (String) map.get("definitionSubServUnitScaleId");
//							if (StringUtils.isNotBlank(dfSubServUnitScaleId)) {
//								DefinitionSubServUnitScaleEntity dfSubServUnitScale = new DefinitionSubServUnitScaleEntity();
//								dfSubServUnitScale.setId(dfSubServUnitScaleId);
//								subOrder.setDefinitionSubServUnitScale(dfSubServUnitScale);
//							}
//							
//							Integer dataDirSize = (Integer) map.get("dataDirSize");
//							if (dataDirSize != null) {
//								subOrder.setDataDirSize(dataDirSize);
//							}
//							
//							String dataDirDeviceType = (String) map.get("dataDirDeviceType");
//							if (StringUtils.isNotBlank(dataDirDeviceType)) {
//								subOrder.setDataDirDeviceType(dataDirDeviceType);
//							}
//							
//							Integer logDirSize = (Integer) map.get("logDirSize");
//							if (logDirSize != null) {
//								subOrder.setLogDirSize(logDirSize);
//							}
//							
//							String logDirDeviceType = (String) map.get("logDirDeviceType");
//							if (StringUtils.isNotBlank(logDirDeviceType)) {
//								subOrder.setLogDirDeviceType(logDirDeviceType);
//							}
//							
//							
//							Integer maxBackupSpace = (Integer) map.get("maxBackupSpace");
//							if (maxBackupSpace != null) {
//								subOrder.setMaxBackupSpace(maxBackupSpace);
//							}
//							
//							Integer backupFilesRetention = (Integer) map.get("backupFilesRetention");
//							if (backupFilesRetention != null) {
//								subOrder.setBackupFilesRetention(backupFilesRetention);
//							}
//							subOrderDao.update(subOrder);
//							break;
//						}
//					}
//				}
//				return RespJsonFactory.buildSuccess("�����༭�ɹ�");
//			}
//		} catch (Exception e) {
//			logger.error("�����༭�쳣", e);
//			throw new APIException("�����༭�쳣:" + e.getMessage());
//		}
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
	@Transactional(rollbackFor = APIException.class)
	public RespJson audit(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);
			String id = (String)param.get("id");
			OrderEntity order = orderDao.get(id);
			if (order == null) {
				return RespJsonFactory.buildWarning("�ù����ѱ������û�ɾ��");
			} else {
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_ORDER, DictConstants.OPERATE_ACTION_AUDIT, order.getId(),
						order.getServBusinessName(), user.getLoginName());
				String status = (String) param.get("status");
				String msg = (String) param.get("msg");
				order.setStatus(status);
				order.setMsg(msg);
				orderDao.updateStatus(order);
				return RespJsonFactory.buildSuccess("���������ɹ�");
			}
		} catch (Exception e) {
			logger.error("���������쳣", e);
			throw new APIException("���������쳣:" + e.getMessage());
		}
	}
	
	/**
	 * ����ִ��
	 * 
	 * @param request
	 * @param param
	 * @return
	 * @throws APIException
	 */
	@SuppressWarnings("unchecked")
	@Transactional(rollbackFor = APIException.class)
	public RespJson execute(HttpServletRequest request, Map<String, Object> param) throws APIException {
		try {
			HttpSession session = request.getSession();
			UserEntity user = (UserEntity) session.getAttribute(SysConstants.SESSION_USER);
			String loginName = user.getLoginName();
			String id = (String)param.get("id");
			
			OrderEntity order = null;
			try {
				order = orderDao.get(id);
			} catch (Exception e) {
				logger.error("����ִ���쳣:����ȡ������Ϣ�쳣��", e);
				throw new APIException("����ִ���쳣:����ȡ������Ϣ�쳣��");
			}
			
			if (order == null) {
				return RespJsonFactory.buildWarning("�ù����ѱ������û�ɾ��");
			} 
			
			String objName = order.getServBusinessName();
			OperateLogEntity operateLog = null;
			try {
				// ���������־
				operateLog = saveOperateLog(DictConstants.OPERATE_MODEL_ORDER, DictConstants.OPERATE_ACTION_EXECUTE,
						order.getId(), order.getServBusinessName(), user.getLoginName());
				logger.info("��(" + loginName + ")����ִ��_" + objName + "��-���������־������");
			} catch (Exception e) {
				logger.error("����ִ���쳣:�����������־�쳣��", e);
				throw new APIException("����ִ���쳣:�����������־�쳣��");
			}
			
			
//			String areaId = (String) param.get("areaId");
//			if (StringUtils.isBlank(areaId)) {
//				throw new APIException("����ִ��ʧ��:��������Ϊ�ա�");
//			} 
//			AreaEntity area = new AreaEntity();
//			area.setId(areaId);
//			order.setArea(area);
//			
//			try {
//				orderDao.update(order);
//				logger.info("��(" + loginName + ")����ִ��_" + objName + "��-���¹�����Ϣ������");
//			} catch (Exception e) {
//				logger.error("����ִ���쳣:�����¹�����Ϣ�쳣��", e);
//				throw new APIException("����ִ���쳣:�����¹�����Ϣ�쳣��");
//			}
			
			List<Map<String, Object>> dfSubServList = null;
			try {
				dfSubServList = (List<Map<String, Object>>) param.get("definitionSubServ");
			} catch (Exception e) {
				logger.error("����ִ���쳣:��������ʽ����", e);
				throw new APIException("����ִ���쳣:��������ʽ����");
			}
			
			List<SubOrderEntity> subOrderList = order.getSubOrderList();
			if (subOrderList.size() < 1) {
				throw new APIException("����ִ���쳣:��������ѯ�����ӹ�����Ϣ��");
			}
			for (SubOrderEntity  subOrder : subOrderList) {
				for (Map<String, Object> map : dfSubServList) {
					DefinitionSubServEntity dfSubServ = subOrder.getDefinitionSubServ();
					if (dfSubServ == null) {
						throw new APIException("����ִ��ʧ��:��������ѯ���ӷ�����ΪNULL��");
					}
					if (map.get("id").equals(dfSubServ.getId())) {
						String dfSubServName = dfSubServ.getName();
						String dfUserRoleId = (String) map.get("definitionUserRoleId");
						if (StringUtils.isNotBlank(dfUserRoleId)) {
							String username = (String) map.get("username");
							String password = (String) map.get("password");
							SubOrderUserEntity subOrderUser = new SubOrderUserEntity();
							subOrderUser.setSubOrder(subOrder);
							subOrderUser.setUsername(username);
							subOrderUser.setPassword(password);
							DefinitionUserRoleEntity dfUserRole = new DefinitionUserRoleEntity();
							dfUserRole.setId(dfUserRoleId);
							subOrderUser.setDefinitionUserRole(dfUserRole);
							try {
								subOrderUserDao.update(subOrderUser);
								logger.info("��(" + loginName + ")����ִ��_" + objName + "��-�����ӹ����û���Ϣ(" + dfSubServName + ")������");
							} catch (Exception e) {
								logger.error("����ִ���쳣:�������ӹ����û���Ϣ�쳣(" + dfSubServName + ")��", e);
								throw new APIException("����ִ���쳣:�������ӹ����û���Ϣ�쳣(" + dfSubServName + ")��");
							}
						}
						String subServSoftwareImageId = (String) map.get("subServSoftwareImageId");
						if (StringUtils.isNotBlank(subServSoftwareImageId)) {
							SubServSoftwareImageEntity subServSoftwareImage = new SubServSoftwareImageEntity();
							subServSoftwareImage.setId(subServSoftwareImageId);
							subOrder.setSubServSoftwareImage(subServSoftwareImage);	
						}
						
						String dfSubServArchId = (String) map.get("definitionSubServArchId");
						if (StringUtils.isNotBlank(dfSubServArchId)) {
							DefinitionSubServArchEntity dfSubServArch = new DefinitionSubServArchEntity();
							dfSubServArch.setId(dfSubServArchId);
							subOrder.setDefinitionSubServArch(dfSubServArch);
						}
						
						String dfSubServUnitScaleId = (String) map.get("definitionSubServUnitScaleId");
						if (StringUtils.isNotBlank(dfSubServUnitScaleId)) {
							DefinitionSubServUnitScaleEntity dfSubServUnitScale = new DefinitionSubServUnitScaleEntity();
							dfSubServUnitScale.setId(dfSubServUnitScaleId);
							subOrder.setDefinitionSubServUnitScale(dfSubServUnitScale);
						}
						
						Integer dataDirSize = (Integer) map.get("dataDirSize");
						if (dataDirSize != null) {
							subOrder.setDataDirSize(dataDirSize);
						}
						
						String dataDirDeviceType = (String) map.get("dataDirDeviceType");
						if (StringUtils.isNotBlank(dataDirDeviceType)) {
							subOrder.setDataDirDeviceType(dataDirDeviceType);
						}
						
						Integer logDirSize = (Integer) map.get("logDirSize");
						if (logDirSize != null) {
							subOrder.setLogDirSize(logDirSize);
						}
						
						String logDirDeviceType = (String) map.get("logDirDeviceType");
						if (StringUtils.isNotBlank(logDirDeviceType)) {
							subOrder.setLogDirDeviceType(logDirDeviceType);
						}
						
						Integer maxBackupSpace = (Integer) map.get("maxBackupSpace");
						if (maxBackupSpace != null) {
							subOrder.setMaxBackupSpace(maxBackupSpace);
						}
						
						Integer backupFilesRetention = (Integer) map.get("backupFilesRetention");
						if (backupFilesRetention != null) {
							subOrder.setBackupFilesRetention(backupFilesRetention);
						}
						try {
							subOrderDao.update(subOrder);
							logger.info("��(" + loginName + ")����ִ��_" + objName + "��-�����ӹ�����Ϣ(" + dfSubServName + ")������");
						} catch (Exception e) {
							logger.error("����ִ���쳣:�������ӹ����쳣(" + dfSubServName + ")��", e);
							throw new APIException("����ִ���쳣:�������ӹ����쳣(" + dfSubServName + ")��");
						}
						break;
					}
				}
			}
			
			// ��ȡ�¹���
			OrderEntity newOrder = null;
			try {
				newOrder = orderDao.get(id);
			} catch (Exception e) {
				logger.error("����ִ���쳣:����ȡ���º�Ĺ�����Ϣ�쳣��", e);
				throw new APIException("����ִ���쳣:����ȡ���º�Ĺ�����Ϣ�쳣��");
			}
			
			TaskEntity task = new TaskEntity();
			task.setId(PrimaryKeyUtils.uniqueId());
			task.setObjType(DictConstants.TASK_OBJ_TYPE_ORDER);
			task.setObjId(id);
			task.setActionType(DictConstants.TASK_ACTION_TYPE_EXECUTE);
			task.setStartDateTime(operateLog.getCreateDateTime());
			task.setStatus(DictConstants.TASK_STATUS_CREATE_NO);
			task.setOperateLog(operateLog);
			task.setCreateUserLoginName(user.getLoginName());
			try {
				taskDao.save(task);
				logger.info("��(" + loginName + ")����ִ��_" + objName + "��-�������񡣡���");
			} catch (Exception e) {
				logger.error("����ִ���쳣:�����������쳣��", e);
				throw new APIException("����ִ���쳣:�����������쳣��");
			}
			
			List<SubOrderEntity> newSubOrderList = newOrder.getSubOrderList();
			if (newSubOrderList.size() < 1) {
				throw new APIException("����ִ���쳣:��������ѯ���޸��º���ӹ�����Ϣ��");
			}
			
			NfsBackupEntity nfsBackup = nfsBackupDao.getByAreaId(newOrder.getArea().getId());
			
			Map<String, Object> networkingMap = new HashMap<String, Object>();
			networkingMap.put("areaId", newOrder.getArea().getId());
			networkingMap.put("enabled", true);
			List<NetworkingEntity> networkingList = networkingDao.list(networkingMap);
			if (networkingList.size() < 1) {
				throw new APIException("����ִ���쳣:�����������޿������Ρ�");
			}
			
			int maxPriority = 0;
			for (SubOrderEntity newSubOrder : newSubOrderList) {
				DefinitionSubServEntity dfSubServ = newSubOrder.getDefinitionSubServ();
				String dfSubServName = dfSubServ.getName();
				SubTaskEntity subTask = new SubTaskEntity();
				subTask.setId(PrimaryKeyUtils.uniqueId());
				subTask.setObjType(DictConstants.TASK_OBJ_TYPE_SUBORDER);
				subTask.setObjId(newSubOrder.getId());
				subTask.setActionType(DictConstants.TASK_ACTION_TYPE_EXECUTE);
				subTask.setAsync(true);
				subTask.setStartDateTime(task.getStartDateTime());
				subTask.setStatus(DictConstants.TASK_STATUS_CREATE_RUNNING);
				String url = "/" + SysConstants.URL_VERSION + "/services";
				subTask.setUrl(url);
				subTask.setMethodType(HttpClientUtils.METHOD_POST);
				JSONObject paramJson = new JSONObject();
				
				paramJson.put("name", newOrder.getServBusinessName());
				SubServSoftwareImageEntity subServSoftwareImage = newSubOrder.getSubServSoftwareImage();
				DefinitionSubServSoftwareEntity dfSubServSoftware = subServSoftwareImage.getDefinitionSubServSoftware();
				String imageVersion = dfSubServName + "_" + dfSubServSoftware.getMajorVersion() + "."
						+ dfSubServSoftware.getMinorVersion() + "." + subServSoftwareImage.getPatchVersion();
				paramJson.put("image_version", imageVersion);
				
				DefinitionSubServArchEntity dfSubServArch = newSubOrder.getDefinitionSubServArch();
				DefinitionSubServUnitScaleEntity dfSubServUnitScale = newSubOrder.getDefinitionSubServUnitScale();
				paramJson.put("tag", newOrder.getServBusinessCode());
				paramJson.put("auto_healing", false);
				paramJson.put("auto_scaling", false);
				paramJson.put("high_available", true);
				
				JSONObject architectureJson = new JSONObject();
				paramJson.put("architecture", architectureJson);
				architectureJson.put("mode", dfSubServArch.getType());
				architectureJson.put("code", dfSubServArch.getCode());
				architectureJson.put("unit_num", dfSubServArch.getUnitNum());
				
				JSONObject backupJson = new JSONObject();
				paramJson.put("backup", backupJson);
				backupJson.put("nfs_mount_dir", nfsBackup.getNfsMountDir());
				backupJson.put("max_space", NumberUtils.gToByte(newSubOrder.getMaxBackupSpace()));
				backupJson.put("backup_files_retention", newSubOrder.getBackupFilesRetention());
				
				JSONObject unitRequireJson = new JSONObject();
				paramJson.put("unit_require", unitRequireJson);
				
				JSONObject requireJson = new JSONObject();
				unitRequireJson.put("require", requireJson);
				requireJson.put("ncpu", dfSubServUnitScale.getCpuNum());
				requireJson.put("memory", NumberUtils.gToByte(dfSubServUnitScale.getMemSize()));
				
				JSONArray volumesJsonArray = new JSONArray();
				unitRequireJson.put("volumes", volumesJsonArray);
				
				JSONObject volumeJson_data = new JSONObject();
				volumesJsonArray.add(volumeJson_data);
				volumeJson_data.put("name", "DATA");
				volumeJson_data.put("type", getDefinitionCode(newSubOrder.getDataDirDeviceType()));
				volumeJson_data.put("size", NumberUtils.gToByte(newSubOrder.getDataDirSize()));
				
				JSONObject volumeJson_log = new JSONObject();
				volumesJsonArray.add(volumeJson_log);
				volumeJson_log.put("name", "LOG");
				volumeJson_log.put("type", getDefinitionCode(newSubOrder.getLogDirDeviceType()));
				volumeJson_log.put("size", NumberUtils.gToByte(newSubOrder.getLogDirSize()));
				
				JSONArray networksJsonArray = new JSONArray();
				unitRequireJson.put("networks", networksJsonArray);
				List<SubOrderNicEntity> subOrderNicList = newSubOrder.getSubOrderNicList();
				for (SubOrderNicEntity subOrderNic : subOrderNicList) {
					JSONObject networkJson = new JSONObject();
					networkJson.put("bandwidth", subOrderNic.getNetworkBandWidth());
					networksJsonArray.add(networkJson);
				}
				
				String[] networkingIdArr = new String[networkingList.size()];
				paramJson.put("networking_id", networkingIdArr);
				for (int i = 0; i < networkingList.size(); i++) {
					NetworkingEntity networking = networkingList.get(i);
					networkingIdArr[i] = networking.getId();
				}
				
				Map<String, Object> clusterMap = new HashMap<String, Object>();
				clusterMap.put("areaId", newOrder.getArea().getId());
				clusterMap.put("enabled", true);
				clusterMap.put("definitionSubServId", newSubOrder.getDefinitionSubServ().getId());
				List<ClusterEntity> clusterList = clusterDao.listOrderCluster(clusterMap);
				if (clusterList.size() < 1) {
					throw new APIException("����ִ���쳣:���޿��ü�Ⱥ��");
				}
				
				String[] clusterIdArr = new String[clusterList.size()];
				paramJson.put("cluster_id", clusterIdArr);
				for (int i = 0; i < clusterList.size(); i++) {
					ClusterEntity cluster = clusterList.get(i);
					clusterIdArr[i] = cluster.getRelateId();
				}
				
				JSONArray usersJsonArray = new JSONArray();
				paramJson.put("users", usersJsonArray);
				List<SubOrderUserEntity> subOrderUserList = newSubOrder.getSubOrderUserList();
				if (subOrderUserList != null) {
					for (SubOrderUserEntity subOrderUser : subOrderUserList) {
						if (subOrderUser.getOwner().equals("root")) {
							JSONObject userJson = new JSONObject();
							userJson.put("name", subOrderUser.getUsername());
							userJson.put("password", subOrderUser.getPassword());
							userJson.put("privilege", subOrderUser.getDefinitionUserRole().getPrivilege());
							usersJsonArray.add(userJson);
						}
					}
				}
				
				subTask.setParam(paramJson.toJSONString());
				int priority = dfSubServ.getPriority();
				subTask.setPriority(priority);
				if (maxPriority < priority) {
					maxPriority = priority;
				}
				subTask.setTask(task);
				
				try {
					subTaskDao.save(subTask);
					logger.info("��(" + loginName + ")����ִ��_" + objName + "��-����������(" + dfSubServName + ")������");
				} catch (Exception e) {
					logger.error("����ִ���쳣:�������������쳣(" + dfSubServName + ")��", e);
					throw new APIException("����ִ���쳣:�������������쳣(" + dfSubServName + ")��");
				}
			}
			return RespJsonFactory.buildSuccess("����ִ�гɹ�");
		} catch (Exception e) {
			logger.error("����ִ���쳣", e);
			throw new APIException("����ִ���쳣:" + e.getMessage());
		}
	}

	/**
	 * ����ɾ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param id
	 *            ��������
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
			OrderEntity order = orderDao.get(id);
			if (order == null) {
				return RespJsonFactory.buildWarning("�ù����ѱ������û�ɾ��");
			} else {
				// ���������־
				saveOperateLog(DictConstants.OPERATE_MODEL_ORDER, DictConstants.OPERATE_ACTION_DELETE, order.getId(),
						order.getServBusinessName(), user.getLoginName());

				orderDao.remove(id);
				List<SubOrderEntity> subOrderList = order.getSubOrderList();
				for (SubOrderEntity subOrder : subOrderList) {
					subOrderDao.remove(subOrder.getId());
					subOrderNicDao.remove(subOrder.getId());
					subOrderUserDao.remove(subOrder.getId());
				}
				return RespJsonFactory.buildSuccess("����ɾ���ɹ�");
			}
		} catch (Exception e) {
			logger.error("����ɾ���쳣", e);
			throw new APIException("����ɾ���쳣:" + e.getMessage());
		}
	}

}
