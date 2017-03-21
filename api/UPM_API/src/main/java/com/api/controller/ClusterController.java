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
import com.api.service.ClusterService;
import com.api.util.RespJson;
import com.api.util.RespJsonFactory;

/**
 * ��Ⱥ������Ʋ�
 * 
 * @author HCK
 *
 */
@Controller
@RequestMapping("v1.0/clusters")
public class ClusterController {

	@Resource
	private ClusterService clusterService;

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
	public RespJson listCluster(HttpServletRequest request, @RequestParam Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = clusterService.list(request, param);
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
	public RespJson saveCluster(HttpServletRequest request, @RequestBody Map<String, Object> param) {
		RespJson respJson = null;
		try {
			respJson = clusterService.save(request, param);
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
	 * @param clusterId
	 *            ��Ⱥ����
	 * @return �������
	 */
	@RequestMapping(value = "/{clusterId}", method = RequestMethod.DELETE)
	@ResponseBody
	public RespJson deregisterSite(HttpServletRequest request, @PathVariable("clusterId") String clusterId) {
		RespJson respJson = null;
		try {
			respJson = clusterService.remove(request, clusterId);
		} catch (APIException e) {
			respJson = RespJsonFactory.buildFailure(e.getMessage());
		}
		return respJson;
	}

}
