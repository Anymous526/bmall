package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreCart;
import com.amall.core.bean.StoreCartExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStoreCartService</p>
 * <p>Description: 店铺中购物车管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:10:20
 * @version 1.0
 */
public abstract interface IStoreCartService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreCart
	 * @return
	 */
	public Long add(StoreCart example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreCart getByKey(Long id);
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
	public Integer deleteByExample(StoreCartExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreCart record);
	
	public Pagination getObjectListWithPage(StoreCartExample example);
	
	public List<StoreCart> getObjectList(StoreCartExample example);
	
	public Integer getObjectListCount(StoreCartExample example);
}
