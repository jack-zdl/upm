package com.api.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class ServEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �������
	 */
	private String id;

	/**
	 * ����������
	 */
	private DefinitionServEntity definitionServ;

	/**
	 * ����
	 */
	private OrderEntity order;

	/**
	 * ��������
	 */
	private AreaEntity area;

	/**
	 * ����ҵ�����
	 */
	private String servBusinessCode;

	/**
	 * ����ҵ������
	 */
	private String servBusinessName;

	/**
	 * ��������
	 */
	private String owner;

	/**
	 * �����Ӷ���
	 */
	private List<SubServEntity> subServList;

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
	 * ��ȡdefinitionServ
	 *
	 * @return definitionServ definitionServ
	 */
	public DefinitionServEntity getDefinitionServ() {
		return definitionServ;
	}

	/**
	 * ����definitionServ
	 *
	 * @param definitionServ
	 *            definitionServ
	 */
	public void setDefinitionServ(DefinitionServEntity definitionServ) {
		this.definitionServ = definitionServ;
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

	/**
	 * ��ȡservBusinessCode
	 *
	 * @return servBusinessCode servBusinessCode
	 */
	public String getServBusinessCode() {
		return servBusinessCode;
	}

	/**
	 * ����servBusinessCode
	 *
	 * @param servBusinessCode
	 *            servBusinessCode
	 */
	public void setServBusinessCode(String servBusinessCode) {
		this.servBusinessCode = servBusinessCode;
	}

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
	 * ��ȡowner
	 *
	 * @return owner owner
	 */
	public String getOwner() {
		return owner;
	}

	/**
	 * ����owner
	 *
	 * @param owner
	 *            owner
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * ��ȡsubServList
	 *
	 * @return subServList subServList
	 */
	public List<SubServEntity> getSubServList() {
		return subServList;
	}

	/**
	 * ����subServList
	 *
	 * @param subServList
	 *            subServList
	 */
	public void setSubServList(List<SubServEntity> subServList) {
		this.subServList = subServList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServEntity [id=" + id + ", definitionServ=" + definitionServ + ", order=" + order + ", area=" + area
				+ ", servBusinessCode=" + servBusinessCode + ", servBusinessName=" + servBusinessName + ", owner="
				+ owner + "]";
	}

}
