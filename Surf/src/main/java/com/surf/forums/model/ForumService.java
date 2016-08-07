package com.surf.forums.model;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;

import com.surf.members.model.MemberDAO;
import com.surf.members.model.MemberVO;

public class ForumService {
	private static final int List = 0;
	private static final int TrackVO = 0;
	/*-----------------------spring---------------------------------*/
	ArticleDAO articleDAO = null;
	ForumDAO forumDAO = null;
	ReplyDAO replyDAO = null;
	ReportDAO reportDAO = null;
	MemberDAO memberDAO = null;
	TrackDAO trackDAO = null;

	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public void setReplyDAO(ReplyDAO replyDAO) {
		this.replyDAO = replyDAO;
	}

	public void setTrackDAO(TrackDAO trackDAO) {
		this.trackDAO = trackDAO;
	}

	public void setReportDAO(ReportDAO reportDAO) {
		this.reportDAO = reportDAO;
	}

	public void setForumDAO(ForumDAO forumDAO) {
		this.forumDAO = forumDAO;
	}

	public void setMemberDAO(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	/*----------------------------以上spring設定----------------------------------*/

	/* 回傳所有的討論區 */
	public List<ForumVO> getAllForums() {
		return forumDAO.select();
	}

	/* 新增一筆討論區 */
	public ForumVO insetForum(ForumVO vo) {
		return forumDAO.insert(vo);
	}

	/* 取得一個討論區 */
	public ForumVO selectForum(Integer no) {
		return forumDAO.select(no);
	}

	/* 計算搜尋文章的頁數 */
	public int searchArticlesPages(Integer searchType, String qString,
			Integer forumNo) {
		try {
			return articleDAO.getSearchArticlesTotalPages(searchType, qString,
					forumNo);
		} catch (SQLException e) {
			return 1;
		}
	}

	/* 計算搜尋文章的總筆數 */
	public int searchArticlesCount(Integer searchType, String qString,
			Integer forumNo) {
		if (searchType == 1) {
			try {
				return articleDAO.countSearchArticlesByAuthor(qString, forumNo);
			} catch (Exception e) {
				return 0;
			}
		}else if(searchType==2){
			try {
				return articleDAO.countSearchArticles(qString, forumNo);
			} catch (Exception e) {
				return 0;
			}
		}else{
			return 0;
		}
		
	}

	/* 取得每頁搜尋的文章 */
	public List<ArticleVO> searchArticles(Integer pageNo, String qString,
			Integer forumNo) {
		articleDAO.setPageNo(pageNo);
		return articleDAO.findArticleBySearchOrderByDiscuss(qString, forumNo);
	}

	/*---------------------------------------沒用*/
	public List<ArticleVO> searchArticlesByAuthor(Integer pageNo,
			String qString, Integer forumNo) {
		articleDAO.setPageNo(pageNo);
		return articleDAO.findArticleBySearchAuthor(qString, forumNo);

	}

	/* 依版區計算文章總筆數 */
	public int countArticlesByForum(Integer forumNo) {
		try {
			return articleDAO.getArticlesTotalPages(forumNo);
		} catch (Exception e) {
			return 0;
		}
	}

	/* 取得每頁熱門的文章 */
	public List<ArticleVO> selectArticlesOrderByHot(Integer pageNo,
			Integer forumNo) {
		articleDAO.setPageNo(pageNo);
		return articleDAO.findArticleOrderHot(forumNo);
	}

	/* 取得一篇文章 */
	public ArticleVO selectArticle(Integer articleno) {
		return articleDAO.findByArticleNo(articleno);
	}

	/* 新增一筆文章 */
	public ArticleVO insetArticle(ArticleVO articleVO) {
		return articleDAO.insert(articleVO);
	}

	/* 取得一個討論區的所有文章 */
	public List<ArticleVO> findArticlesByForumNo(Integer forumNo) {
		return articleDAO.findByForumNo(forumNo);
	}

	/* 依使用者需求尋找文章 */
	public List<ArticleVO> findArticlesByUserSelected(String dateBgn,
			String dateEnd, Integer memberno, Integer forumno) {
		return articleDAO.artilceMng(dateBgn, dateEnd, memberno, forumno);
	}

	/* 使用者特定版區追蹤的文章 */
	public List<ArticleVO> findArticlesByUserTrackAtForum(Integer memberNo,
			Integer forumNo) {

		return null;
	}

	/* 使用者追蹤的全部文章 */
	public List<ArticleVO> findArticlesByUserTrackAll(Integer memberNo) {
		List<TrackVO> tracks = trackDAO.getTrackByMember(memberNo);
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		Iterator<TrackVO> iter = tracks.iterator();
		while (iter.hasNext()) {
			TrackVO trackVO = iter.next();
			ArticleVO articleVO = trackVO.getArticleVO();
			articles.add(articleVO);
		}
		return articles;
	}

	/* 查詢使用者在某個版區追蹤的文章 */
	public List<ArticleVO> findArticlesByUserTrackAndForum(MemberVO memberVO,
			Integer forumNo) {
		List<TrackVO> tracks = trackDAO.getTrackByMemberAndForum(
				memberVO.getMemberno(), forumNo);
		List<ArticleVO> articles = new ArrayList<ArticleVO>();
		Iterator<TrackVO> iter = tracks.iterator();
		while (iter.hasNext()) {
			TrackVO trackVO = iter.next();
			ArticleVO articleVO = trackVO.getArticleVO();
			articles.add(articleVO);
		}
		return articles;
	}

	/* 修改一篇文章 */
	public ArticleVO updateArticle(ArticleVO vo) {
		return articleDAO.update(vo);
	}

	/* 刪除一篇文章 */
	public boolean deleteArticleByNo(ArticleVO vo) {
		return articleDAO.deleteByArticleNo(vo);
	}

	/* 回傳一篇文章所有的回覆 */
	public List<ReplyVO> findReplysByArticleNo(Integer articleNo) {
		return replyDAO.select(articleNo);
	}

	/* 回傳一篇文章五筆回應依時間 */
	public List<ReplyVO> findReplysByArticleNoPreFive(Integer articleNo,
			Integer loadTime) {
		return replyDAO.selectPreFiveMsg(articleNo, loadTime);
	}

	/* 新增一筆回覆 */
	public ReplyVO insertReply(ReplyVO vo) {
		return replyDAO.insert(vo);
	}

	/* 搜尋一筆回復 */
	public ReplyVO selectReply(ReplyVO vo) {
		return replyDAO.select(vo);
	}

	/* 搜尋一個會員 */
	public MemberVO selectMember(Integer memberno) {
		return memberDAO.select(memberno);
	}

	/* 使用者是否有追蹤文章 */
	public boolean trackjudgement(MemberVO memberVO, ArticleVO articleVO) {
		return trackDAO.findByMemberNoAndArticleNo(memberVO, articleVO);

	}

	/* 新增或取消追蹤 */
	public void trackOrTrackCancel(TrackVO vo, boolean ans) {
		if (ans) {
			trackDAO.cancelTrack(vo);
		} else {
			trackDAO.insert(vo);
		}
	}

	/* 查詢一筆追蹤 */
	public TrackVO findTrackByPK(MemberVO memberVO, ArticleVO articleVO) {
		return trackDAO.findByMemberNo(memberVO, articleVO);
	}

	/* 判斷是否有檢舉 */
	public boolean reportJudgement(Integer memberNo, Integer articleNo) {

		try {
			ReportVO vo = new ReportVO();
			vo.setArticleno(articleNo);
			vo.setMemberno(memberNo);
			ReportVO getVo = reportDAO.select(vo);
			if (getVo != null) {
				return true;
			} else if (getVo == null) {
				return false;
			}

		} catch (Exception e) {
			/* 查詢失敗 */
			return false;
		}
		return false;
	}

	/* 新增一筆檢舉 */
	public boolean insertReport(Integer articleNo, Integer memberNo,
			String content) {
		try {
			ReportVO vo = new ReportVO();
			vo.setArticleno(articleNo);
			vo.setMemberno(memberNo);
			ReportVO getVo = reportDAO.select(vo);
			if (getVo != null) {
				return true;
			}
			vo.setReason(content);
			LocalDateTime dateTime = LocalDateTime.now();
			Timestamp stamp = Timestamp.valueOf(dateTime);
			vo.setDatetime(stamp);
			reportDAO.insert(vo);
			return true;
		} catch (Exception e) {
			/* 新增失敗 */
			return false;
		}
	}
	/*刪除該文章的所有檢舉*/
	public boolean deleteReportsByArticle(Integer articleNo) {
		try {
			reportDAO.deleteReportsByArticle(articleNo);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/* 上傳題片判斷檔名 */
	public static String getFileName(final Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	// 此方法可檢視上傳資料的每個欄位與每個檔案，
	public static void exploreParts(Collection<Part> parts,
			HttpServletRequest req) {
		try {
			for (Part part : parts) {
				String name = part.getName();
				String contentType = part.getContentType();
				String value = "";
				long size = part.getSize(); // 上傳資料的大小，即上傳資料的位元組數
				if (contentType != null) { // 表示該part為檔案
					// 取出上傳檔案的檔名
					String filename = ForumService.getFileName(part);
					// 將上傳的檔案寫入到location屬性所指定的資料夾
					if (filename != null && filename.trim().length() > 0) {
						part.write(filename);
						System.out.println(part.getClass().getName());
					}
				} else { // 表示該part為一般的欄位
					// 將上傳的欄位資料寫入到location屬性所指定的資料夾，檔名為"part_"+ name
					part.write("part_" + name);
					value = req.getParameter(name);
				}
				System.out.printf("%-15s %-15s %8d  %-20s \n", name,
						contentType, size, value);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
