package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.StoreGradeLog;
import com.amall.core.bean.StoreGradeLogExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IStoreGradeLogService</p>
 * <p>Description: 店铺等级日志管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:08:00
 * @version 1.0
 */
public abstract interface IStoreGradeLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param StoreGradeLog
	 * @return
	 */
	public Long add(StoreGradeLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public StoreGradeLog getByKey(Long id);
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
	public Integer deleteByExample(StoreGradeLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(StoreGradeLog record);
	
	public Pagination getObjectListWithPage(StoreGradeLogExample example);
	
	public List<StoreGradeLog> getObjectList(StoreGradeLogExample example);
	
	public Integer getObjectListCount(StoreGradeLogExample example);
}
