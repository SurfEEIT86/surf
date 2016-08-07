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
import com.surf.information.sites.model.SitesDAO;
import com.surf.information.sites.model.SitesVO;

/**
 * Servlet implementation class showSiteData
 */
@WebServlet("/information/showSiteData")
public class showSiteData extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		/* 取得資料 */
		String siteNO = request.getParameter("SiteNo");
		/* 驗證資料 */
		if (siteNO.trim().length() == 0 || siteNO == null) {
			System.out.println("Error Parameter");
			return;
		}
		int siteNo;
		/* 型態轉換 */
		try {
			siteNo = Integer.parseInt(siteNO);
		} catch (Exception e) {
			System.out.println("Error Parameter");
			return;
		}

		SitesVO siteVO = informationService.findSiteByPK(siteNo);
		CitiesVO cityVo = informationService.findCitiesByPK(siteVO.getCityNo());
		String cityname = cityVo.getCityName();

		request.setAttribute("siteVO", siteVO);
		request.setAttribute("cityName", cityname);

		RequestDispatcher rd = request.getRequestDispatcher("SingleSite.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
