package com.api.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * ������ʵ����
 * 
 * @author HCK
 *
 */
public class SubTaskEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ���������
	 */
	private String id;

	/**
	 * �����������������
	 */
	private String objType;

	/**
	 * ����������������
	 */
	private String objId;

	/**
	 * �����������������
	 */
	private String actionType;

	/**
	 * �Ƿ��첽����
	 */
	private boolean async;

	/**
	 * ������ʼʱ��
	 */
	private Date startDateTime;

	/**
	 * ���������ʱ��
	 */
	private Date endDateTime;

	/**
	 * ������״̬
	 */
	private String status;

	private String url;
	private String methodType;
	private String param;

	/**
	 * �����������
	 */
	private String relateTaskId;

	/**
	 * ��������״̬
	 */
	private Integer relateTaskStatus;

	/**
	 * ���������ִ
	 */
	private String relateTaskMsg;

	/**
	 * ���������ȼ�
	 */
	private Integer priority;

	/**
	 * ��������
	 */
	private TaskEntity task;

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
	 * ��ȡasync
	 *
	 * @return async async
	 */
	public boolean isAsync() {
		return async;
	}

	/**
	 * ����async
	 * 
	 * @param async
	 *            async
	 */
	public void setAsync(boolean async) {
		this.async = async;
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
	 * ��ȡurl
	 *
	 * @return url url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * ����url
	 *
	 * @param url
	 *            url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * ��ȡmethodType
	 *
	 * @return methodType methodType
	 */
	public String getMethodType() {
		return methodType;
	}

	/**
	 * ����methodType
	 *
	 * @param methodType
	 *            methodType
	 */
	public void setMethodType(String methodType) {
		this.methodType = methodType;
	}

	/**
	 * ��ȡparam
	 *
	 * @return param param
	 */
	public String getParam() {
		return param;
	}

	/**
	 * ����param
	 *
	 * @param param
	 *            param
	 */
	public void setParam(String param) {
		this.param = param;
	}

	/**
	 * ��ȡrelateTaskId
	 *
	 * @return relateTaskId relateTaskId
	 */
	public String getRelateTaskId() {
		return relateTaskId;
	}

	/**
	 * ����relateTaskId
	 * 
	 * @param relateTaskId
	 *            relateTaskId
	 */
	public void setRelateTaskId(String relateTaskId) {
		this.relateTaskId = relateTaskId;
	}

	/**
	 * ��ȡrelateTaskStatus
	 *
	 * @return relateTaskStatus relateTaskStatus
	 */
	public Integer getRelateTaskStatus() {
		return relateTaskStatus;
	}

	/**
	 * ����relateTaskStatus
	 * 
	 * @param relateTaskStatus
	 *            relateTaskStatus
	 */
	public void setRelateTaskStatus(Integer relateTaskStatus) {
		this.relateTaskStatus = relateTaskStatus;
	}

	/**
	 * ��ȡrelateTaskMsg
	 *
	 * @return relateTaskMsg relateTaskMsg
	 */
	public String getRelateTaskMsg() {
		return relateTaskMsg;
	}

	/**
	 * ����relateTaskMsg
	 * 
	 * @param relateTaskMsg
	 *            relateTaskMsg
	 */
	public void setRelateTaskMsg(String relateTaskMsg) {
		this.relateTaskMsg = relateTaskMsg;
	}

	/**
	 * ��ȡpriority
	 *
	 * @return priority priority
	 */
	public Integer getPriority() {
		return priority;
	}

	/**
	 * ����priority
	 * 
	 * @param priority
	 *            priority
	 */
	public void setPriority(Integer priority) {
		this.priority = priority;
	}

	/**
	 * ��ȡtask
	 *
	 * @return task task
	 */
	public TaskEntity getTask() {
		return task;
	}

	/**
	 * ����task
	 * 
	 * @param task
	 *            task
	 */
	public void setTask(TaskEntity task) {
		this.task = task;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "SubTaskEntity [id=" + id + ", objType=" + objType + ", objId=" + objId + ", actionType=" + actionType
				+ ", async=" + async + ", startDateTime=" + startDateTime + ", endDateTime=" + endDateTime + ", status="
				+ status + ", url=" + url + ", methodType=" + methodType + ", param=" + param + ", relateTaskId="
				+ relateTaskId + ", relateTaskStatus=" + relateTaskStatus + ", relateTaskMsg=" + relateTaskMsg
				+ ", priority=" + priority + ", task=" + task + "]";
	}

}
