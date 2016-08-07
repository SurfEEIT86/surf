package com.surf.members.model;

import java.util.List;

import com.surf.forums.model.ForumVO;

public interface MemberDAO {

	/*尋找一筆會員資料*/
	public abstract MemberVO select(Integer memberno);
	
	public abstract MemberVO select(String username);

	/*搜尋全部會員資料*/
	public abstract List<MemberVO> select();

	/*新增一筆會員*/
	public abstract MemberVO insert(MemberVO bean);

	/*修改一筆會員資料*/

	public abstract MemberVO update(MemberVO vo);


	/*刪除一筆會員資料*/
	public abstract boolean delete(Integer forumno);

}
