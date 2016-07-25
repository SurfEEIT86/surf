package com.surf.forums.controller;

import java.io.IOException;
import java.util.ArrayList;
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

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.ForumVO;
import com.surf.forums.model.ReplyVO;

/**
 * Servlet implementation class SearchArticles
 */
@WebServlet("/forums/SearchArticles")
public class SearchArticles extends HttpServlet {
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
		String searchType = request.getParameter("searchArea");
		int type = 0;
		try {
			type = Integer.parseInt(searchType);
		} catch (Exception e) {
			System.out.println("aaa轉換失敗");
			return;
		}
		/*依文章標題搜尋*/
		if (type == 2) {
			request.setAttribute("searchArea",searchType);
			int pageNo = 1;
			String queryString = request.getParameter("queryString");
			String qString = "%" + queryString + "%";
			String pageNoStr = request.getParameter("pageNo");
			ForumVO vo = (ForumVO) request.getSession().getAttribute("forum");
			Integer forumNo = vo.getForumno();
			if (pageNoStr == null) {
				pageNo = 1;
			} else {
				try {
					pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e) {
					pageNo = 1;
				}
			}
			List<ArticleVO> articles = forumService.searchArticles(pageNo,
					qString, forumNo);
			Iterator<ArticleVO> artno = articles.iterator();
			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			List<Integer> replyList = new ArrayList<Integer>();
			;
			while (artno.hasNext()) {
				ArticleVO articleno = artno.next();

				articleList.add(articleno);
				List<ReplyVO> replys = forumService
						.findReplysByArticleNo(articleno.getArticleno());
				replyList.add(replys.size());
			}
			request.setAttribute("queryString", queryString);
			request.setAttribute("pageNo", pageNo);
			/* 輸入查詢的字串與查詢的版區 回傳 int 筆數 */
			int totalPages = forumService.searchArticlesPages(type,qString, forumNo);
			int countArtilces = forumService.searchArticlesCount(type,qString,
					forumNo);
			if (countArtilces < 1) {
				request.setAttribute("totalPages", 1);
				request.setAttribute("showSearchMsg", "很抱歉，查無相關 " + queryString
						+ " 的文章");

			} else {
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("showSearchMsg", "與 " + queryString
						+ "相關文章共有 " + countArtilces + " 筆");
			}
			request.setAttribute("forumArticles", articleList);
			Iterator<ArticleVO> a = articleList.iterator();
			int ab = 1;
			while (a.hasNext()) {
				ArticleVO vo2 = a.next();
				System.out.println(ab++ + ":" + vo2.getTitle());
			}
			request.setAttribute("replyList", replyList);
			request.setAttribute("controller", "SearchArticles");
			RequestDispatcher rd = request.getRequestDispatcher("Forum.jsp");
			rd.forward(request, response);
			return;
		}
		
		if(type==1){
			request.setAttribute("searchArea",searchType);
			int pageNo = 1;
			String queryString = request.getParameter("queryString");
			String qString = "%" + queryString + "%";
			String pageNoStr = request.getParameter("pageNo");
			ForumVO vo = (ForumVO) request.getSession().getAttribute("forum");
			Integer forumNo = vo.getForumno();
			if (pageNoStr == null) {
				pageNo = 1;
			} else {
				try {
					pageNo = Integer.parseInt(pageNoStr.trim());
				} catch (NumberFormatException e) {
					pageNo = 1;
				}
			}
			List<ArticleVO> articles = forumService.searchArticlesByAuthor(pageNo,
					qString, forumNo);
			Iterator<ArticleVO> artno = articles.iterator();
			List<ArticleVO> articleList = new ArrayList<ArticleVO>();
			List<Integer> replyList = new ArrayList<Integer>();
			
			while (artno.hasNext()) {
				ArticleVO articleno = artno.next();

				articleList.add(articleno);
				List<ReplyVO> replys = forumService
						.findReplysByArticleNo(articleno.getArticleno());
				replyList.add(replys.size());
			}
			request.setAttribute("queryString", queryString);
			request.setAttribute("pageNo", pageNo);
			/* 輸入查詢的字串與查詢的版區 回傳 int 筆數 */
			int totalPages = forumService.searchArticlesPages(type,qString, forumNo);
			int countArtilces = forumService.searchArticlesCount(type,qString,
					forumNo);
			if (countArtilces < 1) {
				request.setAttribute("totalPages", 1);
				request.setAttribute("showSearchMsg", "很抱歉，查無相關 " + queryString
						+ " 的文章");

			} else {
				request.setAttribute("totalPages", totalPages);
				request.setAttribute("showSearchMsg", "與 " + queryString
						+ "相關文章共有 " + countArtilces + " 筆");
			}
			request.setAttribute("forumArticles", articleList);
			Iterator<ArticleVO> a = articleList.iterator();
			int ab = 1;
			while (a.hasNext()) {
				ArticleVO vo2 = a.next();
				System.out.println(ab++ + ":" + vo2.getTitle());
			}
			request.setAttribute("replyList", replyList);
			request.setAttribute("controller", "SearchArticles");
			RequestDispatcher rd = request.getRequestDispatcher("Forum.jsp");
			rd.forward(request, response);
			return;
		}
		/*依作者搜尋*/
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
