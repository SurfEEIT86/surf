package com.surf.models.model;

import java.io.Serializable;

import com.surf.brands.model.BrandsVO;

public class ModelsVO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private BrandsVO brandvo;
	private Integer modelno;
	private String name;
	private String pic;
	
	public BrandsVO getBrandvo() {
		return brandvo;
	}
	public void setBrandvo(BrandsVO brandvo) {
		this.brandvo = brandvo;
	}
	public Integer getModelno() {
		return modelno;
	}
	public void setModelno(Integer modelno) {
		this.modelno = modelno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
}
