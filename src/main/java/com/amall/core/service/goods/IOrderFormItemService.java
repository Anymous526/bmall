package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.OrderFormItem;
import com.amall.core.bean.OrderFormItemExample;
import com.amall.core.web.page.Pagination;


/**
 * @author tangxiang
 * 订单详情表
 */
public abstract interface IOrderFormItemService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param OrderFormItem
	 * @return
	 */
	public Integer add(OrderFormItem example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public OrderFormItem getByKey(Long id);
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
	public Integer deleteByExample(OrderFormItemExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(OrderFormItem record);
	
	public Pagination getObjectListWithPage(OrderFormItemExample example);
	
	public List<OrderFormItem> getObjectList(OrderFormItemExample example);
	
	public Integer getObjectListCount(OrderFormItemExample example);
	
	
	public OrderFormItem getObjectByOrderIdAndGoodsId(Long orderId,Long goodsId);
}
