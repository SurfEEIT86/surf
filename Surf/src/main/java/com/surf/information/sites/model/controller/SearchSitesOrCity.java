package com.surf.information.sites.model.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
import com.surf.information.sites.model.SitesVO;

/**
 * Servlet implementation class SearchSitesOrCity
 */
@WebServlet("/information/SearchSitesOrCity")
public class SearchSitesOrCity extends HttpServlet {
	private static final long serialVersionUID = 1L;
	InformationService informationService;

	public void init() throws ServletException {
		ServletContext application = getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		informationService = (InformationService) context
				.getBean("informationService");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String key=request.getParameter("sitesearch");
		List<SitesVO> list = informationService.findSitesByName(key);
		
		if(list.size()>1||list.size()==0){
			List<String> cityNameList=new ArrayList<String>();
			Iterator<SitesVO> iter = list.iterator();
			while(iter.hasNext()){
				SitesVO siteVO = iter.next();
				CitiesVO cityVO = informationService.findCityNameByPK(siteVO.getCityNo());
				cityNameList.add(cityVO.getCityName());
			}
			request.setAttribute("cityNameList",cityNameList);
			request.setAttribute("Length", list.size());
			request.setAttribute("SiteVO", list);
			request.setAttribute("SearchKey", key);
			request.getRequestDispatcher("ShowSitesList.jsp").forward(request, response);
			return;
		}else if(list.size()==1){
			CitiesVO cityVo = informationService.findCityNameByPK(list.get(0).getCityNo());
			request.setAttribute("CityName", cityVo.getCityName());
			request.setAttribute("Length", list.size());
			request.setAttribute("SiteVO", list);
			request.getRequestDispatcher("ShowInformation.jsp").forward(request, response);
			return;
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
