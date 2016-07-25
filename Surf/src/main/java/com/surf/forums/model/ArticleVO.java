package com.surf.forums.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.surf.members.model.MemberVO;





public class ArticleVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer articleno;
	public Set<TrackVO> getTracks() {
		return tracks;
	}
	public void setTracks(Set<TrackVO> tracks) {
		this.tracks = tracks;
	}
	private String title;
	private java.sql.Timestamp datetime;
	private String context;
	private ForumVO forumVO;
	private MemberVO memberVO;
	private Set<ReplyVO> replys = new HashSet<ReplyVO>();
	private Set<TrackVO> tracks = new HashSet<TrackVO>();
	private Set<ReportVO> reports = new HashSet<ReportVO>();
	
	public Set<ReportVO> getReports() {
		return reports;
	}
	public void setReports(Set<ReportVO> reports) {
		this.reports = reports;
	}
	public Set<ReplyVO> getReplys() {
		return replys;
	}
	public void setReplys(Set<ReplyVO> replys) {
		this.replys = replys;
	}
	public Integer getArticleno() {
		return articleno;
	}
	public void setArticleno(Integer articleno) {
		this.articleno = articleno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public java.sql.Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(java.sql.Timestamp datetime) {
		this.datetime = datetime;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public ForumVO getForumVO() {
		return forumVO;
	}
	public void setForumVO(ForumVO forumVO) {
		this.forumVO = forumVO;
	}
	public MemberVO getMemberVO() {
		return memberVO;
	}
	public void setMemberVO(MemberVO memberVO) {
		this.memberVO = memberVO;
	}
	
}
