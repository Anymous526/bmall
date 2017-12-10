package com.amall.core.service.chatting;

import java.util.List;

import com.amall.core.bean.ChattingLog;
import com.amall.core.bean.ChattingLogExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IChattingLogService</p>
 * <p>Description: 聊天日志管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:17:25
 * @version 1.0
 */
public abstract interface IChattingLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ChattingLog
	 * @return
	 */
	public Long add(ChattingLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ChattingLog getByKey(Long id);
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
	public Integer deleteByExample(ChattingLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ChattingLog record);
	
	public Pagination getObjectListWithPage(ChattingLogExample example);
	
	public List<ChattingLog> getObjectList(ChattingLogExample example);
	
	public Integer getObjectListCount(ChattingLogExample example);
	
	public List<ChattingLog> selectLogsByMarkAndUser1Id(long user1Id);
}
