package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.MutualBenefitExample;
import com.amall.core.bean.MutualBenefit;
import com.amall.core.web.page.Pagination;

public interface IMutualBenefitService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param MutualBenefit
	 * @return
	 */
	public Long add(MutualBenefit example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public MutualBenefit getByKey(Long id);
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
	public Integer deleteByExample(MutualBenefitExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(MutualBenefit record);
	
	public Pagination getObjectListWithPage(MutualBenefitExample example);
	
	public List<MutualBenefit> getObjectList(MutualBenefitExample example);
	
	public Integer getObjectListCount(MutualBenefitExample example);
	
}
