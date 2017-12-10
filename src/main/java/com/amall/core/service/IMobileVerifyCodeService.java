package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.MobileVerifyCode;
import com.amall.core.bean.MobileVerifyCodeExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IMobileVerifyCodeService</p>
 * <p>Description: 手机验证信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:06:41
 * @version 1.0
 */
public abstract interface IMobileVerifyCodeService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param MobileVerifyCode
	 * @return
	 */
	public Long add(MobileVerifyCode example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public MobileVerifyCode getByKey(Long id);
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
	public Integer deleteByExample(MobileVerifyCodeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(MobileVerifyCode record);
	
	public Pagination getObjectListWithPage(MobileVerifyCodeExample example);
	
	public List<MobileVerifyCode> getObjectList(MobileVerifyCodeExample example);
	
	public Integer getObjectListCount(MobileVerifyCodeExample example);
}
