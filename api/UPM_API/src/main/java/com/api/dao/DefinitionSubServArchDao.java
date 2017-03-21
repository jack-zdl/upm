package com.api.dao;

import java.util.List;
import java.util.Map;

import com.api.entity.DefinitionSubServArchEntity;

/**
 * �ӷ���ܹ�����ӿ�
 * 
 * @author HCK
 *
 */
public interface DefinitionSubServArchDao extends CrudDao<DefinitionSubServArchEntity> {

	/**
	 * ��ȡ��Ҫ�ӷ���ܹ�
	 * 
	 * @param paramMap
	 * @return
	 */
	List<DefinitionSubServArchEntity> listPrimarySubServArch(Map<String, Object> paramMap);
}
