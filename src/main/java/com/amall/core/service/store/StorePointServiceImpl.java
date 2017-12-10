package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StorePoint;
import com.amall.core.bean.StorePointExample;
import com.amall.core.dao.StorePointMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StorePointServiceImpl implements IStorePointService {

	@Resource 
	private StorePointMapper  storePointDao;

	public Long add(StorePoint example) {
		return storePointDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StorePoint getByKey(Long id) {
		return storePointDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storePointDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StorePointExample example) {
		return storePointDao.deleteByExample(example);
	}

	public Integer updateByObject(StorePoint record) {
		return storePointDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StorePointExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storePointDao.countByExample(example));
		p.setList(storePointDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StorePoint> getObjectList(StorePointExample example) {
		return storePointDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StorePointExample example) {
		return storePointDao.countByExample(example);
	}


}
