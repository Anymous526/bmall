package com.amall.core.service.coupon;

import java.util.List;

import com.amall.core.bean.CouponInfo;
import com.amall.core.bean.CouponInfoExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ICouponInfoService</p>
 * <p>Description: 优惠券描述管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:27:04
 * @version 1.0
 */
public abstract interface ICouponInfoService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CouponInfo
	 * @return
	 */
	public Long add(CouponInfo example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CouponInfo getByKey(Long id);
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
	public Integer deleteByExample(CouponInfoExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CouponInfo record);
	
	public Pagination getObjectListWithPage(CouponInfoExample example);
	
	public List<CouponInfo> getObjectList(CouponInfoExample example);
	
	public Integer getObjectListCount(CouponInfoExample example);
}
