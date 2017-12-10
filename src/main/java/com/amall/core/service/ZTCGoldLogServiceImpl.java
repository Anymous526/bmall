package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ZTCGoldLog;
import com.amall.core.bean.ZTCGoldLogExample;
import com.amall.core.dao.ZTCGoldLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ZTCGoldLogServiceImpl implements IZTCGoldLogService {

	@Resource
	private ZTCGoldLogMapper  zTCGoldLogDao;

	public Long add(ZTCGoldLog example) {
		return zTCGoldLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ZTCGoldLog getByKey(Long id) {
		return zTCGoldLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return zTCGoldLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ZTCGoldLogExample example) {
		return zTCGoldLogDao.deleteByExample(example);
	}

	public Integer updateByObject(ZTCGoldLog record) {
		return zTCGoldLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ZTCGoldLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),zTCGoldLogDao.countByExample(example));
		p.setList(zTCGoldLogDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ZTCGoldLog> getObjectList(ZTCGoldLogExample example) {
		return zTCGoldLogDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ZTCGoldLogExample example) {
		return zTCGoldLogDao.countByExample(example);
	}


}
