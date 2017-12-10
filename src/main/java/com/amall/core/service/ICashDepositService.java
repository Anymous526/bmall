package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.CashDeposit;
import com.amall.core.bean.CashDepositExample;
import com.amall.core.web.page.Pagination;

public abstract interface ICashDepositService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param CashDeposit
	 * @return
	 */
	public Integer add(CashDeposit example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public CashDeposit getByKey(Long id);
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
	public Integer deleteByExample(CashDepositExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(CashDeposit record);
	
	public Pagination getObjectListWithPage(CashDepositExample example);
	
	public List<CashDeposit> getObjectList(CashDepositExample example);
	
	public Integer getObjectListCount(CashDepositExample example);
}
