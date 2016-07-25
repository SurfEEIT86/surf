package com.surf.producttype.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.surf.producttype.model.ProducttypesDAO;
import com.surf.producttype.model.ProducttypesVO;

public class ProducttypesDAOHibernate implements ProducttypesDAO {
	
	private SessionFactory sessionFactory;
	public ProducttypesDAOHibernate (SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<ProducttypesVO> selectAll(){
		Session session = this.getSession();
		Query query = session.createQuery("from ProducttypesVO order by typeno asc");
		return query.list();
	}
	
	@Override
	public ProducttypesVO select(Integer typeno){
		return this.getSession().get(ProducttypesVO.class, typeno);
	}
	
	@Override
	public ProducttypesVO insert(ProducttypesVO bean){
		Session session = this.getSession();
		ProducttypesVO vo = session.get(ProducttypesVO.class, bean.getTypeno());
		if(vo==null){
			session.save(bean);
			return bean;
		}
		return null;
	}
	
	@Override
	public ProducttypesVO update(ProducttypesVO bean){
		this.getSession().saveOrUpdate(bean);
		return bean; 
	}
	
	@Override
	public boolean delete(ProducttypesVO bean){
		Session session = this.getSession();
		ProducttypesVO vo = session.get(ProducttypesVO.class, bean.getTypeno());
		if(vo!=null){
			session.delete(bean);
			return true;
		}
		return false;
	}
	
	
}
