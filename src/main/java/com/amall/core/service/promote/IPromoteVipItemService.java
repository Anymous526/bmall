package com.amall.core.service.promote;

import java.util.List;

import com.amall.core.bean.PromoteVipItemExample;
import com.amall.core.bean.PromoteVipItem;
import com.amall.core.web.page.Pagination;

public interface IPromoteVipItemService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PromoteVipItemViewVo
	 * @return
	 */
	public Integer add(PromoteVipItem example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PromoteVipItem getByKey(Long id);
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
	public Integer deleteByExample(PromoteVipItemExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PromoteVipItem record);
	
	public Pagination getObjectListWithPage(PromoteVipItemExample example);
	
	public List<PromoteVipItem> getObjectList(PromoteVipItemExample example);
	
	public Integer getObjectListCount(PromoteVipItemExample example);
	
}
