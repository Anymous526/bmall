package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreCount;
import com.amall.core.bean.StoreCountExample;

/**
 * 
 * <p>Title: IStoreCountService</p>
 * <p>Description: 店铺等级管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ygq
 * @date	2016-3-16上午11:44:13
 * @version 1.0
 */
public abstract interface IStoreCountService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreCount
	 * @return
	 */
	public Long add(StoreCount example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreCount getByKey(Long id);
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
	public Integer deleteByExample(StoreCountExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreCount record);
	
	public List<StoreCount> getObjectList(StoreCountExample example);
	
	public Integer getObjectListCount(StoreCountExample example);
}
