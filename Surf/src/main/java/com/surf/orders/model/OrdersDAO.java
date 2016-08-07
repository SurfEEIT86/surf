package com.surf.orders.model;

import java.util.List;

import org.hibernate.Session;

public interface OrdersDAO {

	Session getSession();

	OrdersVO select(Integer orderno);

	List<OrdersVO> selectAll();

	List<OrdersVO> findOrdersByMemberNo(Integer memberNo);

	OrdersVO insert(OrdersVO bean);

	OrdersVO update(OrdersVO vo);

	boolean deleteByOrderNo(Integer orderno);

}