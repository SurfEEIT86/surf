package com.surf.forums.model.dao;



import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.surf.forums.model.ReplyDAO;
import com.surf.forums.model.ReplyVO;

public class ReplyDAOHibernate implements ReplyDAO{
	private SessionFactory sessionFactory = null;

	public ReplyDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ReplyDAOHibernate() {
		
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");		
		try {
			ReplyDAO dao = (ReplyDAO) context.getBean("replyDAO");
			
			/*新增*/
//			ReplyVO vo = new ReplyVO();
//			vo.setArticleno(2);
//			vo.setMemberno(2);
//			vo.setDate(new Date(System.currentTimeMillis()));
//			dao.insert(vo);
			
			
			/*找到文章裡所有的回覆*/
//			List<ReplyVO> all = dao.select(2);
//			Iterator<ReplyVO> allre = all.iterator();
//			while(allre.hasNext()){
//				ReplyVO vo = allre.next();
//				System.out.println(vo.getArticleno()+" "+vo.getMemberno());
//			}

			/*找尋特定一筆回覆*/
//			ReplyVO vo = new ReplyVO();
//			vo.setArticleno(2);
//			vo.setMemberno(2);
//			vo.setDate(new Date(System.currentTimeMillis()));
//			ReplyVO select = dao.select(vo);
//			System.out.println(select.getArticleno()+" "+select.getMemberno());
			
			/*刪除一筆回覆*/
//			ReplyVO vo = new ReplyVO();
//			vo.setArticleno(2);
//			vo.setMemberno(2);		
//			vo.setDate(new Date(System.currentTimeMillis()));
//			dao.delete(vo);
			
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	/*找到文章裡所有的回覆*/
	@Override
	public  List<ReplyVO> select(Integer articleno) {
		Query<ReplyVO> query = this.getSession().
				createQuery("from ReplyVO where articleno = ? order by date");
		query.setParameter(0, articleno);
		return query.getResultList();
	}
	/*預設載入文章後輸出5筆留言*/
	@Override
	public  List<ReplyVO> selectPreFiveMsg(Integer articleno,Integer loadTime) {
		String sql=
				"select a.articleno,a.memberno,a.date,a.context from (SELECT "
				+ "ROW_NUMBER() over (order by date desc) as RowNum, * FROM "
				+ "replys where articleno=?) as a where RowNum >=? and RowNum"
				+ "<=?";
		int bng=loadTime*5-4;
		int end=loadTime*5;
		SQLQuery<ReplyVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, articleno);
		query.setParameter(1, bng);
		query.setParameter(2, end);
		query.addEntity("replyVO", ReplyVO.class);
		return query.list();
	}
	
	/*找尋一筆回覆*/
	@Override
	public ReplyVO select(ReplyVO vo) {
		ReplyVO bean = this.getSession().
				get(ReplyVO.class,vo);
		return bean;
	}
	
	/*新增一筆回覆*/
	@Override
	public ReplyVO insert(ReplyVO vo) {
		ReplyVO result = (ReplyVO)
				this.getSession().get(ReplyVO.class, vo);
		if(result==null) {
			this.getSession().save(vo);
		}
		return null;
	}
	
	/*修改一筆回覆*/
	@Override
	public ReplyVO update(ReplyVO vo) {
		this.getSession().update(vo);
		return vo;
	}
	/*刪除一筆回覆*/
	@Override
	public boolean delete(ReplyVO vo) {
		ReplyVO bean = (ReplyVO) this.getSession().get(ReplyVO.class, vo);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	
	
}
