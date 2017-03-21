package com.api.dao;

import com.api.entity.TaskEntity;

/**
 * ����ӿ�
 * 
 * @author HCK
 *
 */
public interface TaskDao extends CrudDao<TaskEntity> {
	
	TaskEntity getLatestTaskByObjId(String objId);

}
