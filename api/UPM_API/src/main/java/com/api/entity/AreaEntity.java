package com.api.entity;

import java.io.Serializable;

/**
 * վ��ʵ����
 * 
 * @author HCK
 *
 */
public class AreaEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �������
	 */
	private String id;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ��������
	 */
	private String description;

	/**
	 * �Ƿ����
	 */
	private boolean enabled;

	/**
	 * ����վ��
	 */
	private SiteEntity site;

	/**
	 * ��ȡ�������
	 *
	 * @return id �������
	 */
	public String getId() {
		return id;
	}

	/**
	 * �����������
	 * 
	 * @param id
	 *            �������
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return name ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ������������
	 * 
	 * @param name
	 *            ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return description ��������
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ������������
	 * 
	 * @param description
	 *            ��������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��ȡ�����Ƿ����
	 *
	 * @return enabled �����Ƿ����
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * ���������Ƿ����
	 * 
	 * @param enabled
	 *            �����Ƿ����
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡ����վ��
	 *
	 * @return site ����վ�����
	 */
	public SiteEntity getSite() {
		return site;
	}

	/**
	 * ��������վ��
	 * 
	 * @param site
	 *            ����վ�����
	 */
	public void setSite(SiteEntity site) {
		this.site = site;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AreaEntity [id=" + id + ", name=" + name + ", description=" + description + ", enabled=" + enabled
				+ ", site=" + site + "]";
	}

}
