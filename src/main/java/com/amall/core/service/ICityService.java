package com.amall.core.service;

import java.util.List;
import com.amall.core.bean.City;
import com.amall.core.bean.CityPartNerSum;
import com.amall.core.bean.CityPartNerSumExample;

public interface ICityService
{

	/**
	 * 根据城市代理商id查询所属级别
	 * 
	 * @param id
	 * @return
	 */
	public City getBykey (Long id);

	/**
	 * 根据用户userid查询该城市代理商的分红金额
	 * 
	 * @param userid
	 * @return
	 */
	/*
	 * public List<CityPartNerSum> selectBykey(com.amall.core.bean.CityPartNerSum userid);
	 */
	/**
	 * 根据城市代理商的Userid查询月季收入
	 */
	public List <CityPartNerSum> selectyueji (CityPartNerSumExample example);

	public int count (CityPartNerSumExample example);
}
