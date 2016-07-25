package com.surf.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.information.model.InformationService;
import com.surf.information.shops.model.ShopsVO;
import com.surf.information.sites.model.SitesDAO;
import com.surf.information.sites.model.SitesVO;

/**
 * Application Lifecycle Listener implementation class InitObject
 *
 */
@WebListener
public class InitObjectInformation implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public InitObjectInformation() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent event)  { 
         
    	ServletContext application = event.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		InformationService informationService = (InformationService) context.getBean("informationService");
	
		List<SitesVO> sitesList = informationService.selectSitesByAll();
		application.setAttribute("sitesList", sitesList);
    
		List<ShopsVO> shopsList = informationService.selectShopsByAll();
		application.setAttribute("shopList", shopsList);
    }
	
}
