package com.surf.events.model;

import java.util.List;

public interface EventTypeDAO {
	
	EventTypeVO select(Integer typeno);
	
	List<EventTypeVO> selectAll();
	
	EventTypeVO insert(EventTypeVO bean);
	
	EventTypeVO update(EventTypeVO vo);
	
	boolean delete(Integer eventno);
}
