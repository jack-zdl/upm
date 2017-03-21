package com.api.entity;

import java.io.Serializable;

/**
 * ������ʵ����
 * 
 * @author HCK
 *
 */
public class DefinitionServEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���������
	 */
	private String id;

	/**
	 * ����������
	 */
	private String name;

	/**
	 * ����ͼ��
	 */
	private String icon;

	/**
	 * ��ȡid
	 *
	 * @return id id
	 */
	public String getId() {
		return id;
	}

	/**
	 * ����id
	 * 
	 * @param id
	 *            id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡname
	 *
	 * @return name name
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����name
	 * 
	 * @param name
	 *            name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡicon
	 *
	 * @return icon icon
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * ����icon
	 * 
	 * @param icon
	 *            icon
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinitionServEntity [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}

}
