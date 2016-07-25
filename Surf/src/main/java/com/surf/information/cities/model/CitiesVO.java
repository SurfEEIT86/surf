package com.surf.information.cities.model;

import java.io.Serializable;

public class CitiesVO implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer CityNo;
	private String CityName;
	
	public Integer getCityNo() {
		return CityNo;
	}
	public void setCityNo(Integer cityNo) {
		this.CityNo = cityNo;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		this.CityName = cityName;
	}
	

}
