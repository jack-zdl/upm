package com.api.dto;

import java.io.Serializable;

/**
 * �������ݴ������
 * 
 * @author HCK
 *
 */
public class BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Ψһ����
	 */
	private String id;

	/**
	 * ����ʱ��
	 */
	private String createDateTime;

	/**
	 * ������
	 */
	private String createLoginUserName;

	/**
	 * ��ȡΨһ����
	 *
	 * @return id Ψһ����
	 */
	public String getId() {
		return id;
	}

	/**
	 * ����Ψһ����
	 * 
	 * @param id
	 *            Ψһ����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ����ʱ��
	 *
	 * @return createDateTime ����ʱ��
	 */
	public String getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * ���ô���ʱ��
	 *
	 * @param createDateTime
	 *            ����ʱ��
	 */
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * ��ȡ������
	 *
	 * @return createLoginUserName ������
	 */
	public String getCreateLoginUserName() {
		return createLoginUserName;
	}

	/**
	 * ���ô�����
	 *
	 * @param createLoginUserName
	 *            ������
	 */
	public void setCreateLoginUserName(String createLoginUserName) {
		this.createLoginUserName = createLoginUserName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseDto [id=" + id + ", createDateTime=" + createDateTime + ", createLoginUserName="
				+ createLoginUserName + "]";
	}

}
