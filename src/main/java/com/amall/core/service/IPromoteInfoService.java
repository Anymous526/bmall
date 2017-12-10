package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.PromoteInfo;
import com.amall.core.bean.PromoteInfoExample;

/**
 * 
 * <p>Title: IPromoteInfoService</p>
 * <p>Description: 商品所属模块service</p>
 * @author  ygq
 * @date	2016-4-20下午2:49:08
 * @version 1.0
 */
public abstract interface IPromoteInfoService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsModule
	 * @return
	 */
	public Long add(PromoteInfo example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PromoteInfo getByKey(Long id);
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
	public Integer deleteByExample(PromoteInfoExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PromoteInfo record);
	
	public List<PromoteInfo> getObjectList(PromoteInfoExample example);
	
	public Integer getObjectListCount(PromoteInfoExample example);
	
}
