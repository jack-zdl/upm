package com.api.dao;

import com.api.entity.NfsBackupEntity;

/**
 * ���ݴ洢�ӿ�
 * 
 * @author HCK
 *
 */
public interface NfsBackupDao extends CrudDao<NfsBackupEntity> {

	NfsBackupEntity getByAreaId(String areaId);
}
