package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudOpen;
import com.amall.core.bean.CloudOpenExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudOpenService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudOpen
	 * @return
	 */
	public Integer add(CloudOpen example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudOpen getByKey(Long id);
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
	public Integer deleteByExample(CloudOpenExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudOpen record);
	
	public Pagination getObjectListWithPage(CloudOpenExample example);
	
	public List<CloudOpen> getObjectList(CloudOpenExample example);
	
	public CloudOpen getCloudOpen(long goodsId);
	
	public Integer getObjectListCount(CloudOpenExample example);
	
}
