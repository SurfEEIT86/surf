package com.surf.forums.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;

@WebServlet("/forums/MemberMng")
public class MemberMng extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ForumService forumService = null;

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String year = request.getParameter("year");
		String mon = request.getParameter("mon");
		String day = request.getParameter("day");
		String memberNo = request.getParameter("memberNo");
		String forumNo = request.getParameter("forumNo");
		String date = null;
		SimpleDateFormat SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String dateStart = null;
		if (year.equalsIgnoreCase("-1")) {
			Date now = new Date();
			Date pass = new Date(0);
			dateStart=SimpleDateFormat.format(pass);
			date = SimpleDateFormat.format(now);
			if(mon.equalsIgnoreCase("-1") && day.equalsIgnoreCase("-1")){
				dateStart=SimpleDateFormat.format(now);
				System.out.println("bbbbb"+dateStart);
			}
		} else if (mon.equalsIgnoreCase("-1")) {
			dateStart = year + "-" + "01" + "-" + "01";
			date = year + "-" + "12" + "-" + "31";
			System.out.println("bbbb   "+dateStart);
		} else if (day.equalsIgnoreCase("-1")) {
			int yyyy = Integer.parseInt(year);
			int MM = Integer.parseInt(mon);
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
					"yyyy-MM-dd");
			Date a = null;
			try {
				a = format.parse(yyyy + "-" + (MM + 2) +"-"+ "0");
			} catch (ParseException e) {
				System.out.println("轉換失敗");
			}
			dateStart=yyyy+"-"+(MM + 1)+"-"+"1";
			System.out.println("cccc   "+dateStart);
			date = format.format(a);
		} else {
			java.text.SimpleDateFormat format = new java.text.SimpleDateFormat(
					"yyyy-MM-dd");
			dateStart=year+"-"+(Integer.parseInt(mon)+1)+"-"+day;
			date=year+"-"+(Integer.parseInt(mon)+1)+"-"+day;
			System.out.println("dddd   "+dateStart);
		}
		
		String dateEnd=date+" 23:59:59.999";
		System.out.println("servlet"+dateEnd);
		
		List<ArticleVO> articles = forumService.findArticlesByUserSelected(dateStart,
				dateEnd, Integer.parseInt(memberNo),Integer.parseInt(forumNo));
		/* AJAX */
		Iterator<ArticleVO> atls = articles.iterator();
		List<Map<String, String>> l1 = new LinkedList<Map<String, String>>();
		
		while (atls.hasNext()) {
			ArticleVO vo = atls.next();
			Map<String, String> m1 = new HashMap<String, String>();
			m1.put("Title", vo.getTitle());
			m1.put("Date", vo.getDatetime().toString());
			m1.put("Forum", vo.getForumVO().getTitle());
			m1.put("ArticleNo", vo.getArticleno().toString());
			m1.put("ForumNo", vo.getForumVO().getForumno().toString());
			Integer msgCount = forumService.findReplysByArticleNo(vo.getArticleno()).size();
			m1.put("ReplysCount",msgCount.toString());
			m1.put("ForumTitle",vo.getForumVO().getTitle());
			l1.add(m1);
		}
		String jsonString = JSONValue.toJSONString(l1);
		PrintWriter out = response.getWriter();
		out.println(jsonString);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
