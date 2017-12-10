package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.ConsultExample;
import com.amall.core.bean.ConsultWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>
 * Title: IConsultService
 * </p>
 * <p>
 * Description: 咨询管理service
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-5-1上午12:24:54
 * @version 1.0
 */
public abstract interface IConsultService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Consult
	 * @return
	 */
	public Long add(ConsultWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ConsultWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(ConsultExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ConsultWithBLOBs record);
	
	public Pagination getObjectListWithPage(ConsultExample example);
	
	public List<ConsultWithBLOBs> getObjectList(ConsultExample example);
	
	public Integer getObjectListCount(ConsultExample example);
}
