package com.surf.forums.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.ReplyVO;

/**
 * Servlet implementation class ForumPage
 */
@WebServlet("/forums/ForumPage")
public class ForumPage extends HttpServlet {
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
		String forumNo = request.getParameter("forumNo");
		if (forumNo == null || forumNo.trim().length() == 0) {
			response.sendRedirect("forums.jsp");
			return;
		}
		
		HttpSession session = request.getSession();
		/*先將之前的forum物件移除在放入新的forum物件方便之後文章新刪修*/
		session.removeAttribute("forum");
		try {
			session.setAttribute("forum", forumService.selectForum(Integer.parseInt(forumNo)));
		} catch (Exception e) {
			System.out.println("未成功轉換型別");
		}
		List<ArticleVO> forumArticles = forumService
				.findArticlesByForumNo(Integer.parseInt(forumNo));
		Iterator<ArticleVO> it = forumArticles.iterator();
		List<Integer> replyList = new ArrayList<Integer>();

		while (it.hasNext()) {

			List<ReplyVO> replys = forumService.findReplysByArticleNo(it.next()
					.getArticleno());
			replyList.add(replys.size());

		}
		request.setAttribute("replyList", replyList);
		request.setAttribute("forumArticles", forumArticles);
		RequestDispatcher rd = request.getRequestDispatcher("Forum.jsp");
		rd.forward(request, response);
		return;

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
