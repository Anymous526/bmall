package com.amall.core.service.group;

import java.util.List;

import com.amall.core.bean.GroupClass;
import com.amall.core.bean.GroupClassExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGroupClassService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GroupClass
	 * @return
	 */
	public Long add(GroupClass example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GroupClass getByKey(Long id);
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
	public Integer deleteByExample(GroupClassExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GroupClass record);
	
	public Pagination getObjectListWithPage(GroupClassExample example);
	
	public List<GroupClass> getObjectList(GroupClassExample example);
	
	public Integer getObjectListCount(GroupClassExample example);
	
	public List<GroupClass> selectByExampleWithPage(GroupClassExample example);//需要查询分页信息，查询前几列团购
}
