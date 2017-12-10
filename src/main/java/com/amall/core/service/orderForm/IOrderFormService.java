package com.amall.core.service.orderForm;

import java.util.List;

import com.amall.core.bean.OrderExportEntity;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.bean.OrderFormWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IOrderFormService</p>
 * <p>Description: 订单管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午3:44:02
 * @version 1.0
 */
public abstract interface IOrderFormService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param OrderForm
	 * @return
	 */
	public Long add(OrderFormWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public OrderFormWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(OrderFormExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(OrderFormWithBLOBs record);
	
	public Pagination getObjectListWithPage(OrderFormExample example);
	
	public List<OrderFormWithBLOBs> getObjectList(OrderFormExample example);
	
	public Integer getObjectListCount(OrderFormExample example);
	
	
	
	/**
	 * 
	 * <p>Title: getUserAndPrice</p>
	 * <p>Description:根据条件 查询 分组用户id和其总价 </p>
	 * @param example  条件
	 * @return
	 */
	public List<OrderFormWithBLOBs> getUserAndPrice(OrderFormExample example);
	
	/**
	 * 
	 * <p>Title: getUserAndPrice</p>
	 * <p>Description:根据商品名称,获取该商品对应的订单信息 </p>
	 * @param example  条件
	 * @return
	 */
	public List<OrderFormWithBLOBs> selectOfByGoodsNameLike(String condition);
	
	public List<OrderForm> selectOrderForms(OrderFormExample example);
	
	public List<OrderExportEntity> selectOrderExport();
	
	public List<OrderExportEntity> selectO2OOrderExpot();
	
	public List<OrderExportEntity> selectStoreOrderExpot(long storeId);
}
