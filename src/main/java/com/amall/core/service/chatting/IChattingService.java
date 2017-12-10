package com.amall.core.service.chatting;

import java.util.List;
import java.util.Map;
import com.amall.core.bean.Chatting;
import com.amall.core.bean.ChattingExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IChattingService</p>
 * <p>Description: 聊天管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:19:36
 * @version 1.0
 */
public abstract interface IChattingService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Chatting
	 * @return
	 */
	public Long add(Chatting example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Chatting getByKey(Long id);
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
	public Integer deleteByExample(ChattingExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Chatting record);
	
	public Pagination getObjectListWithPage(ChattingExample example);
	
	public List<Chatting> getObjectList(ChattingExample example);
	
	public Integer getObjectListCount(ChattingExample example);
	/**
	 * 
	 * <p>Title: selectChattings</p>
	 * <p>Description: 根据键值对userId查询Chatting记录</p>
	 * @param map
	 * @return
	 */
	public List<Chatting> selectChatting(Map<? extends Object,? extends Object> map);//map键设为userId
}
