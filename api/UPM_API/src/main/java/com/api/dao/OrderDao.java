package com.api.dao;

import com.api.entity.OrderEntity;

/**
 * �����ӿ�
 * 
 * @author HCK
 *
 */
public interface OrderDao extends CrudDao<OrderEntity> {

	int updateStatus(OrderEntity order);
}
