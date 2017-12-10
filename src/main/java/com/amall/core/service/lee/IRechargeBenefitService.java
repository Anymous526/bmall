package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.RechargeBenefitExample;
import com.amall.core.bean.RechargeBenefit;
import com.amall.core.web.page.Pagination;

public interface IRechargeBenefitService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param RechargeBenefit
	 * @return
	 */
	public Long add(RechargeBenefit example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public RechargeBenefit getByKey(Long id);
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
	public Integer deleteByExample(RechargeBenefitExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(RechargeBenefit record);
	
	public Pagination getObjectListWithPage(RechargeBenefitExample example);
	
	public List<RechargeBenefit> getObjectList(RechargeBenefitExample example);
	
	public Integer getObjectListCount(RechargeBenefitExample example);
	
}
