package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreNavigation;
import com.amall.core.bean.StoreNavigationExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStoreNavigationService</p>
 * <p>Description: 店铺导航管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:05:57
 * @version 1.0
 */
public abstract interface IStoreNavigationService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreNavigation
	 * @return
	 */
	public Long add(StoreNavigation example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreNavigation getByKey(Long id);
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
	public Integer deleteByExample(StoreNavigationExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreNavigation record);
	
	public Pagination getObjectListWithPage(StoreNavigationExample example);
	
	public List<StoreNavigation> getObjectList(StoreNavigationExample example);
	
	public Integer getObjectListCount(StoreNavigationExample example);
}
