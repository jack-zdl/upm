package com.api.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.api.exception.APIException;
import com.api.service.NfsBackupService;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * �洢���ݹ�����Ʋ�
 * 
 * @author HCK
 *
 */
@Controller
@RequestMapping("v1.0/nfsBackups")
public class NfsBackupController {

	@Resource
	private NfsBackupService nfsBackupService;

	/**
	 * ����ѯ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public RespJson listNfsBackup(HttpServletRequest request, @RequestParam Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = nfsBackupService.list(request, param);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}

	/**
	 * ��������
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 */
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public RespJson saveNfsBackup(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = nfsBackupService.save(request, param);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}

	/**
	 * ��ɾ����
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param nfsBackupId
	 *            ���ݴ洢����
	 * @return �������
	 */
	@RequestMapping(value = "/{nfsBackupId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RespJson removeNfsBackup(HttpServletRequest request, @PathVariable("nfsBackupId") String nfsBackupId) {
		RespJson respJson = null;
		try {
			respJson = nfsBackupService.remove(request, nfsBackupId);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}

}
