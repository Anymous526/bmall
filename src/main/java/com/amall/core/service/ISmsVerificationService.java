package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.SmsVerification;
import com.amall.core.bean.SmsVerificationExample;

/**
 * 
 * <p>Title: ISmsVerificationService</p>
 * <p>Description: 短信验证</p>
 * <p>Company: www.amall.com</p> 
 * @author  tangxiang
 * @date	2015-07-28
 * @version 1.0
 */
public  interface ISmsVerificationService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SnsFriend
	 * @return
	 */
	public Long add(SmsVerification example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SmsVerification getByKey(Long id);
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
	public Integer deleteByExample(SmsVerificationExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SmsVerification record);
	
	public List<SmsVerification> getObjectList(SmsVerificationExample example);
	
	public Integer getObjectListCount(SmsVerificationExample example);
}
