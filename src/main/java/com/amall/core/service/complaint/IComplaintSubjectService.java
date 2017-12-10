package com.amall.core.service.complaint;

import java.util.List;

import com.amall.core.bean.ComplaintSubject;
import com.amall.core.bean.ComplaintSubjectExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IComplaintSubjectService</p>
 * <p>Description: 投诉主题管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:24:00
 * @version 1.0
 */
public abstract interface IComplaintSubjectService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ComplaintSubject
	 * @return
	 */
	public Long add(ComplaintSubject example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ComplaintSubject getByKey(Long id);
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
	public Integer deleteByExample(ComplaintSubjectExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ComplaintSubject record);
	
	public Pagination getObjectListWithPage(ComplaintSubjectExample example);
	
	public List<ComplaintSubject> getObjectList(ComplaintSubjectExample example);
	
	public Integer getObjectListCount(ComplaintSubjectExample example);
}
