package com.surf.information.shops.model;

import java.util.List;

public interface ShopsDAO {

	/* 搜尋一個店家 */
	public abstract ShopsVO findByCityNo(Integer ShopsNo);

	/* 搜尋全部店家 */
	public abstract List<ShopsVO> selectAll();

	/* 新增一個店家 */
	public abstract ShopsVO insert(ShopsVO bean);

	/* 更新一個店家 */
	public abstract ShopsVO update(ShopsVO vo);

	/* 刪除一個店家 */
	public abstract boolean deleteByShopsNO(Integer ShopsNO);

	/*搜尋城市所有店家*/
	public abstract List<ShopsVO> selectByCityNo(Integer cityNo);

	/*搜尋特定種類店家*/
	public abstract List<ShopsVO> selectByKindNo(Integer kind);

	/*特定城市特定種類店家*/
	public abstract List<ShopsVO> selectByCityNoAndKindNo(Integer cityNo,
			Integer kind);

}