package com.amall.core.service.cart;

import java.util.List;

import com.amall.core.bean.CartDetail;
import com.amall.core.bean.CartDetailExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ICartDetailService</p>
 * <p>Description: 购物车</p>
 * <p>Company: www.amall.com</p> 
 * @author  tangxiang
 * @date	2015-6-16
 * @version 1.0
 */
public  interface ICartDetailService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SnsAttention
	 * @return
	 */
	public Long add(CartDetail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CartDetail getByKey(Long id);
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
	public Integer deleteByExample(CartDetailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CartDetail record);
	
	
	public Pagination getObjectListWithPage(CartDetailExample example);
	
	public List<CartDetail> getObjectList(CartDetailExample example);
	
	public Integer getObjectListCount(CartDetailExample example);
}
