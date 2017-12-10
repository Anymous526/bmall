package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.WaterMark;
import com.amall.core.bean.WaterMarkExample;
import com.amall.core.web.page.Pagination;

public abstract interface IWaterMarkService{
		
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param WaterMark
	 * @return
	 */
	public Long add(WaterMark example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public WaterMark getByKey(Long id);
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
	public Integer deleteByExample(WaterMarkExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(WaterMark record);
	
	public Pagination getObjectListWithPage(WaterMarkExample example);
	
	public List<WaterMark> getObjectList(WaterMarkExample example);
	
	public Integer getObjectListCount(WaterMarkExample example);
}
