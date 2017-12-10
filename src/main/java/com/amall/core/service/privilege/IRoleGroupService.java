package com.amall.core.service.privilege;

import java.util.List;

import com.amall.core.bean.RoleGroup;
import com.amall.core.bean.RoleGroupExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IRoleGroupService</p>
 * <p>Description: 角色分组管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:25:45
 * @version 1.0	
 */
public abstract interface IRoleGroupService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param RoleGroup
	 * @return
	 */
	public Long add(RoleGroup example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public RoleGroup getByKey(Long id);
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
	public Integer deleteByExample(RoleGroupExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(RoleGroup record);
	
	public Pagination getObjectListWithPage(RoleGroupExample example);
	
	public List<RoleGroup> getObjectList(RoleGroupExample example);
	
	public Integer getObjectListCount(RoleGroupExample example);
	
}
