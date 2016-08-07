package com.surf.events.model;

import java.util.List;

public interface EventDAO {

	EventVO select(Integer eventno);
	
	List<EventVO> selectAll();
	
	EventVO insert(EventVO bean);
	
	EventVO update(EventVO vo);
	//EventVO update(int eventno,int typeno,String title,java.util.Date datetime,String context,byte[] pic);
	
	boolean delete(Integer eventno);
	
}
