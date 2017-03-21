package com.api.entity;

import java.io.Serializable;

/**
 * �Ӷ�������ʵ����
 * 
 * @author HCK
 *
 */
public class SubOrderNicEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �Ӷ�����������
	 */
	private String id;

	/**
	 * �����Ӷ���
	 */
	private SubOrderEntity subOrder;

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
	 * ����id
	 *
	 * @param id
	 *            id
	 */
	public void setId(String id) {
		this.id = id;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubOrderNicEntity [id=" + id + ", subOrder=" + subOrder + ", nicPhyType=" + nicPhyType + ", nicHaType="
				+ nicHaType + ", networkBandWidth=" + networkBandWidth + "]";
	}

}
