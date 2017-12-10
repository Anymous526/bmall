package com.amall.core.service.home;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.HomePageGoodsClass;
import com.amall.core.bean.HomePageGoodsClassExample;
import com.amall.core.dao.HomePageGoodsClassMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class HomePageGoodsClassServiceImpl implements
		IHomePageGoodsClassService {

	@Resource
	private HomePageGoodsClassMapper homePageGoodsClassDao;

	public Long add(HomePageGoodsClass example) {
		
		return homePageGoodsClassDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public HomePageGoodsClass getByKey(Long id) {
		
		return homePageGoodsClassDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		
		return homePageGoodsClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(HomePageGoodsClassExample example) {
		
		return homePageGoodsClassDao.deleteByExample(example);
	}

	public Integer updateByObject(HomePageGoodsClass record) {
		
		return homePageGoodsClassDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(HomePageGoodsClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),homePageGoodsClassDao.countByExample(example));
		p.setList(homePageGoodsClassDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<HomePageGoodsClass> getObjectList(HomePageGoodsClassExample example) {
		
		return homePageGoodsClassDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(HomePageGoodsClassExample example) {
		
		return homePageGoodsClassDao.countByExample(example);
	}


}
