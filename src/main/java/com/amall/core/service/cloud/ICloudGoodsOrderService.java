package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudGoodsOrder;
import com.amall.core.bean.CloudGoodsOrderExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudGoodsOrderService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudGoodsOrder
	 * @return
	 */
	public Long add(CloudGoodsOrder example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudGoodsOrder getByKey(Long id);
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
	public Integer deleteByExample(CloudGoodsOrderExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudGoodsOrder record);
	
	public Pagination getObjectListWithPage(CloudGoodsOrderExample example);
	
	public List<CloudGoodsOrder> getObjectList(CloudGoodsOrderExample example);
	
	public Integer getObjectListCount(CloudGoodsOrderExample example);
	
}