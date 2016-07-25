package com.surf.forums.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.forums.model.ArticleDAO;
import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.ForumDAO;
import com.surf.forums.model.ForumService;

public class ArticleDAOHibernate implements ArticleDAO {
	private SessionFactory sessionFactory = null;

	public ArticleDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public ArticleDAOHibernate() {

	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		try {
			ForumService service = (ForumService) context
					.getBean("forumService");
			/* 新增2筆文章 */
			ArticleVO bean = new ArticleVO();
			bean.setArticleno(18);
			/* 取得現在時間(戳記) */
			// LocalDateTime dateTime = LocalDateTime.now();
			// Timestamp stamp = Timestamp.valueOf(dateTime);
			// bean.setDatetime(stamp);
			// bean.setTitle("testTitle");
			// bean.setMemberno(3);
			// bean.setForumno(1);
			// service.insetArticle(bean);

			// ArticleVO bean2 = new ArticleVO();
			// bean2.setArticleno(4);
			// bean2.setDatetime(new Date(System.currentTimeMillis()));
			// bean2.setTitle("testTitle");
			// bean2.setMemberno(4);
			// bean2.setForumno(1);
			// dao.insert(bean2);

			/* 查詢一筆文章 */
			// ArticleVO select1 = dao.findByArticleNo(3);
			// System.out.println(select1.getArticleno());
			// System.out.println(select1.getTitle());
			// System.out.println(select1.getDatetime());
			// System.out.println(select1.getForumno());
			// System.out.println(select1.getMemberno());

			/* 修改一筆文章文章 */
			// ArticleVO select1 = dao.findByArticleNo(3);
			// select1.setTitle("bbb");
			// dao.update(select1);

			/* 修改一筆文章文章 */
			// ArticleVO select1 = dao.findByArticleNo(3);
			// dao.update(select1.getArticleno(), "aaaa", select1.getMemberno(),
			// select1.getForumno(), select1.getDatetime(), null);

			/* 刪除2筆文章 */
			// dao.deleteByArticleNo(3);
			// dao.deleteByArticleNo(4);

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/* 搜尋一筆文章 */
	@Override
	public ArticleVO findByArticleNo(Integer articleno) {
		return (ArticleVO) this.getSession().get(ArticleVO.class, articleno);
	}

	/* 搜尋一個討論區的所有文章 */
	@Override
	public List<ArticleVO> findByForumNo(Integer forumNo) {
		Query<ArticleVO> query = this.getSession().createQuery(
				"from ArticleVO where forumno = ? order by datetime desc");
		query.setParameter(0, forumNo);
		return query.getResultList();
	}

	/* 搜尋全部文章 */
	@Override
	public List<ArticleVO> selectAll() {
		Query<ArticleVO> query = this.getSession().createQuery(
				"from ArticleVO", ArticleVO.class);
		return query.getResultList();
	}

	/* 搜尋特定會員發表的文章 */
	@Override
	public List<ArticleVO> findByMemberNo(Integer memberno) {
		Query<ArticleVO> query = this.getSession().createQuery(
				"from ArticleVO where memberno =?");
		query.setParameter(0, memberno);
		return query.getResultList();
	}

	/* 新增一篇文章 */
	@Override
	public ArticleVO insert(ArticleVO bean) {
		try {
			this.getSession().save(bean);
			return bean;
		} catch (Exception e) {
			return null;
		}

	}

	/* 修改一篇文章 */
	@Override
	public ArticleVO update(ArticleVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	@Override
	public boolean deleteByArticleNo(ArticleVO vo) {
		try {
			this.getSession().delete(vo);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	/* 查詢特地使用者在特定版區發布的文章 */
	@Override
	public List<ArticleVO> artilceMng(String dateBng, String dateEnd,
			Integer memberno, Integer forumno) {
		SQLQuery<ArticleVO> query = null;
		if (forumno != -1) {
			query = this
					.getSession()
					.createSQLQuery(
							"select * from articles where datetime >=? and datetime <=? and memberno=? and forumno=? order by datetime desc");
			query.setParameter(0, dateBng);
			query.setParameter(1, dateEnd);
			query.setParameter(2, memberno);
			query.setParameter(3, forumno);
		} else {
			query = this
					.getSession()
					.createSQLQuery(
							"select * from articles where datetime >=? and datetime <=? and memberno=? order by datetime desc");
			query.setParameter(0, dateBng);
			query.setParameter(1, dateEnd);
			query.setParameter(2, memberno);
		}

		// System.out.println(date+" "+memberno+" "+forumno);
		query.addEntity("articleVO", ArticleVO.class);
		return query.list();
	}

	private int totalPages = -1;
	private int recordsPerPage = 10;
	private int pageNo;

	public int getPageNo() {

		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	/* 模糊查詢取得的vo list */
	@Override
	public List<ArticleVO> findArticleBySearchOrderByDiscuss(String qString,
			Integer forumNo) {
		String sql = "select c.articleno,c.title,c.memberno,c.forumno,c.datetime,"
				+ "c.context from (select ROW_NUMBER() over (order by replyNum "
				+ "desc,datetime desc) as RowNum,a.articleno,a.title,a.memberno,"
				+ "a.forumno,a.datetime,a.context,b.replyNum from (SELECT * FROM "
				+ "articles where title like ? and forumno=?) as a left join "
				+ "(select articleno,ISNULL(count(*),0)as replyNum from replys "
				+ "group by articleno )as b on a.articleno=b.articleno) as c where "
				+ "RowNum>=? and RowNum<=?";
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		SQLQuery<ArticleVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, qString);
		query.setParameter(1, forumNo);
		query.setParameter(2, startRecordNo);
		query.setParameter(3, endRecordNo);
		query.addEntity("articleVO", ArticleVO.class);
		return query.list();
	}

	/* 計算查詢標題總筆數 */
	@Override
	public Integer countSearchArticles(String qString, Integer forumNo) {
		String sql = "select a.articleno,a.title,a.memberno,a.forumno,a.datetime,a.context,replyNum"
				+ " FROM ( SELECT ROW_NUMBER() over (order by datetime desc) as RowNum, * FROM"
				+ " articles where title like ? and forumno=?) as a join (select ar.ARTICLENO"
				+ ",ISNULL(count(*),0) as replyNum  FROM articles ar LEFT JOIN replys w ON ar.articleno"
				+ " = w.articleno group by ar.ARTICLENO) as b on a.articleno = b.articleno";
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		SQLQuery<ArticleVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, qString);
		query.setParameter(1, forumNo);
		query.addEntity("articleVO", ArticleVO.class);
		int count = query.list().size();
		return count;
	}

	/* 再討論各版區搜尋作者取得文章 */
	public List<ArticleVO> findArticleBySearchAuthor(String qString,
			Integer forumNo) {
		String sql = "select c.articleno,c.title,c.memberno,c.forumno,"
				+ "c.datetime,c.context from (select ROW_NUMBER() over "
				+ "(order by datetime desc) as RowNum,a.articleno,a.title,"
				+ "a.forumno,a.context,a.datetime,a.memberno from (select "
				+ "* from articles where forumno=?) as a join (select name,"
				+ "memberno from members where name like ?) as b on a."
				+ "memberno=b.memberno) as c where RowNum>=? and RowNum<=?";
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		SQLQuery<ArticleVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, forumNo);
		query.setParameter(1, qString);
		query.setParameter(2, startRecordNo);
		query.setParameter(3, endRecordNo);
		query.addEntity("articleVO", ArticleVO.class);
		return query.list();
	}

	/* 計算作者查詢總筆數 */
	@Override
	public Integer countSearchArticlesByAuthor(String qString, Integer forumNo) {
		String sql = "select c.articleno,c.title,c.memberno,c.forumno,"
				+ "c.datetime,c.context from (select ROW_NUMBER() over "
				+ "(order by datetime desc) as RowNum,a.articleno,a.title,"
				+ "a.forumno,a.context,a.datetime,a.memberno from (select "
				+ "* from articles where forumno=?) as a join (select name,"
				+ "memberno from members where name like ?) as b on a."
				+ "memberno=b.memberno) as c";
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		SQLQuery<ArticleVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, forumNo);
		query.setParameter(1, qString);
		query.addEntity("articleVO", ArticleVO.class);
		int count = query.list().size();
		return count;
	}

	/* 取得模糊查詢的頁數 */
	@Override
	public int getSearchArticlesTotalPages(Integer searchType, String qString,
			Integer forumNo) throws SQLException {
		if (searchType == 1) {
			totalPages = (int) (Math.ceil(countSearchArticlesByAuthor(qString,
					forumNo) / (double) recordsPerPage));

			return totalPages;
		} else if (searchType == 2) {
			totalPages = (int) (Math.ceil(countSearchArticles(qString, forumNo)
					/ (double) recordsPerPage));
			return totalPages;
		} else {
			return 1;
		}
	}

	/* 依熱門程度排名 */
	@Override
	public List<ArticleVO> findArticleOrderHot(Integer forumNo) {
		String sql = " select newTable.articleno,newTable.title,newTable.memberno,"
				+ "newTable.forumno,newTable.datetime,newTable.context from "
				+ "(select ROW_NUMBER() over (order by replyNum desc, datetime desc) as RowNum,"
				+ "d.articleno,d.title,d.memberno,d.forumno,d.datetime,d.context "
				+ "from articles as d  right join ( select  b.replyNum,a.articleno,"
				+ "a.forumno from (select * from articles as a where forumno=? ) "
				+ "as a left join (select articleno,ISNULL(count(*),0)as replyNum "
				+ "from replys group by articleno)as b on a.forumno=? and  "
				+ "a.articleno=b.articleno  ) as c on c.articleno=d.articleno ) "
				+ "as newTable where RowNum>=? and RowNum<=?";
		int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
		int endRecordNo = (pageNo) * recordsPerPage;
		SQLQuery<ArticleVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, forumNo);
		query.setParameter(1, forumNo);
		query.setParameter(2, startRecordNo);
		query.setParameter(3, endRecordNo);
		query.addEntity("articleVO", ArticleVO.class);
		return query.list();

	}

	/* 計算文章總頁數 */
	@Override
	public int getArticlesTotalPages(Integer forumNo) throws SQLException {
		int totalPages = (int) (Math.ceil(findByForumNo(forumNo).size()
				/ (double) recordsPerPage));

		return totalPages;
	}

}
