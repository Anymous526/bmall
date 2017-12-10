package com.amall.core.service.integral;

import java.util.List;

import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IIntegralGoodsService</p>
 * <p>Description: 积分商品管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:07:31
 * @version 1.0
 */
public abstract interface IIntegralGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param IntegralGoods
	 * @return
	 */
	public Long add(IntegralGoods example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public IntegralGoods getByKey(Long id);
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
	public Integer deleteByExample(IntegralGoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(IntegralGoods record);
	
	public Pagination getObjectListWithPage(IntegralGoodsExample example);
	
	public List<IntegralGoods> getObjectList(IntegralGoodsExample example);
	
	public Integer getObjectListCount(IntegralGoodsExample example);
	
	/**
	 * 
	 * @todo 免费兑换页面banner商品类型个数
	 * @author wsw
	 * @date 2015年7月10日 上午10:39:37
	 * @return List<IntegralGoods>
	 * @param max
	 * @return
	 */
	public List<IntegralGoods> selectGoodsClassNameByGcIdAndTimeDesc(int max);
	
}
