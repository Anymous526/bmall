package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreSlide;
import com.amall.core.bean.StoreSlideExample;
import com.amall.core.web.page.Pagination;

public abstract interface IStoreSlideService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreSlide
	 * @return
	 */
	public Long add(StoreSlide example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreSlide getByKey(Long id);
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
	public Integer deleteByExample(StoreSlideExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreSlide record);
	
	public Pagination getObjectListWithPage(StoreSlideExample example);
	
	public List<StoreSlide> getObjectList(StoreSlideExample example);
	
	public Integer getObjectListCount(StoreSlideExample example);
}
