package com.surf.forums.model.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.forums.model.ArticleVO;
import com.surf.forums.model.TrackDAO;
import com.surf.forums.model.TrackVO;
import com.surf.members.model.MemberVO;



public class TrackDAOHibernate implements TrackDAO{
	
	private SessionFactory sessionFactory = null;

	public TrackDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public TrackDAOHibernate() {
		
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");		
		try {
//			TrackDAO dao = (TrackDAO) context.getBean("trackDAO");
			
			/*測試程式*/
			/*新增一筆追蹤*/
//			TrackVO bean = new TrackVO();
//			bean.setMemberno(2);
//			bean.setArticleno(1);
//			bean.setTitle("testTitle");
//			Date date = new Date();
//			bean.setDatetime(new Timestamp(date.getTime()));
//			dao.insert(bean);
			
			/*查詢一筆追蹤*/
//			TrackVO select1 = dao.findByMemberNo(1);
//			System.out.println(select1.getMemberno());
//			System.out.println(select1.getArticleno());
//			System.out.println(select1.getTitle());
//			System.out.println(select1.getDatetime());
			
			/*修改一筆追蹤*/
//			TrackVO select1 = dao.findByMemberNo(1);
//			select1.setTitle("Hahaha");
//			dao.update(select1);
			
			/*刪除2筆文章*/
//			dao.deleteByMemberNo(1);
//			dao.deleteByMemberNo(2);

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	
	
	@Override
	public TrackVO findByMemberNo(MemberVO memberVO,ArticleVO articleVO){
		TrackVO vo = new TrackVO();
		vo.setMemberVO(memberVO);
		vo.setArticleVO(articleVO);
		return (TrackVO)this.getSession().get(TrackVO.class, vo);
	 
	}
	/*查看是否有追蹤*/
	@Override
	public boolean findByMemberNoAndArticleNo(MemberVO memberVO,ArticleVO articleVO) {
		TrackVO vo = new TrackVO();
		vo.setMemberVO(memberVO);
		vo.setArticleVO(articleVO);
	 TrackVO trackVO = (TrackVO)this.getSession().get(TrackVO.class, vo);
	 if(trackVO!=null){
		 return true;
	 }else{
		 return false;
	 }
	 
	}

	/*搜尋全部追蹤*/
	@Override
	public List<TrackVO> selectAll() {
		Query<TrackVO> query =
				this.getSession().createQuery("from TrackVO", TrackVO.class);
		return query.getResultList();
	}
	


	/*新增一筆追蹤*/
	@Override
	public TrackVO insert(TrackVO vo) {
		TrackVO result = (TrackVO)
				this.getSession().get(TrackVO.class, vo);
		if(result==null) {
			this.getSession().save(vo);
			return vo;
		}
		return null;
	}

	/*修改追蹤*/
	/* (non-Javadoc)
	 * @see com.surf.forums.model.dao.TrackDAO#update(com.surf.forums.model.TrackVO)
	 */
	@Override
	public TrackVO update(TrackVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/*取消追蹤*/
	@Override
	public boolean cancelTrack(TrackVO vo) {
		TrackVO bean = (TrackVO) this.getSession().get(TrackVO.class, vo);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	/*查詢使用者全部的追蹤*/
	public List<TrackVO> getTrackByMember (Integer memberNo) {
		Query<TrackVO> query = this.getSession().createQuery(
				"from TrackVO where memberno =? order by datetime desc");
		query.setParameter(0, memberNo);
		return query.getResultList();
	}
	/*查詢使用者在某個版區的追蹤*/
	public List<TrackVO> getTrackByMemberAndForum(Integer memberNo,Integer forumNo){
		String sql = 
		"select t.memberno,t.articleno,t.datetime from tracks t LEFT JOIN "
		+ "articles a ON t.articleno=a.articleno where a.forumno=? and "
		+ "t.memberno=?";
		SQLQuery<TrackVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, forumNo);
		query.setParameter(1, memberNo);
		query.addEntity("trackVO", TrackVO.class);
		return query.list();
	}
	
	
}
