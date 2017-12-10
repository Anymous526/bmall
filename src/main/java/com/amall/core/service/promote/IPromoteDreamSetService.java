package com.amall.core.service.promote;

import java.math.BigDecimal;
import java.util.List;

import com.amall.core.bean.PromoteDreamSetExample;
import com.amall.core.bean.PromoteDreamSet;

public interface IPromoteDreamSetService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PromoteDreamSetViewVo
	 * @return
	 */
	public Integer add(PromoteDreamSet example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PromoteDreamSet getByKey(Long id);
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
	public Integer deleteByExample(PromoteDreamSetExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PromoteDreamSet record);
	
	public List<PromoteDreamSet> getObjectList(PromoteDreamSetExample example);
	
	public Integer getObjectListCount(PromoteDreamSetExample example);
	
	public BigDecimal getRate();
}
