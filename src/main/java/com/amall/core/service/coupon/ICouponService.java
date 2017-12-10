package com.amall.core.service.coupon;

import java.util.List;

import com.amall.core.bean.Coupon;
import com.amall.core.bean.CouponExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ICouponService</p>
 * <p>Description: 优惠券管理</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:28:39
 * @version 1.0
 */
public interface ICouponService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Coupon
	 * @return
	 */
	public Long add(Coupon example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Coupon getByKey(Long id);
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
	public Integer deleteByExample(CouponExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Coupon record);
	
	public Pagination getObjectListWithPage(CouponExample example);
	
	public List<Coupon> getObjectList(CouponExample example);
	
	public Integer getObjectListCount(CouponExample example);
}
