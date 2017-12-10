package com.amall.core.service.system;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SysLog;
import com.amall.core.bean.SysLogExample;
import com.amall.core.dao.SysLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

	@Resource 
	private SysLogMapper  sysLogDao;

	public Long add(SysLog example) {
		return sysLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SysLog getByKey(Long id) {
		return sysLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return sysLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SysLogExample example) {
		return sysLogDao.deleteByExample(example);
	}

	public Integer updateByObject(SysLog record) {
		return sysLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(SysLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),sysLogDao.countByExample(example));
		p.setList(sysLogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<SysLog> getObjectList(SysLogExample example) {
		return sysLogDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SysLogExample example) {
		return sysLogDao.countByExample(example);
	}


}
