package com.amall.core.service.advert;

import java.util.List;

import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.web.page.Pagination;


/**
 * 
 * <p>Title: IAdvertService</p>
 * <p>Description: 广告管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:11:39
 * @version 1.0
 */
public abstract interface IAdvertService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Advert
	 * @return
	 */
	public Long add(Advert example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Advert getByKey(Long id);
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
	public Integer deleteByExample(AdvertExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Advert record);
	
	public Pagination getObjectListWithPage(AdvertExample example);
	
	public List<Advert> getObjectList(AdvertExample example);
	
	public Integer getObjectListCount(AdvertExample example);
}
