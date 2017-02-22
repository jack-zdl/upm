package com.api.dao;

import java.util.List;
import java.util.Map;

/**
 * ��ɾ�Ĳ�ӿ�
 * 
 * @author HCK
 *
 * @param <T>
 */
public interface CrudDao<T> {

	/**
	 * ���ݼ���������ȡ���ݼ���
	 * 
	 * @param param
	 * @return
	 */
	List<T> list(Map<String, Object> param);
	
	/**
	 * ��ȡ��������
	 * 
	 * @param id
	 * @return
	 */
	T get(String id);

	/**
	 * ��������
	 * 
	 * @param entity
	 * @return
	 */
	int save(T entity);

	/**
	 * ��������
	 * 
	 * @param entity
	 * @return
	 */
	int update(T entity);

	/**
	 * ɾ������
	 * 
	 * @param id
	 * @return
	 */
	int remove(String id);
}
