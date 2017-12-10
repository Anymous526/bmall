package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsPoint;
import com.amall.core.bean.GoodsPointExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsPointService</p>
 * <p>Description: 商品评分管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:00:18
 * @version 1.0
 */
public abstract interface IGoodsPointService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsPoint
	 * @return
	 */
	public Long add(GoodsPoint example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsPoint getByKey(Long id);
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
	public Integer deleteByExample(GoodsPointExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsPoint record);
	
	public Pagination getObjectListWithPage(GoodsPointExample example);
	
	public List<GoodsPoint> getObjectList(GoodsPointExample example);
	
	public Integer getObjectListCount(GoodsPointExample example);
}
