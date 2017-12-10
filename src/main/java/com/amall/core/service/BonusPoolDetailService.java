package com.amall.core.service;

import java.util.List;
import com.amall.core.bean.WeekBenifitDetail;
import com.amall.core.bean.WeekBenifitDetailExample;

/**
 * <p>Title: IWeekBenefitService</p>
 * <p>Description: 全球分红池详情service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  liuguo
 * @date	2017/10/11   14:26
 * @version 1.0
 */
public interface BonusPoolDetailService
{

	public Integer add (WeekBenifitDetail record);


	public Integer countByExample (	WeekBenifitDetailExample example);


	public List <WeekBenifitDetail> queryBenifutDetail (WeekBenifitDetailExample example);


	public WeekBenifitDetail queryBenifutDetails (	WeekBenifitDetailExample example);


	public Integer deleteByExample (WeekBenifitDetailExample example);


	public Integer deleteByPrimaryKey (	Long id);


	public WeekBenifitDetail selectByPrimaryKey (	Long id);


	public Integer updateByObject (	WeekBenifitDetail record);
	
	public int updateExample(WeekBenifitDetail record,WeekBenifitDetailExample example);
}
