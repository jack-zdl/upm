package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ���Ԫ��ģ����ʵ����
 * 
 * @author HCK
 *
 */
public class DefinitionSubServUnitScaleEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ���Ԫ��ģ�������
	 */
	private String id;

	/**
	 * �ӷ���Ԫ��ģ��������
	 */
	private String name;

	/**
	 * �ӷ���������
	 */
	private String definitionSubServName;

	/**
	 * cpu��Ŀ
	 */
	private Integer cpuNum;

	/**
	 * �ڴ�����
	 */
	private Integer memSize;

	/**
	 * IOȨ��
	 */
	private Integer ioWeight;

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
	 * ��ȡcpuNum
	 *
	 * @return cpuNum cpuNum
	 */
	public Integer getCpuNum() {
		return cpuNum;
	}

	/**
	 * ����cpuNum
	 * 
	 * @param cpuNum
	 *            cpuNum
	 */
	public void setCpuNum(Integer cpuNum) {
		this.cpuNum = cpuNum;
	}

	/**
	 * ��ȡmemSize
	 *
	 * @return memSize memSize
	 */
	public Integer getMemSize() {
		return memSize;
	}

	/**
	 * ����memSize
	 * 
	 * @param memSize
	 *            memSize
	 */
	public void setMemSize(Integer memSize) {
		this.memSize = memSize;
	}

	/**
	 * ��ȡioWeight
	 *
	 * @return ioWeight ioWeight
	 */
	public Integer getIoWeight() {
		return ioWeight;
	}

	/**
	 * ����ioWeight
	 * 
	 * @param ioWeight
	 *            ioWeight
	 */
	public void setIoWeight(Integer ioWeight) {
		this.ioWeight = ioWeight;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinitionSubServUnitScaleEntity [id=" + id + ", name=" + name + ", definitionSubServName="
				+ definitionSubServName + ", cpuNum=" + cpuNum + ", memSize=" + memSize + ", ioWeight=" + ioWeight
				+ "]";
	}

}
