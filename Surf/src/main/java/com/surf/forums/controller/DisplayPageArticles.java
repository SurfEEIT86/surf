package com.surf.forums.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.naming.NamingException;
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

import com.surf.forums.model.ArticleAccessBean;
import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.ForumVO;
import com.surf.forums.model.ReplyVO;

/**
 * Servlet implementation class DisplayPageArticles
 */
@WebServlet("/forums/DisplayPageArticles")
public class DisplayPageArticles extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int pageNo = 1;
	ForumService forumService = null;

	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
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

		/* 先將之前的forum物件移除在放入新的forum物件方便之後文章新刪修 */
		ArticleAccessBean aab = null;
		try {
			if (pageNoStr == null) {
				pageNo = 1;

			} else {
				try {
					pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e) {
					pageNo = 1;
				}
			}
			aab = new ArticleAccessBean();
			aab.setPageNo(pageNo);
			List<Integer> coll;
			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			List<Integer> replyList = new ArrayList<Integer>();
			try {
				coll = aab.getPageArticle(Integer.parseInt(forumNo));
				Iterator<Integer> artno = coll.iterator();
				while (artno.hasNext()) {
					int articleno = artno.next();
					ArticleVO article = forumService.selectArticle(articleno);
					articleList.add(article);
					List<ReplyVO> replys = forumService
							.findReplysByArticleNo(articleno);
					replyList.add(replys.size());
				}

				request.setAttribute("pageNo", pageNo);
				request.setAttribute("totalPages", aab
						.getForumArticlesTotalPages(Integer.parseInt(forumNo)));
				request.setAttribute("forumArticles", articleList);
				request.setAttribute("replyList", replyList);
				request.setAttribute("controller", "DisplayPageArticles");
			} catch (Exception e) {

				e.printStackTrace();
			}
			RequestDispatcher rd = request.getRequestDispatcher("Forum.jsp");
			rd.forward(request, response);
			return;

		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
