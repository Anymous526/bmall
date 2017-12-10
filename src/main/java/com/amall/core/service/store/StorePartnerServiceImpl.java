package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StorePartner;
import com.amall.core.bean.StorePartnerExample;
import com.amall.core.dao.StorePartnerMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StorePartnerServiceImpl implements IStorePartnerService {

	@Resource 
	private StorePartnerMapper  storePartnerDao;

	public Long add(StorePartner example) {
		return storePartnerDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StorePartner getByKey(Long id) {
		return storePartnerDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storePartnerDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StorePartnerExample example) {
		return storePartnerDao.deleteByExample(example);
	}

	public Integer updateByObject(StorePartner record) {
		return storePartnerDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StorePartnerExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storePartnerDao.countByExample(example));
		p.setList(storePartnerDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StorePartner> getObjectList(StorePartnerExample example) {
		return storePartnerDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StorePartnerExample example) {
		return storePartnerDao.countByExample(example);
	}


}
