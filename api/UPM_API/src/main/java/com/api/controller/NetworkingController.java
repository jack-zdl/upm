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
import com.api.service.NetworkingService;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * ���ι�����Ʋ�
 * 
 * @author HCK
 *
 */
@Controller
@RequestMapping("/v1.0/networkings")
public class NetworkingController {

	@Resource
	private NetworkingService networkingService;

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
	public RespJson listNetworking(HttpServletRequest request, @RequestParam Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = networkingService.list(request, param);
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
	public RespJson saveNetworking(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = networkingService.save(request, param);
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
	 * @param networkingId
	 *            ���α���
	 * @return �������
	 */
	@RequestMapping(value = "/{networkingId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RespJson removeNetworking(HttpServletRequest request, @PathVariable("networkingId") String networkingId) {
		RespJson respJson = null;
		try {
			respJson = networkingService.remove(request, networkingId);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}
}
