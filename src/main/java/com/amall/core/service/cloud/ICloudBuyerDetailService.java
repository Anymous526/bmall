package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudBuyerDetail;
import com.amall.core.bean.CloudBuyerDetailExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudBuyerDetailService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudBuyerDetail
	 * @return
	 */
	public Integer add(CloudBuyerDetail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudBuyerDetail getByKey(Long id);
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
	public Integer deleteByExample(CloudBuyerDetailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudBuyerDetail record);
	
	public Pagination getObjectListWithPage(CloudBuyerDetailExample example);
	
	public List<CloudBuyerDetail> getObjectList(CloudBuyerDetailExample example);
	
	public Integer getObjectListCount(CloudBuyerDetailExample example);
	
	public CloudBuyerDetail getCloudBuyerDetailOfCloudGoodsIdAndUserId(long goodsId, long userId);
	
}
