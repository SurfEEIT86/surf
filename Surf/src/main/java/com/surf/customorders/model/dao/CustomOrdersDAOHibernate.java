package com.surf.customorders.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.surf.customorders.model.CustomOrdersDAO;
import com.surf.customorders.model.CustomOrdersVO;

public class CustomOrdersDAOHibernate implements CustomOrdersDAO {
	
	private SessionFactory sessionFactory;
	public CustomOrdersDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public CustomOrdersVO insert(CustomOrdersVO bean){
		this.getSession().saveOrUpdate(bean);
		return bean;		
	}
	
	@Override
	public CustomOrdersVO select(Integer orderno){
		return this.getSession().get(CustomOrdersVO.class, orderno);	
	}
	
	@Override
	public List<CustomOrdersVO> selectAll(Integer memberno){
		Query query= this.getSession().createQuery("from CustomOrdersVO where memberno=? order by date desc");
		query.setParameter(0, memberno);
		return query.list();
	}
}
