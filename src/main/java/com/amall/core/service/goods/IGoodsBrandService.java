package com.amall.core.service.goods;

import java.util.List;
import java.util.Map;

import com.amall.core.bean.GoodsBrand;
import com.amall.core.bean.GoodsBrandExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IGoodsBrandService</p>
 * <p>Description: 商品品牌管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:24:08
 * @version 1.0
 */
public abstract interface IGoodsBrandService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoodsBrand
	 * @return
	 */
	public Long add(GoodsBrand example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsBrand getByKey(Long id);
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
	public Integer deleteByExample(GoodsBrandExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsBrand record);
	
	public Pagination getObjectListWithPage(GoodsBrandExample example);
	
	public List<GoodsBrand> getObjectList(GoodsBrandExample example);
	
	public Integer getObjectListCount(GoodsBrandExample example);
	
	public List<GoodsBrand> selectGoodsBrand(Map map);//第三张表，amall_goodstype_brand，通过typeId得到GoodsBrand对象
	
	public GoodsBrand getGoodsById(Long id);
	

}
