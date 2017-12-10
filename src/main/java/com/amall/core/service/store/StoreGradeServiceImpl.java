package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreGrade;
import com.amall.core.bean.StoreGradeExample;
import com.amall.core.dao.StoreGradeMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreGradeServiceImpl implements IStoreGradeService {

	@Resource
	private StoreGradeMapper storeGradeDao;

	public Long add(StoreGrade example) {
		return storeGradeDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreGrade getByKey(Long id) {
		return storeGradeDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeGradeDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreGradeExample example) {
		return storeGradeDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreGrade record) {
		return storeGradeDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreGradeExample example) {
		Pagination p = new Pagination();
		p.setList(storeGradeDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StoreGrade> getObjectList(StoreGradeExample example) {
		return storeGradeDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreGradeExample example) {
		return storeGradeDao.countByExample(example);
	}


}
