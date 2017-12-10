package com.amall.core.service.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ReportType;
import com.amall.core.bean.ReportTypeExample;
import com.amall.core.dao.ReportTypeMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ReportTypeServiceImpl implements IReportTypeService {

	@Resource
	private ReportTypeMapper reportTypeDao;

	public Long add(ReportType example) {
		
		return reportTypeDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ReportType getByKey(Long id) {
		
		return reportTypeDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return reportTypeDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ReportTypeExample example) {
		
		return reportTypeDao.deleteByExample(example);
	}

	public Integer updateByObject(ReportType record) {
		
		return reportTypeDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ReportTypeExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),reportTypeDao.countByExample(example));
		p.setList(reportTypeDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ReportType> getObjectList(ReportTypeExample example) {
		
		return reportTypeDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ReportTypeExample example) {
		
		return reportTypeDao.countByExample(example);
	}


}
