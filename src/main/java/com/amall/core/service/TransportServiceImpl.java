package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.TransportExample;
import com.amall.core.bean.TransportWithBLOBs;
import com.amall.core.dao.TransportMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class TransportServiceImpl implements ITransportService {

	@Resource 
	private TransportMapper transportDao;

	public Long add(TransportWithBLOBs example) {
		return transportDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public TransportWithBLOBs getByKey(Long id) {
		return transportDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return transportDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(TransportExample example) {
		return transportDao.deleteByExample(example);
	}

	public Integer updateByObject(TransportWithBLOBs record) {
		return transportDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(TransportExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),transportDao.countByExample(example));
		p.setList(transportDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<TransportWithBLOBs> getObjectList(TransportExample example) {
		return transportDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(TransportExample example) {
		return transportDao.countByExample(example);
	}

}
