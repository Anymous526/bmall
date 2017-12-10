package com.amall.core.service.integral;

import java.util.List;

import com.amall.core.bean.IntegralGoodsOrderExample;
import com.amall.core.bean.IntegralGoodsOrderWithBLOBs;
import com.amall.core.web.page.Pagination;

public abstract interface IIntegralGoodsOrderService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param IntegralGoodsOrder
	 * @return
	 */
	public Long add(IntegralGoodsOrderWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public IntegralGoodsOrderWithBLOBs getByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByKey</p>
	 * <p>Description: 根据id单个删除</p>
	 * @param id
	 * @return
	 */
	public Integer deleteByKey(Long id);
	public Integer deleteByExample(IntegralGoodsOrderExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(IntegralGoodsOrderWithBLOBs record);
	
	public Pagination getObjectListWithPage(IntegralGoodsOrderExample example);
	
	public List<IntegralGoodsOrderWithBLOBs> getObjectList(IntegralGoodsOrderExample example);
	
	public Integer getObjectListCount(IntegralGoodsOrderExample example);
}
