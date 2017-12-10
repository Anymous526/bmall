package com.amall.core.service.home;

import java.util.List;

import com.amall.core.bean.HomePage;
import com.amall.core.bean.HomePageExample;
import com.amall.core.web.page.Pagination;

public abstract interface IHomePageService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param HomePage
	 * @return
	 */
	public Long add(HomePage example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public HomePage getByKey(Long id);
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
	public Integer deleteByExample(HomePageExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(HomePage record);
	
	public Pagination getObjectListWithPage(HomePageExample example);
	
	public List<HomePage> getObjectList(HomePageExample example);
	
	public Integer getObjectListCount(HomePageExample example);
}
