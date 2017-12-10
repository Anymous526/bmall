package com.amall.core.service.predeposit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PredepositLog;
import com.amall.core.bean.PredepositLogExample;
import com.amall.core.dao.PredepositLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PredepositLogServiceImpl implements IPredepositLogService {

	@Resource 
	private PredepositLogMapper  predepositLogDao;

	public Long add(PredepositLog example) {
		
		return predepositLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public PredepositLog getByKey(Long id) {
		
		return predepositLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return predepositLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PredepositLogExample example) {
		
		return predepositLogDao.deleteByExample(example);
	}

	public Integer updateByObject(PredepositLog record) {
		
		return predepositLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PredepositLogExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),predepositLogDao.countByExample(example));
		p.setList(predepositLogDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<PredepositLog> getObjectList(PredepositLogExample example) {
		
		return predepositLogDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(PredepositLogExample example) {
		
		return predepositLogDao.countByExample(example);
	}


}
