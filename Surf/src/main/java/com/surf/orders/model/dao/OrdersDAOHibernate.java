package com.surf.orders.model.dao;



import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import com.surf.orders.model.OrdersDAO;
import com.surf.orders.model.OrdersVO;


public class OrdersDAOHibernate implements OrdersDAO{
	private SessionFactory sessionFactory = null;
	private OrdersVO order;
	public OrdersDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}	
	
	public void setOrder(OrdersVO order){
		this.order=order;
		
	}
	
	public OrdersDAOHibernate() {

	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}	

	@Override
	public OrdersVO select(Integer orderno) {
		return this.getSession().get(OrdersVO.class, orderno);
	}

	@Override
	public List<OrdersVO> selectAll() {
		Query<OrdersVO> query = this.getSession().createQuery("from OrdersVO order by orderno desc");
		return query.getResultList();
	}
	
	@Override
	public List<OrdersVO> findOrdersByMemberNo(Integer memberno) {
		Query<OrdersVO> query = this.getSession().createQuery("from OrdersVO where memberno=?");
		query.setParameter(0, memberno);
		return query.getResultList();
	}
	
	@Override
	public OrdersVO insert(OrdersVO bean) {
		this.getSession().saveOrUpdate(bean);
		return bean;
	}

	@Override
	public OrdersVO update(OrdersVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	@Override
	public boolean deleteByOrderNo(Integer orderno) {
		OrdersVO bean = this.getSession().get(OrdersVO.class, orderno);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
