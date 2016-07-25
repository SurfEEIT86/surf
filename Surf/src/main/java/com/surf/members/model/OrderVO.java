package com.surf.members.model;

import java.io.Serializable;

public class OrderVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer orderno;
	private MemberVO memberVO;
	private java.sql.Timestamp datetime;
	private Integer status;
	private double total;
	public Integer getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
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
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
		
}
