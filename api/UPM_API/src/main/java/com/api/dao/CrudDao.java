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
	 * ���ݼ���������ȡ��¼����
	 * 
	 * @param param
	 *            ������ֵ��
	 * @return ���ϼ��������ļ�¼����
	 */
	List<T> list(Map<String, Object> param);

	/**
	 * ��ȡ������¼
	 * 
	 * @param id
	 *            ����
	 * @return ������¼
	 */
	T get(String id);

	/**
	 * �����¼
	 * 
	 * @param entity
	 *            ��¼ʵ�������
	 * @return �����������
	 */
	int save(T entity);

	/**
	 * ���¼�¼
	 * 
	 * @param entity
	 *            ��¼ʵ�������
	 * @return ���¶�������
	 */
	int update(T entity);

	/**
	 * ɾ����¼
	 * 
	 * @param id
	 *            ����
	 * @return ��¼��������
	 */
	int remove(String id);
}
