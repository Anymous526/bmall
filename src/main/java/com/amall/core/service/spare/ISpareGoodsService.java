package com.amall.core.service.spare;

import java.util.List;

import com.amall.core.bean.SpareGoodsExample;
import com.amall.core.bean.SpareGoodsWithBLOBs;
import com.amall.core.web.page.Pagination;

	/**
	 * 
	 * <p>Title: ISpareGoodsService</p>
	 * <p>Description: 闲置商品管理service</p>
	 * <p>Company: www.hg-sem.com</p> 
	 * @author  ljx
	 * @date	2015-4-29下午7:12:15
	 * @version 1.0
	 */
	public abstract interface ISpareGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SpareGoods
	 * @return
	 */
	public Long add(SpareGoodsWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SpareGoodsWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(SpareGoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SpareGoodsWithBLOBs record);
	
	public Pagination getObjectListWithPage(SpareGoodsExample example);
	
	public List<SpareGoodsWithBLOBs> getObjectList(SpareGoodsExample example);
	
	public Integer getObjectListCount(SpareGoodsExample example);
}
