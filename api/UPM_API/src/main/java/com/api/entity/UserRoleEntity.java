package com.api.entity;

import java.io.Serializable;

/**
 * �û���ɫʵ����
 * 
 * @author HCK
 *
 */
public class UserRoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��ɫ����
	 */
	private String code;

	/**
	 * ��ɫ����
	 */
	private String name;

	/**
	 * ��ɫ����
	 */
	private String level;

	/**
	 * ��ɫ����
	 */
	private String description;

	/**
	 * ��ɫ�Ƿ�ɼ�
	 */
	private boolean visible;

	/**
	 * ��ȡ��ɫ����
	 *
	 * @return code ��ɫ����
	 */
	public String getCode() {
		return code;
	}

	/**
	 * ���ý�ɫ����
	 *
	 * @param code
	 *            ��ɫ����
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ��ȡ��ɫ����
	 *
	 * @return name ��ɫ����
	 */
	public String getName() {
		return name;
	}

	/**
	 * ���ý�ɫ����
	 *
	 * @param name
	 *            ��ɫ����
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��ɫ����
	 *
	 * @return level ��ɫ����
	 */
	public String getLevel() {
		return level;
	}

	/**
	 * ���ý�ɫ����
	 *
	 * @param level
	 *            ��ɫ����
	 */
	public void setLevel(String level) {
		this.level = level;
	}

	/**
	 * ��ȡ��ɫ����
	 *
	 * @return description ��ɫ����
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ���ý�ɫ����
	 *
	 * @param description
	 *            ��ɫ����
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��ȡ��ɫ�Ƿ�ɼ�
	 *
	 * @return visible ��ɫ�Ƿ�ɼ�
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * ���ý�ɫ�Ƿ�ɼ�
	 *
	 * @param visible
	 *            ��ɫ�Ƿ�ɼ�
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRolesEntity [code=" + code + ", name=" + name + ", level=" + level + ", description=" + description
				+ ", visible=" + visible + "]";
	}

}
