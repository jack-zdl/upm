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
	private String regionText;

	/**
	 * mgm״̬����
	 */
	private String mgmStatusCode;

	/**
	 * mgm״̬��ʾ
	 */
	private String mgmStatusText;

	/**
	 * horus_server״̬����
	 */
	private String hsStatusCode;

	/**
	 * horus_server״̬��ʾ
	 */
	private String hsStatusText;

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
	 * @return regionText ��������
	 */
	public String getRegionText() {
		return regionText;
	}

	/**
	 * ���õ�������
	 *
	 * @param regionText
	 *            ��������
	 */
	public void setRegionText(String regionText) {
		this.regionText = regionText;
	}

	/**
	 * ��ȡmgm״̬����
	 *
	 * @return mgmStatusCode mgm״̬����
	 */
	public String getMgmStatusCode() {
		return mgmStatusCode;
	}

	/**
	 * ����mgm״̬����
	 *
	 * @param mgmStatusCode
	 *            mgm״̬����
	 */
	public void setMgmStatusCode(String mgmStatusCode) {
		this.mgmStatusCode = mgmStatusCode;
	}

	/**
	 * ��ȡmgm״̬��ʾ
	 *
	 * @return mgmStatusText mgm״̬��ʾ
	 */
	public String getMgmStatusText() {
		return mgmStatusText;
	}

	/**
	 * ����mgm״̬��ʾ
	 *
	 * @param mgmStatusText
	 *            mgm״̬��ʾ
	 */
	public void setMgmStatusText(String mgmStatusText) {
		this.mgmStatusText = mgmStatusText;
	}

	/**
	 * ��ȡhorus_server״̬����
	 *
	 * @return hsStatusCode horus_server״̬����
	 */
	public String getHsStatusCode() {
		return hsStatusCode;
	}

	/**
	 * ����horus_server״̬����
	 *
	 * @param hsStatusCode
	 *            horus_server״̬����
	 */
	public void setHsStatusCode(String hsStatusCode) {
		this.hsStatusCode = hsStatusCode;
	}

	/**
	 * ��ȡhorus_server״̬��ʾ
	 *
	 * @return hsStatusText horus_server״̬��ʾ
	 */
	public String getHsStatusText() {
		return hsStatusText;
	}

	/**
	 * ����horus_server״̬��ʾ
	 *
	 * @param hsStatusText
	 *            horus_server״̬��ʾ
	 */
	public void setHsStatusText(String hsStatusText) {
		this.hsStatusText = hsStatusText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SiteDto [id=" + id + ", name=" + name + ", regionCode=" + regionCode + ", regionText=" + regionText
				+ ", mgmStatusCode=" + mgmStatusCode + ", mgmStatusText=" + mgmStatusText + ", hsStatusCode="
				+ hsStatusCode + ", hsStatusText=" + hsStatusText + "]";
	}

}
