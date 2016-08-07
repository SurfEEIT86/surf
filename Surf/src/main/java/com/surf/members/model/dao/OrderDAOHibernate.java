package com.surf.members.model.dao;



import java.util.List;




import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.members.model.OrderVO;

public class OrderDAOHibernate{
	private SessionFactory sessionFactory = null;

	public OrderDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public OrderDAOHibernate() {

	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"beans.config.xml");
		try {
//			OrderDAO dao = (OrderDAO) context.getBean("orderDAO");
			
			/* 測試程式 */
			/* 新增訂單 */
//			OrderVO bean = new OrderVO();
//			bean.setOrderno(1);
//			bean.setMemberno(1);
//			Date date = new Date();
//			bean.setDatetime(new Timestamp(date.getTime()));
//			bean.setStatus(true);
//			bean.setTotal(999);
//			dao.insert(bean);

			/*查詢一筆訂單*/
//			OrderVO select1 = dao.findByOrderNo(1);
//			System.out.println(select1.getOrderno());
//			System.out.println(select1.getMemberno());
//			System.out.println(select1.getDatetime());
//			System.out.println(select1.getStatus());
//			System.out.println(select1.getTotal());
			
			/*修改一筆訂單*/
//			OrderVO select1 = dao.findByOrderNo(1);
//			select1.setTotal(2000);
//			dao.update(select1);
			
			/*刪除訂單*/
//			dao.deleteByOrderNo(1);

			
		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}

	/*-------------------------我好愛分隔線--------------------------*/

	/* 搜尋交易紀錄 */
	public OrderVO findByOrderNo(Integer orderno) {
		return (OrderVO) this.getSession().get(OrderVO.class, orderno);
	}

	/* 搜尋全部紀錄 */
	public List<OrderVO> selectAll() {
		Query<OrderVO> query = this.getSession().createQuery("from OrderVO",
				OrderVO.class);
		return query.getResultList();
	}
	
	/*搜尋使用者的交易紀錄*/
	public List<OrderVO> findOrdersByMemberNo(Integer memberNo) {
		Query<OrderVO> query = this.getSession().createQuery("from OrderVO where memberno=?");
		query.setParameter(0, memberNo);
		return query.getResultList();
	}
	
	/* 新增交易 */
	public OrderVO insert(OrderVO bean) {
		OrderVO result = (OrderVO) this.getSession().get(OrderVO.class,
				bean.getOrderno());
		if (result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	/* 修改一筆交易 */
	public OrderVO update(OrderVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/* 刪除一筆交易 */
	public boolean deleteByOrderNo(Integer orderno) {
		OrderVO bean = (OrderVO) this.getSession()
				.get(OrderVO.class, orderno);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
	/*修改交易紀錄*/
	public OrderVO updateOrderByOrderNo(OrderVO orderVO) {
			this.getSession().update(orderVO);
			return orderVO;
	}

}
