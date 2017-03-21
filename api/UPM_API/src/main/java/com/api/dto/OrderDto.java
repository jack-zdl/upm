package com.api.dto;

import java.io.Serializable;

/**
 * �������ݴ������
 * 
 * @author HCK
 *
 */
public class OrderDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����ҵ������
	 */
	private String servBusinessName;

	/**
	 * ����վ��
	 */
	private String siteName;

	/**
	 * ����Ŀ¼����
	 */
	private String dataDirSize;

	/**
	 * ���
	 */
	private String softwareName;

	/**
	 * �ܹ�
	 */
	private String archName;

	/**
	 * ��ģ
	 */
	private String scaleName;

	/**
	 * ״̬
	 */
	private String status;

	/**
	 * ״̬��ʾ
	 */
	private String statusText;

	private String definitionServId;

	/**
	 * ��ȡservBusinessName
	 *
	 * @return servBusinessName servBusinessName
	 */
	public String getServBusinessName() {
		return servBusinessName;
	}

	/**
	 * ����servBusinessName
	 *
	 * @param servBusinessName
	 *            servBusinessName
	 */
	public void setServBusinessName(String servBusinessName) {
		this.servBusinessName = servBusinessName;
	}

	/**
	 * ��ȡsiteName
	 *
	 * @return siteName siteName
	 */
	public String getSiteName() {
		return siteName;
	}

	/**
	 * ����siteName
	 *
	 * @param siteName
	 *            siteName
	 */
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	/**
	 * ��ȡdataDirSize
	 *
	 * @return dataDirSize dataDirSize
	 */
	public String getDataDirSize() {
		return dataDirSize;
	}

	/**
	 * ����dataDirSize
	 *
	 * @param dataDirSize
	 *            dataDirSize
	 */
	public void setDataDirSize(String dataDirSize) {
		this.dataDirSize = dataDirSize;
	}

	/**
	 * ��ȡsoftwareName
	 *
	 * @return softwareName softwareName
	 */
	public String getSoftwareName() {
		return softwareName;
	}

	/**
	 * ����softwareName
	 *
	 * @param softwareName
	 *            softwareName
	 */
	public void setSoftwareName(String softwareName) {
		this.softwareName = softwareName;
	}

	/**
	 * ��ȡarchName
	 *
	 * @return archName archName
	 */
	public String getArchName() {
		return archName;
	}

	/**
	 * ����archName
	 *
	 * @param archName
	 *            archName
	 */
	public void setArchName(String archName) {
		this.archName = archName;
	}

	/**
	 * ��ȡscaleName
	 *
	 * @return scaleName scaleName
	 */
	public String getScaleName() {
		return scaleName;
	}

	/**
	 * ����scaleName
	 *
	 * @param scaleName
	 *            scaleName
	 */
	public void setScaleName(String scaleName) {
		this.scaleName = scaleName;
	}

	/**
	 * ��ȡstatus
	 *
	 * @return status status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ����status
	 *
	 * @param status
	 *            status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ��ȡstatusText
	 *
	 * @return statusText statusText
	 */
	public String getStatusText() {
		return statusText;
	}

	/**
	 * ����statusText
	 *
	 * @param statusText
	 *            statusText
	 */
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	/**
	 * ��ȡdefinitionServId
	 *
	 * @return definitionServId definitionServId
	 */
	public String getDefinitionServId() {
		return definitionServId;
	}

	/**
	 * ����definitionServId
	 *
	 * @param definitionServId
	 *            definitionServId
	 */
	public void setDefinitionServId(String definitionServId) {
		this.definitionServId = definitionServId;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderDto [servBusinessName=" + servBusinessName + ", siteName=" + siteName + ", dataDirSize="
				+ dataDirSize + ", softwareName=" + softwareName + ", archName=" + archName + ", scaleName=" + scaleName
				+ ", status=" + status + ", statusText=" + statusText + ", definitionServId=" + definitionServId + "]";
	}

}
