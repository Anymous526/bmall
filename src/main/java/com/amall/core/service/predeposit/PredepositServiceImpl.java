package com.amall.core.service.predeposit;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Predeposit;
import com.amall.core.bean.PredepositExample;
import com.amall.core.bean.PredepositWithBLOBs;
import com.amall.core.dao.PredepositMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class PredepositServiceImpl implements IPredepositService {

	@Resource 
	private PredepositMapper predepositDao;

	public Long add(PredepositWithBLOBs example) {
		
		return predepositDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public PredepositWithBLOBs getByKey(Long id) {
		
		return predepositDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return predepositDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PredepositExample example) {
		
		return predepositDao.deleteByExample(example);
	}

	public Integer updateByObject(PredepositWithBLOBs record) {
		
		return predepositDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(PredepositExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),predepositDao.countByExample(example));
		p.setList(predepositDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Predeposit> getObjectList(PredepositExample example) {
		
		return predepositDao.selectByExampleWithPage(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(PredepositExample example) {
		
		return predepositDao.countByExample(example);
	}


}
