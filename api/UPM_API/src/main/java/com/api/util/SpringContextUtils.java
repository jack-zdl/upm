package com.api.util;

import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SuppressWarnings({ "rawtypes", "unchecked" })
public class SpringContextUtils implements ApplicationContextAware {
	private static ApplicationContext applicationContext;

	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		applicationContext = arg0;
	}

	/**
	 * ��ȡapplicationContext����
	 * 
	 * @return
	 */
	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * ����bean��id�����Ҷ���
	 * 
	 * @param id
	 * @return
	 */
	public static Object getBeanById(String id) {
		return applicationContext.getBean(id);
	}

	/**
	 * ����bean��class�����Ҷ���
	 * 
	 * @param c
	 * @return
	 */
	public static Object getBeanByClass(Class c) {
		return applicationContext.getBean(c);
	}

	/**
	 * ����bean��class���������еĶ���(��������)
	 * 
	 * @param c
	 * @return
	 */
	public static Map getBeansByClass(Class c) {
		return applicationContext.getBeansOfType(c);
	}
}