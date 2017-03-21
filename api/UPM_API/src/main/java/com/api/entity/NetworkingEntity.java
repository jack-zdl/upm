package com.api.entity;

import java.io.Serializable;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class NetworkingEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���α���
	 */
	private String id;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ��������
	 */
	private String type;

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
	private Integer vlanId;

	/**
	 * ����
	 */
	private Integer prefix;

	/**
	 * ����
	 */
	private String gateway;

	/**
	 * �Ƿ�����
	 */
	private boolean enabled;

	/**
	 * ��������
	 */
	private AreaEntity area;

	/**
	 * ��ȡ���α���
	 *
	 * @return id ���α���
	 */
	public String getId() {
		return id;
	}

	/**
	 * �������α���
	 * 
	 * @param id
	 *            ���α���
	 */
	public void setId(String id) {
		this.id = id;
	}

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
	 * ��ȡ��������
	 *
	 * @return type ��������
	 */
	public String getType() {
		return type;
	}

	/**
	 * ������������
	 * 
	 * @param type
	 *            ��������
	 */
	public void setType(String type) {
		this.type = type;
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
	public Integer getVlanId() {
		return vlanId;
	}

	/**
	 * ���ñ��vlanID
	 * 
	 * @param vlanId
	 *            ���vlanID
	 */
	public void setVlanId(Integer vlanId) {
		this.vlanId = vlanId;
	}

	/**
	 * ��ȡ����
	 *
	 * @return prefix ����
	 */
	public Integer getPrefix() {
		return prefix;
	}

	/**
	 * ��������
	 * 
	 * @param prefix
	 *            ����
	 */
	public void setPrefix(Integer prefix) {
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
	 * �����Ƿ�����
	 *
	 * @return enabled �����Ƿ�����
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * ���������Ƿ�����
	 * 
	 * @param enabled
	 *            �����Ƿ�����
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡarea
	 *
	 * @return area area
	 */
	public AreaEntity getArea() {
		return area;
	}

	/**
	 * ����area
	 * 
	 * @param area
	 *            area
	 */
	public void setArea(AreaEntity area) {
		this.area = area;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "NetworkingEntity [id=" + id + ", name=" + name + ", type=" + type + ", startIp=" + startIp + ", endIp="
				+ endIp + ", vlanId=" + vlanId + ", prefix=" + prefix + ", gateway=" + gateway + ", enabled=" + enabled
				+ ", area=" + area + "]";
	}

}
