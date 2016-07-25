package com.surf.forums.model;

import java.util.List;

import com.surf.members.model.MemberVO;

public interface TrackDAO {

	/*搜尋一筆追蹤*/
	public abstract boolean findByMemberNoAndArticleNo(MemberVO memberVO,ArticleVO articleVO);

	/*搜尋全部追蹤*/
	public abstract List<TrackVO> selectAll();

	/*新增一筆追蹤*/
	public abstract TrackVO insert(TrackVO vo);

	/*修改追蹤*/
	public abstract TrackVO update(TrackVO vo);

	/*取消追蹤*/
	public abstract boolean cancelTrack(TrackVO vo);
	
	/*使用者追蹤的全部文章 依時間排序*/
	public List<TrackVO> getTrackByMember(Integer memberNo);
	
	/*查詢一筆追蹤*/
	public TrackVO findByMemberNo(MemberVO memberVO,ArticleVO articleVO);
	
	/*查詢一個使用者在某個版區所有追蹤的文章*/
	public List<TrackVO> getTrackByMemberAndForum(Integer memberNo,Integer forumNo);

}