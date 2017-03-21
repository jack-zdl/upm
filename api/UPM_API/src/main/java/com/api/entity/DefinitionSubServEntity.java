package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ�����ʵ����
 * 
 * @author HCK
 *
 */
public class DefinitionSubServEntity implements Serializable {

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
	 * �ӷ���������
	 */
	private String type;

	/**
	 * ����Ŀ¼����
	 */
	private Integer defaultDataDirSize;

	/**
	 * ����Ŀ¼�豸����
	 */
	private String defaultDataDirDeviceType;

	/**
	 * ��־Ŀ¼����
	 */
	private Integer defaultLogDirSize;

	/**
	 * ��־Ŀ¼�豸����
	 */
	private String defaultLogDirDeviceType;

	/**
	 * ��󱸷ݿռ�
	 */
	private Integer defaultMaxBackupSpace;

	/**
	 * �����ļ���������
	 */
	private Integer defaultBackupFilesRetention;

	private boolean userManager;

	private String defaultRootUserRoleId;
	private String defaultRootUsername;
	private String defaultRootPassword;

	private String defaultMonitorUserRoleId;
	private String defaultMonitorUsername;
	private String defaultMonitorPassword;

	private String defaultReplicationUserRoleId;
	private String defaultReplicationUsername;
	private String defaultReplicationPassword;

	/**
	 * �Ƿ�Ϊ��Ҫ�ӷ���
	 */
	private boolean primary;

	/**
	 * �������ȼ�
	 */
	private Integer priority;

	/**
	 * Ĭ���ӷ���ܹ�
	 */
	private DefinitionSubServArchEntity defaultDefinitionSubServArch;

	/**
	 * Ĭ���ӷ���Ԫ��ģ
	 */
	private DefinitionSubServUnitScaleEntity defaultDefinitionSubServUnitScale;

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

	/**
	 * ��ȡtype
	 *
	 * @return type type
	 */
	public String getType() {
		return type;
	}

	/**
	 * ����type
	 *
	 * @param type
	 *            type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ��ȡdefaultDataDirSize
	 *
	 * @return defaultDataDirSize defaultDataDirSize
	 */
	public Integer getDefaultDataDirSize() {
		return defaultDataDirSize;
	}

	/**
	 * ����defaultDataDirSize
	 *
	 * @param defaultDataDirSize
	 *            defaultDataDirSize
	 */
	public void setDefaultDataDirSize(Integer defaultDataDirSize) {
		this.defaultDataDirSize = defaultDataDirSize;
	}

	/**
	 * ��ȡdefaultDataDirDeviceType
	 *
	 * @return defaultDataDirDeviceType defaultDataDirDeviceType
	 */
	public String getDefaultDataDirDeviceType() {
		return defaultDataDirDeviceType;
	}

	/**
	 * ����defaultDataDirDeviceType
	 *
	 * @param defaultDataDirDeviceType
	 *            defaultDataDirDeviceType
	 */
	public void setDefaultDataDirDeviceType(String defaultDataDirDeviceType) {
		this.defaultDataDirDeviceType = defaultDataDirDeviceType;
	}

	/**
	 * ��ȡdefaultLogDirSize
	 *
	 * @return defaultLogDirSize defaultLogDirSize
	 */
	public Integer getDefaultLogDirSize() {
		return defaultLogDirSize;
	}

	/**
	 * ����defaultLogDirSize
	 *
	 * @param defaultLogDirSize
	 *            defaultLogDirSize
	 */
	public void setDefaultLogDirSize(Integer defaultLogDirSize) {
		this.defaultLogDirSize = defaultLogDirSize;
	}

	/**
	 * ��ȡdefaultLogDirDeviceType
	 *
	 * @return defaultLogDirDeviceType defaultLogDirDeviceType
	 */
	public String getDefaultLogDirDeviceType() {
		return defaultLogDirDeviceType;
	}

	/**
	 * ����defaultLogDirDeviceType
	 *
	 * @param defaultLogDirDeviceType
	 *            defaultLogDirDeviceType
	 */
	public void setDefaultLogDirDeviceType(String defaultLogDirDeviceType) {
		this.defaultLogDirDeviceType = defaultLogDirDeviceType;
	}

	/**
	 * ��ȡdefaultMaxBackupSpace
	 *
	 * @return defaultMaxBackupSpace defaultMaxBackupSpace
	 */
	public Integer getDefaultMaxBackupSpace() {
		return defaultMaxBackupSpace;
	}

	/**
	 * ����defaultMaxBackupSpace
	 *
	 * @param defaultMaxBackupSpace
	 *            defaultMaxBackupSpace
	 */
	public void setDefaultMaxBackupSpace(Integer defaultMaxBackupSpace) {
		this.defaultMaxBackupSpace = defaultMaxBackupSpace;
	}

	/**
	 * ��ȡdefaultBackupFilesRetention
	 *
	 * @return defaultBackupFilesRetention defaultBackupFilesRetention
	 */
	public Integer getDefaultBackupFilesRetention() {
		return defaultBackupFilesRetention;
	}

	/**
	 * ����defaultBackupFilesRetention
	 *
	 * @param defaultBackupFilesRetention
	 *            defaultBackupFilesRetention
	 */
	public void setDefaultBackupFilesRetention(Integer defaultBackupFilesRetention) {
		this.defaultBackupFilesRetention = defaultBackupFilesRetention;
	}

	/**
	 * ��ȡuserManager
	 *
	 * @return userManager userManager
	 */
	public boolean isUserManager() {
		return userManager;
	}

	/**
	 * ����userManager
	 *
	 * @param userManager
	 *            userManager
	 */
	public void setUserManager(boolean userManager) {
		this.userManager = userManager;
	}

	/**
	 * ��ȡdefaultRootUserRoleId
	 *
	 * @return defaultRootUserRoleId defaultRootUserRoleId
	 */
	public String getDefaultRootUserRoleId() {
		return defaultRootUserRoleId;
	}

	/**
	 * ����defaultRootUserRoleId
	 *
	 * @param defaultRootUserRoleId
	 *            defaultRootUserRoleId
	 */
	public void setDefaultRootUserRoleId(String defaultRootUserRoleId) {
		this.defaultRootUserRoleId = defaultRootUserRoleId;
	}

	/**
	 * ��ȡdefaultRootUsername
	 *
	 * @return defaultRootUsername defaultRootUsername
	 */
	public String getDefaultRootUsername() {
		return defaultRootUsername;
	}

	/**
	 * ����defaultRootUsername
	 *
	 * @param defaultRootUsername
	 *            defaultRootUsername
	 */
	public void setDefaultRootUsername(String defaultRootUsername) {
		this.defaultRootUsername = defaultRootUsername;
	}

	/**
	 * ��ȡdefaultRootPassword
	 *
	 * @return defaultRootPassword defaultRootPassword
	 */
	public String getDefaultRootPassword() {
		return defaultRootPassword;
	}

	/**
	 * ����defaultRootPassword
	 *
	 * @param defaultRootPassword
	 *            defaultRootPassword
	 */
	public void setDefaultRootPassword(String defaultRootPassword) {
		this.defaultRootPassword = defaultRootPassword;
	}

	/**
	 * ��ȡdefaultMonitorUserRoleId
	 *
	 * @return defaultMonitorUserRoleId defaultMonitorUserRoleId
	 */
	public String getDefaultMonitorUserRoleId() {
		return defaultMonitorUserRoleId;
	}

	/**
	 * ����defaultMonitorUserRoleId
	 *
	 * @param defaultMonitorUserRoleId
	 *            defaultMonitorUserRoleId
	 */
	public void setDefaultMonitorUserRoleId(String defaultMonitorUserRoleId) {
		this.defaultMonitorUserRoleId = defaultMonitorUserRoleId;
	}

	/**
	 * ��ȡdefaultMonitorUsername
	 *
	 * @return defaultMonitorUsername defaultMonitorUsername
	 */
	public String getDefaultMonitorUsername() {
		return defaultMonitorUsername;
	}

	/**
	 * ����defaultMonitorUsername
	 *
	 * @param defaultMonitorUsername
	 *            defaultMonitorUsername
	 */
	public void setDefaultMonitorUsername(String defaultMonitorUsername) {
		this.defaultMonitorUsername = defaultMonitorUsername;
	}

	/**
	 * ��ȡdefaultMonitorPassword
	 *
	 * @return defaultMonitorPassword defaultMonitorPassword
	 */
	public String getDefaultMonitorPassword() {
		return defaultMonitorPassword;
	}

	/**
	 * ����defaultMonitorPassword
	 *
	 * @param defaultMonitorPassword
	 *            defaultMonitorPassword
	 */
	public void setDefaultMonitorPassword(String defaultMonitorPassword) {
		this.defaultMonitorPassword = defaultMonitorPassword;
	}

	/**
	 * ��ȡdefaultReplicationUserRoleId
	 *
	 * @return defaultReplicationUserRoleId defaultReplicationUserRoleId
	 */
	public String getDefaultReplicationUserRoleId() {
		return defaultReplicationUserRoleId;
	}

	/**
	 * ����defaultReplicationUserRoleId
	 *
	 * @param defaultReplicationUserRoleId
	 *            defaultReplicationUserRoleId
	 */
	public void setDefaultReplicationUserRoleId(String defaultReplicationUserRoleId) {
		this.defaultReplicationUserRoleId = defaultReplicationUserRoleId;
	}

	/**
	 * ��ȡdefaultReplicationUsername
	 *
	 * @return defaultReplicationUsername defaultReplicationUsername
	 */
	public String getDefaultReplicationUsername() {
		return defaultReplicationUsername;
	}

	/**
	 * ����defaultReplicationUsername
	 *
	 * @param defaultReplicationUsername
	 *            defaultReplicationUsername
	 */
	public void setDefaultReplicationUsername(String defaultReplicationUsername) {
		this.defaultReplicationUsername = defaultReplicationUsername;
	}

	/**
	 * ��ȡdefaultReplicationPassword
	 *
	 * @return defaultReplicationPassword defaultReplicationPassword
	 */
	public String getDefaultReplicationPassword() {
		return defaultReplicationPassword;
	}

	/**
	 * ����defaultReplicationPassword
	 *
	 * @param defaultReplicationPassword
	 *            defaultReplicationPassword
	 */
	public void setDefaultReplicationPassword(String defaultReplicationPassword) {
		this.defaultReplicationPassword = defaultReplicationPassword;
	}

	/**
	 * ��ȡprimary
	 *
	 * @return primary primary
	 */
	public boolean isPrimary() {
		return primary;
	}

	/**
	 * ����primary
	 *
	 * @param primary
	 *            primary
	 */
	public void setPrimary(boolean primary) {
		this.primary = primary;
	}

	/**
	 * ��ȡpriority
	 *
	 * @return priority priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * ����priority
	 *
	 * @param priority
	 *            priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * ��ȡdefaultDefinitionSubServArch
	 *
	 * @return defaultDefinitionSubServArch defaultDefinitionSubServArch
	 */
	public DefinitionSubServArchEntity getDefaultDefinitionSubServArch() {
		return defaultDefinitionSubServArch;
	}

	/**
	 * ����defaultDefinitionSubServArch
	 *
	 * @param defaultDefinitionSubServArch
	 *            defaultDefinitionSubServArch
	 */
	public void setDefaultDefinitionSubServArch(DefinitionSubServArchEntity defaultDefinitionSubServArch) {
		this.defaultDefinitionSubServArch = defaultDefinitionSubServArch;
	}

	/**
	 * ��ȡdefaultDefinitionSubServUnitScale
	 *
	 * @return defaultDefinitionSubServUnitScale
	 *         defaultDefinitionSubServUnitScale
	 */
	public DefinitionSubServUnitScaleEntity getDefaultDefinitionSubServUnitScale() {
		return defaultDefinitionSubServUnitScale;
	}

	/**
	 * ����defaultDefinitionSubServUnitScale
	 *
	 * @param defaultDefinitionSubServUnitScale
	 *            defaultDefinitionSubServUnitScale
	 */
	public void setDefaultDefinitionSubServUnitScale(
			DefinitionSubServUnitScaleEntity defaultDefinitionSubServUnitScale) {
		this.defaultDefinitionSubServUnitScale = defaultDefinitionSubServUnitScale;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinitionSubServEntity [id=" + id + ", name=" + name + ", icon=" + icon + ", type=" + type
				+ ", defaultDataDirSize=" + defaultDataDirSize + ", defaultDataDirDeviceType="
				+ defaultDataDirDeviceType + ", defaultLogDirSize=" + defaultLogDirSize + ", defaultLogDirDeviceType="
				+ defaultLogDirDeviceType + ", defaultMaxBackupSpace=" + defaultMaxBackupSpace
				+ ", defaultBackupFilesRetention=" + defaultBackupFilesRetention + ", userManager=" + userManager
				+ ", defaultRootUserRoleId=" + defaultRootUserRoleId + ", defaultRootUsername=" + defaultRootUsername
				+ ", defaultRootPassword=" + defaultRootPassword + ", defaultMonitorUserRoleId="
				+ defaultMonitorUserRoleId + ", defaultMonitorUsername=" + defaultMonitorUsername
				+ ", defaultMonitorPassword=" + defaultMonitorPassword + ", defaultReplicationUserRoleId="
				+ defaultReplicationUserRoleId + ", defaultReplicationUsername=" + defaultReplicationUsername
				+ ", defaultReplicationPassword=" + defaultReplicationPassword + ", primary=" + primary + ", priority="
				+ priority + ", defaultDefinitionSubServArch=" + defaultDefinitionSubServArch
				+ ", defaultDefinitionSubServUnitScale=" + defaultDefinitionSubServUnitScale + "]";
	}

}
