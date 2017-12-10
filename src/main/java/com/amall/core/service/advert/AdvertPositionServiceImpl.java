package com.amall.core.service.advert;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.AdvertPositionExample;
import com.amall.core.bean.AdvertPositionWithBLOBs;
import com.amall.core.dao.AdvertPositionMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class AdvertPositionServiceImpl implements IAdvertPositionService {

	@Resource
	private AdvertPositionMapper advertPositionDao;

	public Long add(AdvertPositionWithBLOBs example) {
		return advertPositionDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public AdvertPositionWithBLOBs getByKey(Long id) {
		return advertPositionDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return advertPositionDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(AdvertPositionExample example) {
		return advertPositionDao.deleteByExample(example);
	}

	public Integer updateByObject(AdvertPositionWithBLOBs record) {
		return advertPositionDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(AdvertPositionExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),advertPositionDao.countByExample(example));
		p.setList(advertPositionDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<AdvertPositionWithBLOBs> getObjectList(AdvertPositionExample example) {
		return advertPositionDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(AdvertPositionExample example) {
		return advertPositionDao.countByExample(example);
	}
	

}
