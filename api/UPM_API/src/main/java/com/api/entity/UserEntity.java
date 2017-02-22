package com.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * �û�ʵ����
 * 
 * @author HCK
 *
 */
public class UserEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��¼�û���
	 */
	private String loginName;

	/**
	 * ����
	 */
	private String password;

	/**
	 * ��ϵ�绰
	 */
	private String telephone;

	/**
	 * ����
	 */
	private String email;

	/**
	 * ������λ
	 */
	private String company;

	/**
	 * �������
	 */
	private UserGroupEntity userGroup;

	/**
	 * �����û���ɫ
	 */
	private UserRoleEntity userRole;

	/**
	 * �û��Ƿ���Ч
	 */
	private boolean validate;

	/**
	 * �����½ʱ��
	 */
	private Date latestLoginDateTime;

	/**
	 * ��ȡ��¼�û���
	 *
	 * @return loginName ��¼�û���
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * ���õ�¼�û���
	 *
	 * @param loginName
	 *            ��¼�û���
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	/**
	 * ��ȡ����
	 *
	 * @return password ����
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * ��������
	 *
	 * @param password
	 *            ����
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * ��ȡ��ϵ�绰
	 *
	 * @return telephone ��ϵ�绰
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * ������ϵ�绰
	 *
	 * @param telephone
	 *            ��ϵ�绰
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * ��ȡ����
	 *
	 * @return email ����
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * ��������
	 *
	 * @param email
	 *            ����
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * ��ȡ������λ
	 *
	 * @return company ������λ
	 */
	public String getCompany() {
		return company;
	}

	/**
	 * ����������λ
	 *
	 * @param company
	 *            ������λ
	 */
	public void setCompany(String company) {
		this.company = company;
	}

	/**
	 * ��ȡ�������
	 *
	 * @return userGroup �������
	 */
	public UserGroupEntity getUserGroup() {
		return userGroup;
	}

	/**
	 * �����������
	 *
	 * @param userGroup
	 *            �������
	 */
	public void setUserGroup(UserGroupEntity userGroup) {
		this.userGroup = userGroup;
	}

	/**
	 * ��ȡ�����û���ɫ
	 *
	 * @return userRole �����û���ɫ
	 */
	public UserRoleEntity getUserRole() {
		return userRole;
	}

	/**
	 * ���������û���ɫ
	 *
	 * @param userRole
	 *            �����û���ɫ
	 */
	public void setUserRole(UserRoleEntity userRole) {
		this.userRole = userRole;
	}

	/**
	 * ��ȡ�û��Ƿ���Ч
	 *
	 * @return validate �û��Ƿ���Ч
	 */
	public boolean isValidate() {
		return validate;
	}

	/**
	 * �����û��Ƿ���Ч
	 *
	 * @param validate
	 *            �û��Ƿ���Ч
	 */
	public void setValidate(boolean validate) {
		this.validate = validate;
	}

	/**
	 * ��ȡ�����½ʱ��
	 *
	 * @return latestLoginDateTime �����½ʱ��
	 */
	public Date getLatestLoginDateTime() {
		return latestLoginDateTime;
	}

	/**
	 * ���������½ʱ��
	 *
	 * @param latestLoginDateTime
	 *            �����½ʱ��
	 */
	public void setLatestLoginDateTime(Date latestLoginDateTime) {
		this.latestLoginDateTime = latestLoginDateTime;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserEntity [loginName=" + loginName + ", password=" + password + ", telephone=" + telephone + ", email="
				+ email + ", company=" + company + ", userGroup=" + userGroup + ", userRole=" + userRole
				+ ", validate=" + validate + ", latestLoginDateTime=" + latestLoginDateTime + "]";
	}

}
