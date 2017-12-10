package com.amall.core.service.store;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;
import com.amall.core.dao.StoreClassMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreClassServiceImpl implements IStoreClassService {

	@Resource 
	private StoreClassMapper  storeClassDao;

	public Long add(StoreClass example) {
		return storeClassDao.insertSelective(example);
	}

	public StoreClass getByKey(Long id) {
		return storeClassDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreClassExample example) {
		return storeClassDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreClass record) {
		return storeClassDao.updateByPrimaryKeySelective(record);
	}

	public Pagination getObjectListWithPage(StoreClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storeClassDao.countByExample(example));
		p.setList(storeClassDao.selectByExampleWithPage(example));
		return p;
	}

	public List<StoreClass> getObjectList(StoreClassExample example) {
		return storeClassDao.selectByExample(example);
	}

	public Integer getObjectListCount(StoreClassExample example) {
		return storeClassDao.countByExample(example);
	}

	public List<StoreClass> selectChilds(Map map) {
		return storeClassDao.selectChilds(map);
	}


}
