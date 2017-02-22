package com.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ������־ʵ����
 * 
 * @author HCK
 *
 */
public class OperateLogEntity implements Serializable {

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
	private String operateModelName;

	/**
	 * ��������
	 */
	private String operateAction;

	/**
	 * �����������
	 */
	private String operateObjId;

	/**
	 * ������������
	 */
	private String operateObjName;

	/**
	 * ������
	 */
	private String operateLoginName;

	/**
	 * ����ʱ��
	 */
	private Date operateDateTime;

	/**
	 * ����״̬
	 */
	private Integer operateStatus;

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
	 * @return operateModelName ����ģ������
	 */
	public String getOperateModelName() {
		return operateModelName;
	}

	/**
	 * ���ò���ģ������
	 *
	 * @param operateModelName
	 *            ����ģ������
	 */
	public void setOperateModelName(String operateModelName) {
		this.operateModelName = operateModelName;
	}

	/**
	 * ��ȡ��������
	 *
	 * @return operateAction ��������
	 */
	public String getOperateAction() {
		return operateAction;
	}

	/**
	 * ���ò�������
	 *
	 * @param operateAction
	 *            ��������
	 */
	public void setOperateAction(String operateAction) {
		this.operateAction = operateAction;
	}

	/**
	 * ��ȡ�����������
	 *
	 * @return operateObjId �����������
	 */
	public String getOperateObjId() {
		return operateObjId;
	}

	/**
	 * ���ò����������
	 *
	 * @param operateObjId
	 *            �����������
	 */
	public void setOperateObjId(String operateObjId) {
		this.operateObjId = operateObjId;
	}

	/**
	 * ��ȡ������������
	 *
	 * @return operateObjName ������������
	 */
	public String getOperateObjName() {
		return operateObjName;
	}

	/**
	 * ���ò�����������
	 *
	 * @param operateObjName
	 *            ������������
	 */
	public void setOperateObjName(String operateObjName) {
		this.operateObjName = operateObjName;
	}

	/**
	 * ��ȡ������
	 *
	 * @return operateLoginName ������
	 */
	public String getOperateLoginName() {
		return operateLoginName;
	}

	/**
	 * ���ò�����
	 *
	 * @param operateLoginName
	 *            ������
	 */
	public void setOperateLoginName(String operateLoginName) {
		this.operateLoginName = operateLoginName;
	}

	/**
	 * ��ȡ����ʱ��
	 *
	 * @return operateDateTime ����ʱ��
	 */
	public Date getOperateDateTime() {
		return operateDateTime;
	}

	/**
	 * ���ò���ʱ��
	 *
	 * @param operateDateTime
	 *            ����ʱ��
	 */
	public void setOperateDateTime(Date operateDateTime) {
		this.operateDateTime = operateDateTime;
	}

	/**
	 * ��ȡ����״̬
	 *
	 * @return operateStatus ����״̬
	 */
	public Integer getOperateStatus() {
		return operateStatus;
	}

	/**
	 * ���ò���״̬
	 *
	 * @param operateStatus
	 *            ����״̬
	 */
	public void setOperateStatus(Integer operateStatus) {
		this.operateStatus = operateStatus;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OperateLogEntity [id=" + id + ", operateModelName=" + operateModelName + ", operateAction="
				+ operateAction + ", operateObjId=" + operateObjId + ", operateObjName=" + operateObjName
				+ ", operateLoginName=" + operateLoginName + ", operateDateTime=" + operateDateTime + ", operateStatus="
				+ operateStatus + "]";
	}

}
