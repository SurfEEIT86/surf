package com.surf.information.shops.model.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.forums.model.ArticleVO;
import com.surf.information.shops.model.ShopsDAO;
import com.surf.information.shops.model.ShopsVO;

public class ShopsDAOHibernate implements ShopsDAO {
	private SessionFactory sessionFactory = null;

	public ShopsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ShopsDAOHibernate() {

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");

		try {
			ShopsDAO dao = (ShopsDAO) context.getBean("shopsDAO");

			/* 新增1個店家 */
			ShopsVO bean = new ShopsVO();
			bean.setShopno(1);
			bean.setName("7-11便利商店");
			bean.setAddress("花蓮");
			bean.setCityNo(1);
			bean.setTel("05-2234567");
			dao.insert(bean);



			/* 查詢一個店家 */
//			 ShopsVO select1 = dao.findByCityNo(1);
//			 System.out.println(select1.getName());
//			 System.out.println(select1.getKind());

			/* 修改一個店家名稱 */
			 ShopsVO select2 = dao.findByCityNo(1);
			 select2.setName("ccc");
			 dao.update(select2);

			/* 刪除1個店家 */

//			dao.deleteByShopsNO(1);
			

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/* 搜尋一個店家 */
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#findByCityNo(java.lang.Integer)
	 */
	public ShopsVO findByCityNo(Integer ShopsNo) {
		return (ShopsVO) this.getSession().get(ShopsVO.class, ShopsNo);
	}

	/* 搜尋全部店家 */
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#selectAll()
	 */
	public List<ShopsVO> selectAll() {
		Query<ShopsVO> query = this.getSession().createQuery("from ShopsVO",
				ShopsVO.class);
		return query.getResultList();
	}

	/* 新增一個店家 */
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#insert(com.surf.shops.model.ShopsVO)
	 */
	public ShopsVO insert(ShopsVO bean) {
		ShopsVO result = (ShopsVO) this.getSession().get(ShopsVO.class,
				bean.getShopno());
		if (result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	/* 更新一個店家 */
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#update(com.surf.shops.model.ShopsVO)
	 */
	public ShopsVO update(ShopsVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/* 刪除一個店家 */
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#deleteByShopsNO(java.lang.Integer)
	 */
	public boolean deleteByShopsNO(Integer ShopsNO) {
		ShopsVO bean = (ShopsVO) this.getSession().get(ShopsVO.class, ShopsNO);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	/*搜尋城市所有店家*/
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#selectByCityNo(java.lang.Integer)
	 */
	public List<ShopsVO> selectByCityNo(Integer cityNo){
		Query query = this.getSession().createQuery("from ShopsVO where cityNo=? order by shopno");
		query.setParameter(0,cityNo);
		return query.getResultList();
	}
	/*搜尋特定種類店家*/
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#selectByKindNo(java.lang.Integer)
	 */
	public List<ShopsVO> selectByKindNo(Integer kind){
		Query query = this.getSession().createQuery("from ShopsVO where kind=? order by shopno");
		query.setParameter(0,kind);
		return query.getResultList();
	}
	
	
	/*特定城市特定種類店家*/
	/* (non-Javadoc)
	 * @see com.surf.shops.model.dao.ShopsDAO#selectByCityNoAndKindNo(java.lang.Integer, java.lang.Integer)
	 */
	public List<ShopsVO> selectByCityNoAndKindNo(Integer cityNo,Integer kind){
		Query query = this.getSession().createQuery("from ShopsVO where cityNo=? and kind=?");
		query.setParameter(0,cityNo);
		query.setParameter(2,kind);
		return query.getResultList();
	}
	
	public List<ShopsVO> findShopByCityNoAndKindNo(Integer cityNo,Integer shopKind){
		String sql = "select * from shops where cityNo=? and kind=?";
		SQLQuery <ShopsVO> query= null;
		this.getSession().createSQLQuery(sql);
		query.setParameter(0, cityNo);
		query.setParameter(1, shopKind);
		query.addEntity("shopsVO", ShopsVO.class);
		return query.list();
	}
}
