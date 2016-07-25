package com.surf.forums.model.dao;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.forums.model.ReplyVO;
import com.surf.forums.model.ReportDAO;
import com.surf.forums.model.ReportVO;

public class ReportDAOHibernate implements ReportDAO {
	private SessionFactory sessionFactory = null;

	public ReportDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ReportDAOHibernate() {

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		try {
			ReportDAO dao = (ReportDAO) context.getBean("reportDAO");
			/* 新增一筆檢舉 */
			// ReportVO vo = new ReportVO();
			// vo.setArticleno(1);
			// vo.setMemberno(1);
			// vo.setDatetime(new Date(System.currentTimeMillis()));
			// vo.setReason("aaaa");
			// dao.insert(vo);

			/* 查詢單筆檢舉 */
			// ReportVO vo = new ReportVO();
			// vo.setArticleno(1);
			// vo.setMemberno(1);
			// vo.setDatetime(new Date(System.currentTimeMillis()));
			// dao.select(vo);
			// System.out.println(vo.getReason());

			/* 查詢一篇文章所有的回覆檢舉 */
			// List<ReportVO> list = dao.findByArticleno(1);
			// Iterator<ReportVO> listre = list.iterator();
			// while(listre.hasNext()){
			// ReportVO vo = listre.next();
			// System.out.println(vo.getReason());
			// }
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/* 查詢一筆檢舉回覆 */
	public ReportVO select(ReportVO vo) {
		return (ReportVO) this.getSession().get(ReportVO.class, vo);
	}

	/* 查詢一篇文章的檢舉回覆 */
	public List<ReportVO> findByArticleno(Integer articleno) {
		Query<ReportVO> query = this.getSession().createQuery(
				"from ReportVO where articleno = ? order by datetime");
		query.setParameter(0, articleno);
		return query.getResultList();
	}

	/* 新增一筆資料 */
	public ReportVO insert(ReportVO vo) {
		ReportVO result = (ReportVO) this.getSession().get(ReportVO.class, vo);
		if (result == null) {
			this.getSession().save(vo);
		}
		return null;
	}

	/* 刪除一篇文章的所有檢舉 */
	@Override
	public boolean deleteReportsByArticle(Integer articleNo) {
		Query<ReportVO> query = this.getSession().createQuery(
				"from ReportVO where articleno = ? order by datetime");
		query.setParameter(0, articleNo);
		List<ReportVO> list = query.getResultList();
		try {
			this.getSession().delete(list);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
