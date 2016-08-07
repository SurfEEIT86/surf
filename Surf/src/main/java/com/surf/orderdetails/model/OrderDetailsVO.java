package com.surf.orderdetails.model;

import java.io.Serializable;

import com.surf.orders.model.OrdersVO;

public class OrderDetailsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer productno;
	private OrdersVO ordersvo;
	private Integer quantity;
	
	public OrdersVO getOrdersvo() {
		return ordersvo;
	}
	public void setOrdersvo(OrdersVO ordersvo) {
		this.ordersvo = ordersvo;
	}
	
	public Integer getProductno() {
		return productno;
	}
	public void setProductno(Integer productno) {
		this.productno = productno;
	}
	
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
}
