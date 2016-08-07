package com.surf.information.sites.model.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.forums.model.ArticleVO;
import com.surf.information.sites.model.SitesDAO;
import com.surf.information.sites.model.SitesVO;

public class SitesDAOHibernate implements SitesDAO {
	private SessionFactory sessionFactory = null;

	public SitesDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public SitesDAOHibernate() {

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		try {
			SitesDAO dao = (SitesDAO) context.getBean("sitesDAO");

			/* 查詢一個浪點 */
			// SitesVO vo = dao.findBySites(2);
			// vo.getCityNo();
			// System.out.println(vo.getName());
			/* 查詢一個城市所有的浪點 */
			// List<SitesVO> list = dao.selectAll();
			// Iterator<SitesVO> listre = list.iterator();
			// while(listre.hasNext()){
			// SitesVO vo = listre.next();
			// System.out.println(vo.getName());
			// }
			/* 新增一個浪點 */
			// SitesVO vo = new SitesVO();
			// vo.setSiteno(2);
			// vo.setName("烏石港");
			// vo.setLatitude(123.0);
			// vo.setLongitude(456.0);
			// vo.setCityNo(2);
			// vo.setStatus(true);
			// vo.setDescription("浪大，人多，風景美");
			// dao.insert(vo);
			/* 更新一個浪點 */
			// SitesVO vo = dao.findBySites(1);
			// vo.setName("花蓮港");
			// dao.update(vo);

			/* 刪除一個浪點 */
			dao.deleteBySitesVO(1);

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/* 搜尋一個浪點 */

	public SitesVO findBySites(Integer Sites) {
		return (SitesVO) this.getSession().get(SitesVO.class, Sites);

	}

	/* 搜尋全部浪點 */

	public List<SitesVO> selectAll() {
		Query<SitesVO> query = this.getSession().createQuery("from SitesVO",
				SitesVO.class);
		return query.getResultList();
	}

	/* 新增一個浪點 */

	public SitesVO insert(SitesVO bean) {

		this.getSession().save(bean);

		return bean;

	}

	/* 更新一個浪點 */

	public SitesVO update(SitesVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/* 刪除一個浪點 */

	public boolean deleteBySitesVO(Integer Sites) {
		SitesVO bean = (SitesVO) this.getSession().get(SitesVO.class, Sites);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}

	/* 模糊查詢浪點 */
	@Override
	public List<SitesVO> findSitesByName(String siteName) {
		String name = "%" + siteName + "%";
		String sql = "select * from sites where name like ?";
		SQLQuery<SitesVO> query = null;
		query = this.getSession().createSQLQuery(sql);
		query.setParameter(0, name);
		query.addEntity("sitesVO", SitesVO.class);
		List<SitesVO> list1 = query.list();

		String sql2 = "select b.siteno,b.name,b.longitude,b.latitude,b.cityNo,b.status,"
				+ "b.pic1,b.pic2,b.pic3,b.description,b.seaArea from (select * from cities where "
				+ "CityName like ?) as a join (select * from sites) as b on a.CityNo"
				+ "=b.CityNo";

		SQLQuery<SitesVO> query2 = null;
		query2 = this.getSession().createSQLQuery(sql2);
		query2.setParameter(0, name);
		query2.addEntity("sitesVO", SitesVO.class);
		List<SitesVO> list2 = query2.list();
		Iterator<SitesVO> iter1 = list1.iterator();

		List<SitesVO> list3 = new ArrayList<SitesVO>();

		while (iter1.hasNext()) {
			SitesVO vo1 = iter1.next();
			Iterator<SitesVO> iter2 = list2.iterator();
			list3.add(vo1);
			while (iter2.hasNext()) {
				SitesVO vo2 = iter2.next();
				Iterator<SitesVO> iter3 = list1.iterator();
				int temp=0;
				while(iter3.hasNext()){
					SitesVO vo3 = iter3.next();
					if(vo3.getSiteno()==vo2.getSiteno()){
						temp++;
					}
				}
				if(temp==0){
					list3.add(vo2);
				}
			}
		}
		if(list1.size()!=0){
			return list3;
		}
		if(list1.size()==0){
			Iterator<SitesVO> iter2 = list2.iterator();
			while (iter2.hasNext()) {
				SitesVO vo2 = iter2.next();
					list3.add(vo2);
			}
			return list3;
		}		
		return null;
		
	}
	/*隨機六筆*/
	@Override
	public List<SitesVO> selectSiteByRand(){
		String sql="SELECT TOP(6) * FROM sites ORDER BY NEWID()";
		SQLQuery<SitesVO> query = this.getSession().createSQLQuery(sql);
		query.addEntity("sitesVO", SitesVO.class);
		List<SitesVO> list1 = query.list();
		return list1;
	}
}
