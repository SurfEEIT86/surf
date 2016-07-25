package com.surf.customorders.model;

import java.io.Serializable;

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
	private byte[] custumlogo1;
	private byte[] custumlogo2;
	
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
	public byte[] getCustumlogo1() {
		return custumlogo1;
	}
	public void setCustumlogo1(byte[] custumlogo1) {
		this.custumlogo1 = custumlogo1;
	}
	public byte[] getCustumlogo2() {
		return custumlogo2;
	}
	public void setCustumlogo2(byte[] custumlogo2) {
		this.custumlogo2 = custumlogo2;
	}
	
}
