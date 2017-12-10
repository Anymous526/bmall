package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudGoodsAuto;
import com.amall.core.bean.CloudGoodsAutoExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudGoodsAutoService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudGoodsAuto
	 * @return
	 */
	public Long add(CloudGoodsAuto example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudGoodsAuto getByKey(Long id);
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
	public Integer deleteByExample(CloudGoodsAutoExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudGoodsAuto record);
	
	public Pagination getObjectListWithPage(CloudGoodsAutoExample example);
	
	public List<CloudGoodsAuto> getObjectList(CloudGoodsAutoExample example);
	
	public Integer getObjectListCount(CloudGoodsAutoExample example);
	
}
