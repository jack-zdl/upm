package com.api.dao;

import java.util.List;

import com.api.entity.DefinitionServEntity;

/**
 * ������ӿ�
 * 
 * @author HCK
 *
 */
public interface DefinitionServDao extends CrudDao<DefinitionServEntity> {
	
	List<DefinitionServEntity> listNameAndIcon();
}
