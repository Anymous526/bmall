package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.Document;
import com.amall.core.bean.DocumentExample;
import com.amall.core.web.page.Pagination;

public interface IDocumentService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Document
	 * @return
	 */
	public Long add(Document example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Document getByKey(Long id);
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
	public Integer deleteByExample(DocumentExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Document record);
	
	public Pagination getObjectListWithPage(DocumentExample example);
	
	public List<Document> getObjectList(DocumentExample example);
	
	public Integer getObjectListCount(DocumentExample example);
}
