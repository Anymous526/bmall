package com.amall.core.service.advert;

import java.util.List;

import com.amall.core.bean.WapAdvertPositionExample;
import com.amall.core.bean.WapAdvertPositionWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IAdvertPositionService</p>
 * <p>Description: 广告位管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:11:07
 * @version 1.0
 */
public interface IWapAdvertPositionService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param AdvertPosition
	 * @return
	 */
	public Integer add(WapAdvertPositionWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public WapAdvertPositionWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(WapAdvertPositionExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(WapAdvertPositionWithBLOBs record);
	
	public Pagination getObjectListWithPage(WapAdvertPositionExample example);
	
	public List<WapAdvertPositionWithBLOBs> getObjectList(WapAdvertPositionExample example);
	
	public Integer getObjectListCount(WapAdvertPositionExample example);
}
