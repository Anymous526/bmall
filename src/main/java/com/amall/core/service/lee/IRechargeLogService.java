package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.RechargeLogExample;
import com.amall.core.bean.RechargeLog;
import com.amall.core.web.page.Pagination;

public interface IRechargeLogService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param RechargeLog
	 * @return
	 */
	public Long add(RechargeLog example);
	
	public int addGold(RechargeLog log);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public RechargeLog getByKey(Long id);
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
	public Integer deleteByExample(RechargeLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(RechargeLog record);
	
	public Pagination getObjectListWithPage(RechargeLogExample example);
	
	public List<RechargeLog> getObjectList(RechargeLogExample example);
	
	public Integer getObjectListCount(RechargeLogExample example);
	
}
