package com.api.dto;

/**
 * �ļ���Ϣ���ݴ������
 * 
 * @author HCK
 *
 */
public class FileDto {

	/**
	 * �ļ���
	 */
	private String name;

	/**
	 * �ļ���С
	 */
	private String size;

	/**
	 * ��ȡ�ļ���
	 *
	 * @return name �ļ���
	 */
	public String getName() {
		return name;
	}

	/**
	 * �����ļ���
	 * 
	 * @param name
	 *            �ļ���
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * ��ȡ�ļ���С
	 *
	 * @return size �ļ���С
	 */
	public String getSize() {
		return size;
	}

	/**
	 * �����ļ���С
	 * 
	 * @param size
	 *            �ļ���С
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "FileDto [name=" + name + ", size=" + size + "]";
	}

}
