package com.api.dto;

import java.io.Serializable;
import java.util.List;

/**
 * ��Ⱥ���ݴ������
 * 
 * @author HCK
 *
 */
public class ClusterDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��Ⱥ����
	 */
	private String name;

	/**
	 * �������
	 */
	private List<DefinitionSubServDto> definitionSubServList;

	/**
	 * ���ʹ����
	 */
	private String maxUsage;

	/**
	 * �����������
	 */
	private String maxHostCount;

	/**
	 * �����������
	 */
	private String areaId;

	/**
	 * ������������
	 */
	private String areaName;

	/**
	 * ���ݴ洢����
	 */
	private String nfsBackupId;

	/**
	 * ���ݴ洢����
	 */
	private String nfSBackupName;

	/**
	 * �Ƿ����
	 */
	private Boolean enabled;

	/**
	 * �Ƿ����(������ʾ)
	 */
	private String enabledText;

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
	 * ��ȡ�������
	 *
	 * @return definitionSubServList �������
	 */
	public List<DefinitionSubServDto> getDefinitionSubServList() {
		return definitionSubServList;
	}

	/**
	 * ���ð������
	 * 
	 * @param definitionSubServList
	 *            �������
	 */
	public void setDefinitionSubServList(List<DefinitionSubServDto> definitionSubServList) {
		this.definitionSubServList = definitionSubServList;
	}

	/**
	 * ��ȡ���ʹ����
	 *
	 * @return maxUsage ���ʹ����
	 */
	public String getMaxUsage() {
		return maxUsage;
	}

	/**
	 * �������ʹ����
	 * 
	 * @param maxUsage
	 *            ���ʹ����
	 */
	public void setMaxUsage(String maxUsage) {
		this.maxUsage = maxUsage;
	}

	/**
	 * ��ȡ�����������
	 *
	 * @return maxHostCount �����������
	 */
	public String getMaxHostCount() {
		return maxHostCount;
	}

	/**
	 * ���������������
	 * 
	 * @param maxHostCount
	 *            �����������
	 */
	public void setMaxHostCount(String maxHostCount) {
		this.maxHostCount = maxHostCount;
	}

	/**
	 * ��ȡ�����������
	 *
	 * @return areaId �����������
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * ���������������
	 * 
	 * @param areaId
	 *            �����������
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * ��ȡ������������
	 *
	 * @return areaName ������������
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * ����������������
	 * 
	 * @param areaName
	 *            ������������
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * ��ȡnfsBackupId
	 *
	 * @return nfsBackupId nfsBackupId
	 */
	public String getNfsBackupId() {
		return nfsBackupId;
	}

	/**
	 * ����nfsBackupId
	 * 
	 * @param nfsBackupId
	 *            nfsBackupId
	 */
	public void setNfsBackupId(String nfsBackupId) {
		this.nfsBackupId = nfsBackupId;
	}

	/**
	 * ��ȡnfSBackupName
	 *
	 * @return nfSBackupName nfSBackupName
	 */
	public String getNfSBackupName() {
		return nfSBackupName;
	}

	/**
	 * ����nfSBackupName
	 * 
	 * @param nfSBackupName
	 *            nfSBackupName
	 */
	public void setNfSBackupName(String nfSBackupName) {
		this.nfSBackupName = nfSBackupName;
	}

	/**
	 * ��ȡenabled
	 *
	 * @return enabled enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * ����enabled
	 *
	 * @param enabled
	 *            enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡenabledText
	 *
	 * @return enabledText enabledText
	 */
	public String getEnabledText() {
		return enabledText;
	}

	/**
	 * ����enabledText
	 *
	 * @param enabledText
	 *            enabledText
	 */
	public void setEnabledText(String enabledText) {
		this.enabledText = enabledText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ClusterDto [name=" + name + ", definitionSubServList=" + definitionSubServList + ", maxUsage="
				+ maxUsage + ", maxHostCount=" + maxHostCount + ", areaId=" + areaId + ", areaName=" + areaName
				+ ", nfsBackupId=" + nfsBackupId + ", nfSBackupName=" + nfSBackupName + ", enabled=" + enabled
				+ ", enabledText=" + enabledText + "]";
	}

}
