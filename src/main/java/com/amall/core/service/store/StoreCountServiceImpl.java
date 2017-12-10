package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreCount;
import com.amall.core.bean.StoreCountExample;
import com.amall.core.dao.StoreCountMapper;

@Service
@Transactional
public class StoreCountServiceImpl implements IStoreCountService {

	@Resource
	private StoreCountMapper storeCountDao;

	public Long add(StoreCount example) {
		return storeCountDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreCount getByKey(Long id) {
		return storeCountDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeCountDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreCountExample example) {
		return storeCountDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreCount record) {
		return storeCountDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreCountExample example) {
		return storeCountDao.countByExample(example);
	}
	@Override
	public List<StoreCount> getObjectList(StoreCountExample example) {
		return storeCountDao.selectByExample(example);
	}


}
