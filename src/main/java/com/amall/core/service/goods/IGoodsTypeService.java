package com.amall.core.service.goods;

import java.util.List;

import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsType;
import com.amall.core.bean.GoodsTypeExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsTypeService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsType
	 * @return
	 */
	public Long add(GoodsType example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsType getByKey(Long id);
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
	public Integer deleteByExample(GoodsTypeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsType record);
	
	public Pagination getObjectListWithPage(GoodsTypeExample example);
	
	public List<GoodsType> getObjectList(GoodsTypeExample example);
	
	public Integer getObjectListCount(GoodsTypeExample example);
	
	/**
	 * 
	 * @todo 通过传入type的Id 获取对应种类下的商品集合
	 * @author wsw
	 * @date 2015年6月22日 下午5:40:14
	 * @return List<GoodsBrand>
	 * @param id
	 * @return
	 */
	public List<GoodsBrand> selectGoodsBrandRightJoinByGoodsTypeId(long id);
}
