package com.amall.core.service.gold;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.trend;
import com.amall.core.bean.trendExample;
import com.amall.core.dao.trendMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class TrendServiceImpl implements ITrendService {

	@Resource
	private trendMapper trendDao;

	public int add(trend example) {
		return trendDao.insertSelective(example);
	}

	public trend getByKey(Integer id) {
		return trendDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Integer id) {
		return trendDao.deleteByPrimaryKey(id);
	}

	public int deleteByExample(trendExample example) {
		return trendDao.deleteByExample(example);
	}

	public Integer updateByObject(trend record) {
		return trendDao.updateByPrimaryKeySelective(record);
	}

	public Integer getObjectListCount(trendExample example) {
		return trendDao.countByExample(example);
	}

	@Override
	public Pagination getObjectListWithPage(trendExample example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<trend> getObjectList(trendExample example) {
		return trendDao.selectByExample(example);
	}

}
