package com.amall.core.service.cloud;

import java.util.List;
import com.amall.core.bean.CloudStatistics;
import com.amall.core.bean.CloudStatisticsExample;

public abstract interface ICloudStatisticsService
{

	/**
	 * 
	 * <p>
	 * Title: add
	 * </p>
	 * <p>
	 * Description: 添加
	 * </p>
	 * 
	 * @param CloudStatistics
	 * @return
	 */
	public Integer add (CloudStatistics example);

	/**
	 * 
	 * <p>
	 * Title: getByKey
	 * </p>
	 * <p>
	 * Description: 根据id查询单个对象
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public CloudStatistics getCloudStatistics ( );

	/**
	 * 
	 * <p>
	 * Title: deleteByKey
	 * </p>
	 * <p>
	 * Description: 根据id单个删除
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteByKey (Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByExample
	 * </p>
	 * <p>
	 * Description: 根据条件删除
	 * </p>
	 * 
	 * @param example
	 * @return
	 */
	public Integer deleteByExample (CloudStatisticsExample example);

	/**
	 * 
	 * <p>
	 * Title: updateByObject
	 * </p>
	 * <p>
	 * Description: 修改
	 * </p>
	 * 
	 * @param record
	 * @return
	 */
	public Integer updateByObject (CloudStatistics record);

	public List <CloudStatistics> getObjectList (CloudStatisticsExample example);

	public Integer getObjectListCount (CloudStatisticsExample example);
}
