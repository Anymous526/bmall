package com.amall.core.service.privilege;

import java.util.List;

import com.amall.core.bean.Res;
import com.amall.core.bean.ResExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IResService</p>
 * <p>Description: 权限管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午7:28:11
 * @version 1.0
 */
public interface IResService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Res
	 * @return
	 */
	public Long add(Res example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Res getByKey(Long id);
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
	public Integer deleteByExample(ResExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Res record);
	
	public Pagination getObjectListWithPage(ResExample example);
	
	public List<Res> getObjectList(ResExample example);
	
	public Integer getObjectListCount(ResExample example);
}
