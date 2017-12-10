package com.amall.core.service.privilege;

import java.util.List;

import com.amall.core.bean.Role;
import com.amall.core.bean.RoleExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IRoleService</p>
 * <p>Description: 角色管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:24:55
 * @version 1.0
 */
public abstract interface IRoleService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Role
	 * @return
	 */
	public Long add(Role example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Role getByKey(Long id);
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
	public Integer deleteByExample(RoleExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Role record);
	
	public Pagination getObjectListWithPage(RoleExample example);
	
	public List<Role> getObjectList(RoleExample example);
	
	public Integer getObjectListCount(RoleExample example);
	
	public List<Role> getRolesToUserByUserIdAndDisplay(long id);
	
}
