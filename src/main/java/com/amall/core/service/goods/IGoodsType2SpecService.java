package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsType2Spec;
import com.amall.core.bean.GoodsType2SpecExample;

public interface IGoodsType2SpecService {

	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Integer add(GoodsType2Spec example);

	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(GoodsType2SpecExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsType2Spec record);
	
	public List<GoodsType2Spec> getObjectList(GoodsType2SpecExample example);
	
	public Integer getObjectListCount(GoodsType2SpecExample example);
}
