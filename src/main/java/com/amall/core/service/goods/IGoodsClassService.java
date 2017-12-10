package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsClassExample;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.bean.GoodsSpecial;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsClassService</p>
 * <p>Description: 商品类型管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:21:55
 * @version 1.0
 */
public abstract interface IGoodsClassService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsClass
	 * @return
	 */
	public Long add(GoodsClassWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsClassWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(GoodsClassExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsClassWithBLOBs record);
	
	public Pagination getObjectListWithPage(GoodsClassExample example);
	
	public List<GoodsClassWithBLOBs> getObjectList(GoodsClassExample example);
	
	public Integer getObjectListCount(GoodsClassExample example);
	
	public List<GoodsSpecial> selectClass(Integer id);
}
