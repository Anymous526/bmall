package com.amall.core.service.article;

import java.util.List;

import com.amall.core.bean.Article;
import com.amall.core.bean.ArticleExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IArticleService</p>
 * <p>Description: 活动信息管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:29:29
 * @version 1.0
 */
public abstract interface IArticleService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Article
	 * @return
	 */
	public Long add(Article example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Article getByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByKey</p>
	 * <p>Description: 根据id单个删除</p>
	 * @param id
	 * @return
	 */
	public Integer deleteByKey(Long id);
	/**
	 * 
	 * <p>Title: deleteByExample</p>
	 * <p>Description: 根据条件删除</p>
	 * @param example
	 * @return
	 */
	public Integer deleteByExample(ArticleExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Article record);
	
	public Pagination getObjectListWithPage(ArticleExample example);
	
	public List<Article> getObjectList(ArticleExample example);
	
	public Integer getObjectListCount(ArticleExample example);
}
