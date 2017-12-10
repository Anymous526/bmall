package com.amall.core.service.home;

import java.util.List;

import com.amall.core.bean.HomePageGoodsClass;
import com.amall.core.bean.HomePageGoodsClassExample;
import com.amall.core.web.page.Pagination;

public abstract interface IHomePageGoodsClassService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param HomePageGoods
	 * @return
	 */
	public Long add(HomePageGoodsClass example);
			
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public HomePageGoodsClass getByKey(Long id);
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
	public Integer deleteByExample(HomePageGoodsClassExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(HomePageGoodsClass record);
	
	public Pagination getObjectListWithPage(HomePageGoodsClassExample example);
	
	public List<HomePageGoodsClass> getObjectList(HomePageGoodsClassExample example);
	
	public Integer getObjectListCount(HomePageGoodsClassExample example);
}
