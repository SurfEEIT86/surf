package com.surf.forums.model;


import java.sql.SQLException;
import java.util.List;





public interface ArticleDAO {
	ArticleVO findByArticleNo(Integer articleno);

	List<ArticleVO> selectAll();
	
	public List<ArticleVO> findByForumNo(Integer forumNo);
	
	public List<ArticleVO> findByMemberNo(Integer memberno);
	
	ArticleVO insert(ArticleVO bean);
	
	ArticleVO update(ArticleVO vo);

	boolean deleteByArticleNo(ArticleVO vo);
	
	public List<ArticleVO> artilceMng(String dateBng,String dateEnd,Integer memberno,Integer forumno);
	
	public List<ArticleVO> findArticleBySearchOrderByDiscuss(String qString,Integer forumNo);
	
	public int getSearchArticlesTotalPages(Integer searchType,String qString,Integer forumNo) throws SQLException;
	
	public int getPageNo();
	
	public void setPageNo(int pageNo);
	
	public Integer countSearchArticles(String qString,Integer forumNo);
	
	public List<ArticleVO> findArticleOrderHot(Integer forumNo);
	
	public int getArticlesTotalPages(Integer forumNo) throws SQLException;
	
	public List<ArticleVO> findArticleBySearchAuthor(String qString,Integer forumNo);
	
	public Integer countSearchArticlesByAuthor(String qString, Integer forumNo);
}
