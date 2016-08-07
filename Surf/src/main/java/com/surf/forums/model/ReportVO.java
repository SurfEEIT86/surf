package com.surf.forums.model;

import java.io.Serializable;
import java.sql.Timestamp;




public class ReportVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer memberno;
	private Integer articleno;
	private Timestamp datetime;
	private String reason;
	public Integer getMemberno() {
		return memberno;
	}
	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}
	public Integer getArticleno() {
		return articleno;
	}
	public void setArticleno(Integer articleno) {
		this.articleno = articleno;
	}
	public Timestamp getDatetime() {
		return datetime;
	}
	public void setDatetime(Timestamp datetime) {
		this.datetime = datetime;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
//	public boolean equals(Object obj) {
//        if(obj == this) {
//            return true;
//        }
// 
//        if(!(obj instanceof ReportVO)) {
//            return false;
//        }
// 
//        ReportVO user = (ReportVO) obj;
//        return new EqualsBuilder()
//                    .append(this.memberno, user.getMemberno())
//                    .append(this.articleno, user.getArticleno())
//                    .append(this.datetime, user.getDatetime())
//                    .isEquals();
//    }
// 
//    public int hashCode() {
//        return new HashCodeBuilder()
//                    .append(this.memberno)
//                    .append(this.articleno)
//                    .append(this.datetime)
//                    .toHashCode();
//    }
//	
}
