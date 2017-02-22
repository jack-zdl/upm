package com.api.dto;

import java.io.Serializable;

/**
 * վ�����ݴ������
 * 
 * @author HCK
 *
 */
public class SiteDto extends BaseDto implements Serializable {

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
	 * ��������
	 */
	private String regionName;

	/**
	 * mgm״̬����
	 */
	private int mgmStatusCode;

	/**
	 * mgm״̬����
	 */
	private String mgmStatusName;

	/**
	 * horus_server״̬����
	 */
	private int hsStatusCode;

	/**
	 * horus_server״̬����
	 */
	private String hsStatusName;

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
	 * ��ȡ��������
	 *
	 * @return regionName ��������
	 */
	public String getRegionName() {
		return regionName;
	}

	/**
	 * ���õ�������
	 *
	 * @param regionName
	 *            ��������
	 */
	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	/**
	 * ��ȡmgm״̬����
	 *
	 * @return mgmStatusCode mgm״̬����
	 */
	public int getMgmStatusCode() {
		return mgmStatusCode;
	}

	/**
	 * ����mgm״̬����
	 *
	 * @param mgmStatusCode
	 *            mgm״̬����
	 */
	public void setMgmStatusCode(int mgmStatusCode) {
		this.mgmStatusCode = mgmStatusCode;
	}

	/**
	 * ��ȡmgm״̬����
	 *
	 * @return mgmStatusName mgm״̬����
	 */
	public String getMgmStatusName() {
		return mgmStatusName;
	}

	/**
	 * ����mgm״̬����
	 *
	 * @param mgmStatusName
	 *            mgm״̬����
	 */
	public void setMgmStatusName(String mgmStatusName) {
		this.mgmStatusName = mgmStatusName;
	}

	/**
	 * ��ȡhorus_server״̬����
	 *
	 * @return hsStatusCode horus_server״̬����
	 */
	public int getHsStatusCode() {
		return hsStatusCode;
	}

	/**
	 * ����horus_server״̬����
	 *
	 * @param hsStatusCode
	 *            horus_server״̬����
	 */
	public void setHsStatusCode(int hsStatusCode) {
		this.hsStatusCode = hsStatusCode;
	}

	/**
	 * ��ȡhorus_server״̬����
	 *
	 * @return hsStatusName horus_server״̬����
	 */
	public String getHsStatusName() {
		return hsStatusName;
	}

	/**
	 * ����horus_server״̬����
	 *
	 * @param hsStatusName
	 *            horus_server״̬����
	 */
	public void setHsStatusName(String hsStatusName) {
		this.hsStatusName = hsStatusName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteDto [id=" + id + ", name=" + name + ", regionCode=" + regionCode + ", regionName=" + regionName
				+ ", mgmStatusCode=" + mgmStatusCode + ", mgmStatusName=" + mgmStatusName + ", hsStatusCode="
				+ hsStatusCode + ", hsStatusName=" + hsStatusName + "]";
	}

}
