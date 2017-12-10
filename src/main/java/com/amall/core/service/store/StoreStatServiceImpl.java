package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreStat;
import com.amall.core.bean.StoreStatExample;
import com.amall.core.dao.StoreStatMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreStatServiceImpl implements IStoreStatService {

	@Resource 
	private StoreStatMapper  storeStatDao;

	public Long add(StoreStat example) {
		return storeStatDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreStat getByKey(Long id) {
		return storeStatDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeStatDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreStatExample example) {
		return storeStatDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreStat record) {
		return storeStatDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreStatExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storeStatDao.countByExample(example));
		p.setList(storeStatDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StoreStat> getObjectList(StoreStatExample example) {
		return storeStatDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreStatExample example) {
		return storeStatDao.countByExample(example);
	}


}
