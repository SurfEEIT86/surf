package com.surf.forums.model;

import java.sql.Clob;
import java.sql.Date;
import java.util.List;

public interface ForumDAO {
	ForumVO select(Integer forumno);

	List<ForumVO> select();
	
	ForumVO insert(ForumVO bean);
	
//	ForumVO update(Integer forumno,String title,
//			Boolean status,byte[] pic1);
	
	ForumVO update(ForumVO vo);
	
	boolean delete(Integer  forumno);
}
