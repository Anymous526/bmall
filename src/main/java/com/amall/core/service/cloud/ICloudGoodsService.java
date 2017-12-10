package com.amall.core.service.cloud;

import java.util.List;

import com.amall.core.bean.CloudGoods;
import com.amall.core.bean.CloudGoodsExample;
import com.amall.core.web.page.Pagination;


public abstract interface ICloudGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CloudGoods
	 * @return
	 */
	public Integer add(CloudGoods example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CloudGoods getByKey(Long id);
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
	public Integer deleteByExample(CloudGoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CloudGoods record);
	
	public Pagination getObjectListWithPage(CloudGoodsExample example);
	
	public List<CloudGoods> getObjectList(CloudGoodsExample example);
	
	public Integer getObjectListCount(CloudGoodsExample example);
	
}
