package com.surf.members.model;

import java.io.Serializable;

public class MessageVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private MemberVO sender;
	private MemberVO receiver;
	private java.sql.Timestamp datetime;
	private String context;
	private String pic;
	private Boolean status;

	public java.sql.Timestamp getDatetime() {
		return datetime;
	}
	public MemberVO getSender() {
		return sender;
	}
	public void setSender(MemberVO sender) {
		this.sender = sender;
	}
	public MemberVO getReceiver() {
		return receiver;
	}
	public void setReceiver(MemberVO receiver) {
		this.receiver = receiver;
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

	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
