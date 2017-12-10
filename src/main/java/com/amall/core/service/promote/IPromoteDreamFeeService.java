package com.amall.core.service.promote;

import java.util.List;

import com.amall.core.bean.PromoteDreamFeeExample;
import com.amall.core.bean.PromoteDreamFee;

public interface IPromoteDreamFeeService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PromoteDreamFeeViewVo
	 * @return
	 */
	public Integer add(PromoteDreamFee example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PromoteDreamFee getByKey(Long id);
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
	public Integer deleteByExample(PromoteDreamFeeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PromoteDreamFee record);
	
	public List<PromoteDreamFee> getObjectList(PromoteDreamFeeExample example);
	
	public Integer getObjectListCount(PromoteDreamFeeExample example);
	
}
