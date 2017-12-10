package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Visit;
import com.amall.core.bean.VisitExample;
import com.amall.core.dao.VisitMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class VisitServiceImpl implements IVisitService {

	@Resource 
	private VisitMapper  visitDao;

	public Long add(Visit example) {
		
		return visitDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Visit getByKey(Long id) {
		
		return visitDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return visitDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(VisitExample example) {
		
		return visitDao.deleteByExample(example);
	}

	public Integer updateByObject(Visit record) {
		
		return visitDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(VisitExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),visitDao.countByExample(example));
		p.setList(visitDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Visit> getObjectList(VisitExample example) {
		
		return visitDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(VisitExample example) {
		
		return visitDao.countByExample(example);
	}


}
