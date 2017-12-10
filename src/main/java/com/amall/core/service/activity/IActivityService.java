package com.amall.core.service.activity;

import java.util.List;

import com.amall.core.bean.Activity;
import com.amall.core.bean.ActivityExample;
import com.amall.core.web.page.Pagination;


/**
 * 
 * <p>Title: IActivityService</p>
 * <p>Description: 活动 管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月3日下午12:04:38
 * @version 1.0
 */
public  interface IActivityService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param activity
	 * @return
	 */
	public Long add(Activity activity);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Activity getByKey(Long id);
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
	public Integer deleteByExample(ActivityExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Activity record);
	
	public Pagination getObjectListWithPage(ActivityExample example);
	
	public List<Activity> getObjectList(ActivityExample example);
	
	public Integer getObjectListCount(ActivityExample example);
	

}
