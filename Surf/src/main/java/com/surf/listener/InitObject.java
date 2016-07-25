package com.surf.listener;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.forums.model.ForumService;
import com.surf.forums.model.ForumVO;

/**
 * Application Lifecycle Listener implementation class InitObject
 *
 */
@WebListener
public class InitObject implements ServletContextListener {
	public void contextInitialized(ServletContextEvent even)  { 
		ServletContext servletContext = even.getServletContext();
		WebApplicationContext context = 
				WebApplicationContextUtils.getWebApplicationContext(servletContext);
		ForumService forumService=(ForumService)context.getBean("forumService");
		ArrayList<ForumVO> forums = (ArrayList)forumService.getAllForums();
		Iterator<ForumVO> iforums = forums.iterator();
		while(iforums.hasNext()){
			ForumVO vo = iforums.next();
		}
		servletContext.setAttribute("forums",forums);
		
    }
	
    public void contextDestroyed(ServletContextEvent arg0)  { 
    }

    
}
