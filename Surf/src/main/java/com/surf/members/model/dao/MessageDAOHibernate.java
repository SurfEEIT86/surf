package com.surf.members.model.dao;



import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.members.model.MemberVO;
import com.surf.members.model.MessageVO;


public class MessageDAOHibernate {
	
	private SessionFactory sessionFactory = null;

	public MessageDAOHibernate(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public MessageDAOHibernate() {
		
	}
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public static void main(String[] args){
		ApplicationContext context =
				new ClassPathXmlApplicationContext("beans.config.xml");		
		try {
//			MessageDAO dao = (MessageDAO) context.getBean("messageDAO");
			
			/* 測試的內容 */

			/*新增一筆訊息*/
//			MessageVO bean = new MessageVO();
//			bean.setMessageno(111);
//			bean.setSender(1);
//			bean.setReceiver(4);
//			Date date = new Date();
//			bean.setDatetime(new Timestamp(date.getTime()));
//			bean.setContext("aaa");
//			bean.setStatus(true);
//			dao.insert(bean);
			
			/*查詢一筆訊息*/
//			MessageVO select1 = dao.findByMessageNo(111);
//			System.out.println(select1.getMessageno());
//			System.out.println(select1.getSender());
//			System.out.println(select1.getReceiver());
//			System.out.println(select1.getDatetime());
//			System.out.println(select1.getContext());
//			System.out.println(select1.getStatus());
			
			/*修改一筆訊息*/
//			MessageVO select1 = dao.findByMessageNo(111);
//			select1.setSender(16);
//			dao.update(select1);
			
			/*刪除2筆文章*/
//			dao.deleteByMessageNo(111);
//			dao.deleteByArticleNo(4);

		} finally {
			((ConfigurableApplicationContext) context).close();
		}
	}
	
	/*-------------------------我好愛分隔線--------------------------*/

	/*搜尋一筆訊息*/
	public MessageVO findByMessageNo(MemberVO sender,MemberVO receiver,Timestamp datetime) {
		MessageVO messagePK = new MessageVO();
		messagePK.setSender(sender);
		messagePK.setReceiver(receiver);
		messagePK.setDatetime(datetime);
		return (MessageVO)
				this.getSession().get(MessageVO.class, messagePK);
	}

	/*搜詢使用者與其他使用者的對話紀錄*/
	public List<MessageVO> findMsgByPerson() {
		return null;
	}
	
	/*新增一筆訊息*/
	public MessageVO insert(MessageVO bean) {
		MessageVO result = (MessageVO)
				this.getSession().get(MessageVO.class, bean);
		if(result==null) {
			this.getSession().save(bean);
			return bean;
		}
		return null;
	}






}
