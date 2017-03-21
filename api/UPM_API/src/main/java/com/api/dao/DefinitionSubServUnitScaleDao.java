package com.api.dao;

import java.util.List;
import java.util.Map;

import com.api.entity.DefinitionSubServUnitScaleEntity;

/**
 * �ӷ���Ԫ��ģ����ӿ�
 * 
 * @author HCK
 *
 */
public interface DefinitionSubServUnitScaleDao extends CrudDao<DefinitionSubServUnitScaleEntity> {
	
	/**
	 * ��ȡ��Ҫ�ӷ���Ԫ��ģ
	 * 
	 * @param paramMap
	 * @return
	 */
	List<DefinitionSubServUnitScaleEntity> listPrimarySubServUnitScale(Map<String, Object> paramMap);
}
