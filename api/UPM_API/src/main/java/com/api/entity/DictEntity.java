package com.api.entity;

import java.io.Serializable;

/**
 * �ֵ�ʵ����
 * 
 * @author HCK
 *
 */
public class DictEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ֵ����ʹ���
	 */
	private String code;

	/**
	 * �ֵ���������
	 */
	private String name;

	/**
	 * ��ȡ�ֵ����ʹ���
	 *
	 * @return code �ֵ����ʹ���
	 */
	public String getCode() {
		return code;
	}

	/**
	 * �����ֵ����ʹ���
	 *
	 * @param code
	 *            �ֵ����ʹ���
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ��ȡ�ֵ���������
	 *
	 * @return name �ֵ���������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����ֵ���������
	 *
	 * @param name
	 *            �ֵ���������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DictEntity [code=" + code + ", name=" + name + "]";
	}

}
