package com.amall.core.service.spare;

import java.util.List;

import com.amall.core.bean.SpareGoodsFloor;
import com.amall.core.bean.SpareGoodsFloorExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ISpareGoodsFloorService</p>
 * <p>Description: 闲置商品楼层管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:18:49
 * @version 1.0
 */
public abstract interface ISpareGoodsFloorService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SpareGoodsFloor
	 * @return
	 */
	public Long add(SpareGoodsFloor example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SpareGoodsFloor getByKey(Long id);
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
	public Integer deleteByExample(SpareGoodsFloorExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SpareGoodsFloor record);
	
	public Pagination getObjectListWithPage(SpareGoodsFloorExample example);
	
	public List<SpareGoodsFloor> getObjectList(SpareGoodsFloorExample example);
	
	public Integer getObjectListCount(SpareGoodsFloorExample example);
}
