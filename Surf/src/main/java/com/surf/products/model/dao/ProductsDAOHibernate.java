package com.surf.products.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.products.model.ProductsDAO;
import com.surf.products.model.ProductsVO;

public class ProductsDAOHibernate implements ProductsDAO{
	private SessionFactory sessionFactory = null;

	public ProductsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public ProductsDAOHibernate() {
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public ProductsVO select(Integer productno){
		return this.getSession().get(ProductsVO.class, productno);
	}
	
	@Override
	public List<ProductsVO> selectAll(){
		Session session = this.getSession();
		Query query = session.createQuery("from ProductsVO order by productno desc");
		List<ProductsVO> prods = query.list();
		return prods;
	}
	
	@Override
	public ProductsVO insert(ProductsVO bean){		
		Session session = this.getSession();
		ProductsVO result = session.get(ProductsVO.class, bean.getProductno());
		if(result==null){
			session.save(bean);
			return bean;
		}
		return null;
	}

	@Override
	public ProductsVO update (ProductsVO bean){
		this.getSession().saveOrUpdate(bean);
		return bean;
	}

	@Override
	public boolean delete(ProductsVO bean){
		Session session = this.getSession();
		ProductsVO vo = session.get(ProductsVO.class, bean.getProductno());
		if(vo!=null){
			session.delete(vo);
			return true;
		}	
		return false;
	}
}
