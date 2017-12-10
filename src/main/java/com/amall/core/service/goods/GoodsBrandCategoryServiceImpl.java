package com.amall.core.service.goods;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.GoodsBrandCategory;
import com.amall.core.bean.GoodsBrandCategoryExample;
import com.amall.core.dao.GoodsBrandCategoryMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class GoodsBrandCategoryServiceImpl implements
		IGoodsBrandCategoryService {

	@Resource 
	private GoodsBrandCategoryMapper  goodsBrandCategoryDao;

	public Long add(GoodsBrandCategory example) {
		return goodsBrandCategoryDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public GoodsBrandCategory getByKey(Long id) {
		return goodsBrandCategoryDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return goodsBrandCategoryDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(GoodsBrandCategoryExample example) {
		return goodsBrandCategoryDao.deleteByExample(example);
	}

	public Integer updateByObject(GoodsBrandCategory record) {
		return goodsBrandCategoryDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(GoodsBrandCategoryExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),goodsBrandCategoryDao.countByExample(example));
		p.setList(goodsBrandCategoryDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<GoodsBrandCategory> getObjectList(
			GoodsBrandCategoryExample example) {
		return goodsBrandCategoryDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(GoodsBrandCategoryExample example) {
		return goodsBrandCategoryDao.countByExample(example);
	}

}
