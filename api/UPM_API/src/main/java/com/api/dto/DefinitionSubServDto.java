package com.api.dto;

import java.io.Serializable;

/**
 * 
 * 
 * @author HCK
 *
 */
public class DefinitionSubServDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ��������
	 */
	private String id;

	/**
	 * �ӷ���������
	 */
	private String name;

	/**
	 * �ӷ�����ͼ��
	 */
	private String icon;

	/**
	 * ��ȡ�ӷ��������
	 *
	 * @return id �ӷ��������
	 */
	public String getId() {
		return id;
	}

	/**
	 * �����ӷ��������
	 * 
	 * @param id
	 *            �ӷ��������
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ�ӷ���������
	 *
	 * @return name �ӷ���������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����ӷ���������
	 * 
	 * @param name
	 *            �ӷ���������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ�ӷ�����ͼ��
	 *
	 * @return icon �ӷ�����ͼ��
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * �����ӷ�����ͼ��
	 * 
	 * @param icon
	 *            �ӷ�����ͼ��
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
		return "DefinitionSubServDto [id=" + id + ", name=" + name + ", icon=" + icon + "]";
	}

}
