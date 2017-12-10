package com.amall.core.service.system;

import java.util.List;

import com.amall.core.bean.SysLog;
import com.amall.core.bean.SysLogExample;
import com.amall.core.web.page.Pagination;


/**
 * 
 * <p>Title: ISysLogService</p>
 * <p>Description: 系统操作日志service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-27下午6:05:31
 * @version 1.0
 */
public  interface ISysLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SysLog
	 * @return
	 */
	public Long add(SysLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SysLog getByKey(Long id);
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
	public Integer deleteByExample(SysLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SysLog record);
	
	public Pagination getObjectListWithPage(SysLogExample example);
	
	public List<SysLog> getObjectList(SysLogExample example);
	
	public Integer getObjectListCount(SysLogExample example);
}
