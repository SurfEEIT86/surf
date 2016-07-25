package com.surf.information.shopkinds.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.information.shopkinds.model.ShopKindsDAO;
import com.surf.information.shopkinds.model.ShopKindsVO;

public class ShopKindsDAOHibernate implements ShopKindsDAO{
	private SessionFactory sessionFactory = null;

	public ShopKindsDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public ShopKindsDAOHibernate() {

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		try {
			ShopKindsDAO dao = (ShopKindsDAO) context.getBean("shopkindsDAO");
			
			/* 新增1個商店種類 */
//			 ShopKindsVO bean = new ShopKindsVO();
//			 bean.setShopKind(7);
//			 bean.setKindName("漫畫");
//			 dao.insert(bean);


			/* 查詢一個商店種類 */
			 ShopKindsVO select1 = dao.findByShopKind(4);
			 System.out.println(select1.getShopKind());
			 System.out.println(select1.getKindName());

			/* 修改1個商店名稱 */
			 ShopKindsVO select2 = dao.findByShopKind(3);
			 select2.setKindName("sing");
			 dao.update(select2);

			/* 刪除1個商店名稱 */
			 dao.deleteByShopKinds(7);

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/* 搜尋一個商店種類 */

	public ShopKindsVO findByShopKind(Integer Shopkinds) {
		return (ShopKindsVO) this.getSession().get(ShopKindsVO.class, Shopkinds);
		
	}

	/* 搜尋全部商店種類 */

	public List<ShopKindsVO> selectAll() {
		Query<ShopKindsVO> query = this.getSession().createQuery(
				"from ShopkindsVO", ShopKindsVO.class);
		return query.getResultList();
	}

	/* 新增一個商店種類 */

	public ShopKindsVO insert(ShopKindsVO bean) {
	
			this.getSession().save(bean);
			return bean;

	}

	/* 更新一個商店種類 */

	public ShopKindsVO update(ShopKindsVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/* 刪除一個商店種類 */


	public boolean deleteByShopKinds(Integer shopKinds) {
		ShopKindsVO bean = (ShopKindsVO) this.getSession().get(
				ShopKindsVO.class, shopKinds);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
