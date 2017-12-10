package com.amall.core.service.alipayorder;

import java.util.List;
import com.amall.core.bean.AlipayOrder;
import com.amall.core.bean.AlipayOrderExample;

/**
 * 
 * <p>
 * Title: IAlipayOrderService
 * </p>
 * <p>
 * Description: 根据多个订单生成新的订单提交的管理
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author 李越
 * @date 2015年7月4日下午3:26:06
 * @version 1.0
 */
public interface IAlipayOrderService
{

	/**
	 * 
	 * <p>
	 * Title: add
	 * </p>
	 * <p>
	 * Description: 添加
	 * </p>
	 * 
	 * @param alipayOrder
	 * @return
	 */
	public Long add (AlipayOrder alipayOrder);

	/**
	 * 
	 * <p>
	 * Title: getByKey
	 * </p>
	 * <p>
	 * Description: 根据Id查询单个对象
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public AlipayOrder getByKey (Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByKey
	 * </p>
	 * <p>
	 * Description: 根据id单个删除
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteByKey (Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByExample
	 * </p>
	 * <p>
	 * Description: 根据条件删除
	 * </p>
	 * 
	 * @param example
	 * @return
	 */
	public Integer deleteByExample (AlipayOrderExample example);

	/**
	 * 
	 * <p>
	 * Title: updateByObject
	 * </p>
	 * <p>
	 * Description: 修改
	 * </p>
	 * 
	 * @param record
	 * @return
	 */
	public Integer updateByObject (AlipayOrder record);

	public List <AlipayOrder> getObjectList (AlipayOrderExample example);

	public Integer getObjectListCount (AlipayOrderExample example);
}
