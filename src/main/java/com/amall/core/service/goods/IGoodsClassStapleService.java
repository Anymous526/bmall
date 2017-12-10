package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsClassStaple;
import com.amall.core.bean.GoodsClassStapleExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsClassStapleService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsClassStaple
	 * @return
	 */
	public Long add(GoodsClassStaple example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsClassStaple getByKey(Long id);
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
	public Integer deleteByExample(GoodsClassStapleExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsClassStaple record);
	
	public Pagination getObjectListWithPage(GoodsClassStapleExample example);
	
	public List<GoodsClassStaple> getObjectList(GoodsClassStapleExample example);
	
	public Integer getObjectListCount(GoodsClassStapleExample example);
}
