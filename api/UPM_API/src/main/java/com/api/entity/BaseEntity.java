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
	private String createLoginUserName;

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
		return "BaseEntity [createDateTime=" + createDateTime + ", createLoginUserName=" + createLoginUserName + "]";
	}

}
