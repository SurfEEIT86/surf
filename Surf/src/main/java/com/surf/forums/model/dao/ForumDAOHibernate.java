package com.surf.forums.model.dao;


import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.surf.forums.model.ForumDAO;
import com.surf.forums.model.ForumVO;

public class ForumDAOHibernate implements ForumDAO{
	private SessionFactory sessionFactory = null;

	public ForumDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");		
		try {
//			ForumDAO dao = (ForumDAO) context.getBean("forumDAO");
			/*新增一個討論區*/
//			ForumVO bean=new ForumVO();
//			bean.setForumno(1);
//			bean.setStatus(false);
//			bean.setTitle("aaaa");
//			dao.insert(bean);
			
			/*查詢一筆討論區*/
//			ForumVO bean = dao.select(1);
//			System.out.println("----------------");
//			System.out.println(bean.getTitle());
			
			/*查詢多筆討論區*/
//			List<ForumVO> rs = dao.select();
//			ListIterator<ForumVO> vos = rs.listIterator();
//			while(vos.hasNext()){
//				ForumVO vo = vos.next();
//				System.out.println(vo.getForumno()+" "+vo.getTitle());
//			}
			
			/*修改一筆討論區(舊)*/
//			dao.update(1, "ccc", null, null);
			
			/*修改一筆討論區(新)*/
//			ForumVO vo = dao.select(1);
//			vo.setTitle("update");     //記得資料庫長度只設10(長度過常會有例外)
//			dao.update(vo);
			
			/*刪除一筆討論區*/
//			dao.delete(1);
			
			
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	/*搜尋一筆討論區*/
	@Override
	public ForumVO select(Integer forumno) {
		return(ForumVO)this.getSession()
				.get(ForumVO.class, forumno);
		
	}
	
	/*搜尋全部討論區(只有狀態開啟的)*/
	@Override
	public 	List<ForumVO> select() {
		Query<ForumVO> query =
				this.getSession().createQuery("from ForumVO where status='true' order by forumno ");
		return query.getResultList();
		
	}
	
	/*新增一筆討論區*/
	@Override
	public ForumVO insert(ForumVO bean) {
		try{
		this.getSession().save(bean);
		return bean;
		}catch (Exception e){
		return null;
		}
	}
	/*修改一筆討論區*/
	@Override
	public ForumVO update(ForumVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}
	
	/*刪除一筆討論區*/
	@Override
	public boolean delete(Integer forumno) {
		ForumVO bean = (ForumVO) this.getSession().get(ForumVO.class, forumno);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
