package com.amall.core.service;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsClass2Spec;
import com.amall.core.bean.GoodsClass2SpecExample;
import com.amall.core.dao.GoodsClass2SpecMapper;


@Service
@Transactional
public class GoodsClass2SpecImpl implements IGoodsClass2SpecService {

	@Resource 
	private GoodsClass2SpecMapper  class2SpecMapperDao;

	public int add(GoodsClass2Spec example) {
		return class2SpecMapperDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsClass2Spec getByKey(Long id) {
		return class2SpecMapperDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return class2SpecMapperDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsClass2SpecExample example) {
		return class2SpecMapperDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsClass2Spec record) {
		return class2SpecMapperDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<GoodsClass2Spec> getObjectList(GoodsClass2SpecExample example) {
		return class2SpecMapperDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsClass2SpecExample example) {
		return class2SpecMapperDao.countByExample(example);
	}


}
