package com.api.dto;

import java.io.Serializable;

/**
 * �ӷ�������������ݴ������
 * 
 * @author HCK
 *
 */
public class SubServSoftwareImageDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ���������
	 */
	private String name;

	/**
	 * �ӷ�����ͼ��
	 */
	private String icon;

	/**
	 * ���汾��
	 */
	private String majorVersion;

	/**
	 * �ΰ汾��
	 */
	private String minorVersion;

	/**
	 * �޶��汾��
	 */
	private String patchVersion;

	/**
	 * �汾
	 */
	private String version;

	/**
	 * �Ƿ����
	 */
	private Boolean enabled;

	/**
	 * �Ƿ����(������ʾ)
	 */
	private String enabledText;

	/**
	 * ״̬
	 */
	private String status;

	/**
	 * ״̬(������ʾ)
	 */
	private String statusText;

	/**
	 * ��ȡ�ӷ���������
	 *
	 * @return name �ӷ���������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����ӷ���������
	 * 
	 * @param name
	 *            �ӷ���������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ�ӷ�����ͼ��
	 *
	 * @return icon �ӷ�����ͼ��
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * �����ӷ�����ͼ��
	 * 
	 * @param icon
	 *            �ӷ�����ͼ��
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/**
	 * ��ȡ���汾��
	 *
	 * @return majorVersion ���汾��
	 */
	public String getMajorVersion() {
		return majorVersion;
	}

	/**
	 * �������汾��
	 * 
	 * @param majorVersion
	 *            ���汾��
	 */
	public void setMajorVersion(String majorVersion) {
		this.majorVersion = majorVersion;
	}

	/**
	 * ��ȡ�ΰ汾��
	 *
	 * @return minorVersion �ΰ汾��
	 */
	public String getMinorVersion() {
		return minorVersion;
	}

	/**
	 * ���ôΰ汾��
	 * 
	 * @param minorVersion
	 *            �ΰ汾��
	 */
	public void setMinorVersion(String minorVersion) {
		this.minorVersion = minorVersion;
	}

	/**
	 * ��ȡ�޶��汾��
	 *
	 * @return patchVersion �޶��汾��
	 */
	public String getPatchVersion() {
		return patchVersion;
	}

	/**
	 * �����޶��汾��
	 * 
	 * @param patchVersion
	 *            �޶��汾��
	 */
	public void setPatchVersion(String patchVersion) {
		this.patchVersion = patchVersion;
	}

	/**
	 * ��ȡversion
	 *
	 * @return version version
	 */
	public String getVersion() {
		return version;
	}

	/**
	 * ����version
	 *
	 * @param version
	 *            version
	 */
	public void setVersion(String version) {
		this.version = version;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubServSoftwareImageDto [name=" + name + ", icon=" + icon + ", majorVersion=" + majorVersion
				+ ", minorVersion=" + minorVersion + ", patchVersion=" + patchVersion + ", version=" + version
				+ ", enabled=" + enabled + ", enabledText=" + enabledText + ", status=" + status + ", statusText="
				+ statusText + "]";
	}

}
