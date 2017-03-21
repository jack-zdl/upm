package com.api.entity;

import java.io.Serializable;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class HostEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��������
	 */
	private String id;

	/**
	 * ������Ⱥ
	 */
	private ClusterEntity cluster;

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
	 * ����san
	 */
	private SanEntity san;

	/**
	 * ��������
	 */
	private String nicPhyType;

	/**
	 * ��������
	 */
	private String relateId;

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
	 * ��ȡcluster
	 *
	 * @return cluster cluster
	 */
	public ClusterEntity getCluster() {
		return cluster;
	}

	/**
	 * ����cluster
	 * 
	 * @param cluster
	 *            cluster
	 */
	public void setCluster(ClusterEntity cluster) {
		this.cluster = cluster;
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
	 * ��ȡsan
	 *
	 * @return san san
	 */
	public SanEntity getSan() {
		return san;
	}

	/**
	 * ����san
	 * 
	 * @param san
	 *            san
	 */
	public void setSan(SanEntity san) {
		this.san = san;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "HostEntity [id=" + id + ", cluster=" + cluster + ", name=" + name + ", sshIp=" + sshIp + ", sshUser="
				+ sshUser + ", sshPassword=" + sshPassword + ", room=" + room + ", seat=" + seat + ", maxContainer="
				+ maxContainer + ", hddDev=" + hddDev + ", ssdDev=" + ssdDev + ", san=" + san + ", nicPhyType="
				+ nicPhyType + ", relateId=" + relateId + "]";
	}

}
