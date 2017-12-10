package com.amall.core.service.delivery;

import java.util.List;

import com.amall.core.bean.DeliveryGoods;
import com.amall.core.bean.DeliveryGoodsExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IDeliveryGoodsService</p>
 * <p>Description: 买就送</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月3日下午12:02:12
 * @version 1.0
 */

public abstract interface IDeliveryGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param DeliveryGoods
	 * @return
	 */
	public Long add(DeliveryGoods example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public DeliveryGoods getByKey(Long id);
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
	public Integer deleteByExample(DeliveryGoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(DeliveryGoods record);
	
	public Pagination getObjectListWithPage(DeliveryGoodsExample example);
	
	public List<DeliveryGoods> getObjectList(DeliveryGoodsExample example);
	
	public Integer getObjectListCount(DeliveryGoodsExample example);
}
