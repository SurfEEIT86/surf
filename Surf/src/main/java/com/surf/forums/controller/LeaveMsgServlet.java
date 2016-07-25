package com.surf.forums.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONValue;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.ReplyVO;
import com.surf.members.model.MemberVO;

@WebServlet("/forums/LeaveMsgServlet")
public class LeaveMsgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ForumService forumService;

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String content = request.getParameter("content");
		String article = request.getParameter("article");

		HttpSession session = request.getSession();
		MemberVO user = (MemberVO) session.getAttribute("user");
		int articleno;
		try {
			articleno = Integer.parseInt(article);
		} catch (Exception e) {
			System.out.println("新增失敗");
			return;
		}
		try {
			ArticleVO articleVO = forumService.selectArticle(articleno);
			System.out.println("articlenoarticleno"+articleno);
			LocalDateTime dateTime = LocalDateTime.now();
			Timestamp stamp = Timestamp.valueOf(dateTime);
			ReplyVO vo = new ReplyVO();
			vo.setArticleVO(articleVO);
			vo.setContext(content);
			vo.setMemberVO(user);
			vo.setDate(stamp);
			forumService.insertReply(vo);
			List<Map<String, String>> l1 = new LinkedList<Map<String, String>>();
			Map<String, String> m1 = new HashMap<String, String>();
			m1.put("MemberName", vo.getMemberVO().getName().trim());
			m1.put("DateTime", vo.getDate().toString());
			m1.put("Content", vo.getContext());
			l1.add(m1);
			String jsonString = JSONValue.toJSONString(l1);
			System.out.println(jsonString);
			out.println(jsonString);
		} catch (Exception e) {
			System.out.println("errrrroorr");
		}

		/* AJAX */

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);

	}
}
