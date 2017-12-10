package com.amall.core.service.systemmsgrecord;

import java.util.List;

import com.amall.core.bean.SystemMsgRecord;
import com.amall.core.bean.SystemMsgRecordExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ISystemMsgRecordService</p>
 * <p>Description: 活动信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:29:29
 * @version 1.0
 */
public abstract interface ISystemMsgRecordService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SystemMsgRecord
	 * @return
	 */
	public Integer add(SystemMsgRecord example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SystemMsgRecord getByKey(Long id);
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
	public Integer deleteByExample(SystemMsgRecordExample example);
	
	
	public List<SystemMsgRecord> getObjectList(SystemMsgRecordExample example);
	
	public Integer getObjectListCount(SystemMsgRecordExample example);
	
	public Pagination getObjectListWithPage(SystemMsgRecordExample example);

	public Integer updateByObject(SystemMsgRecord record);
}
