package com.api.dao;

import java.util.Map;

import com.api.entity.UserEntity;

/**
 * �û��ӿ�
 * 
 * @author HCK
 *
 */
public interface UserDao {

	/**
	 * ��ȡ�û���Ϣ
	 * 
	 * @param param
	 * @return
	 */
	public UserEntity getUser(Map<String, Object> param);
	
	/**
	 * �����û�����¼ʱ��
	 * 
	 * @param user
	 */
	public void updateLatestLoginDateTime(UserEntity user);
}
