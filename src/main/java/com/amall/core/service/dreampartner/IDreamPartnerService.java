package com.amall.core.service.dreampartner;

import java.util.List;

import com.amall.core.bean.DreamPartner;
import com.amall.core.bean.DreamPartnerExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IDreamPartnerService</p>
 * <p>Description: 活动信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:29:29
 * @version 1.0
 */
public abstract interface IDreamPartnerService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param DreamPartner
	 * @return
	 */
	public Integer add(DreamPartner example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public DreamPartner getByKey(Long id);
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
	public Integer deleteByExample(DreamPartnerExample example);
	
	
	public List<DreamPartner> getObjectList(DreamPartnerExample example);
	
	public Integer getObjectListCount(DreamPartnerExample example);
	
	public Pagination getObjectListWithPage(DreamPartnerExample example);

	public Integer updateByObject(DreamPartner record);
	
	int countByExample(DreamPartnerExample example);
}
