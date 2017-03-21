package com.api.dto;

import java.io.Serializable;

/**
 * ����б����ݴ��������
 * 
 * @author HCK
 *
 */
public class DefinitionSubServSoftwareDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ�������������
	 */
	private String id;

	/**
	 * ���汾��
	 */
	private String majorVersion;

	/**
	 * �ΰ汾��
	 */
	private String minorVersion;

	/**
	 * �ӷ���������
	 */
	private String name;

	/**
	 * �ӷ�����ͼ��
	 */
	private String icon;

	/**
	 * ��ȡ�ӷ�������������
	 *
	 * @return id �ӷ�������������
	 */
	public String getId() {
		return id;
	}

	/**
	 * �����ӷ�������������
	 * 
	 * @param id
	 *            �ӷ�������������
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ���汾��
	 *
	 * @return majorVersion ���汾��
	 */
	public String getMajorVersion() {
		return majorVersion;
	}

	/**
	 * �������汾��
	 * 
	 * @param majorVersion
	 *            ���汾��
	 */
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	/**
	 * ��ȡ�ΰ汾��
	 *
	 * @return minorVersion �ΰ汾��
	 */
	public String getMinorVersion() {
		return minorVersion;
	}

	/**
	 * ���ôΰ汾��
	 * 
	 * @param minorVersion
	 *            �ΰ汾��
	 */
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
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
		return "DefinitionSubServSoftwareDto [id=" + id + ", majorVersion=" + majorVersion + ", minorVersion="
				+ minorVersion + ", name=" + name + ", icon=" + icon + "]";
	}

}
