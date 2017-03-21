package com.api.entity;

import java.io.Serializable;
import java.util.List;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class OrderEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��������
	 */
	private String id;

	/**
	 * ����������
	 */
	private DefinitionServEntity definitionServ;

	/**
	 * ����վ��
	 */
	private SiteEntity site;

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
	private String type;

	/**
	 * ����״̬
	 */
	private String status;

	/**
	 * ����״̬��Ϣ
	 */
	private String msg;

	/**
	 * ������������
	 */
	private String associateOrderId;

	/**
	 * �����Ӷ���
	 */
	private List<SubOrderEntity> subOrderList;

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
	 * ��ȡsite
	 *
	 * @return site site
	 */
	public SiteEntity getSite() {
		return site;
	}

	/**
	 * ����site
	 * 
	 * @param site
	 *            site
	 */
	public void setSite(SiteEntity site) {
		this.site = site;
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
	 * ��ȡtype
	 *
	 * @return type type
	 */
	public String getType() {
		return type;
	}

	/**
	 * ����type
	 * 
	 * @param type
	 *            type
	 */
	public void setType(String type) {
		this.type = type;
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
	 * ��ȡmsg
	 *
	 * @return msg msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ����msg
	 *
	 * @param msg
	 *            msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * ��ȡassociateOrderId
	 *
	 * @return associateOrderId associateOrderId
	 */
	public String getAssociateOrderId() {
		return associateOrderId;
	}

	/**
	 * ����associateOrderId
	 * 
	 * @param associateOrderId
	 *            associateOrderId
	 */
	public void setAssociateOrderId(String associateOrderId) {
		this.associateOrderId = associateOrderId;
	}

	/**
	 * ��ȡsubOrderList
	 *
	 * @return subOrderList subOrderList
	 */
	public List<SubOrderEntity> getSubOrderList() {
		return subOrderList;
	}

	/**
	 * ����subOrderList
	 *
	 * @param subOrderList
	 *            subOrderList
	 */
	public void setSubOrderList(List<SubOrderEntity> subOrderList) {
		this.subOrderList = subOrderList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", definitionServ=" + definitionServ + ", site=" + site + ", area=" + area
				+ ", servBusinessCode=" + servBusinessCode + ", servBusinessName=" + servBusinessName + ", type=" + type
				+ ", status=" + status + ", msg=" + msg + ", associateOrderId=" + associateOrderId + ", subOrderList="
				+ subOrderList + "]";
	}

}
