package com.amall.core.service.article;

import java.util.List;

import com.amall.core.bean.ArticleClass;
import com.amall.core.bean.ArticleClassExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IArticleClassService</p>
 * <p>Description: 文章分类管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午6:29:03
 * @version 1.0
 */
public abstract interface IArticleClassService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param ArticleClass
	 * @return
	 */
	public Long add(ArticleClass example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public ArticleClass getByKey(Long id);
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
	public Integer deleteByExample(ArticleClassExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(ArticleClass record);
	
	public Pagination getObjectListWithPage(ArticleClassExample example);
	
	public List<ArticleClass> getObjectList(ArticleClassExample example);
	
	public Integer getObjectListCount(ArticleClassExample example);
}
