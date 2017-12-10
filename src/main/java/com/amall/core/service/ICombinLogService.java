package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.CombinLog;
import com.amall.core.bean.CombinLogExample;
import com.amall.core.web.page.Pagination;

public abstract interface ICombinLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CombinLog
	 * @return
	 */
	public Long add(CombinLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CombinLog getByKey(Long id);
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
	public Integer deleteByExample(CombinLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CombinLog record);
	
	public Pagination getObjectListWithPage(CombinLogExample example);
	
	public List<CombinLog> getObjectList(CombinLogExample example);
	
	public Integer getObjectListCount(CombinLogExample example);
}
