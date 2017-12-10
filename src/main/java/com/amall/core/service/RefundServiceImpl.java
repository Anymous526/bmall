package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Refund;
import com.amall.core.bean.RefundExample;
import com.amall.core.dao.RefundMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class RefundServiceImpl implements IRefundService {

	@Resource 
	private RefundMapper RefundDao;

	public Long add(Refund example) {
		
		return RefundDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Refund getByKey(Long id) {
		
		return RefundDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return RefundDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(RefundExample example) {
		
		return RefundDao.deleteByExample(example);
	}

	public Integer updateByObject(Refund record) {
		
		return RefundDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(RefundExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),RefundDao.countByExample(example));
		p.setList(RefundDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Refund> getObjectList(RefundExample example) {
		
		return RefundDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(RefundExample example) {
		
		return RefundDao.countByExample(example);
	}


}
