package com.surf.forums.model;

import java.io.Serializable;
import java.sql.Timestamp;

import com.surf.forums.model.ArticleVO;
import com.surf.members.model.MemberVO;



public class TrackVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArticleVO articleVO;
	private MemberVO memberVO;
	private Timestamp datetime;
	public ArticleVO getArticleVO() {
		return articleVO;
	}
	public void setArticleVO(ArticleVO articleVO) {
		this.articleVO = articleVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}

	

}
