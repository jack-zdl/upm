package com.api.controller;

import java.util.List;
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

import com.api.dto.FileDto;
import com.api.exception.APIException;
import com.api.service.SoftwareImageService;
import com.api.service.SoftwareService;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * ���������Ʋ�
 * 
 * @author HCK
 *
 */
@Controller
@RequestMapping("/v1.0/softwares")
public class SoftwareController {

	@Resource
	private SoftwareService softwareService;
	
	@Resource
	private SoftwareImageService softwareImageService;

	/**
	 * �������ѯ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 */
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public RespJson listSoftware(HttpServletRequest request, @RequestParam Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = softwareService.list(request, param);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}
	
	/**
	 * ����������ѯ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 */
	@RequestMapping(value = "/images", method = RequestMethod.GET)
	@ResponseBody
	public RespJson listSoftwareImage(HttpServletRequest request, @RequestParam Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = softwareImageService.list(request, param);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}
	
	/**
	 * ����������ļ���ѯ��
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 */
	@RequestMapping(value = "/images/files", method = RequestMethod.GET)
	@ResponseBody
	public List<FileDto> listSoftwareImageFile(HttpServletRequest request, @RequestParam Map<String, Object> param) {
		return softwareImageService.listSoftwareImageFile(request, param);
	}
	
	/**
	 * ���������������
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param param
	 *            �������
	 * @return �������
	 */
	@RequestMapping(value = "/images", method = RequestMethod.POST)
	@ResponseBody
	public RespJson saveSoftwareImage(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = softwareImageService.save(request, param);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}
	
	/**
	 * ���������ɾ����
	 * 
	 * @param request
	 *            HttpServletRequest����
	 * @param softwareImageId
	 *            ����������
	 * @return �������
	 */
	@RequestMapping(value = "/images/{softwareImageId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RespJson removeSoftwareImage(HttpServletRequest request, @PathVariable("softwareImageId") String softwareImageId) {
		RespJson respJson = null;
		try {
			respJson = softwareImageService.remove(request, softwareImageId);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}

}
