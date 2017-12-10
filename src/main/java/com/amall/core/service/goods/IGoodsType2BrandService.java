package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsType2Brand;
import com.amall.core.bean.GoodsType2BrandExample;

public interface IGoodsType2BrandService {
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Integer add(GoodsType2Brand example);

	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(GoodsType2BrandExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsType2Brand record);
	
	public List<GoodsType2Brand> getObjectList(GoodsType2BrandExample example);
	
	public Integer getObjectListCount(GoodsType2BrandExample example);
}
