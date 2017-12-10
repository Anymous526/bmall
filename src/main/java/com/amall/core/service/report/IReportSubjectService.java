package com.amall.core.service.report;

import java.util.List;

import com.amall.core.bean.ReportSubject;
import com.amall.core.bean.ReportSubjectExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IReportSubjectService</p>
 * <p>Description: 举报主题管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:32:07
 * @version 1.0
 */
public abstract interface IReportSubjectService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ReportSubject
	 * @return
	 */
	public Long add(ReportSubject example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ReportSubject getByKey(Long id);
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
	public Integer deleteByExample(ReportSubjectExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ReportSubject record);
	
	public Pagination getObjectListWithPage(ReportSubjectExample example);
	
	public List<ReportSubject> getObjectList(ReportSubjectExample example);
	
	public Integer getObjectListCount(ReportSubjectExample example);
}
