package com.surf.forums.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
import com.surf.forums.model.ReplyVO;

@WebServlet("/forums/article.do")
public class ArticlePage extends HttpServlet {
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
		request.setCharacterEncoding("UTF-8");
		String articleNo = request.getParameter("No");
		String loadTimes=request.getParameter("loadTimes");
		String ArticlesMng=request.getParameter("ArticlesMng");
		String TrackMng=request.getParameter("TrackMng");
		try {
			if (Integer.parseInt(ArticlesMng) == 1) {
				request.setAttribute("ArticlesMng", "文章管理");
			}
		} catch (Exception e) {

		}
		try {
			if (Integer.parseInt(TrackMng) == 1) {
				request.setAttribute("TrackMng", "追蹤管理");
			}
		} catch (Exception e) {

		}
		if(loadTimes!=null&&loadTimes.trim().length()!=0){
			int loadTime;
			int articleNO;
			try{
				loadTime =Integer.parseInt(loadTimes);
				articleNO=Integer.parseInt(articleNo);
				List<Map<String, String>> l1 = new LinkedList<Map<String, String>>();
				int replysSize=forumService.findReplysByArticleNo(articleNO).size();
				int loadTimeMax = 0;
				Integer replyStatus= 1;
				if(replysSize%5!=0){
					loadTimeMax=(replysSize/5)+1;
				}else if(replysSize%5==0){
					loadTimeMax=replysSize/5;
				}
				if(loadTime>loadTimeMax){
					return;
				}
				if(loadTime==loadTimeMax){
					replyStatus=-1;
				}
				List<ReplyVO> replyList = forumService.findReplysByArticleNoPreFive(articleNO, loadTime);
				Iterator<ReplyVO> iter = replyList.iterator();
				while(iter.hasNext()){
					Map<String, String> m1 = new HashMap<String, String>();
					ReplyVO vo = iter.next();
					m1.put("replyStatus", replyStatus.toString());
					m1.put("MemberNo", vo.getMemberVO().getMemberno().toString());
					m1.put("MemberName", vo.getMemberVO().getName().trim());
					m1.put("DateTime", vo.getDate().toString());
					m1.put("Content", vo.getContext());
					l1.add(m1);
				}
				String jsonString = JSONValue.toJSONString(l1);
				PrintWriter out = response.getWriter();
				System.out.println(jsonString);
				out.println(jsonString);
				return;
			}catch (Exception e){
				System.out.println("轉型失敗");
				return;
			}
		}
		
		
		
		
		
		Integer no = null;
		try {
			
			no = Integer.parseInt(articleNo);
			
		} catch (Exception e) {

		}
		int replaySumCount = forumService.findReplysByArticleNo(no).size();
		int replayCount=forumService.findReplysByArticleNo(no).size();
		List<ReplyVO> replayList = forumService.findReplysByArticleNoPreFive(no,1);
		ArticleVO article = forumService.selectArticle(no);
		
		request.setAttribute("article", article);
		request.setAttribute("replayCount", replayCount);
		request.setAttribute("replayList", replayList);
		request.setAttribute("replaySumCount", replaySumCount);
		RequestDispatcher rd = request.getRequestDispatcher("Article.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
