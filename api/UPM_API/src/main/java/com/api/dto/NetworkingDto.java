package com.api.dto;

import java.io.Serializable;

/**
 * �������ݴ������
 * 
 * @author HCK
 *
 */
public class NetworkingDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ��ʼip
	 */
	private String startIp;

	/**
	 * ����ip
	 */
	private String endIp;

	/**
	 * ���vlanID
	 */
	private String vlanId;

	/**
	 * ����
	 */
	private String prefix;

	/**
	 * ����
	 */
	private String gateway;

	/**
	 * �������
	 */
	private String areaId;

	/**
	 * ��������
	 */
	private String areaName;

	/**
	 * �Ƿ����
	 */
	private Boolean enabled;

	/**
	 * �Ƿ����(������ʾ)
	 */
	private String enabledText;

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
	 * ��ȡ��ʼIP
	 *
	 * @return startIp ��ʼIP
	 */
	public String getStartIp() {
		return startIp;
	}

	/**
	 * ������ʼIP
	 * 
	 * @param startIp
	 *            ��ʼIP
	 */
	public void setStartIp(String startIp) {
		this.startIp = startIp;
	}

	/**
	 * ��ȡ����IP
	 *
	 * @return endIp ����IP
	 */
	public String getEndIp() {
		return endIp;
	}

	/**
	 * ���ý���IP
	 * 
	 * @param endIp
	 *            ����IP
	 */
	public void setEndIp(String endIp) {
		this.endIp = endIp;
	}

	/**
	 * ��ȡ���vlanID
	 *
	 * @return vlanId ���vlanID
	 */
	public String getVlanId() {
		return vlanId;
	}

	/**
	 * ���ñ��vlanID
	 * 
	 * @param vlanId
	 *            ���vlanID
	 */
	public void setVlanId(String vlanId) {
		this.vlanId = vlanId;
	}

	/**
	 * ��ȡ����
	 *
	 * @return prefix ����
	 */
	public String getPrefix() {
		return prefix;
	}

	/**
	 * ��������
	 * 
	 * @param prefix
	 *            ����
	 */
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	/**
	 * ��ȡ����
	 *
	 * @return gateway ����
	 */
	public String getGateway() {
		return gateway;
	}

	/**
	 * ��������
	 * 
	 * @param gateway
	 *            ����
	 */
	public void setGateway(String gateway) {
		this.gateway = gateway;
	}

	/**
	 * ��ȡareaId
	 *
	 * @return areaId areaId
	 */
	public String getAreaId() {
		return areaId;
	}

	/**
	 * ����areaId
	 * 
	 * @param areaId
	 *            areaId
	 */
	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	/**
	 * ��ȡareaName
	 *
	 * @return areaName areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * ����areaName
	 * 
	 * @param areaName
	 *            areaName
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
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
		return "NetworkingDto [name=" + name + ", startIp=" + startIp + ", endIp=" + endIp + ", vlanId=" + vlanId
				+ ", prefix=" + prefix + ", gateway=" + gateway + ", areaId=" + areaId + ", areaName=" + areaName
				+ ", enabled=" + enabled + ", enabledText=" + enabledText + "]";
	}

}
