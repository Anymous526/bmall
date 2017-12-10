package com.amall.core.service.promote;

import java.math.BigDecimal;
import java.util.List;

import com.amall.core.bean.PromoteVipRankExample;
import com.amall.core.bean.PromoteVipRank;
import com.amall.core.web.page.Pagination;

public interface IPromoteVipRankService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PromoteVipRankViewVo
	 * @return
	 */
	public Integer add(PromoteVipRank example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PromoteVipRank getByKey(Long id);
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
	public Integer deleteByExample(PromoteVipRankExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PromoteVipRank record);
	
	public Pagination getObjectListWithPage(PromoteVipRankExample example);
	
	public List<PromoteVipRank> getObjectList(PromoteVipRankExample example);
	
	public Integer getObjectListCount(PromoteVipRankExample example);
	
	/**
	 * 查询当月推广总额
	 * @return
	 */
	public BigDecimal selectTotalFee();
}
