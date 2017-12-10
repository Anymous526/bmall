package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreCart;
import com.amall.core.bean.StoreCartExample;
import com.amall.core.dao.StoreCartMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreCartServiceImpl implements IStoreCartService {

	@Resource 
	private StoreCartMapper  storeCartDao;

	public Long add(StoreCart example) {
		return storeCartDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreCart getByKey(Long id) {
		return storeCartDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeCartDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreCartExample example) {
		return storeCartDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreCart record) {
		return storeCartDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreCartExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storeCartDao.countByExample(example));
		p.setList(storeCartDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StoreCart> getObjectList(StoreCartExample example) {
		return storeCartDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreCartExample example) {
		return storeCartDao.countByExample(example);
	}
	

}
