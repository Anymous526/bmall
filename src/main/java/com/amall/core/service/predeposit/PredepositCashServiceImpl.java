package com.amall.core.service.predeposit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PredepositCashExample;
import com.amall.core.bean.PredepositCashWithBLOBs;
import com.amall.core.dao.PredepositCashMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PredepositCashServiceImpl implements IPredepositCashService {

	@Resource 
	private PredepositCashMapper  predepositCashDao;

	public Long add(PredepositCashWithBLOBs example) {
		
		return predepositCashDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public PredepositCashWithBLOBs getByKey(Long id) {
		
		return predepositCashDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return predepositCashDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PredepositCashExample example) {
		
		return predepositCashDao.deleteByExample(example);
	}

	public Integer updateByObject(PredepositCashWithBLOBs record) {
		
		return predepositCashDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PredepositCashExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),predepositCashDao.countByExample(example));
		p.setList(predepositCashDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<PredepositCashWithBLOBs> getObjectList(PredepositCashExample example) {
		
		return predepositCashDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(PredepositCashExample example) {
		
		return predepositCashDao.countByExample(example);
	}


}
