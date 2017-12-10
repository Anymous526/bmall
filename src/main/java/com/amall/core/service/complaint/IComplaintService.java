package com.amall.core.service.complaint;

import java.util.List;

import com.amall.core.bean.ComplaintExample;
import com.amall.core.bean.ComplaintWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IComplaintService</p>
 * <p>Description: 投诉管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午3:53:15
 * @version 1.0
 */
public abstract interface IComplaintService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Complaint
	 * @return
	 */
	public Long add(ComplaintWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ComplaintWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(ComplaintExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ComplaintWithBLOBs record);
	
	public Pagination getObjectListWithPage(ComplaintExample example);
	
	public List<ComplaintWithBLOBs> getObjectList(ComplaintExample example);
	
	public Integer getObjectListCount(ComplaintExample example);
}
