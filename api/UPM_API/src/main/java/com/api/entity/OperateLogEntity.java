package com.api.entity;

import java.io.Serializable;

/**
 * ������־ʵ����
 * 
 * @author HCK
 *
 */
public class OperateLogEntity extends BaseEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ������־����
	 */
	private String id;

	/**
	 * ����ģ������
	 */
	private String modelName;

	/**
	 * ��������
	 */
	private String action;

	/**
	 * �����������
	 */
	private String objId;

	/**
	 * ������������
	 */
	private String objName;

	/**
	 * ���������Ϣ
	 */
	private String msg;

	/**
	 * ��ȡ������־����
	 *
	 * @return id ������־����
	 */
	public String getId() {
		return id;
	}

	/**
	 * ���ò�����־����
	 * 
	 * @param id
	 *            ������־����
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * ��ȡ����ģ������
	 *
	 * @return modelName ����ģ������
	 */
	public String getModelName() {
		return modelName;
	}

	/**
	 * ���ò���ģ������
	 * 
	 * @param modelName
	 *            ����ģ������
	 */
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return action ��������
	 */
	public String getAction() {
		return action;
	}

	/**
	 * ���ò�������
	 * 
	 * @param action
	 *            ��������
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * ��ȡ�����������
	 *
	 * @return objId �����������
	 */
	public String getObjId() {
		return objId;
	}

	/**
	 * ���ò����������
	 * 
	 * @param objId
	 *            �����������
	 */
	public void setObjId(String objId) {
		this.objId = objId;
	}

	/**
	 * ��ȡ������������
	 *
	 * @return objName ������������
	 */
	public String getObjName() {
		return objName;
	}

	/**
	 * ���ò�����������
	 * 
	 * @param objName
	 *            ������������
	 */
	public void setObjName(String objName) {
		this.objName = objName;
	}

	/**
	 * ��ȡ���������Ϣ
	 *
	 * @return msg ���������Ϣ
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ���ò��������Ϣ
	 * 
	 * @param msg
	 *            ���������Ϣ
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OperateLogEntity [id=" + id + ", modelName=" + modelName + ", action=" + action + ", objId=" + objId
				+ ", objName=" + objName + ", msg=" + msg + "]";
	}

}
