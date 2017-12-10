package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsTypeProperty;
import com.amall.core.bean.GoodsTypePropertyExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsTypePropertyService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsTypeProperty
	 * @return
	 */
	public Long add(GoodsTypeProperty example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsTypeProperty getByKey(Long id);
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
	public Integer deleteByExample(GoodsTypePropertyExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsTypeProperty record);
	
	public Pagination getObjectListWithPage(GoodsTypePropertyExample example);
	
	public List<GoodsTypeProperty> getObjectList(GoodsTypePropertyExample example);
	
	public Integer getObjectListCount(GoodsTypePropertyExample example);
}
