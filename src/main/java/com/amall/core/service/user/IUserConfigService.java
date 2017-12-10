package com.amall.core.service.user;

import java.util.List;

import com.amall.core.bean.UserConfig;
import com.amall.core.bean.UserConfigExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IUserConfigService</p>
 * <p>Description: 用户信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29上午11:29:35
 * @version 1.0
 */
public  interface IUserConfigService{
	public  UserConfig getUserConfig();
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param UserConfig
	 * @return
	 */
	public Long add(UserConfig example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public UserConfig getByKey(Long id);
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
	public Integer deleteByExample(UserConfigExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(UserConfig record);
	
	public Pagination getObjectListWithPage(UserConfigExample example);
	
	public List<UserConfig> getObjectList(UserConfigExample example);
	
	public Integer getObjectListCount(UserConfigExample example);
}
