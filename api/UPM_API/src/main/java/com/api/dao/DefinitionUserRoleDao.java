package com.api.dao;

import java.util.List;
import java.util.Map;

import com.api.entity.DefinitionUserRoleEntity;

/**
 * �û���ɫ����ӿ�
 * 
 * @author HCK
 *
 */
public interface DefinitionUserRoleDao extends CrudDao<DefinitionUserRoleEntity> {

	List<DefinitionUserRoleEntity> listPrimarySubServUserRole(Map<String, Object> paramMap);
}
