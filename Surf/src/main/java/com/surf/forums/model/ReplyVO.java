package com.surf.forums.model;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.surf.members.model.MemberVO;


public class ReplyVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private ArticleVO articleVO;
	private MemberVO memberVO;
	private java.sql.Timestamp date;
	private String context;
	
	
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
	public java.sql.Timestamp getDate() {
		return date;
	}
	public void setDate(java.sql.Timestamp date) {
		this.date = date;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	
	public boolean equals(Object obj) {
        if(obj == this) {
            return true;
        }
 
        if(!(obj instanceof ReplyVO)) {
            return false;
        }
 
        ReplyVO user = (ReplyVO) obj;
        return new EqualsBuilder()
                    .append(this.articleVO, user.getArticleVO())
                    .append(this.memberVO, user.getMemberVO())
                    .append(this.date, user.getDate())
                    .isEquals();
    }
 
    public int hashCode() {
        return new HashCodeBuilder()
                    .append(this.articleVO)
                    .append(this.memberVO)
                    .append(this.date)
                    .toHashCode();
    }
	
}
