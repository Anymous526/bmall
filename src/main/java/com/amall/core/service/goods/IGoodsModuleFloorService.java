package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsModuleFloor;
import com.amall.core.bean.GoodsModuleFloorExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsModuleFloorService</p>
 * <p>Description: 商品所属模块楼层service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ygq
 * @date	2016-2-15下午2:49:08
 * @version 1.0
 */
public abstract interface IGoodsModuleFloorService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsModuleFloor
	 * @return
	 */
	public Long add(GoodsModuleFloor example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsModuleFloor getByKey(Long id);
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
	public Integer deleteByExample(GoodsModuleFloorExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsModuleFloor record);
	
	public List<GoodsModuleFloor> getObjectList(GoodsModuleFloorExample example);
	
	public Pagination getObjectListWithPage(GoodsModuleFloorExample example);
	
	public Integer getObjectListCount(GoodsModuleFloorExample example);
	
}
