package com.api.entity;

import java.io.Serializable;

/**
 * �û���ɫ�����
 * 
 * @author HCK
 *
 */
public class DefinitionUserRoleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String definitionSubServName;
	private String privilege;
	private boolean visible;

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
	 * ��ȡdefinitionSubServName
	 *
	 * @return definitionSubServName definitionSubServName
	 */
	public String getDefinitionSubServName() {
		return definitionSubServName;
	}

	/**
	 * ����definitionSubServName
	 *
	 * @param definitionSubServName
	 *            definitionSubServName
	 */
	public void setDefinitionSubServName(String definitionSubServName) {
		this.definitionSubServName = definitionSubServName;
	}

	/**
	 * ��ȡprivilege
	 *
	 * @return privilege privilege
	 */
	public String getPrivilege() {
		return privilege;
	}

	/**
	 * ����privilege
	 *
	 * @param privilege
	 *            privilege
	 */
	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	/**
	 * ��ȡvisible
	 *
	 * @return visible visible
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * ����visible
	 *
	 * @param visible
	 *            visible
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
		return "DefinitionUserRoleEntity [id=" + id + ", name=" + name + ", definitionSubServName="
				+ definitionSubServName + ", privilege=" + privilege + ", visible=" + visible + "]";
	}

}
