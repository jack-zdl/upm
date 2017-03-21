package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ����������ʵ����
 * 
 * @author HCK
 *
 */
public class DefinitionSubServSoftwareEntity implements Serializable {

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
	private Integer majorVersion;

	/**
	 * �ΰ汾��
	 */
	private Integer minorVersion;

	/**
	 * �����ӷ�����
	 */
	private DefinitionSubServEntity definitionSubServ;

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
	public Integer getMajorVersion() {
		return majorVersion;
	}

	/**
	 * �������汾��
	 * 
	 * @param majorVersion
	 *            ���汾��
	 */
	public void setMajorVersion(Integer majorVersion) {
		this.majorVersion = majorVersion;
	}

	/**
	 * ��ȡ�ΰ汾��
	 *
	 * @return minorVersion �ΰ汾��
	 */
	public Integer getMinorVersion() {
		return minorVersion;
	}

	/**
	 * ���ôΰ汾��
	 * 
	 * @param minorVersion
	 *            �ΰ汾��
	 */
	public void setMinorVersion(Integer minorVersion) {
		this.minorVersion = minorVersion;
	}

	/**
	 * ��ȡ�����ӷ�����
	 *
	 * @return definitionSubServ �����ӷ�����
	 */
	public DefinitionSubServEntity getDefinitionSubServ() {
		return definitionSubServ;
	}

	/**
	 * ���������ӷ�����
	 * 
	 * @param definitionSubServ
	 *            �����ӷ�����
	 */
	public void setDefinitionSubServ(DefinitionSubServEntity definitionSubServ) {
		this.definitionSubServ = definitionSubServ;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinitionSubServSoftwareEntity [id=" + id + ", majorVersion=" + majorVersion + ", minorVersion="
				+ minorVersion + ", definitionSubServ=" + definitionSubServ + "]";
	}

}
