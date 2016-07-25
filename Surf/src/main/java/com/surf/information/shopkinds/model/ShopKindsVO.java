package com.surf.information.shopkinds.model;

import java.io.Serializable;

public class ShopKindsVO implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer shopKind;
	private String kindName;

	public Integer getShopKind() {
		return shopKind;
	}

	public void setShopKind(Integer shopKind) {
		this.shopKind = shopKind;
	}

	public String getKindName() {
		return kindName;
	}

	public void setKindName(String kindName) {
		this.kindName = kindName;

	}

}
