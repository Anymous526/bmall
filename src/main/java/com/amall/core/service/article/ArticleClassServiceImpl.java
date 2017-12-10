package com.amall.core.service.article;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.ArticleClass;
import com.amall.core.bean.ArticleClassExample;
import com.amall.core.dao.ArticleClassMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ArticleClassServiceImpl implements IArticleClassService {

	@Resource
	private ArticleClassMapper articleClassDao;

	public Long add(ArticleClass example) {
		return articleClassDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public ArticleClass getByKey(Long id) {
		return articleClassDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return articleClassDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ArticleClassExample example) {
		return articleClassDao.deleteByExample(example);
	}

	public Integer updateByObject(ArticleClass record) {
		return articleClassDao.updateByPrimaryKeySelective(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ArticleClassExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),articleClassDao.countByExample(example));
		p.setList(articleClassDao.selectByExampleWithPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<ArticleClass> getObjectList(ArticleClassExample example) {
		return articleClassDao.selectByExample(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ArticleClassExample example) {
		return articleClassDao.countByExample(example);
	}

	
}
