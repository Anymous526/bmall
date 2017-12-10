package com.amall.core.service.gold;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.DouDetail;
import com.amall.core.bean.DouDetailExample;

import com.amall.core.dao.DouDetailMapper;

import com.amall.core.service.gold.IDouDetailService;

@Service
@Transactional
public class DouDetailServiceImpl implements IDouDetailService
{

	@Resource
	private DouDetailMapper DouDetailDao;

	@Override
	public List<DouDetail> selectByExample(DouDetailExample example) {
		// TODO Auto-generated method stub
		return this.DouDetailDao.selectByExample (example);
	}






}
