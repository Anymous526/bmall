package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudCodes;
import com.amall.core.bean.CloudCodesExample;


public abstract interface ICloudCodesService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudCodes
	 * @return
	 */
	public void add(List<CloudCodes> CloudCodesList);
	
	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(CloudCodesExample example);
	
	public List<CloudCodes> getObjectList(long goodsId, int count);
	
	public Integer getObjectListCount(CloudCodesExample example);
	
	
}
