package com.api.util;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;

/**
 * IP��������
 * 
 * @author HCK
 *
 */
public class IPUtils {

	/**
	 * �ȴӷ����������ip
	 * 
	 * @param request
	 * @return
	 */
	public static String getIp(HttpServletRequest request) {
		if (request == null) {
			return "";
		}
		String ip = request.getHeader("x-forwarded-for");
		if (StringUtils.isBlank(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;

	}

}
