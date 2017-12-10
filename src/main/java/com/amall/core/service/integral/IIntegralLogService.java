package com.amall.core.service.integral;

import java.util.List;

import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.IntegralLogExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IIntegralLogService</p>
 * <p>Description: 积分日志管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29上午11:46:28
 * @version 1.0
 */
public abstract interface IIntegralLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param IntegralLog
	 * @return
	 */
	public Long add(IntegralLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public IntegralLog getByKey(Long id);
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
	public Integer deleteByExample(IntegralLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(IntegralLog record);
	
	public Pagination getObjectListWithPage(IntegralLogExample example);
	
	public List<IntegralLog> getObjectList(IntegralLogExample example);
	
	public Integer getObjectListCount(IntegralLogExample example);
}
