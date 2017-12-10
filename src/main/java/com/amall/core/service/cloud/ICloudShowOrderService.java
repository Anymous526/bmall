package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudShowOrder;
import com.amall.core.bean.CloudShowOrderExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudShowOrderService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudShowOrder
	 * @return
	 */
	public Integer add(CloudShowOrder example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudShowOrder getByKey(Long id);
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
	public Integer deleteByExample(CloudShowOrderExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudShowOrder record);
	
	public Pagination getObjectListWithPage(CloudShowOrderExample example);
	
	public List<CloudShowOrder> getObjectList(CloudShowOrderExample example);
	
	public Integer getObjectListCount(CloudShowOrderExample example);
	
}
