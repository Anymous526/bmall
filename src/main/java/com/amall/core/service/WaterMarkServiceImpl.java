package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.WaterMark;
import com.amall.core.bean.WaterMarkExample;
import com.amall.core.dao.WaterMarkMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class WaterMarkServiceImpl implements IWaterMarkService {

	@Resource 
	private WaterMarkMapper  waterMarkDao;

	public Long add(WaterMark example) {
		
		return waterMarkDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public WaterMark getByKey(Long id) {
		
		return waterMarkDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return waterMarkDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(WaterMarkExample example) {
		
		return waterMarkDao.deleteByExample(example);
	}

	public Integer updateByObject(WaterMark record) {
		
		return waterMarkDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(WaterMarkExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),waterMarkDao.countByExample(example));
		p.setList(waterMarkDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<WaterMark> getObjectList(WaterMarkExample example) {
		
		return waterMarkDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(WaterMarkExample example) {
		
		return waterMarkDao.countByExample(example);
	}


}
