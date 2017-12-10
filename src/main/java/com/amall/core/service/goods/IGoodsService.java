package com.amall.core.service.goods;

import java.util.List;
import java.util.Map;
import com.amall.core.bean.Goods;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.GoodsSpecial;
import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsService</p>
 * <p>Description: 商品管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29上午11:35:11
 * @version 1.0
 */
public abstract interface IGoodsService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Goods
	 * @return
	 */
	public Long add(GoodsWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(GoodsExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsWithBLOBs record);
	
	public Pagination getObjectListWithPage(GoodsExample example);
	
	public List<GoodsWithBLOBs> getObjectList(GoodsExample example);
	
	public Integer getObjectListCount(GoodsExample example);
	
	public List<GoodsWithBLOBs> selectGoodsCombin(Map map);
	/**
	 * 
	 * <p>Title: selectByExampleWithBLOBsAndPage</p>
	 * <p>Description: 需要查询从0开始到5之间的商品，又不是分页</p>
	 * @param example
	 * @return
	 */
	public List<GoodsWithBLOBs> selectByExampleWithBLOBsAndPage(GoodsExample example);
	
	/**
	 * 特賣場
	 * @param map
	 * @return
	 */
	public List<GoodsSpecial> selectGoodsSpecial(Long id);
	
	public List<Goods> selectByExample(GoodsExample example);
}
