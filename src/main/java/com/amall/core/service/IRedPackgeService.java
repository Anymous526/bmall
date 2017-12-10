package com.amall.core.service;

import java.util.List;

import com.amall.core.bean.RedPackge;
import com.amall.core.bean.RedPackgeExample;
import com.amall.core.web.page.Pagination;

public interface IRedPackgeService {

	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Favorite
	 * @return
	 */
	public Integer add(RedPackge example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public RedPackge getByKey(Long id);
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
	public Integer deleteByExample(RedPackgeExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(RedPackge record);
	
	
	public List<RedPackge> getObjectList(RedPackgeExample example);
	
	public Integer getObjectListCount(RedPackgeExample example);
	
	public Pagination getObjectListWithPage(RedPackgeExample example);
}
