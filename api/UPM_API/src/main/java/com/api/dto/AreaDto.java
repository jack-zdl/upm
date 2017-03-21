package com.api.dto;

import java.io.Serializable;

/**
 * �������ݴ������
 * 
 * @author HCK
 *
 */
public class AreaDto extends BaseDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ��������
	 */
	private String name;

	/**
	 * ��������
	 */
	private String description;

	/**
	 * �Ƿ����
	 */
	private Boolean enabled;

	/**
	 * �Ƿ����(������ʾ)
	 */
	private String enabledText;

	/**
	 * ��ȡ��������
	 *
	 * @return name ��������
	 */
	public String getName() {
		return name;
	}

	/**
	 * ������������
	 * 
	 * @param name
	 *            ��������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return description ��������
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * ������������
	 * 
	 * @param description
	 *            ��������
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * ��ȡenabled
	 *
	 * @return enabled enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	/**
	 * ����enabled
	 *
	 * @param enabled
	 *            enabled
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * ��ȡenabledText
	 *
	 * @return enabledText enabledText
	 */
	public String getEnabledText() {
		return enabledText;
	}

	/**
	 * ����enabledText
	 *
	 * @param enabledText
	 *            enabledText
	 */
	public void setEnabledText(String enabledText) {
		this.enabledText = enabledText;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AreaDto [name=" + name + ", description=" + description + ", enabled=" + enabled + ", enabledText="
				+ enabledText + "]";
	}

}
