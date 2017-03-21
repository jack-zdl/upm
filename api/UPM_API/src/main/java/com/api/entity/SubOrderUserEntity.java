package com.api.entity;

import java.io.Serializable;

/**
 * �Ӷ����û�ʵ����
 * 
 * @author HCK
 *
 */
public class SubOrderUserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �Ӷ����û�����
	 */
	private String id;

	/**
	 * �����Ӷ���
	 */
	private SubOrderEntity subOrder;

	/**
	 * �û���
	 */
	private String username;

	/**
	 * ����
	 */
	private String password;

	/**
	 * �û���ɫ�������
	 */
	private DefinitionUserRoleEntity definitionUserRole;

	/**
	 * ӳ���Ӷ����û�����
	 */
	private String mappingSubOrderUserId;

	/**
	 * ������
	 */
	private String owner;

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
	 * ��ȡusername
	 *
	 * @return username username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ����username
	 *
	 * @param username
	 *            username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ��ȡpassword
	 *
	 * @return password password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ����password
	 *
	 * @param password
	 *            password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ��ȡdefinitionUserRole
	 *
	 * @return definitionUserRole definitionUserRole
	 */
	public DefinitionUserRoleEntity getDefinitionUserRole() {
		return definitionUserRole;
	}

	/**
	 * ����definitionUserRole
	 *
	 * @param definitionUserRole
	 *            definitionUserRole
	 */
	public void setDefinitionUserRole(DefinitionUserRoleEntity definitionUserRole) {
		this.definitionUserRole = definitionUserRole;
	}

	/**
	 * ��ȡmappingSubOrderUserId
	 *
	 * @return mappingSubOrderUserId mappingSubOrderUserId
	 */
	public String getMappingSubOrderUserId() {
		return mappingSubOrderUserId;
	}

	/**
	 * ����mappingSubOrderUserId
	 *
	 * @param mappingSubOrderUserId
	 *            mappingSubOrderUserId
	 */
	public void setMappingSubOrderUserId(String mappingSubOrderUserId) {
		this.mappingSubOrderUserId = mappingSubOrderUserId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubOrderUserEntity [id=" + id + ", subOrder=" + subOrder + ", username=" + username + ", password="
				+ password + ", definitionUserRole=" + definitionUserRole + ", mappingSubOrderUserId="
				+ mappingSubOrderUserId + ", owner=" + owner + "]";
	}

}
