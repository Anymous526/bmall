package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStoreGradeService</p>
 * <p>Description: 店铺等级管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:07:13
 * @version 1.0
 */
public abstract interface IStoreGradeService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreGrade
	 * @return
	 */
	public Long add(StoreGrade example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreGrade getByKey(Long id);
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
	public Integer deleteByExample(StoreGradeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreGrade record);
	
	public Pagination getObjectListWithPage(StoreGradeExample example);
	
	public List<StoreGrade> getObjectList(StoreGradeExample example);
	
	public Integer getObjectListCount(StoreGradeExample example);
}
