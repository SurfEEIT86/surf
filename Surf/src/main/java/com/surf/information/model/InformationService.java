package com.surf.information.model;



import java.util.List;

import com.surf.information.cities.model.CitiesDAO;
import com.surf.information.cities.model.CitiesVO;
import com.surf.information.shopkinds.model.ShopKindsDAO;
import com.surf.information.shopkinds.model.ShopKindsVO;
import com.surf.information.shops.model.ShopsDAO;
import com.surf.information.shops.model.ShopsVO;
import com.surf.information.sites.model.SitesDAO;
import com.surf.information.sites.model.SitesVO;

public class InformationService {
	
	CitiesDAO citiesDAO = null;
	ShopKindsDAO shopKindsDAO = null;
	SitesDAO sitesDAO = null;
	ShopsDAO shopsDAO = null;
	public void setCitiesDAO(CitiesDAO citiesDAO) {
		this.citiesDAO = citiesDAO;
	}
	public void setShopKindsDAO(ShopKindsDAO shopKindsDAO) {
		this.shopKindsDAO = shopKindsDAO;
	}
	public void setSitesDAO(SitesDAO sitesDAO) {
		this.sitesDAO = sitesDAO;
	}
	public void setShopsDAO(ShopsDAO shopsDAO) {
		this.shopsDAO = shopsDAO;
	}
	
	
	/*取得一個地點物件*/
	public SitesVO findSiteByPK(Integer siteNo){
		return sitesDAO.findBySites(siteNo);
	}
	/*取得全部的sites*/
	public List<SitesVO> selectSitesByAll(){
		return sitesDAO.selectAll();
	}
	
	public CitiesVO findCitiesByPK(Integer cityNo){
		return citiesDAO.findByCityNo(cityNo);
	}
	/*取得一個shop物件*/
	public ShopsVO findByShopNo(Integer ShopsNo) {
		return shopsDAO.findByCityNo(ShopsNo);
	}
	/*取得全部的shops*/
	public List<ShopsVO> selectShopsByAll(){
		return shopsDAO.selectAll();
	}
	/*取得一個shopkind物件*/
	public ShopKindsVO findByShopKind(Integer ShopKindNo){
		return shopKindsDAO.findByShopKind(ShopKindNo);
	}
}

