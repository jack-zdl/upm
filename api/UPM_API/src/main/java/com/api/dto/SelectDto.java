package com.api.dto;

import java.io.Serializable;

/**
 * SELECT���ݴ������
 * 
 * @author HCK
 *
 */
public class SelectDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ����
	 */
	private String id;

	/**
	 * ��ʾ����
	 */
	private String text;

	/**
	 * ��ʾͼ��
	 */
	private String icon;

	/**
	 * ��ȡ����
	 *
	 * @return id ����
	 */
	public String getId() {
		return id;
	}

	/**
	 * ���ñ���
	 * 
	 * @param id
	 *            ����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ��ʾ����
	 *
	 * @return text ��ʾ����
	 */
	public String getText() {
		return text;
	}

	/**
	 * ������ʾ����
	 * 
	 * @param text
	 *            ��ʾ����
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * ��ȡ��ʾͼ��
	 *
	 * @return icon ��ʾͼ��
	 */
	public String getIcon() {
		return icon;
	}

	/**
	 * ������ʾͼ��
	 * 
	 * @param icon
	 *            ��ʾͼ��
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SelectDto [id=" + id + ", text=" + text + ", icon=" + icon + "]";
	}

}
