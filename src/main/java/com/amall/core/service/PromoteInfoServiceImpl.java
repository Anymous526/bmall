package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.PromoteInfo;
import com.amall.core.bean.PromoteInfoExample;
import com.amall.core.dao.PromoteInfoMapper;

@Service
@Transactional
public class PromoteInfoServiceImpl implements IPromoteInfoService {

	@Resource 
	private PromoteInfoMapper  PromoteInfoDao;

	public Long add(PromoteInfo example) {
		return PromoteInfoDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public PromoteInfo getByKey(Long id) {
		return PromoteInfoDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return PromoteInfoDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(PromoteInfoExample example) {
		return PromoteInfoDao.deleteByExample(example);
	}

	public Integer updateByObject(PromoteInfo record) {
		return PromoteInfoDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public List<PromoteInfo> getObjectList(PromoteInfoExample example) {
		return PromoteInfoDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(PromoteInfoExample example) {
		return PromoteInfoDao.countByExample(example);
	}
	
}
