package com.api.controller;

import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.api.constant.DictTypeConstants;
import com.api.dto.SelectDto;
import com.api.service.SelectService;

/**
 * SELECT�ؼ����ݻ�ȡ
 * 
 * @author HCK
 *
 */
@Controller
@RequestMapping("v1.0/selections")
public class SelectController {

	@Resource
	private SelectService selectService;

	/**
	 * ��վ�㡿
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "sites", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listSite(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listSite(paramMap);
	}

	/**
	 * ������
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "areas", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listArea(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listArea(paramMap);
	}

	/**
	 * �����ݴ洢��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "nfs-backups", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listNfsBackup(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listNfsBackup(paramMap);
	}

	/**
	 * ����Ⱥ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "clusters", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listCluster(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listCluster(paramMap);
	}

	/**
	 * �������
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "softwares", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listSoftware(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listSoftware(paramMap);
	}
	
	/**
	 * ������汾��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "softwares/versions", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listSoftwareVersion(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listSoftwareVersion(paramMap);
	}
	
	/**
	 * ����Ҫ�ӷ����������汾��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "softwares/primary-image-versions", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listPrimaryImageVersion(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listPrimaryImageVersion(paramMap);
	}
	
	/**
	 * ���ӷ����������汾��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "softwares/image-versions", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listImageVersion(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listImageVersion(paramMap);
	}

	/**
	 * ������
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "servs", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listServ(HttpServletRequest request) {
		return selectService.listServ();
	}
	
	/**
	 * ���û���ɫ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "primary-roles", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listPrimarySubServUserRole(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listPrimarySubServUserRole(paramMap);
	}

	/**
	 * ����Ҫ�ӷ���ܹ���
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "primary-archs", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listPrimarySubServArch(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listPrimarySubServArch(paramMap);
	}

	/**
	 * ����Ҫ�ӷ���Ԫ��ģ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param paramMap
	 *            �������
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "primary-scales", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listPrimarySubServUnitScale(HttpServletRequest request, @RequestParam Map<String, Object> paramMap) {
		return selectService.listPrimarySubServUnitScale(paramMap);
	}

	/**
	 * ���洢���͡�
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "storage-types", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listStorageType(HttpServletRequest request) {
		return selectService.list(DictTypeConstants.STORAGE_TYPE);
	}

//	/**
//	 * ���������͡�
//	 * 
//	 * @param request
//	 *            HttpServletRequest����
//	 * @return SELECT�б�
//	 */
//	@RequestMapping(value = "networking-types", method = RequestMethod.GET)
//	@ResponseBody
//	public List<SelectDto> listNetworkingType(HttpServletRequest request) {
//		return selectService.list(DictTypeConstants.NETWORKING_TYPE);
//	}
	
	/**
	 * ���������͡�
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "nic-phy-types", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listNicPhyType(HttpServletRequest request) {
		return selectService.list(DictTypeConstants.NIC_PHY_TYPE);
	}
	
	/**
	 * ������Ŀ¼���͡�
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "data-dir-types", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listdataDirType(HttpServletRequest request) {
		return selectService.list(DictTypeConstants.DATADIR_TYPE);
	}
	
	/**
	 * ����־Ŀ¼���͡�
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @return SELECT�б�
	 */
	@RequestMapping(value = "log-dir-types", method = RequestMethod.GET)
	@ResponseBody
	public List<SelectDto> listLogDirType(HttpServletRequest request) {
		return selectService.list(DictTypeConstants.LOGDIR_TYPE);
	}
	
}
