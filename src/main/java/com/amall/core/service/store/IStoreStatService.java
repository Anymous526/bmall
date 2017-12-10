package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreStat;
import com.amall.core.bean.StoreStatExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStoreStatService</p>
 * <p>Description: 店铺状态service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午2:17:07
 * @version 1.0
 */
public abstract interface IStoreStatService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreStat
	 * @return
	 */
	public Long add(StoreStat example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreStat getByKey(Long id);
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
	public Integer deleteByExample(StoreStatExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreStat record);
	
	public Pagination getObjectListWithPage(StoreStatExample example);
	
	public List<StoreStat> getObjectList(StoreStatExample example);
	
	public Integer getObjectListCount(StoreStatExample example);
}
