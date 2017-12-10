package com.amall.core.service.complaint;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ComplaintExample;
import com.amall.core.bean.ComplaintWithBLOBs;
import com.amall.core.dao.ComplaintMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ComplaintServiceImpl implements IComplaintService {

	@Resource
	private ComplaintMapper complaintDao;

	public Long add(ComplaintWithBLOBs example) {
		return complaintDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ComplaintWithBLOBs getByKey(Long id) {
		return complaintDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return complaintDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ComplaintExample example) {
		return complaintDao.deleteByExample(example);
	}

	public Integer updateByObject(ComplaintWithBLOBs record) {
		return complaintDao.updateByPrimaryKeyWithBLOBs(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ComplaintExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),complaintDao.countByExample(example));
		p.setList(complaintDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ComplaintWithBLOBs> getObjectList(ComplaintExample example) {
		return complaintDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ComplaintExample example) {
		return complaintDao.countByExample(example);
	}

	
}
