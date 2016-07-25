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

import com.surf.information.cities.model.CitiesVO;
import com.surf.information.model.InformationService;
import com.surf.information.shops.model.ShopsVO;

/**
 * Servlet implementation class showShopData
 */
@WebServlet("/information/showShopData")
public class showShopData extends HttpServlet {
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
		String shopNO = request.getParameter("ShopNo");
		/* 驗證資料 */
		if(shopNO.trim().length()==0||shopNO==null){
			System.out.println("Error Parameter");
			return;
		}
		int shopNo;
		/* 型態轉換 */
	try{
		shopNo=Integer.parseInt(shopNO);
	}catch(Exception e){
		System.out.println("Error Parameter");
		return;
	}
	ShopsVO shopVO = informationService.findByShopNo(shopNo);
	CitiesVO cityVo = informationService.findCitiesByPK(shopVO.getCityNo());
	String cityname = cityVo.getCityName();
	
	request.setAttribute("shopVO",shopVO );
	request.setAttribute("cityName", cityname);
	
	 RequestDispatcher rd = request.getRequestDispatcher("SingleShop.jsp");
	 rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
this.doGet(request, response);
	}

}
