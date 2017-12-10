package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.web.page.Pagination;

public abstract interface IRefundService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Refund
	 * @return
	 */
	public Long add(Refund example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Refund getByKey(Long id);
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
	public Integer deleteByExample(RefundExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Refund record);
	
	public Pagination getObjectListWithPage(RefundExample example);
	
	public List<Refund> getObjectList(RefundExample example);
	
	public Integer getObjectListCount(RefundExample example);
}
