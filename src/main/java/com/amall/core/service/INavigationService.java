package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: INavigationService</p>
 * <p>Description: 导航信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:31:42
 * @version 1.0
 */
public abstract interface INavigationService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Navigation
	 * @return
	 */
	public Long add(Navigation example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Navigation getByKey(Long id);
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
	public Integer deleteByExample(NavigationExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Navigation record);
	
	public Pagination getObjectListWithPage(NavigationExample example);
	
	public List<Navigation> getObjectList(NavigationExample example);
	
	public Integer getObjectListCount(NavigationExample example);
}
