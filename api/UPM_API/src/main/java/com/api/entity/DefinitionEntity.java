package com.api.entity;

import java.io.Serializable;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class DefinitionEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String dictCode;
	private String code;

	/**
	 * ��ȡdictCode
	 *
	 * @return dictCode dictCode
	 */
	public String getDictCode() {
		return dictCode;
	}

	/**
	 * ����dictCode
	 *
	 * @param dictCode
	 *            dictCode
	 */
	public void setDictCode(String dictCode) {
		this.dictCode = dictCode;
	}

	/**
	 * ��ȡcode
	 *
	 * @return code code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * ����code
	 *
	 * @param code
	 *            code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinitionEntity [dictCode=" + dictCode + ", code=" + code + "]";
	}

}
