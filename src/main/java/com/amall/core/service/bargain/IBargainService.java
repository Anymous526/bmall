package com.amall.core.service.bargain;

import java.util.List;

import com.amall.core.bean.Bargain;
import com.amall.core.bean.BargainExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IBargainService</p>
 * <p>Description: 特价管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-5-1上午12:15:47
 * @version 1.0
 */
public abstract interface IBargainService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Bargain
	 * @return
	 */
	public Long add(Bargain example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Bargain getByKey(Long id);
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
	public Integer deleteByExample(BargainExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Bargain record);
	
	public Pagination getObjectListWithPage(BargainExample example);
	
	public List<Bargain> getObjectList(BargainExample example);
	
	public Integer getObjectListCount(BargainExample example);
}
