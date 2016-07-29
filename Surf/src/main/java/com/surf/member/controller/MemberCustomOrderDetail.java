package com.surf.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.customorders.model.CustomOrdersDAO;
import com.surf.customorders.model.CustomOrdersVO;


@WebServlet("/members/Theme/MemberCustomOrderDetail.do")
public class MemberCustomOrderDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private CustomOrdersDAO cDao;   
   
    public MemberCustomOrderDetail() {
        super();        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("hello im here");
		request.setCharacterEncoding("UTF-8");
		Integer orderno = Integer.parseInt(request.getParameter("no"));
		CustomOrdersVO vo = cDao.select(orderno);
		request.setAttribute("customorderdetail", vo);
		RequestDispatcher rd =request.getRequestDispatcher("MemberCustomOrderDetail.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		doGet(request, response);
	}


	@Override
	public void init() throws ServletException {
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		cDao =(CustomOrdersDAO)context.getBean("customordersDAO");
	}

}
