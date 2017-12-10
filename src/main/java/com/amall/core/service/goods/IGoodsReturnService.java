package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsReturn;
import com.amall.core.bean.GoodsReturnExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsReturnService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsReturn
	 * @return
	 */
	public Long add(GoodsReturn example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsReturn getByKey(Long id);
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
	public Integer deleteByExample(GoodsReturnExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsReturn record);
	
	public Pagination getObjectListWithPage(GoodsReturnExample example);
	
	public List<GoodsReturn> getObjectList(GoodsReturnExample example);
	
	public Integer getObjectListCount(GoodsReturnExample example);
}
