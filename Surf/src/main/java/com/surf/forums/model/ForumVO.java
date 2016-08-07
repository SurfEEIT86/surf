package com.surf.forums.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ForumVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer forumno;
	private String title;
	private Boolean status;
	private String pic1;
	private Set<ArticleVO> articles = new HashSet<ArticleVO>();
	public Integer getForumno() {
		return forumno;
	}
	public void setForumno(Integer forumno) {
		this.forumno = forumno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getPic1() {
		return pic1;
	}
	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}
	public Set<ArticleVO> getArticles() {
		return articles;
	}
	public void setArticles(Set<ArticleVO> articles) {
		this.articles = articles;
	}
	
}
