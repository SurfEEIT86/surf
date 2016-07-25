package com.surf.brands.model;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.surf.models.model.ModelsVO;
import com.surf.products.model.ProductsVO;
import com.surf.producttype.model.ProducttypesVO;

public class BrandsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer brandno;
	private String name;
	private ProducttypesVO prodtypesVO;
	private String pic;
	private Boolean status;
	private Set<ProductsVO> prods = new LinkedHashSet<ProductsVO>();
	private Set<ModelsVO> models = new LinkedHashSet<ModelsVO>();
	
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	
	public Integer getBrandno() {
		return brandno;
	}
	public void setBrandno(Integer brandno) {
		this.brandno = brandno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ProducttypesVO getProdtypesVO() {
		return prodtypesVO;
	}
	public void setProdtypesVO(ProducttypesVO prodtypesVO) {
		this.prodtypesVO = prodtypesVO;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public Set<ProductsVO> getProds() {
		return prods;
	}
	public void setProds(Set<ProductsVO> prods) {
		this.prods = prods;
	}

	public Set<ModelsVO> getModels() {
		return models;
	}
	public void setModels(Set<ModelsVO> models) {
		this.models = models;
	}
	
}
