package com.surf.producttype.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import com.surf.brands.model.BrandsVO;

public class ProducttypesVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Integer typeno;
	private String type;
	private Boolean status;
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	private Set<BrandsVO> brands = new LinkedHashSet<BrandsVO>();
	
	public Integer getTypeno() {
		return typeno;
	}
	public void setTypeno(Integer typeno) {
		this.typeno = typeno;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Set<BrandsVO> getBrands() {
		return brands;
	}
	public void setBrands(Set<BrandsVO> brands) {
		this.brands = brands;
	}
	
	
}
