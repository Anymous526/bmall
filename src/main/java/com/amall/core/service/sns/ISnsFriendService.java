package com.amall.core.service.sns;

import java.util.List;

import com.amall.core.bean.SnsFriend;
import com.amall.core.bean.SnsFriendExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ISnsFriendService</p>
 * <p>Description: 好友管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:20:40
 * @version 1.0
 */
public  interface ISnsFriendService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SnsFriend
	 * @return
	 */
	public Long add(SnsFriend example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SnsFriend getByKey(Long id);
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
	public Integer deleteByExample(SnsFriendExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SnsFriend record);
	
	public Pagination getObjectListWithPage(SnsFriendExample example);
	
	public List<SnsFriend> getObjectList(SnsFriendExample example);
	
	public Integer getObjectListCount(SnsFriendExample example);
}
