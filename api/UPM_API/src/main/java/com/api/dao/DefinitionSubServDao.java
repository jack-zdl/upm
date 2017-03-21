package com.api.dao;

import java.util.List;
import java.util.Map;
import com.api.entity.DefinitionSubServEntity;

/**
 * �ӷ�����ӿ�
 * 
 * @author HCK
 *
 */
public interface DefinitionSubServDao extends CrudDao<DefinitionSubServEntity> {

	/**
	 * ��ȡ�ӷ���������ͼ��
	 * 
	 * @param paramMap
	 *            ��������
	 * @return
	 */
	List<DefinitionSubServEntity> listNameAndIcon(Map<String, Object> paramMap);
}
