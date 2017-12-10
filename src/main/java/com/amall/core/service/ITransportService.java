package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.TransportExample;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.web.page.Pagination;

public abstract interface ITransportService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Transport
	 * @return
	 */
	public Long add(TransportWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public TransportWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(TransportExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(TransportWithBLOBs record);
	
	public Pagination getObjectListWithPage(TransportExample example);
	
	public List<TransportWithBLOBs> getObjectList(TransportExample example);
	
	public Integer getObjectListCount(TransportExample example);
}
