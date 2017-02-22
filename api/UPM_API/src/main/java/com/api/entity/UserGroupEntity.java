package com.api.entity;

import java.io.Serializable;

/**
 * �û����ʵ����
 * 
 * @author HCK
 *
 */
public class UserGroupEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ������
	 */
	private String id;

	/**
	 * �������
	 */
	private String name;

	/**
	 * ��ȡ������
	 *
	 * @return id ������
	 */
	public String getId() {
		return id;
	}

	/**
	 * ����������
	 *
	 * @param id
	 *            ������
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ�������
	 *
	 * @return name �������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����������
	 *
	 * @param name
	 *            �������
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
		return "UserGroupEntity [id=" + id + ", name=" + name + "]";
	}

}
