package com.surf.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.customorders.model.CustomOrdersDAO;
import com.surf.customorders.model.CustomOrdersVO;
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
	private CustomOrdersDAO cDao;
	@Override
	public void init() throws ServletException {
		
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(getServletContext());
		memberService = (MemberService) context.getBean("memberService");
		cDao = (CustomOrdersDAO) context.getBean("customordersDAO");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberVO user = (MemberVO)request.getSession().getAttribute("user");
		List<OrdersVO> orderList = memberService.findOrdersByMember(user);
		Integer memberno = user.getMemberno();
		List<CustomOrdersVO> customorders = cDao.selectAll(memberno);
		HttpSession session = request.getSession();
		session.setAttribute("orderList", orderList);
		session.setAttribute("customorders", customorders);
		response.sendRedirect("Theme/MemberData.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
