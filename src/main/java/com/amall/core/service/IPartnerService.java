package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Partner;
import com.amall.core.bean.PartnerExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IPartnerService</p>
 * <p>Description: 合作伙伴（友情链接）管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:25:39
 * @version 1.0
 */
public  interface IPartnerService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Partner
	 * @return
	 */
	public Long add(Partner example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Partner getByKey(Long id);
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
	public Integer deleteByExample(PartnerExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Partner record);
	
	public Pagination getObjectListWithPage(PartnerExample example);
	
	public List<Partner> getObjectList(PartnerExample example);
	
	public Integer getObjectListCount(PartnerExample example);
}
