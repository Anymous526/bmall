package com.amall.core.service.systemmsg;

import java.util.List;

import com.amall.core.bean.SystemMsg;
import com.amall.core.bean.SystemMsgExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ISystemMsgService</p>
 * <p>Description: 活动信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:29:29
 * @version 1.0
 */
public abstract interface ISystemMsgService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SystemMsg
	 * @return
	 */
	public Integer add(SystemMsg example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SystemMsg getByKey(Long id);
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
	public Integer deleteByExample(SystemMsgExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SystemMsg record);
	
	public Pagination getObjectListWithPage(SystemMsgExample example);
	
	public List<SystemMsg> getObjectList(SystemMsgExample example);
	
	public Integer getObjectListCount(SystemMsgExample example);
}
