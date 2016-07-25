package com.surf.members.model.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import com.surf.forums.model.ForumVO;
import com.surf.members.model.MemberDAO;
import com.surf.members.model.MemberVO;

public class MemberDAOHibernate implements MemberDAO {
	private SessionFactory sessionFactory = null;

	public MemberDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MemberDAOHibernate() {

	}

	/* 尋找一筆會員資料 */
	@Override
	public MemberVO select(Integer memberno) {
		return (MemberVO) this.getSession().get(MemberVO.class, memberno);

	}
	/*利用帳號搜尋會員*/
	@Override
	public MemberVO select(String username) {
		Query<MemberVO> query=this.getSession().createQuery(
				"from MemberVO where username =?");
		query.setParameter(0, username);
		Iterator<MemberVO> iter = query.getResultList().iterator();
		MemberVO vo = null;
		while(iter.hasNext()){
			vo=(MemberVO) iter.next();
		}
		return vo;
		
	}

	/* 搜尋全部會員資料 */
	@Override
	public List<MemberVO> select() {
		Query<MemberVO> query = this.getSession().createQuery(
				"from NumberVO order by memberno", MemberVO.class);
		return query.getResultList();

	}

	/* 新增一筆會員 */
	@Override
	public MemberVO insert(MemberVO bean) {
		MemberVO result = (MemberVO) this.getSession().get(MemberVO.class,
				bean.getMemberno());
		if (result == null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}

	/* 修改一筆會員資料 */
	@Override
	public ForumVO update(ForumVO vo) {
		this.getSession().saveOrUpdate(vo);
		return vo;
	}

	/* 刪除一筆會員資料 */
	@Override
	public boolean delete(Integer forumno) {
		ForumVO bean = (ForumVO) this.getSession().get(ForumVO.class, forumno);
		if (bean != null) {
			this.getSession().delete(bean);
			return true;
		}
		return false;
	}
}
