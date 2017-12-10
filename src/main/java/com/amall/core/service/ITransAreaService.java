package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.TransArea;
import com.amall.core.bean.TransAreaExample;
import com.amall.core.web.page.Pagination;

public abstract interface ITransAreaService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param TransArea
	 * @return
	 */
	public Long add(TransArea example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public TransArea getByKey(Long id);
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
	public Integer deleteByExample(TransAreaExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(TransArea record);
	
	public Pagination getObjectListWithPage(TransAreaExample example);
	
	public List<TransArea> getObjectList(TransAreaExample example);
	
	public Integer getObjectListCount(TransAreaExample example);
}
