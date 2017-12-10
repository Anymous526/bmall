package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StorePartner;
import com.amall.core.bean.StorePartnerExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStorePartnerService</p>
 * <p>Description: 合作店铺管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:03:39
 * @version 1.0
 */
public abstract interface IStorePartnerService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StorePartner
	 * @return
	 */
	public Long add(StorePartner example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StorePartner getByKey(Long id);
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
	public Integer deleteByExample(StorePartnerExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StorePartner record);
	
	public Pagination getObjectListWithPage(StorePartnerExample example);
	
	public List<StorePartner> getObjectList(StorePartnerExample example);
	
	public Integer getObjectListCount(StorePartnerExample example);
}
