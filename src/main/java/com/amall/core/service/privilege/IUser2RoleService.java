package com.amall.core.service.privilege;

import java.util.List;

import com.amall.core.bean.User2Role;
import com.amall.core.bean.User2RoleExample;


/**
 * 用户与 角色关联中间表 service
 * @author ljx
 *
 */
public interface IUser2RoleService {
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Long add(User2Role example);

	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(User2RoleExample example);
	
	
	public List<User2Role> getObjectList(User2RoleExample example);
	
}
