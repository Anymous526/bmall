package com.amall.core.service.user;

import java.util.List;

import com.amall.core.bean.UserGoodsClass;
import com.amall.core.bean.UserGoodsClassExample;
import com.amall.core.web.page.Pagination;

public interface IUserGoodsClassService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param UserGoodsClass
	 * @return
	 */
	public Long add(UserGoodsClass example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public UserGoodsClass getByKey(Long id);
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
	public Integer deleteByExample(UserGoodsClassExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(UserGoodsClass record);
	
	public Pagination getObjectListWithPage(UserGoodsClassExample example);
	
	public List<UserGoodsClass> getObjectList(UserGoodsClassExample example);
	
	public Integer getObjectListCount(UserGoodsClassExample example);
	
}
