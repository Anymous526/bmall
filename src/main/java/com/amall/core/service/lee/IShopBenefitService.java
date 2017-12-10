package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.ShopBenefitExample;
import com.amall.core.bean.ShopBenefit;
import com.amall.core.web.page.Pagination;

public interface IShopBenefitService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ShopBenefit
	 * @return
	 */
	public Long add(ShopBenefit example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ShopBenefit getByKey(Long id);
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
	public Integer deleteByExample(ShopBenefitExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ShopBenefit record);
	
	public Pagination getObjectListWithPage(ShopBenefitExample example);
	
	public List<ShopBenefit> getObjectList(ShopBenefitExample example);
	
	public Integer getObjectListCount(ShopBenefitExample example);
	
}
