package com.api.dto;

import java.io.Serializable;

/**
 * �������ݴ������
 * 
 * @author HCK
 *
 */
public class HostDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��������
	 */
	private String id;

	/**
	 * �������
	 */
	private String areaId;

	/**
	 * ��������
	 */
	private String areaName;

	/**
	 * ��Ⱥ����
	 */
	private String clusterId;

	/**
	 * ��Ⱥ����
	 */
	private String clusterName;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ssh��½IP
	 */
	private String sshIp;

	/**
	 * ssh��½�û�
	 */
	private String sshUser;

	/**
	 * ssh��¼����
	 */
	private String sshPassword;

	/**
	 * ��������
	 */
	private String room;

	/**
	 * ��λ����
	 */
	private String seat;

	/**
	 * ��������
	 */
	private Integer maxContainer;

	/**
	 * ����hdd�豸
	 */
	private String hddDev;

	/**
	 * ����ssd�豸
	 */
	private String ssdDev;

	/**
	 * san����
	 */
	private String sanId;

	/**
	 * san����
	 */
	private String sanName;

	/**
	 * ��������
	 */
	private String nicPhyType;

	/**
	 * ����������ʾ
	 */
	private String nicPhyTypeText;

	/**
	 * ��������
	 */
	private String relateId;

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
	 * ״̬��ʾ
	 */
	private String statusText;

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
	 * ��ȡclusterId
	 *
	 * @return clusterId clusterId
	 */
	public String getClusterId() {
		return clusterId;
	}

	/**
	 * ����clusterId
	 * 
	 * @param clusterId
	 *            clusterId
	 */
	public void setClusterId(String clusterId) {
		this.clusterId = clusterId;
	}

	/**
	 * ��ȡclusterName
	 *
	 * @return clusterName clusterName
	 */
	public String getClusterName() {
		return clusterName;
	}

	/**
	 * ����clusterName
	 * 
	 * @param clusterName
	 *            clusterName
	 */
	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
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
	 * ��ȡsshIp
	 *
	 * @return sshIp sshIp
	 */
	public String getSshIp() {
		return sshIp;
	}

	/**
	 * ����sshIp
	 * 
	 * @param sshIp
	 *            sshIp
	 */
	public void setSshIp(String sshIp) {
		this.sshIp = sshIp;
	}

	/**
	 * ��ȡsshUser
	 *
	 * @return sshUser sshUser
	 */
	public String getSshUser() {
		return sshUser;
	}

	/**
	 * ����sshUser
	 * 
	 * @param sshUser
	 *            sshUser
	 */
	public void setSshUser(String sshUser) {
		this.sshUser = sshUser;
	}

	/**
	 * ��ȡsshPassword
	 *
	 * @return sshPassword sshPassword
	 */
	public String getSshPassword() {
		return sshPassword;
	}

	/**
	 * ����sshPassword
	 * 
	 * @param sshPassword
	 *            sshPassword
	 */
	public void setSshPassword(String sshPassword) {
		this.sshPassword = sshPassword;
	}

	/**
	 * ��ȡroom
	 *
	 * @return room room
	 */
	public String getRoom() {
		return room;
	}

	/**
	 * ����room
	 * 
	 * @param room
	 *            room
	 */
	public void setRoom(String room) {
		this.room = room;
	}

	/**
	 * ��ȡseat
	 *
	 * @return seat seat
	 */
	public String getSeat() {
		return seat;
	}

	/**
	 * ����seat
	 * 
	 * @param seat
	 *            seat
	 */
	public void setSeat(String seat) {
		this.seat = seat;
	}

	/**
	 * ��ȡmaxContainer
	 *
	 * @return maxContainer maxContainer
	 */
	public Integer getMaxContainer() {
		return maxContainer;
	}

	/**
	 * ����maxContainer
	 * 
	 * @param maxContainer
	 *            maxContainer
	 */
	public void setMaxContainer(Integer maxContainer) {
		this.maxContainer = maxContainer;
	}

	/**
	 * ��ȡhddDev
	 *
	 * @return hddDev hddDev
	 */
	public String getHddDev() {
		return hddDev;
	}

	/**
	 * ����hddDev
	 * 
	 * @param hddDev
	 *            hddDev
	 */
	public void setHddDev(String hddDev) {
		this.hddDev = hddDev;
	}

	/**
	 * ��ȡssdDev
	 *
	 * @return ssdDev ssdDev
	 */
	public String getSsdDev() {
		return ssdDev;
	}

	/**
	 * ����ssdDev
	 * 
	 * @param ssdDev
	 *            ssdDev
	 */
	public void setSsdDev(String ssdDev) {
		this.ssdDev = ssdDev;
	}

	/**
	 * ��ȡsanId
	 *
	 * @return sanId sanId
	 */
	public String getSanId() {
		return sanId;
	}

	/**
	 * ����sanId
	 * 
	 * @param sanId
	 *            sanId
	 */
	public void setSanId(String sanId) {
		this.sanId = sanId;
	}

	/**
	 * ��ȡsanName
	 *
	 * @return sanName sanName
	 */
	public String getSanName() {
		return sanName;
	}

	/**
	 * ����sanName
	 * 
	 * @param sanName
	 *            sanName
	 */
	public void setSanName(String sanName) {
		this.sanName = sanName;
	}

	/**
	 * ��ȡnicPhyType
	 *
	 * @return nicPhyType nicPhyType
	 */
	public String getNicPhyType() {
		return nicPhyType;
	}

	/**
	 * ����nicPhyType
	 * 
	 * @param nicPhyType
	 *            nicPhyType
	 */
	public void setNicPhyType(String nicPhyType) {
		this.nicPhyType = nicPhyType;
	}

	/**
	 * ��ȡnicPhyTypeText
	 *
	 * @return nicPhyTypeText nicPhyTypeText
	 */
	public String getNicPhyTypeText() {
		return nicPhyTypeText;
	}

	/**
	 * ����nicPhyTypeText
	 * 
	 * @param nicPhyTypeText
	 *            nicPhyTypeText
	 */
	public void setNicPhyTypeText(String nicPhyTypeText) {
		this.nicPhyTypeText = nicPhyTypeText;
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
		return "HostDto [id=" + id + ", areaId=" + areaId + ", areaName=" + areaName + ", clusterId=" + clusterId
				+ ", clusterName=" + clusterName + ", name=" + name + ", sshIp=" + sshIp + ", sshUser=" + sshUser
				+ ", sshPassword=" + sshPassword + ", room=" + room + ", seat=" + seat + ", maxContainer="
				+ maxContainer + ", hddDev=" + hddDev + ", ssdDev=" + ssdDev + ", sanId=" + sanId + ", sanName="
				+ sanName + ", nicPhyType=" + nicPhyType + ", nicPhyTypeText=" + nicPhyTypeText + ", relateId="
				+ relateId + ", enabled=" + enabled + ", enabledText=" + enabledText + ", status=" + status
				+ ", statusText=" + statusText + "]";
	}

}
