package com.amall.core.service.orderForm;

import java.util.List;

import com.amall.core.bean.OrderFormLog;
import com.amall.core.bean.OrderFormLogExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IOrderFormLogService</p>
 * <p>Description: 订单日志管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:02:04
 * @version 1.0
 */
public abstract interface IOrderFormLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param OrderFormLog
	 * @return
	 */
	public Long add(OrderFormLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public OrderFormLog getByKey(Long id);
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
	public Integer deleteByExample(OrderFormLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(OrderFormLog record);
	
	public Pagination getObjectListWithPage(OrderFormLogExample example);
	
	public List<OrderFormLog> getObjectList(OrderFormLogExample example);
	
	public Integer getObjectListCount(OrderFormLogExample example);
}
