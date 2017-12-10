package com.amall.core.service.article;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.Article;
import com.amall.core.bean.ArticleExample;
import com.amall.core.dao.ArticleMapper;
import com.amall.core.web.page.Pagination;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

	@Resource
	private ArticleMapper articleDao;

	public Long add(Article example) {
		return articleDao.insertSelective(example);
	}
	@Transactional(readOnly=true)
	public Article getByKey(Long id) {
		return articleDao.selectByPrimaryKey(id);
	}

	public Integer deleteByKey(Long id) {
		return articleDao.deleteByPrimaryKey(id);
	}

	public Integer deleteByExample(ArticleExample example) {
		return articleDao.deleteByExample(example);
	}

	public Integer updateByObject(Article record) {
		return articleDao.updateByPrimaryKeyWithBLOBs(record);
	}
	@Transactional(readOnly=true)
	public Pagination getObjectListWithPage(ArticleExample example) {
		Pagination p = new Pagination(example.getPageNo(),example.getPageSize(),articleDao.countByExample(example));
		p.setList(articleDao.selectByExampleWithBLOBsAndPage(example));
		return p;
	}
	@Transactional(readOnly=true)
	public List<Article> getObjectList(ArticleExample example) {
		return articleDao.selectByExampleWithBLOBs(example);
	}
	@Transactional(readOnly=true)
	public Integer getObjectListCount(ArticleExample example) {
		return articleDao.countByExample(example);
	}

	
	
}
