package com.api.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * ���ִ�������
 * 
 * @author HCK
 *
 */
public class NumberUtils {

	/**
	 * �ֽ�תG
	 * 
	 * @param longValue
	 *            ��ת��ֵ
	 * @return
	 */
	public static String byteToG(long byteValue) {
		double d = byteValue / 1024.0 / 1024 / 1024;
		BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);
		return bg.doubleValue() + "G";
	}
	
	public static String toG(double d) {
		BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);
		return bg.doubleValue() + "G"; 
	}
	
	public static long gToByte(int gValue) {
		long ret = gValue * 1024L * 1024 * 1024;
		return ret;
	}

}
