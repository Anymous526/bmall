package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Navigation;
import com.amall.core.bean.NavigationExample;
import com.amall.core.dao.NavigationMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class NavigationServiceImpl implements INavigationService {

	@Resource 
	private NavigationMapper  navigationDao;

	public Long add(Navigation example) {
		return navigationDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Navigation getByKey(Long id) {
		return navigationDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return navigationDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(NavigationExample example) {
		return navigationDao.deleteByExample(example);
	}

	public Integer updateByObject(Navigation record) {
		
		return navigationDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(NavigationExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),navigationDao.countByExample(example));
		p.setList(navigationDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Navigation> getObjectList(NavigationExample example) {
		return navigationDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(NavigationExample example) {
		return navigationDao.countByExample(example);
	}
}
