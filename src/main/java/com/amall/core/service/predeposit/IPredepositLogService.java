package com.amall.core.service.predeposit;

import java.util.List;

import com.amall.core.bean.PredepositLog;
import com.amall.core.bean.PredepositLogExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IPredepositLogService</p>
 * <p>Description: 预存日志管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午11:51:47
 * @version 1.0
 */
public abstract interface IPredepositLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PredepositLog
	 * @return
	 */
	public Long add(PredepositLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PredepositLog getByKey(Long id);
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
	public Integer deleteByExample(PredepositLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PredepositLog record);
	
	public Pagination getObjectListWithPage(PredepositLogExample example);
	
	public List<PredepositLog> getObjectList(PredepositLogExample example);
	
	public Integer getObjectListCount(PredepositLogExample example);
}
