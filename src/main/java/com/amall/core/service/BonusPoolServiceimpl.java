package com.amall.core.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.WeekBenifit;
import com.amall.core.bean.WeekBenifitExample;
import com.amall.core.dao.WeekBenifitMapper;

@Service
@Transactional
public class BonusPoolServiceimpl implements BonusPoolService{

	@Resource
	private WeekBenifitMapper weekBenifitDao;
	
	@Override
	@Transactional(readOnly=true)
	public List<WeekBenifit> query(WeekBenifitExample weekBenifitExample) {
		return weekBenifitDao.selectByExample(weekBenifitExample);
	}

	@Override
	public Integer add (WeekBenifit record)
		{
			return weekBenifitDao.insertSelective (record);
		}


	@Override
	public Integer countByExample (	WeekBenifitExample example)
		{
			return weekBenifitDao.countByExample (example);
		}


	@Override
	public Integer deleteByExample (WeekBenifitExample example)
		{
			return weekBenifitDao.deleteByExample (example);
		}


	@Override
	public Integer deleteByPrimaryKey (	Long id)
		{
			return weekBenifitDao.deleteByPrimaryKey (id);
		}


	@Override
	@Transactional(readOnly=true)
	public WeekBenifit selectByPrimaryKey (	Long id)
		{
			return weekBenifitDao.selectByPrimaryKey (id);
		}


	@Override
	public Integer updateByObject (	WeekBenifit record)
		{
			return weekBenifitDao.updateByPrimaryKeySelective (record);
		}
	
}
