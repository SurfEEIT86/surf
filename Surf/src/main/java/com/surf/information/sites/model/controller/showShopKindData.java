package com.surf.information.sites.model.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.information.model.InformationService;
import com.surf.information.shopkinds.model.ShopKindsVO;

/**
 * Servlet implementation class showShopKindData
 */
@WebServlet("/information/showShopKindData")
public class showShopKindData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InformationService informationService;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		informationService = (InformationService) context
				.getBean("informationService");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		/* 取得資料 */
		String shopkindNo = request.getParameter("ShopKindNo");
		/* 驗證資料 */
		if(shopkindNo.trim().length()==0||shopkindNo==null){
			System.out.println("Error Parameter");
			return;
		}
		int shopkindNo1;
		/* 型態轉換 */
		try{
			shopkindNo1=Integer.parseInt(shopkindNo);
					
		}catch(Exception e){
			System.out.println("Error Parameter");
			return;
		}
		ShopKindsVO shopkindVO = informationService.findByShopKind(shopkindNo1);
		request.setAttribute("shopkindNo1",shopkindVO);
		
		RequestDispatcher rd = request.getRequestDispatcher("FoodItem.jsp");
		rd.forward(request, response);
	}
	

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
this.doGet(request, response);
	}

}
