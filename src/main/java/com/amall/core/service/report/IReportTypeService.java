package com.amall.core.service.report;

import java.util.List;

import com.amall.core.bean.ReportType;
import com.amall.core.bean.ReportTypeExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IReportTypeService</p>
 * <p>Description: 举报分类管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:28:45
 * @version 1.0
 */
public abstract interface IReportTypeService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ReportType
	 * @return
	 */
	public Long add(ReportType example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ReportType getByKey(Long id);
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
	public Integer deleteByExample(ReportTypeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ReportType record);
	
	public Pagination getObjectListWithPage(ReportTypeExample example);
	
	public List<ReportType> getObjectList(ReportTypeExample example);
	
	public Integer getObjectListCount(ReportTypeExample example);
}
