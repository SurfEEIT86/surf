package com.surf.information.sites.model;

import java.io.Serializable;

public class SitesVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer siteno;
	private String name;
	private Double longitude;
	private Double latitude;
	private Integer cityNo;
	private Boolean status;
	private String pic1;
	private String pic2;
	private String pic3;
	private String description;
	public Integer getSiteno() {
		return siteno;
	}
	public void setSiteno(Integer siteno) {
		this.siteno = siteno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Integer getCityNo() {
		return cityNo;
	}
	public void setCityNo(Integer cityNo) {
		this.cityNo = cityNo;
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
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getPic3() {
		return pic3;
	}
	public void setPic3(String pic3) {
		this.pic3 = pic3;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
