package com.surf.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.members.model.MemberService;
import com.surf.members.model.MemberVO;
import com.surf.orders.model.OrdersVO;

/**
 * Servlet implementation class ShowMemberData
 */
@WebServlet("/members/ShowMemberData")
public class ShowMemberData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService memberService;
	@Override
	public void init() throws ServletException {
		
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		memberService = (MemberService) context.getBean("memberService");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		List<OrdersVO> orderList = memberService.findOrdersByMember(user);
		request.getSession().setAttribute("orderList", orderList);
		response.sendRedirect("Theme/MemberData.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
