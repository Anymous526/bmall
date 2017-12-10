package com.amall.core.service.dreampartnercash;

import java.util.List;

import com.amall.core.bean.DreamPartnerCash;
import com.amall.core.bean.DreamPartnerCashExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IDreamPartnerCashService</p>
 * <p>Description: 活动信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:29:29
 * @version 1.0
 */
public abstract interface IDreamPartnerCashService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param DreamPartnerCash
	 * @return
	 */
	public Integer add(DreamPartnerCash example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public DreamPartnerCash getByKey(Long id);
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
	public Integer deleteByExample(DreamPartnerCashExample example);
	
	
	public List<DreamPartnerCash> getObjectList(DreamPartnerCashExample example);
	
	public Integer getObjectListCount(DreamPartnerCashExample example);
	
	public Pagination getObjectListWithPage(DreamPartnerCashExample example);

	public Integer updateByObject(DreamPartnerCash record);
}
