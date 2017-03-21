package com.api.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ���ڴ�������
 * 
 * @author HCK
 *
 */
public class DateUtils {
	
	/**
	 * ��ȡ��ǰʱ��
	 * 
	 * @return
	 */
	public static Date getCurrentDateTime() {
		return new Date();
	}
	
	public static String dateToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(date);
	}
	
	public static String dateTimeToString(Date date) {
		if (date == null) {
			return "";
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
	}
}
