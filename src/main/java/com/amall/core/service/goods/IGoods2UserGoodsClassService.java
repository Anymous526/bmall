package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.Goods2Ugc;
import com.amall.core.bean.Goods2UgcExample;

public interface IGoods2UserGoodsClassService {
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Integer add(Goods2Ugc example);

	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(Goods2UgcExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Goods2Ugc record);
	
	public void updateByExample(Goods2Ugc record,Goods2UgcExample example);
	
	public List<Goods2Ugc> getObjectList(Goods2UgcExample example);
	
	public Integer getObjectListCount(Goods2UgcExample example);
	
	
}
