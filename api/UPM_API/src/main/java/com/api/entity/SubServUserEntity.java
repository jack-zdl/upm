package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ����û�ʵ����
 * 
 * @author HCK
 *
 */
public class SubServUserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ����û�����
	 */
	private String id;

	/**
	 * �����ӷ���
	 */
	private SubServEntity subServ;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubServUserEntity [id=" + id + ", subServ=" + subServ + ", username=" + username + ", password="
				+ password + ", definitionUserRole=" + definitionUserRole + ", mappingSubOrderUserId="
				+ mappingSubOrderUserId + "]";
	}

}
