package com.amall.core.service.sns;

import java.util.List;

import com.amall.core.bean.SnsAttention;
import com.amall.core.bean.SnsAttentionExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: ISnsAttentionService</p>
 * <p>Description: 好友关注管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:24:00
 * @version 1.0
 */
public  interface ISnsAttentionService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param SnsAttention
	 * @return
	 */
	public Long add(SnsAttention example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public SnsAttention getByKey(Long id);
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
	public Integer deleteByExample(SnsAttentionExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(SnsAttention record);
	
	public Pagination getObjectListWithPage(SnsAttentionExample example);
	
	public List<SnsAttention> getObjectList(SnsAttentionExample example);
	
	public Integer getObjectListCount(SnsAttentionExample example);
}
