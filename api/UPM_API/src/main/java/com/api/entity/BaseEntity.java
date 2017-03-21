package com.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����ʱ��
	 */
	private Date createDateTime;

	/**
	 * ������
	 */
	private String createUserLoginName;

	/**
	 * ��ȡ����ʱ��
	 *
	 * @return createDateTime ����ʱ��
	 */
	public Date getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * ���ô���ʱ��
	 *
	 * @param createDateTime
	 *            ����ʱ��
	 */
	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * ��ȡ������
	 *
	 * @return createUserLoginName ������
	 */
	public String getCreateUserLoginName() {
		return createUserLoginName;
	}

	/**
	 * ���ô�����
	 * 
	 * @param createUserLoginName
	 *            ������
	 */
	public void setCreateUserLoginName(String createUserLoginName) {
		this.createUserLoginName = createUserLoginName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BaseEntity [createDateTime=" + createDateTime + ", createUserLoginName=" + createUserLoginName + "]";
	}

}
