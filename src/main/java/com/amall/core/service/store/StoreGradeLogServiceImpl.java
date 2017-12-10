package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreGradeLog;
import com.amall.core.bean.StoreGradeLogExample;
import com.amall.core.dao.StoreGradeLogMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreGradeLogServiceImpl implements IStoreGradeLogService {

	@Resource
	private StoreGradeLogMapper storeGradeLogDao;

	public Long add(StoreGradeLog example) {
		return storeGradeLogDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreGradeLog getByKey(Long id) {
		return storeGradeLogDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeGradeLogDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreGradeLogExample example) {
		return storeGradeLogDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreGradeLog record) {
		return storeGradeLogDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreGradeLogExample example) {
		Pagination p = new Pagination();
		p.setList(storeGradeLogDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StoreGradeLog> getObjectList(StoreGradeLogExample example) {
		return storeGradeLogDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreGradeLogExample example) {
		return storeGradeLogDao.countByExample(example);
	}


}
