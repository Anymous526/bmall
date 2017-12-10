package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.ExpressCompany;
import com.amall.core.bean.ExpressCompanyExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IExpressCompanyService</p>
 * <p>Description: 快递公司管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:35:25
 * @version 1.0
 */
public  interface IExpressCompanyService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ExpressCompany
	 * @return
	 */
	public Long add(ExpressCompany example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ExpressCompany getByKey(Long id);
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
	public Integer deleteByExample(ExpressCompanyExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ExpressCompany record);
	
	public Pagination getObjectListWithPage(ExpressCompanyExample example);
	
	public List<ExpressCompany> getObjectList(ExpressCompanyExample example);
	
	public Integer getObjectListCount(ExpressCompanyExample example);
}
