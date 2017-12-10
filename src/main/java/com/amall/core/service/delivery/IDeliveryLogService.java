package com.amall.core.service.delivery;

import java.util.List;

import com.amall.core.bean.DeliveryLog;
import com.amall.core.bean.DeliveryLogExample;
import com.amall.core.web.page.Pagination;

public  interface IDeliveryLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param DeliveryLog
	 * @return
	 */
	public Long add(DeliveryLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public DeliveryLog getByKey(Long id);
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
	public Integer deleteByExample(DeliveryLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(DeliveryLog record);
	
	public Pagination getObjectListWithPage(DeliveryLogExample example);
	
	public List<DeliveryLog> getObjectList(DeliveryLogExample example);
	
	public Integer getObjectListCount(DeliveryLogExample example);
}
