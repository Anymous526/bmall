package com.amall.core.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.WeekBenifitDetail;
import com.amall.core.bean.WeekBenifitDetailExample;
import com.amall.core.dao.WeekBenifitDetailMapper;

@Service
@Transactional
public class BonusPoolDetailServiceImpl implements BonusPoolDetailService
{

	@Resource
	private WeekBenifitDetailMapper weekBenifitDetailDao;


	@Override
	@Transactional(readOnly = true)
	public List <WeekBenifitDetail> queryBenifutDetail (WeekBenifitDetailExample example)
		{
			return weekBenifitDetailDao.selectByExample (example);
		}


	@Override
	@Transactional(readOnly = true)
	public WeekBenifitDetail queryBenifutDetails (	WeekBenifitDetailExample example)
		{
			if (weekBenifitDetailDao.selectByExample (example).size () > 0)
			{
				return weekBenifitDetailDao.selectByExample (example).get (0);
			}
			return null;
		}


	@Override
	public Integer add (WeekBenifitDetail record)
		{
			return weekBenifitDetailDao.insertSelective (record);
		}


	@Override
	public Integer countByExample (	WeekBenifitDetailExample example)
		{
			return weekBenifitDetailDao.countByExample (example);
		}


	@Override
	public Integer deleteByExample (WeekBenifitDetailExample example)
		{
			return weekBenifitDetailDao.deleteByExample (example);
		}


	@Override
	public Integer deleteByPrimaryKey (	Long id)
		{
			return weekBenifitDetailDao.deleteByPrimaryKey (id);
		}


	@Override
	@Transactional(readOnly = true)
	public WeekBenifitDetail selectByPrimaryKey (	Long id)
		{
			return weekBenifitDetailDao.selectByPrimaryKey (id);
		}


	@Override
	public Integer updateByObject (	WeekBenifitDetail record)
		{
			return weekBenifitDetailDao.updateByPrimaryKeySelective (record);
		}


	@Override
	public int updateExample(WeekBenifitDetail record,
			WeekBenifitDetailExample example) {
		
		return weekBenifitDetailDao.updateByExampleSelective(record,example);
	}
}
