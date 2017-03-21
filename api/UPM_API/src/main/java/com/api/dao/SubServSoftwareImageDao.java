package com.api.dao;

import java.util.List;
import java.util.Map;

import com.api.entity.SubServSoftwareImageEntity;

/**
 * �ӷ������������ӿ�
 * 
 * @author HCK
 *
 */
public interface SubServSoftwareImageDao extends CrudDao<SubServSoftwareImageEntity> {

	/**
	 * ��ȡ��Ҫ�ӷ����������汾
	 * 
	 * @param paramMap
	 * @return
	 */
	List<SubServSoftwareImageEntity> listPrimarySubServSoftwareImageVersion(Map<String, Object> paramMap);
	
	/**
	 * ��ȡ�ӷ����������汾
	 * 
	 * @param paramMap
	 * @return
	 */
	List<SubServSoftwareImageEntity> listSubServSoftwareImageVersion(Map<String, Object> paramMap);
}
