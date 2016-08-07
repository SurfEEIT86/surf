package com.surf.orders.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.surf.orderdetails.model.OrderDetailsVO;

public class OrdersVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer orderno;
	private Integer memberno;
	private java.sql.Timestamp datetime;
	private Integer status;
	private double totalprice;
	private String address;
	private Set<OrderDetailsVO> orderdetails = new LinkedHashSet<OrderDetailsVO>();
	private String creditcard;
	
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	public Set<OrderDetailsVO> getOrderdetails() {
		return orderdetails;
	}
	public void setOrderdetails(Set<OrderDetailsVO> orderdetails) {
		this.orderdetails = orderdetails;
	}
	public Integer getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public Integer getMemberno() {
		return memberno;
	}
	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}
	public java.sql.Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(java.sql.Timestamp datetime) {
		this.datetime = datetime;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public double getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(double total) {
		this.totalprice = total;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
		
}
