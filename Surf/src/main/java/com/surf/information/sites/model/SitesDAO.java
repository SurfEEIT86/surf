package com.surf.information.sites.model;

import java.util.List;

public interface SitesDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.surf.sites.model.dao.SitesDAO#findBySites(java.lang.Integer)
	 */

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.surf.sites.model.dao.SitesDAO#selectAll()
	 */
	public abstract List<SitesVO> selectAll();

	/* 新增一個浪點 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.surf.sites.model.dao.SitesDAO#insert(com.surf.sites.model.SitesVO)
	 */
	public abstract SitesVO insert(SitesVO bean);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.surf.sites.model.dao.SitesDAO#update(com.surf.sites.model.SitesVO)
	 */
	public abstract SitesVO update(SitesVO vo);

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.surf.sites.model.dao.SitesDAO#deleteBySitesVO(java.lang.Integer)
	 */
	public abstract boolean deleteBySitesVO(Integer Sites);

	public SitesVO findBySites(Integer Sites) ;

}