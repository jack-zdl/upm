package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ�������ʵ����
 * 
 * @author HCK
 *
 */
public class SubServNicEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ�����������
	 */
	private String id;

	/**
	 * �����ӷ���
	 */
	private SubServEntity subServ;

	/**
	 * ��������
	 */
	private String nicPhyType;

	/**
	 * �����߿�������
	 */
	private String nicHaType;

	/**
	 * �������
	 */
	private Integer networkBandWidth;

	/**
	 * ��ȡid
	 *
	 * @return id id
	 */
	public String getId() {
		return id;
	}

	/**
	 * ��ȡsubServ
	 *
	 * @return subServ subServ
	 */
	public SubServEntity getSubServ() {
		return subServ;
	}

	/**
	 * ����subServ
	 *
	 * @param subServ
	 *            subServ
	 */
	public void setSubServ(SubServEntity subServ) {
		this.subServ = subServ;
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
	 * ��ȡnicHaType
	 *
	 * @return nicHaType nicHaType
	 */
	public String getNicHaType() {
		return nicHaType;
	}

	/**
	 * ����nicHaType
	 *
	 * @param nicHaType
	 *            nicHaType
	 */
	public void setNicHaType(String nicHaType) {
		this.nicHaType = nicHaType;
	}

	/**
	 * ��ȡnetworkBandWidth
	 *
	 * @return networkBandWidth networkBandWidth
	 */
	public Integer getNetworkBandWidth() {
		return networkBandWidth;
	}

	/**
	 * ����networkBandWidth
	 *
	 * @param networkBandWidth
	 *            networkBandWidth
	 */
	public void setNetworkBandWidth(Integer networkBandWidth) {
		this.networkBandWidth = networkBandWidth;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubServNicEntity [id=" + id + ", subServ=" + subServ + ", nicPhyType=" + nicPhyType + ", nicHaType="
				+ nicHaType + ", networkBandWidth=" + networkBandWidth + "]";
	}

}
