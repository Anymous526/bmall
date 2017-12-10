package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudBuyCodes;
import com.amall.core.bean.CloudBuyCodesExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudBuyCodesService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudBuyCodes
	 * @return
	 */
	public Integer add(CloudBuyCodes example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudBuyCodes getByKey(Long id);
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
	public Integer deleteByExample(CloudBuyCodesExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudBuyCodes record);
	
	public Pagination getObjectListWithPage(CloudBuyCodesExample example);
	
	public List<CloudBuyCodes> getObjectList(CloudBuyCodesExample example);
	
	public Integer getObjectListCount(CloudBuyCodesExample example);
	
	public List<CloudBuyCodes> getCloudBuyCodesOfCloudGoodsId(long goodsId);
	
	public List<CloudBuyCodes> getCloudBuyCodesOfUserId(long userId);
	
	public List<CloudBuyCodes> getCloudBuyCodesOfCloudGoodsIdAndUserId(long goodsId, long userId);
	
}
