package com.amall.core.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Favorite;
import com.amall.core.bean.FavoriteExample;
import com.amall.core.dao.FavoriteMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class FavoriteServiceImpl implements IFavoriteService {

	@Resource
	private FavoriteMapper favoriteDao;

	public Long add(Favorite example) {
		return favoriteDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Favorite getByKey(Long id) {
		return favoriteDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return favoriteDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(FavoriteExample example) {
		return favoriteDao.deleteByExample(example);
	}

	public Integer updateByObject(Favorite record) {
		return favoriteDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(FavoriteExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),favoriteDao.countByExample(example));
		p.setList(favoriteDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Favorite> getObjectList(FavoriteExample example) {
		return favoriteDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(FavoriteExample example) {
		return favoriteDao.countByExample(example);
	}

}
