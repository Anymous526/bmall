package com.amall.core.service.group;

import java.util.List;

import com.amall.core.bean.GroupBrand;
import com.amall.core.bean.GroupBrandExample;
import com.amall.core.web.page.Pagination;

public interface IGroupBrandService {

	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description:添加 </p>
	 * @param example
	 * @return
	 */
	public Long add(GroupBrand example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description:根据Id查询单个对象 </p>
	 * @param id
	 * @return
	 */
	public GroupBrand getByKey(Long id);
	
	/**
	 * 
	 * <p>Title: deleteByKey</p>
	 * <p>Description: 根据Id单个删除</p>
	 * @param id
	 * @return
	 */
	public Integer deleteByKey(Long id);
	
	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description:根据条件删除 </p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(GroupBrandExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GroupBrand record);
	
	public Pagination getObjectListWithPage(GroupBrandExample example);
	
	public List<GroupBrand> getObjectList(GroupBrandExample example);
	
	public Integer getObjectListCount(GroupBrandExample example);
	
	public List<GroupBrand> selectByExampleWithPage(GroupBrandExample example);//需要查询分页信息
	
	
	
	
}
