package com.amall.core.service.advert;

import java.util.List;

import com.amall.core.bean.WapAdvert;
import com.amall.core.bean.WapAdvertExample;
import com.amall.core.web.page.Pagination;


/**
 * 
 * <p>Title: IWapAdvertService</p>
 * <p>Description: 广告管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:11:39
 * @version 1.0
 */
public abstract interface IWapAdvertService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param WapAdvert
	 * @return
	 */
	public Integer add(WapAdvert example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public WapAdvert getByKey(Long id);
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
	public Integer deleteByExample(WapAdvertExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(WapAdvert record);
	
	public Pagination getObjectListWithPage(WapAdvertExample example);
	
	public List<WapAdvert> getObjectList(WapAdvertExample example);
	
	public Integer getObjectListCount(WapAdvertExample example);
}
