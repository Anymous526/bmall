package com.amall.core.service.group;

import java.util.List;

import com.amall.core.bean.Group;
import com.amall.core.bean.GroupExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGroupService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Group
	 * @return
	 */
	public Long add(Group example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Group getByKey(Long id);
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
	public Integer deleteByExample(GroupExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Group record);
	
	public Pagination getObjectListWithPage(GroupExample example);
	
	public List<Group> getObjectList(GroupExample example);
	
	public Integer getObjectListCount(GroupExample example);
}
