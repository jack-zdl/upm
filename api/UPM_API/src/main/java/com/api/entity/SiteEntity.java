package com.api.entity;

import java.io.Serializable;

/**
 * վ��ʵ����
 * 
 * @author HCK
 *
 */
public class SiteEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * վ�����
	 */
	private String id;

	/**
	 * վ������
	 */
	private String name;

	/**
	 * �������
	 */
	private String regionCode;

	/**
	 * consul��Ⱥ��ַ
	 */
	private String consulIps;

	/**
	 * consul��Ⱥ�˿�
	 */
	private Integer consulPort;

	/**
	 * consulͨѶ����
	 */
	private String consulToken;

	/**
	 * ��Դ�������mgm����֤֤��
	 */
	private String mgmCa;

	/**
	 * ��ع������horus server����֤֤��
	 */
	private String horusServerCa;

	/**
	 * ��Դ�����������
	 */
	private String mgmPrefix;

	/**
	 * ��ع����������
	 */
	private String horusServerPrefix;

	/**
	 * ��ȡվ�����
	 *
	 * @return id վ�����
	 */
	public String getId() {
		return id;
	}

	/**
	 * ����վ�����
	 *
	 * @param id
	 *            վ�����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡվ������
	 *
	 * @return name վ������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ����վ������
	 *
	 * @param name
	 *            վ������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ�������
	 *
	 * @return regionCode �������
	 */
	public String getRegionCode() {
		return regionCode;
	}

	/**
	 * ���õ������
	 *
	 * @param regionCode
	 *            �������
	 */
	public void setRegionCode(String regionCode) {
		this.regionCode = regionCode;
	}

	/**
	 * ��ȡconsul��Ⱥ��ַ
	 *
	 * @return consulIps consul��Ⱥ��ַ
	 */
	public String getConsulIps() {
		return consulIps;
	}

	/**
	 * ����consul��Ⱥ��ַ
	 *
	 * @param consulIps
	 *            consul��Ⱥ��ַ
	 */
	public void setConsulIps(String consulIps) {
		this.consulIps = consulIps;
	}

	/**
	 * ��ȡconsul��Ⱥ�˿�
	 *
	 * @return consulPort consul��Ⱥ�˿�
	 */
	public Integer getConsulPort() {
		return consulPort;
	}

	/**
	 * ����consul��Ⱥ�˿�
	 *
	 * @param consulPort
	 *            consul��Ⱥ�˿�
	 */
	public void setConsulPort(Integer consulPort) {
		this.consulPort = consulPort;
	}

	/**
	 * ��ȡconsulͨѶ����
	 *
	 * @return consulToken consulͨѶ����
	 */
	public String getConsulToken() {
		return consulToken;
	}

	/**
	 * ����consulͨѶ����
	 *
	 * @param consulToken
	 *            consulͨѶ����
	 */
	public void setConsulToken(String consulToken) {
		this.consulToken = consulToken;
	}

	/**
	 * ��ȡ��Դ�������mgm����֤֤��
	 *
	 * @return mgmCa ��Դ�������mgm����֤֤��
	 */
	public String getMgmCa() {
		return mgmCa;
	}

	/**
	 * ������Դ�������mgm����֤֤��
	 *
	 * @param mgmCa
	 *            ��Դ�������mgm����֤֤��
	 */
	public void setMgmCa(String mgmCa) {
		this.mgmCa = mgmCa;
	}

	/**
	 * ��ȡ��ع������horus server����֤֤��
	 *
	 * @return hoursServerCa ��ع������horus server����֤֤��
	 */
	public String getHorusServerCa() {
		return horusServerCa;
	}

	/**
	 * ���ü�ع������horus server����֤֤��
	 *
	 * @param horusServerCa
	 *            ��ع������horus server����֤֤��
	 */
	public void setHorusServerCa(String horusServerCa) {
		this.horusServerCa = horusServerCa;
	}

	/**
	 * ��ȡ��Դ�����������
	 *
	 * @return mgmPrefix ��Դ�����������
	 */
	public String getMgmPrefix() {
		return mgmPrefix;
	}

	/**
	 * ������Դ�����������
	 *
	 * @param mgmPrefix
	 *            ��Դ�����������
	 */
	public void setMgmPrefix(String mgmPrefix) {
		this.mgmPrefix = mgmPrefix;
	}

	/**
	 * ��ȡ��ع����������
	 *
	 * @return horusServerPrefix ��ع����������
	 */
	public String getHorusServerPrefix() {
		return horusServerPrefix;
	}

	/**
	 * ���ü�ع����������
	 *
	 * @param horusServerPrefix
	 *            ��ع����������
	 */
	public void setHorusServerPrefix(String horusServerPrefix) {
		this.horusServerPrefix = horusServerPrefix;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteEntity [id=" + id + ", name=" + name + ", regionCode=" + regionCode + ", consulIps=" + consulIps
				+ ", consulPort=" + consulPort + ", consulToken=" + consulToken + ", mgmCa=" + mgmCa
				+ ", horusServerCa=" + horusServerCa + ", mgmPrefix=" + mgmPrefix + ", horusServerPrefix="
				+ horusServerPrefix + "]";
	}

}
