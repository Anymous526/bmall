package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Dynamic;
import com.amall.core.bean.DynamicExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IDynamicService</p>
 * <p>Description: 动态管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:33:30
 * @version 1.0
 */
public  interface IDynamicService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Dynamic
	 * @return
	 */
	public Long add(Dynamic example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Dynamic getByKey(Long id);
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
	public Integer deleteByExample(DynamicExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Dynamic record);
	
	public Pagination getObjectListWithPage(DynamicExample example);
	
	public List<Dynamic> getObjectList(DynamicExample example);
	
	public Integer getObjectListCount(DynamicExample example);
}
