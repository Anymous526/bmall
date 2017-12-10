package com.amall.core.service.address;

import java.util.List;

import com.amall.core.bean.Area;
import com.amall.core.bean.AreaExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IAreaService</p>
 * <p>Description: 区域管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午6:15:02
 * @version 1.0
 */
public abstract interface IAreaService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Area
	 * @return
	 */
	public Long add(Area example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Area getByKey(Long id);
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
	public Integer deleteByExample(AreaExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Area record);
	
	public Pagination getObjectListWithPage(AreaExample example);
	
	public List<Area> getObjectList(AreaExample example);
	
	public Integer getObjectListCount(AreaExample example);
}
