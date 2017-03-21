package com.api.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ��Ⱥʵ����
 * 
 * @author HCK
 *
 */
public class ClusterEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ⱥ����
	 */
	private String id;

	/**
	 * ��Ⱥ����
	 */
	private String name;

	/**
	 * �Ƿ����
	 */
	private boolean enabled;

	/**
	 * ��������
	 */
	private String relateId;

	/**
	 * ��������
	 */
	private AreaEntity area;

	/**
	 * ���ݴ洢
	 */
	private NfsBackupEntity nfsBackup;

	/**
	 * �������
	 */
	private List<DefinitionSubServEntity> definitionSubServList;

	/**
	 * ��ȡ��Ⱥ����
	 *
	 * @return id ��Ⱥ����
	 */
	public String getId() {
		return id;
	}

	/**
	 * ���ü�Ⱥ����
	 * 
	 * @param id
	 *            ��Ⱥ����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ��Ⱥ����
	 *
	 * @return name ��Ⱥ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���ü�Ⱥ����
	 * 
	 * @param name
	 *            ��Ⱥ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��Ⱥ�Ƿ����
	 *
	 * @return enabled ��Ⱥ�Ƿ����
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * ���ü�Ⱥ�Ƿ����
	 * 
	 * @param enabled
	 *            ��Ⱥ�Ƿ����
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

	/**
	 * ��ȡ��������
	 *
	 * @return area ��������
	 */
	public AreaEntity getArea() {
		return area;
	}

	/**
	 * ������������
	 * 
	 * @param area
	 *            ��������
	 */
	public void setArea(AreaEntity area) {
		this.area = area;
	}

	/**
	 * ��ȡnfsBackup
	 *
	 * @return nfsBackup nfsBackup
	 */
	public NfsBackupEntity getNfsBackup() {
		return nfsBackup;
	}

	/**
	 * ����nfsBackup
	 * 
	 * @param nfsBackup
	 *            nfsBackup
	 */
	public void setNfsBackup(NfsBackupEntity nfsBackup) {
		this.nfsBackup = nfsBackup;
	}

	/**
	 * ��ȡ�������
	 *
	 * @return definitionSubServList �������
	 */
	public List<DefinitionSubServEntity> getDefinitionSubServList() {
		return definitionSubServList;
	}

	/**
	 * ���ð������
	 * 
	 * @param definitionSubServList
	 *            �������
	 */
	public void setDefinitionSubServList(List<DefinitionSubServEntity> definitionSubServList) {
		this.definitionSubServList = definitionSubServList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClusterEntity [id=" + id + ", name=" + name + ", enabled=" + enabled + ", relateId=" + relateId
				+ ", area=" + area + ", nfsBackup=" + nfsBackup + ", definitionSubServList=" + definitionSubServList
				+ "]";
	}

}
