package com.amall.core.service.cart;

import java.util.List;

import com.amall.core.bean.Cart;
import com.amall.core.bean.CartExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ICartService</p>
 * <p>Description: 购物车</p>
 * <p>Company: www.amall.com</p> 
 * @author  tangxiang
 * @date	2015-6-16
 * @version 1.0
 */
public  interface ICartService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SnsFriend
	 * @return
	 */
	public Long add(Cart example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Cart getByKey(Long id);
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
	public Integer deleteByExample(CartExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Cart record);
	
	public Pagination getObjectListWithPage(CartExample example);
	
	public List<Cart> getObjectList(CartExample example);
	
	public Integer getObjectListCount(CartExample example);
}
