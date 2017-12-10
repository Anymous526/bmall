package com.amall.core.service.gold;

import java.util.List;

import com.amall.core.bean.GoldRecordExample;
import com.amall.core.bean.GoldRecordWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoldRecordService</p>
 * <p>Description: 金币记录管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:39:17
 * @version 1.0
 */
public abstract interface IGoldRecordService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoldRecord
	 * @return
	 */
	public Long add(GoldRecordWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoldRecordWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(GoldRecordExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoldRecordWithBLOBs record);
	
	public Pagination getObjectListWithPage(GoldRecordExample example);
	
	public List<GoldRecordWithBLOBs> getObjectList(GoldRecordExample example);
	
	public Integer getObjectListCount(GoldRecordExample example);
}
