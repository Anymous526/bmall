package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreEarningDetailExample;
import com.amall.core.bean.StoreEarningDetail;
import com.amall.core.web.page.Pagination;

public interface IStoreEarningDetailService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreEarningDetail
	 * @return
	 */
	public Integer add(StoreEarningDetail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreEarningDetail getByKey(Long id);
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
	public Integer deleteByExample(StoreEarningDetailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreEarningDetail record);
	
	public Pagination getObjectListWithPage(StoreEarningDetailExample example);
	
	public List<StoreEarningDetail> getObjectList(StoreEarningDetailExample example);
	
	public Integer getObjectListCount(StoreEarningDetailExample example);
	
}
