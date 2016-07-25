package com.surf.forums.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;

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
import com.surf.members.model.MemberVO;

@WebServlet("/forums/createArticle.do")
public class CreateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ForumService forumService;
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}
    public CreateArticle() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String article = request.getParameter("articleContent");
		String title = request.getParameter("title");
		String updateArticleNo = request.getParameter("UpdateArticleNo");
		if(updateArticleNo!=null&&updateArticleNo.trim().length()!=0){
			int no=Integer.parseInt(updateArticleNo);
			ArticleVO vo = forumService.selectArticle(no);
			vo.setTitle(title);
			vo.setContext(article);
			forumService.updateArticle(vo);
			response.sendRedirect("article.do?No="+vo.getArticleno());
			return;
		}
		
		
		HttpSession session = request.getSession();
		Object obj = request.getAttribute("UpdateArticleVO");
		if(obj!=null){
			System.out.println("obj hererere");
		}else{
			System.out.println("obj nonononno");
		}
		/*在ForumPage setAttribute的 "forum"*/
		/*在com.surf.member.controller LoginServlet setAttribute 的"user"*/
		ForumVO forumVO=(ForumVO)session.getAttribute("forum");
		MemberVO memberVO=(MemberVO)session.getAttribute("user");
		
		ArticleVO articleVO = new ArticleVO();
		
		articleVO.setContext(article);
		articleVO.setTitle(title);
		LocalDateTime dateTime = LocalDateTime.now();
		Timestamp stamp = Timestamp.valueOf(dateTime);
		articleVO.setDatetime(stamp);
		articleVO.setForumVO(forumVO);
		articleVO.setMemberVO(memberVO);
		
		forumService.insetArticle(articleVO);
		response.sendRedirect("article.do?No="+articleVO.getArticleno());
		return;
	}

}
