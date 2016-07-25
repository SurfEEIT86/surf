package com.surf.brands.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.surf.brands.model.BrandsDAO;
import com.surf.brands.model.BrandsVO;

public class BrandsDAOHibernate implements BrandsDAO {
	private SessionFactory sessionFactory;
	public BrandsDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory=sessionFactory;
	}
	
	@Override
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public BrandsVO select(Integer brandno){		
		return this.getSession().get(BrandsVO.class, brandno);
	}
	
	@Override
	public List<BrandsVO> selectAll(){
		Session session = this.getSession();
		Query query = session.createQuery("from BrandsVO order by brandno desc");
		List<BrandsVO> brands = query.list();
		return brands;
	}
	
	@Override
	public BrandsVO insert(BrandsVO bean){
		Session session = this.getSession();
		BrandsVO vo = session.get(BrandsVO.class, bean.getBrandno());
		if(vo==null){
			session.save(bean);
			return bean;
		}
		return null;
	}
	
	@Override
	public BrandsVO update(BrandsVO bean){
		this.getSession().saveOrUpdate(bean);
		return bean;
	}
	
	@Override
	public boolean delete(BrandsVO bean){
		Session session = this.getSession();
		BrandsVO vo = session.get(BrandsVO.class, bean.getBrandno());
		if(vo!=null){
			session.delete(bean);
			return true;
		}
		return false;
		
	}
}
