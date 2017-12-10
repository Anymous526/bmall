package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecPropertyExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsSpecPropertyService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsSpecProperty
	 * @return
	 */
	public Long add(GoodsSpecProperty example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsSpecProperty getByKey(Long id);
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
	public Integer deleteByExample(GoodsSpecPropertyExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsSpecProperty record);
	
	public Pagination getObjectListWithPage(GoodsSpecPropertyExample example);
	
	public List<GoodsSpecProperty> getObjectList(GoodsSpecPropertyExample example);
	
	public Integer getObjectListCount(GoodsSpecPropertyExample example);
	
	/**
	 * 
	 * @todo 通过goodsId 关联中间表获取 goodsSpec属性列表, 再关联到具体属性值表goodsSpecProperty
	 * @author wsw
	 * @date 2015年6月23日 下午4:13:13
	 * @return List<GoodsSpecProperty>
	 * @param id
	 * @return
	 */
	public List<GoodsSpecProperty> selectGoodsPropertyByLeftJoinSpecAndGoodsId(long id);
}
