package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Message;
import com.amall.core.bean.MessageExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IMessageService</p>
 * <p>Description: 消息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:30:25
 * @version 1.0
 */
public abstract interface IMessageService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Message
	 * @return
	 */
	public Long add(Message example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Message getByKey(Long id);
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
	public Integer deleteByExample(MessageExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Message record);
	
	public Pagination getObjectListWithPage(MessageExample example);
	
	public List<Message> getObjectList(MessageExample example);
	
	public Integer getObjectListCount(MessageExample example);
}
