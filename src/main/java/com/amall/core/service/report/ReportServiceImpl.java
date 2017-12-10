package com.amall.core.service.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ReportExample;
import com.amall.core.bean.ReportWithBLOBs;
import com.amall.core.dao.ReportMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ReportServiceImpl implements IReportService {

	@Resource 
	private ReportMapper  reportDao;

	public Long add(ReportWithBLOBs example) {
		return reportDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ReportWithBLOBs getByKey(Long id) {
		return reportDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return reportDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ReportExample example) {
		return reportDao.deleteByExample(example);
	}

	public Integer updateByObject(ReportWithBLOBs record) {
		return reportDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ReportExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),reportDao.countByExample(example));
		p.setList(reportDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ReportWithBLOBs> getObjectList(ReportExample example) {
		return reportDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ReportExample example) {
		return reportDao.countByExample(example);
	}


}
