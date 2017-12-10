package com.amall.core.service.report;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ReportSubject;
import com.amall.core.bean.ReportSubjectExample;
import com.amall.core.dao.ReportSubjectMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ReportSubjectServiceImpl implements IReportSubjectService {

	@Resource 
	private ReportSubjectMapper  reportSubjectDao;

	public Long add(ReportSubject example) {
		
		return reportSubjectDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ReportSubject getByKey(Long id) {
		
		return reportSubjectDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return reportSubjectDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ReportSubjectExample example) {
		
		return reportSubjectDao.deleteByExample(example);
	}

	public Integer updateByObject(ReportSubject record) {
		
		return reportSubjectDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ReportSubjectExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),reportSubjectDao.countByExample(example));
		p.setList(reportSubjectDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ReportSubject> getObjectList(ReportSubjectExample example) {
		
		return reportSubjectDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ReportSubjectExample example) {
		
		return reportSubjectDao.countByExample(example);
	}


}
