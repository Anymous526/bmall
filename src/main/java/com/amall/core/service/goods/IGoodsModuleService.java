package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsModule;
import com.amall.core.bean.GoodsModuleExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsModuleService</p>
 * <p>Description: 商品所属模块service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ygq
 * @date	2016-2-15下午2:49:08
 * @version 1.0
 */
public abstract interface IGoodsModuleService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsModule
	 * @return
	 */
	public Long add(GoodsModule example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsModule getByKey(Long id);
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
	public Integer deleteByExample(GoodsModuleExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsModule record);
	
	public List<GoodsModule> getObjectList(GoodsModuleExample example);
	
	public Pagination getObjectListWithPage(GoodsModuleExample example);
	
	public Integer getObjectListCount(GoodsModuleExample example);
	
}
