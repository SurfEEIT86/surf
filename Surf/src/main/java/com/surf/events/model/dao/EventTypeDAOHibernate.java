package com.surf.events.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.events.model.EventTypeDAO;
import com.surf.events.model.EventTypeVO;

public class EventTypeDAOHibernate implements EventTypeDAO{

	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext("beans.config.xml");
		try {
			EventTypeDAO dao = (EventTypeDAO) context.getBean("eventTypeDAO");
			
			
			//新增資料
			EventTypeVO bean = new EventTypeVO();
			bean.setTypeno(9);
			bean.setTypename("其他");
			dao.insert(bean);
			
//			EventTypeVO select = dao.select(7);
//			select.setTypename("商家");
//			dao.update(select);
			
			
		} finally {
			((ConfigurableApplicationContext) context).close();
		}

	}
	
	private SessionFactory sessionFactory=null;
	public EventTypeDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	


	public Session getSession(){
		return sessionFactory.getCurrentSession();	
	}
	
	
	//查詢事件編號
	public EventTypeVO select(Integer typeno) {
		return (EventTypeVO) this.getSession().get(EventTypeVO.class, typeno);
	}
	//查詢全部事件
	public List<EventTypeVO> selectAll() {
		Query<EventTypeVO> query =
				this.getSession().createQuery("from EventTypeVO", EventTypeVO.class);
		return query.getResultList();
	}

	//新增事件
	public EventTypeVO insert(EventTypeVO bean) {
		EventTypeVO result = (EventTypeVO)
				this.getSession().get(EventTypeVO.class, bean.getTypeno());
		if(result==null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	//修改事件
	public EventTypeVO update(EventTypeVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	//刪除事件
	public boolean delete(Integer typeno) {
		EventTypeVO bean = (EventTypeVO) this.getSession().get(EventTypeVO.class, typeno);
		if(bean!=null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}


}
