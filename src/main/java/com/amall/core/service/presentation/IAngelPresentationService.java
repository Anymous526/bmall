package com.amall.core.service.presentation;

import java.util.List;

import com.amall.core.bean.AngelPresentation;
import com.amall.core.bean.AngelPresentationExample;
import com.amall.core.web.page.Pagination;


public abstract interface IAngelPresentationService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param AngelPresentation
	 * @return
	 */
	public Long add(AngelPresentation example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public AngelPresentation getByKey(Long id);
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
	public Integer deleteByExample(AngelPresentationExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(AngelPresentation record);
	
	public Pagination getObjectListWithPage(AngelPresentationExample example);
	
	public List<AngelPresentation> getObjectList(AngelPresentationExample example);
	
	public List<AngelPresentation> getObjectListOfGetUserId(Long getUserId);
	
	public List<AngelPresentation> getObjectListOfGiveUserId(Long giveUserId);
	
	public Integer getObjectListCount(AngelPresentationExample example);
	
}
