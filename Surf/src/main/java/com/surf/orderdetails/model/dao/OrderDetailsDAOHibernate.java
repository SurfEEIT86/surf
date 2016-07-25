package com.surf.orderdetails.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.surf.orderdetails.model.OrderDetailsDAO;
import com.surf.orderdetails.model.OrderDetailsVO;
import com.surf.products.model.ProductsVO;

public class OrderDetailsDAOHibernate implements Serializable, OrderDetailsDAO{

	private static final long serialVersionUID = 1L;
	private SessionFactory sessionFactory = null;

	public OrderDetailsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public OrderDetailsDAOHibernate() {
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public OrderDetailsVO select(Integer orderno){
		return this.getSession().get(OrderDetailsVO.class, orderno);
	}
	
	@Override
	public List<OrderDetailsVO> selectAll(){
		Session session = this.getSession();
		Query query = session.createQuery("from OrderDetailsVO");
		List<OrderDetailsVO> orderdetails = query.list();
		return orderdetails;
	}
	
	@Override
	public OrderDetailsVO insert(OrderDetailsVO bean){		
		this.getSession().saveOrUpdate(bean);
		return bean;
	}

	@Override
	public OrderDetailsVO update (OrderDetailsVO bean){
		this.getSession().saveOrUpdate(bean);
		return bean;
	}

}
