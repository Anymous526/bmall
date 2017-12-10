package com.amall.core.service.store;

import java.util.List;

import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ITemplateService</p>
 * <p>Description: 模板管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午6:45:19
 * @version 1.0
 */
public abstract interface ITemplateService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Template
	 * @return
	 */
	public Long add(Template example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Template getByKey(Long id);
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
	public Integer deleteByExample(TemplateExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Template record);
	
	public Pagination getObjectListWithPage(TemplateExample example);
	
	public List<Template> getObjectList(TemplateExample example);
	
	public Integer getObjectListCount(TemplateExample example);
}
