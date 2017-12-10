package com.amall.core.service.chatting;

import java.util.List;

import com.amall.core.bean.ChattingFriend;
import com.amall.core.bean.ChattingFriendExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IChattingFriendService</p>
 * <p>Description: 聊天交友service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:16:42
 * @version 1.0
 */
public abstract interface IChattingFriendService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ChattingFriend
	 * @return
	 */
	public Long add(ChattingFriend example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ChattingFriend getByKey(Long id);
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
	public Integer deleteByExample(ChattingFriendExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ChattingFriend record);
	
	public Pagination getObjectListWithPage(ChattingFriendExample example);
	
	public List<ChattingFriend> getObjectList(ChattingFriendExample example);
	
	public Integer getObjectListCount(ChattingFriendExample example);
}
