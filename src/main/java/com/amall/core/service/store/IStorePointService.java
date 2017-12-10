package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStorePointService</p>
 * <p>Description: 店铺评分管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:00:18
 * @version 1.0
 */
public abstract interface IStorePointService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StorePoint
	 * @return
	 */
	public Long add(StorePoint example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StorePoint getByKey(Long id);
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
	public Integer deleteByExample(StorePointExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StorePoint record);
	
	public Pagination getObjectListWithPage(StorePointExample example);
	
	public List<StorePoint> getObjectList(StorePointExample example);
	
	public Integer getObjectListCount(StorePointExample example);
}
