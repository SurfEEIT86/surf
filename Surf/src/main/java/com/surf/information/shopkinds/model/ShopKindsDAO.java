package com.surf.information.shopkinds.model;

import java.util.List;

public interface ShopKindsDAO {

	/* 搜尋一個商店種類 */
	/* (non-Javadoc)
	 * @see com.surf.shopkinds.model.dao.ShopKindDAO#findByShopKind(java.lang.Integer)
	 */
	public abstract ShopKindsVO findByShopKind(Integer Shopkinds);

	/* 搜尋全部商店種類 */
	/* (non-Javadoc)
	 * @see com.surf.shopkinds.model.dao.ShopKindDAO#selectAll()
	 */
	public abstract List<ShopKindsVO> selectAll();

	/* 新增一個商店種類 */
	/* (non-Javadoc)
	 * @see com.surf.shopkinds.model.dao.ShopKindDAO#insert(com.surf.shopkinds.model.ShopKindsVO)
	 */
	public abstract ShopKindsVO insert(ShopKindsVO bean);

	/* 更新一個商店種類 */
	/* (non-Javadoc)
	 * @see com.surf.shopkinds.model.dao.ShopKindDAO#update(com.surf.shopkinds.model.ShopKindsVO)
	 */
	public abstract ShopKindsVO update(ShopKindsVO vo);

	/* (non-Javadoc)
	 * @see com.surf.shopkinds.model.dao.ShopKindDAO#deleteByShopKinds(java.lang.Integer)
	 */
	public abstract boolean deleteByShopKinds(Integer shopKinds);

}