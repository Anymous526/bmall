package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.CombinLog;
import com.amall.core.bean.CombinLogExample;
import com.amall.core.dao.CombinLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class CombinLogServiceImpl implements ICombinLogService {

	@Resource
	private CombinLogMapper combinLogDao;

	public Long add(CombinLog example) {
		return combinLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public CombinLog getByKey(Long id) {
		return combinLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return combinLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(CombinLogExample example) {
		return combinLogDao.deleteByExample(example);
	}

	public Integer updateByObject(CombinLog record) {
		return combinLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(CombinLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),combinLogDao.countByExample(example));
		p.setList(combinLogDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<CombinLog> getObjectList(CombinLogExample example) {
		return combinLogDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(CombinLogExample example) {
		return combinLogDao.countByExample(example);
	}


}
