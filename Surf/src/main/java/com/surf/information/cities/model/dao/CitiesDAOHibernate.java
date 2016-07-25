package com.surf.information.cities.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.information.cities.model.CitiesDAO;
import com.surf.information.cities.model.CitiesVO;

public class CitiesDAOHibernate implements CitiesDAO {
	private SessionFactory sessionFactory = null;

	public CitiesDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public CitiesDAOHibernate() {

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");

		try {
			CitiesDAO dao = (CitiesDAO) context.getBean("citiesDAO");
			/* 新增1個城市 */
			CitiesVO bean = new CitiesVO();
			bean.setCityNo(21);
			bean.setCityName("連江縣");
			dao.insert(bean);

			// CitiesVO bean2 = new CitiesVO();
			// bean.setCityNo(4);
			// bean.setCityName(1);
			// dao.insert(bean2);

			/* 查詢一個城市 */
			// Cities select1 = dao.findByCityNo(3);
			// System.out.println(select1.getCityNo());
			// System.out.println(select1.getCityName());

			/* 修改1個城市名稱 */
			// CitiesVO select1 = dao.findByCityNo(26);
			// select1.setCityName("東京市");
			// dao.update(select1);

			/* 刪除1個城市 */
			dao.deleteByCityNO(26);

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/* 搜尋一個城市 */
	public CitiesVO findByCityNo(Integer CityNo) {
		return (CitiesVO) this.getSession().get(CitiesVO.class, CityNo);
	}

	/* 搜尋全部城市 */
	public List<CitiesVO> selectAll() {
		Query<CitiesVO> query = this.getSession().createQuery("from CitiesVO",
				CitiesVO.class);
		return query.getResultList();
	}

	/* 新增一個城市 */
	public CitiesVO insert(CitiesVO bean) {
		CitiesVO result = (CitiesVO) this.getSession().get(CitiesVO.class,
				bean.getCityNo());
		if (result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	/* 更新一個城市 */
	public CitiesVO update(CitiesVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/* 刪除一個城市 */

	public boolean deleteByCityNO(Integer CityNO) {
		CitiesVO bean = (CitiesVO) this.getSession()
				.get(CitiesVO.class, CityNO);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

}
