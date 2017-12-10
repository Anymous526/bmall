package com.amall.core.service.store;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.StoreSlide;
import com.amall.core.bean.StoreSlideExample;
import com.amall.core.dao.StoreSlideMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class StoreSlideServiceImpl implements IStoreSlideService {

	@Resource 
	private StoreSlideMapper  storeSlideDao;

	public Long add(StoreSlide example) {
		return storeSlideDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public StoreSlide getByKey(Long id) {
		return storeSlideDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return storeSlideDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(StoreSlideExample example) {
		return storeSlideDao.deleteByExample(example);
	}

	public Integer updateByObject(StoreSlide record) {
		return storeSlideDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(StoreSlideExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),storeSlideDao.countByExample(example));
		p.setList(storeSlideDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<StoreSlide> getObjectList(StoreSlideExample example) {
		return storeSlideDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(StoreSlideExample example) {
		return storeSlideDao.countByExample(example);
	}

}
