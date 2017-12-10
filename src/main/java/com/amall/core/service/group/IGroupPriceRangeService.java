package com.amall.core.service.group;

import java.util.List;

import com.amall.core.bean.GroupPriceRange;
import com.amall.core.bean.GroupPriceRangeExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGroupPriceRangeService {
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GroupPriceRange
	 * @return
	 */
	public Long add(GroupPriceRange example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GroupPriceRange getByKey(Long id);
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
	public Integer deleteByExample(GroupPriceRangeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GroupPriceRange record);
	
	public Pagination getObjectListWithPage(GroupPriceRangeExample example);
	
	public List<GroupPriceRange> getObjectList(GroupPriceRangeExample example);
	
	public Integer getObjectListCount(GroupPriceRangeExample example);
}
