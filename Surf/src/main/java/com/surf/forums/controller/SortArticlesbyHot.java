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
import com.surf.forums.model.ForumVO;
import com.surf.forums.model.ReplyVO;


@WebServlet("/forums/SortArticlesbyHot")
public class SortArticlesbyHot extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;
	ForumService forumService = null;

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pageNoStr = request.getParameter("pageNo");
		String forumNo = request.getParameter("forumNo");
		if(forumNo==null){
			ForumVO vo = (ForumVO)request.getSession().getAttribute("forum");
			forumNo=vo.getForumno().toString();
		}
		HttpSession session = request.getSession();
		try {
			ForumVO forum = forumService.selectForum(Integer.parseInt(forumNo));
			session.removeAttribute("forum");
			session.setAttribute("forum",forum);
		} catch (Exception e) {
			System.out.println("forumNo型態轉換失敗");
		}
		if (pageNoStr == null) {
			pageNo = 1;

		} else {
			try {
				pageNo = Integer.parseInt(pageNoStr.trim());
			} catch (NumberFormatException e) {
				pageNo = 1;
			}
		}
		int forumNoInt = Integer.parseInt(forumNo);
		List<ArticleVO> articleList = forumService.selectArticlesOrderByHot(pageNo,forumNoInt);
		List<Integer> replyList = new ArrayList<Integer>();
		Iterator<ArticleVO> itervo = articleList.iterator();
		while(itervo.hasNext()){
			ArticleVO vo = itervo.next();
			List<ReplyVO> replys = 
					forumService.findReplysByArticleNo(vo.getArticleno());
			replyList.add(replys.size());
		}
		request.setAttribute("pageNo", pageNo);
		request.setAttribute("totalPages",forumService.countArticlesByForum(forumNoInt));
		request.setAttribute("forumArticles", articleList);
		request.setAttribute("replyList", replyList);
		request.setAttribute("controller", "SortArticlesbyHot");
		RequestDispatcher rd = request.getRequestDispatcher("ForumHot.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
