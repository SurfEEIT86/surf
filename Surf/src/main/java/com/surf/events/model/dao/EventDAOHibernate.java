package com.surf.events.model.dao;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.surf.events.model.EventDAO;
import com.surf.events.model.EventTypeDAO;
import com.surf.events.model.EventVO;

public class EventDAOHibernate implements EventDAO{
	
	
//	public static void main(String[] args) {
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext("beans.config.xml");		
//		try {
//			EventDAO dao = (EventDAO) context.getBean("eventDAO");
//			EventTypeDAO dao2 = (EventTypeDAO) context.getBean("eventTypeDAO");
//			/*新增事件*/
//			EventVO bean = new EventVO();
//			
//			bean.setEventno(6);
//			bean.setEventTypeVO(dao2.select(4));
//			
//			Date date = new Date();
//			bean.setDatetime(new Timestamp(date.getTime()));
//			bean.setTitle("4辣妹到海灘衝浪　「穿這樣」誰受得了？");
//			bean.setContext("不少人喜歡到海灘衝浪，除了享受刺激外，現場更有不少比基尼辣妹可以欣賞；有些辣妹擁有高超的衝浪技術，許多人也都欣賞和稱羨不已。最近在國外有一起特殊的衝浪活動，現場有4名面容和身材都姣好的正妹一起參加，但她們的泳裝卻有個秘密，不是穿在身上而是「畫」出來的，讓人直呼「凍未條」。根據《每日星報》（Daily Star）報導，這4名「泳裝」辣妹的傑作，均是人體藝術家保羅（Paul Roustan）的作品。他找來4名身材火辣的正妹，在她們的身上用防水顏料，畫出了假的衝浪衣和泳裝，之後「全裸」到海灘衝浪。這4名辣妹的「泳裝」極為逼真，不仔細看還真的看不出來她們是「全裸」上陣。事後她們衝浪的影片在Youtube分享之後，不少網友大呼「真是太神奇了」、「太酷了」，還有網友直說「之後我要常常去衝浪了！」");
//			dao.insert(bean);
			
			
			/*查詢事件*/
//			EventVO select = dao.select(1);
//			System.out.println(select.getEventno());
//			System.out.println(select.getTypeno());
//			System.out.println(select.getTitle());
//			System.out.println(select.getDatetime());
//			System.out.println(select.getContext());
//			
			/*修改事件*/
//			EventVO select = dao.select(1);
//			select.setTitle("EVENT TEST");
//			dao.update(select);
			
			/*修改事件*/
//			EventVO select = dao.select(1);
//			dao.update(select.getEventno(), select.getTypeno(),
//					select.getTitle(), select.getDatetime());
			
			
			
			/*刪除事件*/
//			dao.delete(1);


//		} finally {
//			((ConfigurableApplicationContext) context).close();
//		}
//	}

	
	
	
	private SessionFactory sessionFactory = null;
	public EventDAOHibernate(SessionFactory sessionFactory){
		this.sessionFactory = sessionFactory;
	}
	public EventDAOHibernate(){
		
	}

	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	
	
	//查詢事件編號
		public EventVO select(Integer eventno) {
			return (EventVO) this.getSession().get(EventVO.class, eventno);
		}
		//查詢全部事件
		public List<EventVO> selectAll() {
			Query<EventVO> query =
					this.getSession().createQuery("from EventVO", EventVO.class);
			return query.getResultList();
		}

		//新增事件
		public EventVO insert(EventVO bean) {
			EventVO result = (EventVO)
					this.getSession().get(EventVO.class, bean.getEventno());
			if(result==null) {
				this.getSession().save(bean);
				return bean;
			}
			return null;
		}

		
//		public EventVO update(int eventno,int typeno,String title,java.util.Date datetime,String context,byte[] pic) {
//			EventVO result = (EventVO)
//					this.getSession().get(EventVO.class, eventno);
//			if(result!=null) {
//				result.setEventno(eventno);
//				result.setTypeno(typeno);
//				result.setTitle(title);
//				result.setDatetime(datetime);
//				result.setContext(context);
//				result.setPic(pic);
//				
//			}
//			return result;
//		}

		//刪除事件
		public boolean delete(Integer eventno) {
			EventVO bean = (EventVO) this.getSession().get(EventVO.class, eventno);
			if(bean!=null) {
				this.getSession().delete(bean);
				return true;
			}
			return false;
		}
		
		//修改事件
		public EventVO update(EventVO vo) {
			this.getSession().saveOrUpdate(vo);
			return vo;
		}
	
	
}
