package com.surf.events.model;

import java.io.Serializable;
import java.sql.Timestamp;



public class EventVO implements Serializable{


	private static final long serialVersionUID = 1L;
	private Integer eventno;
	private Integer type;
	private String title;
	private Timestamp datetime;
	private String context;
	private String pic;
	private EventTypeVO eventTypeVO;
	public Integer getEventno() {
		return eventno;
	}
	public void setEventno(Integer eventno) {
		this.eventno = eventno;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public EventTypeVO getEventTypeVO() {
		return eventTypeVO;
	}
	public void setEventTypeVO(EventTypeVO eventTypeVO) {
		this.eventTypeVO = eventTypeVO;
	}
	

}
