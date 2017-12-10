package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Favorite;
import com.amall.core.bean.FavoriteExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IFavoriteService</p>
 * <p>Description: 收藏管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:36:37
 * @version 1.0
 */
public  interface IFavoriteService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Favorite
	 * @return
	 */
	public Long add(Favorite example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Favorite getByKey(Long id);
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
	public Integer deleteByExample(FavoriteExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Favorite record);
	
	public Pagination getObjectListWithPage(FavoriteExample example);
	
	public List<Favorite> getObjectList(FavoriteExample example);
	
	public Integer getObjectListCount(FavoriteExample example);
}
