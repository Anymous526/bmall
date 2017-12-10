package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsBrandCategory;
import com.amall.core.bean.GoodsBrandCategoryExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsBrandCategoryService</p>
 * <p>Description: 商品品牌种类管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:40:31
 * @version 1.0
 */
public abstract interface IGoodsBrandCategoryService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsBrandCategory
	 * @return
	 */
	public Long add(GoodsBrandCategory example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsBrandCategory getByKey(Long id);
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
	public Integer deleteByExample(GoodsBrandCategoryExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsBrandCategory record);
	
	public Pagination getObjectListWithPage(GoodsBrandCategoryExample example);
	
	public List<GoodsBrandCategory> getObjectList(GoodsBrandCategoryExample example);
	
	public Integer getObjectListCount(GoodsBrandCategoryExample example);
}
