package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreNavigation;
import com.amall.core.bean.StoreNavigationExample;
import com.amall.core.dao.StoreNavigationMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreNavigationServiceImpl implements IStoreNavigationService {

	@Resource 
	private StoreNavigationMapper  storeNavigationDao;

	public Long add(StoreNavigation example) {
		return storeNavigationDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreNavigation getByKey(Long id) {
		return storeNavigationDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeNavigationDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreNavigationExample example) {
		return storeNavigationDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreNavigation record) {
		return storeNavigationDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreNavigationExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storeNavigationDao.countByExample(example));
		p.setList(storeNavigationDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StoreNavigation> getObjectList(StoreNavigationExample example) {
		return storeNavigationDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreNavigationExample example) {
		return storeNavigationDao.countByExample(example);
	}


}
