package com.surf.information.sites.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class showStoreList
 */
@WebServlet("/information/showStoreList")
public class showStoreList extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String type=request.getParameter("type");
		String la=request.getParameter("la");
		String ln=request.getParameter("ln");
		String site=request.getParameter("site");
		double a=Double.parseDouble(la);
		double n=Double.parseDouble(ln);
		String typeName = null;
		if(type.equals("lodging")){
			typeName="住宿";
		}else if(type.equals("food")){
			typeName="美食";
		}
		request.setAttribute("site", site);
		request.setAttribute("la",a);
		request.setAttribute("ln",n);
		request.setAttribute("type",type);
		request.setAttribute("typeName",typeName);
		RequestDispatcher rd = request.getRequestDispatcher("shop-ls.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
