package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.MonthBenifit;
import com.amall.core.bean.MonthBenifitExample;
import com.amall.core.dao.MonthBenifitMapper;

@Service
@Transactional
public class MonthBenifitServiceImpl implements MonthBenifitService{

	@Resource
	private MonthBenifitMapper dao;
	
	@Override
	public List<MonthBenifit> queryBenifits(MonthBenifitExample example) {
		// TODO Auto-generated method stub
		return dao.selectByExample(example);
	}
	
	
	@Override
	public MonthBenifit queryBenifit(MonthBenifitExample example) {
		// TODO Auto-generated method stub
		if(null != dao.selectByExample(example)){
			return dao.selectByExample(example).get(0);
		}
		return null;
	}

}
