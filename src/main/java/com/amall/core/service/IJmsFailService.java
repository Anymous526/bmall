package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.JmsFail;
import com.amall.core.bean.JmsFailExample;

public abstract interface IJmsFailService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param JmsFail
	 * @return
	 */
	public Integer add(JmsFail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public JmsFail getByKey(Long id);
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
	public Integer deleteByExample(JmsFailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(JmsFail record);
	
	public List<JmsFail> getObjectList(JmsFailExample example);
	
	public Integer getObjectListCount(JmsFailExample example);
}
