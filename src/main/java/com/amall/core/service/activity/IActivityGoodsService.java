package com.amall.core.service.activity;

import java.util.List;

import com.amall.core.bean.ActivityGoods;
import com.amall.core.bean.ActivityGoodsExample;
import com.amall.core.web.page.Pagination;


public abstract interface IActivityGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ActivityGoods
	 * @return
	 */
	public Long add(ActivityGoods example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ActivityGoods getByKey(Long id);
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
	public Integer deleteByExample(ActivityGoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ActivityGoods record);
	
	public Pagination getObjectListWithPage(ActivityGoodsExample example);
	
	public List<ActivityGoods> getObjectList(ActivityGoodsExample example);
	
	public Integer getObjectListCount(ActivityGoodsExample example);
}
