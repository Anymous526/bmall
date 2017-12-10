package com.amall.core.service.advert;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.WapAdvert;
import com.amall.core.bean.WapAdvertExample;
import com.amall.core.dao.WapAdvertMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class WapAdvertServiceImpl implements IWapAdvertService {

	@Resource
	private WapAdvertMapper wapAdvertDao;

	public Integer add(WapAdvert example) {
		return wapAdvertDao.insertSelective(example);
	}
	
	@Transactional(readOnly=true)
	public WapAdvert getByKey(Long id) {
		return wapAdvertDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return wapAdvertDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(WapAdvertExample example) {
		return wapAdvertDao.deleteByExample(example);
	}

	public Integer updateByObject(WapAdvert record) {
		return wapAdvertDao.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(WapAdvertExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),wapAdvertDao.countByExample(example));
		p.setList(wapAdvertDao.selectByExampleWithPage(example));
		return p;
	}
	
	@Transactional(readOnly=true)
	public List<WapAdvert> getObjectList(WapAdvertExample example) {
		return wapAdvertDao.selectByExample(example);
	}
	
	@Transactional(readOnly=true)
	public Integer getObjectListCount(WapAdvertExample example) {
		return wapAdvertDao.countByExample(example);
	}


}
