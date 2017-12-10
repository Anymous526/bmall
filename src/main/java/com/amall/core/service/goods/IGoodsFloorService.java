package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsFloorExample;
import com.amall.core.bean.GoodsFloorWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsFloorService</p>
 * <p>Description: 商品楼层管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:33:27
 * @version 1.0
 */
public abstract interface IGoodsFloorService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsFloor
	 * @return
	 */
	public Long add(GoodsFloorWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsFloorWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(GoodsFloorExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsFloorWithBLOBs record);
	
	public Pagination getObjectListWithPage(GoodsFloorExample example);
	
	public List<GoodsFloorWithBLOBs> getObjectList(GoodsFloorExample example);
	
	public Integer getObjectListCount(GoodsFloorExample example);
	
	/**
	 * 
	 * @author wsw
	 * @date 2015年6月16日 下午4:08:18
	 * @todo 通过传入的id获取其子集合 , 在前台直接调用该方法,传入某个特定的id来获取其子集合
	 * @return List<GoodsFloorWithBLOBs>
	 * @param id
	 * @return
	 */
	public List<GoodsFloorWithBLOBs> selectChildsByInnerJoin(Long id);
}
