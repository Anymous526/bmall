package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsModuleFloorNext;
import com.amall.core.bean.GoodsModuleFloorNextExample;

/**
 * 
 * <p>Title: IGoodsModuleFloorNextService</p>
 * <p>Description: 商品所属模块楼层service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ygq
 * @date	2016-2-15下午2:49:08
 * @version 1.0
 */
public abstract interface IGoodsModuleFloorNextService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsModuleFloorNext
	 * @return
	 */
	public Long add(GoodsModuleFloorNext example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsModuleFloorNext getByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByKey</p>
	 * <p>Description: 根据id单个删除</p>
	 * @param id
	 * @return
	 */
	public Integer deleteByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(GoodsModuleFloorNextExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsModuleFloorNext record);
	
	public List<GoodsModuleFloorNext> getObjectList(GoodsModuleFloorNextExample example);
	
	public Integer getObjectListCount(GoodsModuleFloorNextExample example);
	
}
