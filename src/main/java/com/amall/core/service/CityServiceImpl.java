package com.amall.core.service;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.amall.core.bean.City;
import com.amall.core.bean.CityPartNerSum;
import com.amall.core.bean.CityPartNerSumExample;
import com.amall.core.dao.CityMapper;
import com.amall.core.dao.CityPartNerSumMapper;

@Service
@Transactional
public class CityServiceImpl implements ICityService
{

	@Resource
	private CityMapper cityDao;

	@Resource
	private CityPartNerSumMapper parDao;

	@Transactional(readOnly = true)
	public City getBykey (Long id)
		{
			return cityDao.selectByPrimaryKey (id);
		}

	/*
	 * @Transactional(readOnly=true)
	 * public List<CityPartNerSum> selectBykey(com.amall.core.bean.CityPartNerSum userid) {
	 * return parDao.selectByuserId(userid);
	 * }
	 */
	@Transactional(readOnly = true)
	public List <CityPartNerSum> selectyueji (CityPartNerSumExample example)
		{
			return parDao.selectByExample (example);
		}

	@Override
	public int count (CityPartNerSumExample example)
		{
			return parDao.countByExample (example);
		}
}
