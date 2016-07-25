package com.surf.orderdetails.model;

import java.util.List;

import org.hibernate.Session;

public interface OrderDetailsDAO {

	Session getSession();

	OrderDetailsVO select(Integer orderno);

	List<OrderDetailsVO> selectAll();

	OrderDetailsVO insert(OrderDetailsVO bean);

	OrderDetailsVO update(OrderDetailsVO bean);

}