package com.amall.core.service.advert;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Advert;
import com.amall.core.bean.AdvertExample;
import com.amall.core.dao.AdvertMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AdvertServiceImpl implements IAdvertService {

	@Resource
	private AdvertMapper advertDao;

	public Long add(Advert example) {
		return advertDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Advert getByKey(Long id) {
		return advertDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return advertDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(AdvertExample example) {
		return advertDao.deleteByExample(example);
	}

	public Integer updateByObject(Advert record) {
		return advertDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(AdvertExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),advertDao.countByExample(example));
		p.setList(advertDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Advert> getObjectList(AdvertExample example) {
		return advertDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(AdvertExample example) {
		return advertDao.countByExample(example);
	}


}
