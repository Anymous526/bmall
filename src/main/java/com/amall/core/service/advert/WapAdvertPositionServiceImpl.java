package com.amall.core.service.advert;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.WapAdvertPositionExample;
import com.amall.core.bean.WapAdvertPositionWithBLOBs;
import com.amall.core.dao.WapAdvertPositionMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class WapAdvertPositionServiceImpl implements IWapAdvertPositionService {

	@Resource
	private WapAdvertPositionMapper wapAdvertPositionDao;

	public Integer add(WapAdvertPositionWithBLOBs example) {
		return wapAdvertPositionDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public WapAdvertPositionWithBLOBs getByKey(Long id) {
		return wapAdvertPositionDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return wapAdvertPositionDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(WapAdvertPositionExample example) {
		return wapAdvertPositionDao.deleteByExample(example);
	}

	public Integer updateByObject(WapAdvertPositionWithBLOBs record) {
		return wapAdvertPositionDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(WapAdvertPositionExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),wapAdvertPositionDao.countByExample(example));
		p.setList(wapAdvertPositionDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<WapAdvertPositionWithBLOBs> getObjectList(WapAdvertPositionExample example) {
		return wapAdvertPositionDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(WapAdvertPositionExample example) {
		return wapAdvertPositionDao.countByExample(example);
	}
	

}
