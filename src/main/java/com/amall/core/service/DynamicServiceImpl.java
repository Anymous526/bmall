package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Dynamic;
import com.amall.core.bean.DynamicExample;
import com.amall.core.dao.DynamicMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class DynamicServiceImpl implements IDynamicService {
	@Resource
	private DynamicMapper dynamicDao;

	public Long add(Dynamic example) {
		return dynamicDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Dynamic getByKey(Long id) {
		return dynamicDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return dynamicDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(DynamicExample example) {
		return dynamicDao.deleteByExample(example);
	}

	public Integer updateByObject(Dynamic record) {
		return dynamicDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(DynamicExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),dynamicDao.countByExample(example));
		p.setList(dynamicDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Dynamic> getObjectList(DynamicExample example) {
		return dynamicDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(DynamicExample example) {
		return dynamicDao.countByExample(example);
	}

	
	
}
