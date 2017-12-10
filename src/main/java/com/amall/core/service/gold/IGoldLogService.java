package com.amall.core.service.gold;

import java.util.List;

import com.amall.core.bean.GoldLogExample;
import com.amall.core.bean.GoldLogWithBLOBs;
import com.amall.core.web.page.Pagination;

public abstract interface IGoldLogService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoldLog
	 * @return
	 */
	public Long add(GoldLogWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoldLogWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(GoldLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoldLogWithBLOBs record);
	
	public Pagination getObjectListWithPage(GoldLogExample example);
	
	public List<GoldLogWithBLOBs> getObjectList(GoldLogExample example);
	
	public Integer getObjectListCount(GoldLogExample example);
}
