package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsReturnItem;
import com.amall.core.bean.GoodsReturnItemExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsReturnItemService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsReturnItem
	 * @return
	 */
	public Long add(GoodsReturnItem example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsReturnItem getByKey(Long id);
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
	public Integer deleteByExample(GoodsReturnItemExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsReturnItem record);
	
	public Pagination getObjectListWithPage(GoodsReturnItemExample example);
	
	public List<GoodsReturnItem> getObjectList(GoodsReturnItemExample example);
	
	public Integer getObjectListCount(GoodsReturnItemExample example);
}
