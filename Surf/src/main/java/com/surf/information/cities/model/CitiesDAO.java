package com.surf.information.cities.model;

import java.util.List;

public interface CitiesDAO {

	/*搜尋一個城市*/
	/* (non-Javadoc)
	 * @see com.surf.cities.model.dao.CitiesDAO#findByCityNo(java.lang.Integer)
	 */
	public abstract CitiesVO findByCityNo(Integer CityNo);

	/*搜尋全部城市*/
	/* (non-Javadoc)
	 * @see com.surf.cities.model.dao.CitiesDAO#selectAll()
	 */
	public abstract List<CitiesVO> selectAll();

	/*新增一個城市*/
	/* (non-Javadoc)
	 * @see com.surf.cities.model.dao.CitiesDAO#insert(com.surf.cities.model.CitiesVO)
	 */
	public abstract CitiesVO insert(CitiesVO bean);

	/*更新一個城市*/
	/* (non-Javadoc)
	 * @see com.surf.cities.model.dao.CitiesDAO#update(com.surf.cities.model.CitiesVO)
	 */
	public abstract CitiesVO update(CitiesVO vo);

	/*刪除一個城市*/
	/* (non-Javadoc)
	 * @see com.surf.cities.model.dao.CitiesDAO#deleteByCityNO(java.lang.Integer)
	 */
	public abstract boolean deleteByCityNO(Integer CityNO);

}