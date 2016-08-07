package com.surf.forums.model;

import java.util.List;

public interface ReplyDAO {

	List<ReplyVO> select(Integer articleno);
	/*新增一筆回覆*/
	List<ReplyVO> selectPreFiveMsg(Integer articleno,Integer loadTime); 
	ReplyVO select(ReplyVO vo);
	
	ReplyVO insert(ReplyVO vo);

	ReplyVO update(ReplyVO vo);

	/*刪除回覆*/
	boolean delete(ReplyVO vo);

}