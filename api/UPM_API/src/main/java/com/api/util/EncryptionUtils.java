package com.api.util;

import org.springframework.util.DigestUtils;

/**
 * ���ܴ�������
 * 
 * @author HCK
 *
 */
public class EncryptionUtils {

	/**
	 * ���ַ���md5����
	 * 
	 * @param str
	 * @return
	 */
	public static String getMD5(String str) {
		return DigestUtils.md5DigestAsHex(str.getBytes());
	}
	
	public static void main(String[] args) {
		System.out.println(getMD5("000000"));
	}
}
