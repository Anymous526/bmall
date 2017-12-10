package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.PaymentExample;
import com.amall.core.bean.PaymentWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IPaymentService</p>
 * <p>Description: 支付管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:00:00
 * @version 1.0
 */
public abstract interface IPaymentService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Payment
	 * @return
	 */
	public Long add(PaymentWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PaymentWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(PaymentExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PaymentWithBLOBs record);
	
	public Pagination getObjectListWithPage(PaymentExample example);
	
	public List<PaymentWithBLOBs> getObjectList(PaymentExample example);
	
	public Integer getObjectListCount(PaymentExample example);

}
