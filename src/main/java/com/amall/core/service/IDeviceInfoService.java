package com.amall.core.service;

import java.util.List; 

import com.amall.core.bean.DeviceInfo;
import com.amall.core.bean.DeviceInfoExample;

/**
 * 
* @ClassName: IDeviceInfoService 
* @Description: 商品类型管理
* @date 2015年12月7日 下午5:38:23 
*
 */
public abstract interface IDeviceInfoService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param DeviceInfo
	 * @return
	 */
	public int add(DeviceInfo example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public DeviceInfo getByKey(Long id);
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
	public Integer deleteByExample(DeviceInfoExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(DeviceInfo record);
	
	public List<DeviceInfo> getObjectList(DeviceInfoExample example);
	
	public Integer getObjectListCount(DeviceInfoExample example);
}
