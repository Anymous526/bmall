package com.amall.core.service.privilege;

import java.util.List;

import com.amall.core.bean.Role2Res;
import com.amall.core.bean.Role2ResExample;

public interface IRole2ResService {
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Long add(Role2Res example);

	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(Role2ResExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Role2Res record);
	
	public List<Role2Res> getObjectList(Role2ResExample example);
	
	public Integer getObjectListCount(Role2ResExample example);
}
