package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudStatisticsAuto;
import com.amall.core.bean.CloudStatisticsAutoExample;


public abstract interface ICloudStatisticsAutoService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudStatisticsAuto
	 * @return
	 */
	public Integer add(CloudStatisticsAuto example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudStatisticsAuto getByKey(Long id);
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
	public Integer deleteByExample(CloudStatisticsAutoExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudStatisticsAuto record);
	
	public List<CloudStatisticsAuto> getObjectList(CloudStatisticsAutoExample example);
	
	public Integer getObjectListCount(CloudStatisticsAutoExample example);
	
}
