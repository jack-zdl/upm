package com.api.entity;

import java.io.Serializable;
import java.util.List;

/**
 * �ֵ�����ʵ����
 * 
 * @author HCK
 *
 */
public class DictTypeEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ֵ����������
	 */
	private String code;
	/**
	 * �ֵ�����������
	 */
	private String name;
	/**
	 * �ֵ����ͼ���
	 */
	private List<DictEntity> dictList;

	/**
	 * ��ȡ�ֵ����������
	 *
	 * @return code �ֵ����������
	 */
	public String getCode() {
		return code;
	}

	/**
	 * �����ֵ����������
	 *
	 * @param code
	 *            �ֵ����������
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * ��ȡ�ֵ�����������
	 *
	 * @return name �ֵ�����������
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����ֵ�����������
	 *
	 * @param name
	 *            �ֵ�����������
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ�ֵ����ͼ���
	 *
	 * @return dictList �ֵ����ͼ���
	 */
	public List<DictEntity> getDictList() {
		return dictList;
	}

	/**
	 * �����ֵ����ͼ���
	 *
	 * @param dictList
	 *            �ֵ����ͼ���
	 */
	public void setDictList(List<DictEntity> dictList) {
		this.dictList = dictList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DictTypeEntity [code=" + code + ", name=" + name + ", dictList=" + dictList + "]";
	}

}
