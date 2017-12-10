package com.amall.core.service.complaint;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ComplaintSubject;
import com.amall.core.bean.ComplaintSubjectExample;
import com.amall.core.dao.ComplaintSubjectMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ComplaintSubjectServiceImpl implements IComplaintSubjectService {

	@Resource
	private ComplaintSubjectMapper complaintSubjectDao;

	public Long add(ComplaintSubject example) {
		return complaintSubjectDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ComplaintSubject getByKey(Long id) {
		return complaintSubjectDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return complaintSubjectDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ComplaintSubjectExample example) {
		return complaintSubjectDao.deleteByExample(example);
	}

	public Integer updateByObject(ComplaintSubject record) {
		return complaintSubjectDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ComplaintSubjectExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),complaintSubjectDao.countByExample(example));
		p.setList(complaintSubjectDao.selectByExampleWithBLOBs(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ComplaintSubject> getObjectList(ComplaintSubjectExample example) {
		return complaintSubjectDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ComplaintSubjectExample example) {
		return complaintSubjectDao.countByExample(example);
	}
	
}
