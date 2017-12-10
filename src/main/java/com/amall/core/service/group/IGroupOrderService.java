package com.amall.core.service.group;

import java.util.List;

import com.amall.core.bean.GroupOrder;
import com.amall.core.bean.GroupOrderExample;
import com.amall.core.web.page.Pagination;


/**
 * 
 * <p>Title: IGroupOrderService</p>
 * <p>Description: 团购订单Service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  李越
 * @date	2015年8月5日上午11:20:47
 * @version 1.0
 */
public interface IGroupOrderService {
    /**
     * 
     * <p>Title: add</p>
     * <p>Description: 新增方法</p>
     * @param example
     * @return
     */
	public Long add(GroupOrder example);
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据Id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GroupOrder getByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByKey</p>
	 * <p>Description:根据Id单个删除 </p>
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
	public Integer deleteByExample(GroupOrderExample example);
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GroupOrder record);
	/**
	 * 
	 * <p>Title: getObjectListWithPage</p>
	 * <p>Description: 分页查询</p>
	 * @param example
	 * @return
	 */
	public Pagination getObjectListWithPage(GroupOrderExample example);
	/**
	 * 
	 * <p>Title: getObjectList</p>
	 * <p>Description: 查询团购订单By List</p>
	 * @param example
	 * @return
	 */
	public List<GroupOrder> getObjectList(GroupOrderExample example);
	/**
	 * 
	 * <p>Title: getObjectListCount</p>
	 * <p>Description: 得到数量Count</p>
	 * @param example
	 * @return
	 */
	public Integer getObjectListCount(GroupOrderExample example);
	
	
	
	
	
}
