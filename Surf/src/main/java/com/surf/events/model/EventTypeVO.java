package com.surf.events.model;

import java.io.Serializable;
import java.util.*;

public class EventTypeVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer typeno;
	private String typename;
	
	private Set<EventVO> events=new HashSet<EventVO>();
	public Set<EventVO> getEvents() {
		return events;
	}
	public void setEvents(Set<EventVO> events) {
		this.events = events;
	}
	public Integer getTypeno() {
		return typeno;
	}
	public void setTypeno(Integer typeno) {
		this.typeno = typeno;
	}
	public String getTypename() {
		return typename;
	}
	public void setTypename(String typename) {
		this.typename = typename;
	}
}
