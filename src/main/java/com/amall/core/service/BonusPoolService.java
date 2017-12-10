package com.amall.core.service;

import java.util.List;
import com.amall.core.bean.WeekBenifit;
import com.amall.core.bean.WeekBenifitExample;

/**
 * <p>Title: IWeekBenefitService</p>
 * <p>Description: 全球分红池service</p>
 * @author  liuguo
 * @date	2017/10/12   14:26
 * @version 1.0
 */
public interface BonusPoolService
{

	public Integer add (WeekBenifit record);


	public Integer countByExample (	WeekBenifitExample example);


	public Integer deleteByExample (WeekBenifitExample example);


	public Integer deleteByPrimaryKey (	Long id);


	public List <WeekBenifit> query (	WeekBenifitExample weekBenifitExample);


	public WeekBenifit selectByPrimaryKey (	Long id);


	public Integer updateByObject (	WeekBenifit record);
}
