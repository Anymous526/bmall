package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.SmsVerification;
import com.amall.core.bean.SmsVerificationExample;
import com.amall.core.dao.SmsVerificationMapper;

@Service
@Transactional
public class SmsVerificationImpl implements ISmsVerificationService {

	@Resource
	private SmsVerificationMapper verificationMapper;

	public Long add(SmsVerification example) {
		return (long) verificationMapper.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public SmsVerification getByKey(Long id) {
		return verificationMapper.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return verificationMapper.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(SmsVerificationExample example) {
		return verificationMapper.deleteByExample(example);
	}

	public Integer updateByObject(SmsVerification record) {
		return verificationMapper.updateByPrimaryKeySelective(record);
	}
	
	@Transactional(readOnly=true)
	public List<SmsVerification> getObjectList(SmsVerificationExample example) {
		return verificationMapper.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(SmsVerificationExample example) {
		return verificationMapper.countByExample(example);
	}

}
