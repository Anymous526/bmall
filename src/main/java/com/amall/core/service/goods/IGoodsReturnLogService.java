package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsReturnLog;
import com.amall.core.bean.GoodsReturnLogExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsReturnLogService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsReturnLog
	 * @return
	 */
	public Long add(GoodsReturnLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsReturnLog getByKey(Long id);
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
	public Integer deleteByExample(GoodsReturnLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsReturnLog record);
	
	public Pagination getObjectListWithPage(GoodsReturnLogExample example);
	
	public List<GoodsReturnLog> getObjectList(GoodsReturnLogExample example);
	
	public Integer getObjectListCount(GoodsReturnLogExample example);
}
