package com.surf.orderdetails.model;

import java.util.List;

import org.hibernate.Session;

import com.surf.orders.model.OrdersVO;



public interface OrderDetailsDAO {

	Session getSession();

	public List<OrderDetailsVO> select(Integer no);

	List<OrderDetailsVO> selectAll();

	OrderDetailsVO insert(OrderDetailsVO bean);

	OrderDetailsVO update(OrderDetailsVO bean);

}
