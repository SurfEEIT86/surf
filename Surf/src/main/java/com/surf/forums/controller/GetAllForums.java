package com.surf.forums.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONValue;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.forums.model.ForumService;
import com.surf.forums.model.ForumVO;

/**
 * Servlet implementation class GetAllForums
 */
@WebServlet("/forums/GetAllForums")
public class GetAllForums extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ForumService forumService = null;

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		List<ForumVO> allForums = forumService.getAllForums();
		Iterator<ForumVO> allFor = allForums.iterator();
		
		List<Map<String, String>> l1 = new LinkedList<Map<String, String>>();
		while(allFor.hasNext()){
			ForumVO vo = allFor.next();
			System.out.println(vo.getTitle());
			Map<String, String> m1 = new HashMap<String, String>();
			m1.put("Title", vo.getTitle());
			m1.put("ForumNo", vo.getForumno().toString());
			l1.add(m1);
		}
		String jsonString = JSONValue.toJSONString(l1);
		System.out.println(jsonString);
		PrintWriter out = response.getWriter();
		out.println(jsonString);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
