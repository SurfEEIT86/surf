package com.surf.customorders.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class CustomOrdersVO implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer orderno;
	private Integer memberno;
	private String dimension;
	private String boardcolor;
	private String finsys;
	private String material;
	private String frontpic;
	private String backpic;
	private Timestamp date;
	private String customlogo1;
	private String customlogo2;
	private String creditcard;
	private Integer modelno;
	
	public Integer getModelno() {
		return modelno;
	}
	public void setModelno(Integer modelno) {
		this.modelno = modelno;
	}
	public String getCreditcard() {
		return creditcard;
	}
	public void setCreditcard(String creditcard) {
		this.creditcard = creditcard;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	public Integer getOrderno() {
		return orderno;
	}
	public void setOrderno(Integer orderno) {
		this.orderno = orderno;
	}
	public Integer getMemberno() {
		return memberno;
	}
	public void setMemberno(Integer memberno) {
		this.memberno = memberno;
	}
	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	public String getBoardcolor() {
		return boardcolor;
	}
	public void setBoardcolor(String boardcolor) {
		this.boardcolor = boardcolor;
	}
	public String getFinsys() {
		return finsys;
	}
	public void setFinsys(String finsys) {
		this.finsys = finsys;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getFrontpic() {
		return frontpic;
	}
	public void setFrontpic(String frontpic) {
		this.frontpic = frontpic;
	}
	public String getBackpic() {
		return backpic;
	}
	public void setBackpic(String backpic) {
		this.backpic = backpic;
	}
	public String getCustomlogo1() {
		return customlogo1;
	}
	public void setCustomlogo1(String customlogo1) {
		this.customlogo1 = customlogo1;
	}
	public String getCustomlogo2() {
		return customlogo2;
	}
	public void setCustomlogo2(String customlogo2) {
		this.customlogo2 = customlogo2;
	}
	
}
