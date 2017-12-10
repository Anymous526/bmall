package com.amall.core.service.report;

import java.util.List;

import com.amall.core.bean.ReportExample;
import com.amall.core.bean.ReportWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IReportService</p>
 * <p>Description: 举报管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:33:06
 * @version 1.0
 */
public abstract interface IReportService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Report
	 * @return
	 */
	public Long add(ReportWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ReportWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(ReportExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ReportWithBLOBs record);
	
	public Pagination getObjectListWithPage(ReportExample example);
	
	public List<ReportWithBLOBs> getObjectList(ReportExample example);
	
	public Integer getObjectListCount(ReportExample example);
}
