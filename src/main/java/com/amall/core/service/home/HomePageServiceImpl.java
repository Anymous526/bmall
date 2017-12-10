package com.amall.core.service.home;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.HomePage;
import com.amall.core.bean.HomePageExample;
import com.amall.core.dao.HomePageMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class HomePageServiceImpl implements IHomePageService {

	@Resource
	private HomePageMapper homePageDao;

	public Long add(HomePage example) {
		
		return homePageDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public HomePage getByKey(Long id) {
		
		return homePageDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return homePageDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(HomePageExample example) {
		
		return homePageDao.deleteByExample(example);
	}

	public Integer updateByObject(HomePage record) {
		
		return homePageDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(HomePageExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),homePageDao.countByExample(example));
		p.setList(homePageDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<HomePage> getObjectList(HomePageExample example) {
		
		return homePageDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(HomePageExample example) {
		
		return homePageDao.countByExample(example);
	}


}
