package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ����������ʵ����
 * 
 * @author HCK
 *
 */
public class SubServSoftwareImageEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ�������������
	 */
	private String id;

	/**
	 * �����ӷ����������
	 */
	private DefinitionSubServSoftwareEntity definitionSubServSoftware;

	/**
	 * �޶��汾��
	 */
	private Integer patchVersion;

	/**
	 * ����վ��
	 */
	private SiteEntity site;

	/**
	 * �Ƿ����
	 */
	private boolean enabled;

	/**
	 * ��������
	 */
	private String relateId;

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
	 * ��ȡ�����ӷ����������
	 *
	 * @return definitionSubServSoftware �����ӷ����������
	 */
	public DefinitionSubServSoftwareEntity getDefinitionSubServSoftware() {
		return definitionSubServSoftware;
	}

	/**
	 * ���������ӷ����������
	 * 
	 * @param definitionSubServSoftware
	 *            �����ӷ����������
	 */
	public void setDefinitionSubServSoftware(DefinitionSubServSoftwareEntity definitionSubServSoftware) {
		this.definitionSubServSoftware = definitionSubServSoftware;
	}

	/**
	 * ��ȡ�޶��汾��
	 *
	 * @return patchVersion �޶��汾��
	 */
	public Integer getPatchVersion() {
		return patchVersion;
	}

	/**
	 * �����޶��汾��
	 * 
	 * @param patchVersion
	 *            �޶��汾��
	 */
	public void setPatchVersion(Integer patchVersion) {
		this.patchVersion = patchVersion;
	}

	/**
	 * ��ȡ����վ��
	 *
	 * @return site ����վ��
	 */
	public SiteEntity getSite() {
		return site;
	}

	/**
	 * ��������վ��
	 * 
	 * @param site
	 *            ����վ��
	 */
	public void setSite(SiteEntity site) {
		this.site = site;
	}

	/**
	 * �Ƿ����
	 *
	 * @return enabled �Ƿ����
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * �����Ƿ����
	 * 
	 * @param enabled
	 *            �Ƿ����
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return relateId ��������
	 */
	public String getRelateId() {
		return relateId;
	}

	/**
	 * ���ù�������
	 * 
	 * @param relateId
	 *            ��������
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
		return "SubServSoftwareImageEntity [id=" + id + ", definitionSubServSoftware=" + definitionSubServSoftware
				+ ", patchVersion=" + patchVersion + ", site=" + site + ", enabled=" + enabled + ", relateId="
				+ relateId + "]";
	}

}
