package com.surf.forums.controller;

import java.io.IOException;
import java.io.PrintWriter;

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

/**
 * Servlet implementation class UpdateArticle
 */
@WebServlet("/forums/UpdateArticle")
public class UpdateArticle extends HttpServlet {
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
		String updateNo = request.getParameter("UpdateNo");
		String deleteNo = request.getParameter("DeleteNo");
		if (updateNo == null && deleteNo == null) {
			return;
		}
		if (updateNo != null&&updateNo.trim().length()!=0) {
			int articleNo;
			System.out.println("updateNo  "+updateNo);
			try {
				articleNo = Integer.parseInt(updateNo);
				
				ArticleVO vo = forumService.selectArticle(articleNo);
				request.setAttribute("UpdateArticleTitle", vo.getTitle());
				request.setAttribute("UpdateArticleNo", vo.getArticleno());
				request.setAttribute("UpdateArticleContent", vo.getContext());
				request.setAttribute("ArticlesMng", "修改文章");
				request.getRequestDispatcher("CreateArticle.jsp").forward(request, response);
				return;
			} catch (Exception e) {
				System.out.println("型態轉換失敗");
				return;
			}
			
		}
		if(deleteNo!=null&&deleteNo.trim().length()!=0){
			int articleNo;
			System.out.println("deleteNo  "+deleteNo);
			
				articleNo = Integer.parseInt(deleteNo);
				
				ArticleVO vo = forumService.selectArticle(articleNo);
				
				boolean result = forumService.deleteArticleByNo(vo);
				PrintWriter out = response.getWriter();
				if(result){
					out.print("deleteOK");
					return;
				}else{
					return;
				}
			
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

	}

}
