package com.amall.core.service.integral;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.IntegralLog;
import com.amall.core.bean.IntegralLogExample;
import com.amall.core.dao.IntegralLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class IntegralLogServiceImpl implements IIntegralLogService {

	@Resource 
	private IntegralLogMapper integralLogDao;
	
	public Long add(IntegralLog example) {
		return integralLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public IntegralLog getByKey(Long id) {
		return integralLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return integralLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(IntegralLogExample example) {
		return integralLogDao.deleteByExample(example);
	}

	public Integer updateByObject(IntegralLog record) {
		return integralLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(IntegralLogExample example) {
		Pagination p = new Pagination(example.getPageNo(), example.getPageSize(), integralLogDao.countByExample(example));
		p.setList(integralLogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<IntegralLog> getObjectList(IntegralLogExample example) {
		return integralLogDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(IntegralLogExample example) {
		return integralLogDao.countByExample(example);
	}
}
