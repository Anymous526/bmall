package com.amall.core.service.promote;

import java.util.List;

import com.amall.core.bean.PromoteVipHistoryExample;
import com.amall.core.bean.PromoteVipHistory;
import com.amall.core.web.page.Pagination;

public interface IPromoteVipHistoryService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PromoteVipHistoryViewVo
	 * @return
	 */
	public Integer add(PromoteVipHistory example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PromoteVipHistory getByKey(Long id);
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
	public Integer deleteByExample(PromoteVipHistoryExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PromoteVipHistory record);
	
	public Pagination getObjectListWithPage(PromoteVipHistoryExample example);
	
	public List<PromoteVipHistory> getObjectList(PromoteVipHistoryExample example);
	
	public Integer getObjectListCount(PromoteVipHistoryExample example);
	
}
