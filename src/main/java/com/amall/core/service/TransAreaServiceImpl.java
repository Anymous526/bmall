package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.TransArea;
import com.amall.core.bean.TransAreaExample;
import com.amall.core.dao.TransAreaMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class TransAreaServiceImpl implements ITransAreaService {

	@Resource 
	private TransAreaMapper transAreaDao;

	public Long add(TransArea example) {
		
		return transAreaDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public TransArea getByKey(Long id) {
		
		return transAreaDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return transAreaDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(TransAreaExample example) {
		
		return transAreaDao.deleteByExample(example);
	}

	public Integer updateByObject(TransArea record) {
		
		return transAreaDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(TransAreaExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),transAreaDao.countByExample(example));
		p.setList(transAreaDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<TransArea> getObjectList(TransAreaExample example) {
		
		return transAreaDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(TransAreaExample example) {
		
		return transAreaDao.countByExample(example);
	}


}
