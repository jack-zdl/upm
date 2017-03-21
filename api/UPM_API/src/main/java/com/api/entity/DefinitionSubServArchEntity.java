package com.api.entity;

import java.io.Serializable;

/**
 * �ӷ���ܹ�����ʵ����
 * 
 * @author HCK
 *
 */
public class DefinitionSubServArchEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �ӷ���ܹ��������
	 */
	private String id;

	/**
	 * �ӷ���ܹ��������
	 */
	private String code;

	/**
	 * �ӷ���ܹ���������
	 */
	private String name;

	private String type;

	/**
	 * �ӷ���������
	 */
	private String definitionSubServName;

	/**
	 * �߿���ָ��
	 */
	private Integer highAvailability;

	/**
	 * һ����ָ��
	 */
	private Integer consistency;

	/**
	 * ����Ч��ָ��
	 */
	private Integer capability;

	/**
	 * ��Ԫ����
	 */
	private Integer unitNum;

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
	 * ��ȡhighAvailability
	 *
	 * @return highAvailability highAvailability
	 */
	public Integer getHighAvailability() {
		return highAvailability;
	}

	/**
	 * ����highAvailability
	 * 
	 * @param highAvailability
	 *            highAvailability
	 */
	public void setHighAvailability(Integer highAvailability) {
		this.highAvailability = highAvailability;
	}

	/**
	 * ��ȡconsistency
	 *
	 * @return consistency consistency
	 */
	public Integer getConsistency() {
		return consistency;
	}

	/**
	 * ����consistency
	 * 
	 * @param consistency
	 *            consistency
	 */
	public void setConsistency(Integer consistency) {
		this.consistency = consistency;
	}

	/**
	 * ��ȡcapability
	 *
	 * @return capability capability
	 */
	public Integer getCapability() {
		return capability;
	}

	/**
	 * ����capability
	 * 
	 * @param capability
	 *            capability
	 */
	public void setCapability(Integer capability) {
		this.capability = capability;
	}

	/**
	 * ��ȡunitNum
	 *
	 * @return unitNum unitNum
	 */
	public Integer getUnitNum() {
		return unitNum;
	}

	/**
	 * ����unitNum
	 * 
	 * @param unitNum
	 *            unitNum
	 */
	public void setUnitNum(Integer unitNum) {
		this.unitNum = unitNum;
	}

	/**
	 * ��ȡtype
	 *
	 * @return type type
	 */
	public String getType() {
		return type;
	}

	/**
	 * ����type
	 *
	 * @param type
	 *            type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DefinitionSubServArchEntity [id=" + id + ", code=" + code + ", name=" + name + ", type=" + type
				+ ", definitionSubServName=" + definitionSubServName + ", highAvailability=" + highAvailability
				+ ", consistency=" + consistency + ", capability=" + capability + ", unitNum=" + unitNum + "]";
	}

}
