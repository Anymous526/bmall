package com.amall.core.service.group;

import java.util.List;

import com.amall.core.bean.GroupArea;
import com.amall.core.bean.GroupAreaExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGroupAreaService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GroupArea
	 * @return
	 */
	public Long add(GroupArea example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GroupArea getByKey(Long id);
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
	public Integer deleteByExample(GroupAreaExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GroupArea record);
	
	public Pagination getObjectListWithPage(GroupAreaExample example);
	
	public List<GroupArea> getObjectList(GroupAreaExample example);
	
	public Integer getObjectListCount(GroupAreaExample example);
}
