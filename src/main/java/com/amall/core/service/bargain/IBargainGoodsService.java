package com.amall.core.service.bargain;

import java.util.List;

import com.amall.core.bean.BargainGoods;
import com.amall.core.bean.BargainGoodsExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IBargainGoodsService</p>
 * <p>Description: 特价商品管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:13:49
 * @version 1.0
 */
public abstract interface IBargainGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param BargainGoods
	 * @return
	 */
	public Long add(BargainGoods example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public BargainGoods getByKey(Long id);
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
	public Integer deleteByExample(BargainGoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(BargainGoods record);
	
	public Pagination getObjectListWithPage(BargainGoodsExample example);
	
	public List<BargainGoods> getObjectList(BargainGoodsExample example);
	
	public Integer getObjectListCount(BargainGoodsExample example);
}
