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
			System.out.println(bean.getUsername());
			System.out.println(bean.getPassword());
			System.out.println(bean.getName());
			System.out.println(bean.getGender());
			System.out.println(bean.getEmail());
			System.out.println(bean.getBirthday());
			System.out.println(bean.getAddress());
			System.out.println(bean.getTel());
			System.out.println(bean.getStatus());
			System.out.println(bean.getPic1());
			

			this.getSession().save(bean);
			return bean;
	}

	/* 修改一筆會員資料 */
	@Override
	public MemberVO update(MemberVO vo) {
		this.getSession().update(vo);
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
