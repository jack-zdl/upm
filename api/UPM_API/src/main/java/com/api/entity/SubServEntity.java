package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ���ʵ����
 * 
 * @author HCK
 *
 */
public class SubServEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �Ӷ�������
	 */
	private String id;

	/**
	 * ��������
	 */
	private String relateId;

	/**
	 * ��������
	 */
	private ServEntity serv;

	/**
	 * �����ӷ�����
	 */
	private DefinitionSubServEntity definitionSubServ;

	/**
	 * �����ӷ����������
	 */
	private SubServSoftwareImageEntity subServSoftwareImage;

	/**
	 * �����ӷ���ܹ�
	 */
	private DefinitionSubServArchEntity definitionSubServArch;

	/**
	 * �����ӷ���Ԫ��ģ
	 */
	private DefinitionSubServUnitScaleEntity definitionSubServUnitScale;

	/**
	 * ����Ŀ¼����
	 */
	private Integer dataDirSize;

	/**
	 * ����Ŀ¼�豸����
	 */
	private String dataDirDeviceType;

	/**
	 * ��־Ŀ¼����
	 */
	private Integer logDirSize;

	/**
	 * ��־Ŀ¼�豸����
	 */
	private String logDirDeviceType;

	/**
	 * ��󱸷ݿռ�
	 */
	private Integer maxBackupSpace;

	/**
	 * �����ļ���������
	 */
	private Integer backupFilesRetention;

	/**
	 * �����Ӷ���
	 */
	private SubOrderEntity subOrder;

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

	/**
	 * ��ȡserv
	 *
	 * @return serv serv
	 */
	public ServEntity getServ() {
		return serv;
	}

	/**
	 * ����serv
	 *
	 * @param serv
	 *            serv
	 */
	public void setServ(ServEntity serv) {
		this.serv = serv;
	}

	/**
	 * ��ȡdefinitionSubServ
	 *
	 * @return definitionSubServ definitionSubServ
	 */
	public DefinitionSubServEntity getDefinitionSubServ() {
		return definitionSubServ;
	}

	/**
	 * ����definitionSubServ
	 *
	 * @param definitionSubServ
	 *            definitionSubServ
	 */
	public void setDefinitionSubServ(DefinitionSubServEntity definitionSubServ) {
		this.definitionSubServ = definitionSubServ;
	}

	/**
	 * ��ȡsubServSoftwareImage
	 *
	 * @return subServSoftwareImage subServSoftwareImage
	 */
	public SubServSoftwareImageEntity getSubServSoftwareImage() {
		return subServSoftwareImage;
	}

	/**
	 * ����subServSoftwareImage
	 *
	 * @param subServSoftwareImage
	 *            subServSoftwareImage
	 */
	public void setSubServSoftwareImage(SubServSoftwareImageEntity subServSoftwareImage) {
		this.subServSoftwareImage = subServSoftwareImage;
	}

	/**
	 * ��ȡdefinitionSubServArch
	 *
	 * @return definitionSubServArch definitionSubServArch
	 */
	public DefinitionSubServArchEntity getDefinitionSubServArch() {
		return definitionSubServArch;
	}

	/**
	 * ����definitionSubServArch
	 *
	 * @param definitionSubServArch
	 *            definitionSubServArch
	 */
	public void setDefinitionSubServArch(DefinitionSubServArchEntity definitionSubServArch) {
		this.definitionSubServArch = definitionSubServArch;
	}

	/**
	 * ��ȡdefinitionSubServUnitScale
	 *
	 * @return definitionSubServUnitScale definitionSubServUnitScale
	 */
	public DefinitionSubServUnitScaleEntity getDefinitionSubServUnitScale() {
		return definitionSubServUnitScale;
	}

	/**
	 * ����definitionSubServUnitScale
	 *
	 * @param definitionSubServUnitScale
	 *            definitionSubServUnitScale
	 */
	public void setDefinitionSubServUnitScale(DefinitionSubServUnitScaleEntity definitionSubServUnitScale) {
		this.definitionSubServUnitScale = definitionSubServUnitScale;
	}

	/**
	 * ��ȡdataDirSize
	 *
	 * @return dataDirSize dataDirSize
	 */
	public Integer getDataDirSize() {
		return dataDirSize;
	}

	/**
	 * ����dataDirSize
	 *
	 * @param dataDirSize
	 *            dataDirSize
	 */
	public void setDataDirSize(Integer dataDirSize) {
		this.dataDirSize = dataDirSize;
	}

	/**
	 * ��ȡdataDirDeviceType
	 *
	 * @return dataDirDeviceType dataDirDeviceType
	 */
	public String getDataDirDeviceType() {
		return dataDirDeviceType;
	}

	/**
	 * ����dataDirDeviceType
	 *
	 * @param dataDirDeviceType
	 *            dataDirDeviceType
	 */
	public void setDataDirDeviceType(String dataDirDeviceType) {
		this.dataDirDeviceType = dataDirDeviceType;
	}

	/**
	 * ��ȡlogDirSize
	 *
	 * @return logDirSize logDirSize
	 */
	public Integer getLogDirSize() {
		return logDirSize;
	}

	/**
	 * ����logDirSize
	 *
	 * @param logDirSize
	 *            logDirSize
	 */
	public void setLogDirSize(Integer logDirSize) {
		this.logDirSize = logDirSize;
	}

	/**
	 * ��ȡlogDirDeviceType
	 *
	 * @return logDirDeviceType logDirDeviceType
	 */
	public String getLogDirDeviceType() {
		return logDirDeviceType;
	}

	/**
	 * ����logDirDeviceType
	 *
	 * @param logDirDeviceType
	 *            logDirDeviceType
	 */
	public void setLogDirDeviceType(String logDirDeviceType) {
		this.logDirDeviceType = logDirDeviceType;
	}

	/**
	 * ��ȡmaxBackupSpace
	 *
	 * @return maxBackupSpace maxBackupSpace
	 */
	public Integer getMaxBackupSpace() {
		return maxBackupSpace;
	}

	/**
	 * ����maxBackupSpace
	 *
	 * @param maxBackupSpace
	 *            maxBackupSpace
	 */
	public void setMaxBackupSpace(Integer maxBackupSpace) {
		this.maxBackupSpace = maxBackupSpace;
	}

	/**
	 * ��ȡbackupFilesRetention
	 *
	 * @return backupFilesRetention backupFilesRetention
	 */
	public Integer getBackupFilesRetention() {
		return backupFilesRetention;
	}

	/**
	 * ����backupFilesRetention
	 *
	 * @param backupFilesRetention
	 *            backupFilesRetention
	 */
	public void setBackupFilesRetention(Integer backupFilesRetention) {
		this.backupFilesRetention = backupFilesRetention;
	}

	/**
	 * ��ȡsubOrder
	 *
	 * @return subOrder subOrder
	 */
	public SubOrderEntity getSubOrder() {
		return subOrder;
	}

	/**
	 * ����subOrder
	 *
	 * @param subOrder
	 *            subOrder
	 */
	public void setSubOrder(SubOrderEntity subOrder) {
		this.subOrder = subOrder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubServEntity [id=" + id + ", relateId=" + relateId + ", serv=" + serv + ", definitionSubServ="
				+ definitionSubServ + ", subServSoftwareImage=" + subServSoftwareImage + ", definitionSubServArch="
				+ definitionSubServArch + ", definitionSubServUnitScale=" + definitionSubServUnitScale
				+ ", dataDirSize=" + dataDirSize + ", dataDirDeviceType=" + dataDirDeviceType + ", logDirSize="
				+ logDirSize + ", logDirDeviceType=" + logDirDeviceType + ", maxBackupSpace=" + maxBackupSpace
				+ ", backupFilesRetention=" + backupFilesRetention + ", subOrder=" + subOrder + "]";
	}

}
