package com.surf.products.model;

import java.io.Serializable;

import com.surf.brands.model.BrandsVO;

public class ProductsVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer productno;
	private String name;
	private String size;
	private String description;
	private Integer stock;
	private Double price;
	private String pic1;
	private String pic2;
	private String pic3;
	private String link;
	private BrandsVO brandvo;
	
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public Integer getProductno() {
		return productno;
	}
	public void setProductno(Integer productno) {
		this.productno = productno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
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
	public BrandsVO getBrandvo() {
		return brandvo;
	}
	public void setBrandvo(BrandsVO brandvo) {
		this.brandvo = brandvo;
	}	
}
