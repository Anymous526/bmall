package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Visit;
import com.amall.core.bean.VisitExample;
import com.amall.core.web.page.Pagination;

public abstract interface IVisitService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Visit
	 * @return
	 */
	public Long add(Visit example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Visit getByKey(Long id);
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
	public Integer deleteByExample(VisitExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Visit record);
	
	public Pagination getObjectListWithPage(VisitExample example);
	
	public List<Visit> getObjectList(VisitExample example);
	
	public Integer getObjectListCount(VisitExample example);
}
