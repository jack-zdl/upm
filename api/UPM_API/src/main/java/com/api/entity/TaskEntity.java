package com.api.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * ����ʵ����
 * 
 * @author HCK
 *
 */
public class TaskEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * �������
	 */
	private String id;

	/**
	 * ���������������
	 */
	private String objType;

	/**
	 * ��������������
	 */
	private String objId;

	/**
	 * ���������������
	 */
	private String actionType;

	/**
	 * ����ʼʱ��
	 */
	private Date startDateTime;

	/**
	 * �������ʱ��
	 */
	private Date endDateTime;

	/**
	 * ����״̬
	 */
	private String status;

	/**
	 * �����ִ
	 */
	private String msg;

	/**
	 * ����������
	 */
	private List<SubTaskEntity> subTaskList;

	/**
	 * ������־
	 */
	private OperateLogEntity operateLog;

	/**
	 * ���񴴽���
	 */
	private String createUserLoginName;

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
	 * ��ȡobjType
	 *
	 * @return objType objType
	 */
	public String getObjType() {
		return objType;
	}

	/**
	 * ����objType
	 * 
	 * @param objType
	 *            objType
	 */
	public void setObjType(String objType) {
		this.objType = objType;
	}

	/**
	 * ��ȡobjId
	 *
	 * @return objId objId
	 */
	public String getObjId() {
		return objId;
	}

	/**
	 * ����objId
	 * 
	 * @param objId
	 *            objId
	 */
	public void setObjId(String objId) {
		this.objId = objId;
	}

	/**
	 * ��ȡactionType
	 *
	 * @return actionType actionType
	 */
	public String getActionType() {
		return actionType;
	}

	/**
	 * ����actionType
	 * 
	 * @param actionType
	 *            actionType
	 */
	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	/**
	 * ��ȡstartDateTime
	 *
	 * @return startDateTime startDateTime
	 */
	public Date getStartDateTime() {
		return startDateTime;
	}

	/**
	 * ����startDateTime
	 * 
	 * @param startDateTime
	 *            startDateTime
	 */
	public void setStartDateTime(Date startDateTime) {
		this.startDateTime = startDateTime;
	}

	/**
	 * ��ȡendDateTime
	 *
	 * @return endDateTime endDateTime
	 */
	public Date getEndDateTime() {
		return endDateTime;
	}

	/**
	 * ����endDateTime
	 * 
	 * @param endDateTime
	 *            endDateTime
	 */
	public void setEndDateTime(Date endDateTime) {
		this.endDateTime = endDateTime;
	}

	/**
	 * ��ȡstatus
	 *
	 * @return status status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ����status
	 * 
	 * @param status
	 *            status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ��ȡmsg
	 *
	 * @return msg msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * ����msg
	 * 
	 * @param msg
	 *            msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * ��ȡsubTaskList
	 *
	 * @return subTaskList subTaskList
	 */
	public List<SubTaskEntity> getSubTaskList() {
		return subTaskList;
	}

	/**
	 * ����subTaskList
	 * 
	 * @param subTaskList
	 *            subTaskList
	 */
	public void setSubTaskList(List<SubTaskEntity> subTaskList) {
		this.subTaskList = subTaskList;
	}

	/**
	 * ��ȡoperateLog
	 *
	 * @return operateLog operateLog
	 */
	public OperateLogEntity getOperateLog() {
		return operateLog;
	}

	/**
	 * ����operateLog
	 * 
	 * @param operateLog
	 *            operateLog
	 */
	public void setOperateLog(OperateLogEntity operateLog) {
		this.operateLog = operateLog;
	}

	/**
	 * ��ȡcreateUserLoginName
	 *
	 * @return createUserLoginName createUserLoginName
	 */
	public String getCreateUserLoginName() {
		return createUserLoginName;
	}

	/**
	 * ����createUserLoginName
	 * 
	 * @param createUserLoginName
	 *            createUserLoginName
	 */
	public void setCreateUserLoginName(String createUserLoginName) {
		this.createUserLoginName = createUserLoginName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TaskEntity [id=" + id + ", objType=" + objType + ", objId=" + objId + ", actionType=" + actionType
				+ ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", status=" + status + ", msg="
				+ msg + ", subTaskList=" + subTaskList + ", operateLog=" + operateLog + ", createUserLoginName="
				+ createUserLoginName + "]";
	}

}
