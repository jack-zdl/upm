package com.api.entity;

import java.io.Serializable;

/**
 * SANʵ����
 * 
 * @author HCK
 *
 */
public class SanEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �洢����
	 */
	private String id;

	/**
	 * ����վ��
	 */
	private SiteEntity site;

	/**
	 * �洢����
	 */
	private String name;

	/**
	 * ��������
	 */
	private String relateId;

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
	 * ��ȡsite
	 *
	 * @return site site
	 */
	public SiteEntity getSite() {
		return site;
	}

	/**
	 * ����site
	 * 
	 * @param site
	 *            site
	 */
	public void setSite(SiteEntity site) {
		this.site = site;
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
	 * ��ȡrelateId
	 *
	 * @return relateId relateId
	 */
	public String getRelateId() {
		return relateId;
	}

	/**
	 * ����relateId
	 * 
	 * @param relateId
	 *            relateId
	 */
	public void setRelateId(String relateId) {
		this.relateId = relateId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SanEntity [id=" + id + ", site=" + site + ", name=" + name + ", relateId=" + relateId + "]";
	}

}
