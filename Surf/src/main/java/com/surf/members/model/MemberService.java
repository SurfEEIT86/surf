package com.surf.members.model;

import java.util.List;

import com.surf.orderdetails.model.OrderDetailsDAO;
import com.surf.orderdetails.model.OrderDetailsVO;
import com.surf.orders.model.OrdersDAO;
import com.surf.orders.model.OrdersVO;

public class MemberService {
	/*-----------------------spring---------------------------------*/
	MemberDAO memberDAO=null;
	OrdersDAO ordersDAO=null;
	OrderDetailsDAO orderDetailsDAO=null;
	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}
	
	
	public void setOrderDetailsDAO(OrderDetailsDAO orderDetailsDAO) {
		this.orderDetailsDAO = orderDetailsDAO;
	}


	public void setOrdersDAO(OrdersDAO ordersDAO) {
		this.ordersDAO = ordersDAO;
	}


	/*會員登入*/
	public MemberVO memberLogin(String username,String password){
		MemberVO vo = memberDAO.select(username);
		if(vo!=null) {
			if(password!=null && password.length()!=0) {
				String pass = vo.getPassword();
				if(pass.equals(password)) {
					return vo;
				}
			}
		}
		return null;
	}
	
	/*會員註冊*/
	public MemberVO register(MemberVO vo){
		memberDAO.insert(vo);
		return null;
	}
	/*會員修改*/
	public MemberVO updateMember(MemberVO vo){
		memberDAO.update(vo);
		return null;
	}
	/*回傳會員的所有訂單*/
	public List<OrdersVO> findOrdersByMember(MemberVO vo){
		return ordersDAO.findOrdersByMemberNo(vo.getMemberno());
	}
	
	/*依訂單編號尋找訂單明細*/
	public List<OrderDetailsVO> findOrderDetialsByOrderNo(Integer no){
		return orderDetailsDAO.select(no);
	}
}
