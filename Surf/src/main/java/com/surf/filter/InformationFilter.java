package com.surf.filter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.information.cities.model.CitiesVO;
import com.surf.information.model.InformationService;
import com.surf.information.sites.model.SitesVO;

/**
 * Servlet Filter implementation class InformationFilter
 */
@WebFilter(
		urlPatterns={"/information/index-surf.jsp"}
)
public class InformationFilter implements Filter {

    public InformationFilter() {
       
    }

	public void destroy() {
		// TODO Auto-generated method stub
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		ServletContext application = req.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		InformationService informationService = (InformationService) context.getBean("informationService");
	
		List<SitesVO> sitesList = informationService.selectSiteByRand();
		List<String> cityNameList=new ArrayList<String>();
		Iterator<SitesVO> iter = sitesList.iterator();
		while(iter.hasNext()){
			SitesVO siteVO = iter.next();
			CitiesVO cityVO = informationService.findCityNameByPK(siteVO.getCityNo());
			cityNameList.add(cityVO.getCityName());
		}
		request.setAttribute("cityNameList",cityNameList);
		request.setAttribute("sitesList", sitesList);
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
