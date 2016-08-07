package com.surf.models.model.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.surf.brands.model.BrandsVO;
import com.surf.models.model.ModelsDAO;
import com.surf.models.model.ModelsVO;

public class ModelsDAOHibernate implements ModelsDAO {
	private SessionFactory sessionFactory;
	
	public ModelsDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory= sessionFactory;		
	}
	
	@Override
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public List<ModelsVO> selectByBrandno(Integer brandno){
		Query query = this.getSession().createQuery("from ModelsVO where brandno=? order by modelno desc");
		query.setParameter(0, brandno);
		return query.list();	
	}
	
	@Override
	public ModelsVO selectByModelno(Integer modelno){
		
		return this.getSession().get(ModelsVO.class, modelno);
	}
	
	@Override
	public ModelsVO insertOrUpdate(ModelsVO bean){
		this.getSession().saveOrUpdate(bean);
		return bean;
	}
	
	@Override
	public boolean delete(ModelsVO bean){
		Session session = this.getSession();
		ModelsVO vo = session.get(ModelsVO.class, bean.getModelno());
		if(vo!=null){
			session.delete(bean);
			return true;
		}
		return false;
	}
	
}
