package com.api.entity;

import java.io.Serializable;
import java.util.List;

/**
 * �Ӷ���ʵ����
 * 
 * @author HCK
 *
 */
public class SubOrderEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �Ӷ�������
	 */
	private String id;

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
	 * �Ӷ����û�
	 */
	private List<SubOrderUserEntity> subOrderUserList;

	/**
	 * �Ӷ�������
	 */
	private List<SubOrderNicEntity> subOrderNicList;

	/** �������� */
	private OrderEntity order;

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
	 * ��ȡsubOrderUserList
	 *
	 * @return subOrderUserList subOrderUserList
	 */
	public List<SubOrderUserEntity> getSubOrderUserList() {
		return subOrderUserList;
	}

	/**
	 * ����subOrderUserList
	 *
	 * @param subOrderUserList
	 *            subOrderUserList
	 */
	public void setSubOrderUserList(List<SubOrderUserEntity> subOrderUserList) {
		this.subOrderUserList = subOrderUserList;
	}

	/**
	 * ��ȡorder
	 *
	 * @return order order
	 */
	public OrderEntity getOrder() {
		return order;
	}

	/**
	 * ����order
	 *
	 * @param order
	 *            order
	 */
	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	/**
	 * ��ȡsubOrderNicList
	 *
	 * @return subOrderNicList subOrderNicList
	 */
	public List<SubOrderNicEntity> getSubOrderNicList() {
		return subOrderNicList;
	}

	/**
	 * ����subOrderNicList
	 *
	 * @param subOrderNicList
	 *            subOrderNicList
	 */
	public void setSubOrderNicList(List<SubOrderNicEntity> subOrderNicList) {
		this.subOrderNicList = subOrderNicList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubOrderEntity [id=" + id + ", definitionSubServ=" + definitionSubServ + ", subServSoftwareImage="
				+ subServSoftwareImage + ", definitionSubServArch=" + definitionSubServArch
				+ ", definitionSubServUnitScale=" + definitionSubServUnitScale + ", dataDirSize=" + dataDirSize
				+ ", dataDirDeviceType=" + dataDirDeviceType + ", logDirSize=" + logDirSize + ", logDirDeviceType="
				+ logDirDeviceType + ", maxBackupSpace=" + maxBackupSpace + ", backupFilesRetention="
				+ backupFilesRetention + ", subOrderUserList=" + subOrderUserList + ", subOrderNicList="
				+ subOrderNicList + ", order=" + order + "]";
	}

}
