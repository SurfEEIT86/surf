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

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumService;
import com.surf.forums.model.TrackVO;
import com.surf.members.model.MemberVO;

/**
 * Servlet implementation class TrackForum
 */
@WebServlet("/forums/TrackForum")
public class TrackForum extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ForumService forumService;
	public void init() throws ServletException {
		ServletContext application = this.getServletContext();
		WebApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(application);
		forumService = (ForumService) context.getBean("forumService");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String forumNo=request.getParameter("forumNo");
		MemberVO memberVO = (MemberVO)request.getSession().getAttribute("user");
		if(forumNo!=null&&forumNo.trim().length()!=0){
			try{
				int forumNO = Integer.parseInt(forumNo);
				List<Map<String, String>> l1 = new LinkedList<Map<String, String>>();
				List<ArticleVO> articlesList = forumService.findArticlesByUserTrackAndForum(memberVO,forumNO);
				Iterator<ArticleVO> iter = articlesList.iterator();
				while(iter.hasNext()){
					ArticleVO vo = iter.next();
					Map<String, String> m1 = new HashMap<String, String>();
					m1.put("Title", vo.getTitle());
					TrackVO trackVO = forumService.findTrackByPK(memberVO,vo);
					m1.put("Date", trackVO.getDatetime().toString());
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
				System.out.println(jsonString);
				return;
			}catch (Exception e){
				
				List<Map<String, String>> l1 = new LinkedList<Map<String, String>>();
				
				List<ArticleVO> articlesList = forumService.findArticlesByUserTrackAll(memberVO.getMemberno());
				Iterator<ArticleVO> iter = articlesList.iterator();
				while(iter.hasNext()){
					ArticleVO vo = iter.next();
					Map<String, String> m1 = new HashMap<String, String>();
					m1.put("Title", vo.getTitle());
					TrackVO trackVO = forumService.findTrackByPK(memberVO,vo);
					m1.put("Date", trackVO.getDatetime().toString());
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
				System.out.println(jsonString);
				return;
			}
		}else {
			return;
		}
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
