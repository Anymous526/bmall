package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.MonthBenifitDetail;
import com.amall.core.bean.MonthBenifitDetailExample;
import com.amall.core.dao.MonthBenifitDetailMapper;

@Service
@Transactional
public class MonthBenifitDedtailServiceImpl implements MonthBenifitDedtailService{

	@Resource
	private MonthBenifitDetailMapper dao;

	@Override
	public List<MonthBenifitDetail> queryBenifitDetails(
			MonthBenifitDetailExample example) {
		// TODO Auto-generated method stub
		 return dao.selectByExample(example);
	}

	@Override
	public MonthBenifitDetail queryBenifitDetail(
			MonthBenifitDetailExample example) {
		if( null != dao.selectByExample(example)  && dao.selectByExample(example).size() > 0){
			 return dao.selectByExample(example).get(0);
		}
		// TODO Auto-generated method stub
		 return null;
	}

}
