package com.amall.core.service.spare;

import java.util.List;

import com.amall.core.bean.SpareGoodsClass;
import com.amall.core.bean.SpareGoodsClassExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ISpareGoodsClassService</p>
 * <p>Description: 闲置商品类型管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:19:41
 * @version 1.0
 */
public abstract interface ISpareGoodsClassService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SpareGoodsClass
	 * @return
	 */
	public Long add(SpareGoodsClass example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SpareGoodsClass getByKey(Long id);
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
	public Integer deleteByExample(SpareGoodsClassExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SpareGoodsClass record);
	
	public Pagination getObjectListWithPage(SpareGoodsClassExample example);
	
	public List<SpareGoodsClass> getObjectList(SpareGoodsClassExample example);
	
	public Integer getObjectListCount(SpareGoodsClassExample example);
}
