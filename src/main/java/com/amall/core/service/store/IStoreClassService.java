package com.amall.core.service.store;

import java.util.List;
import java.util.Map;
import com.amall.core.bean.StoreClass;
import com.amall.core.bean.StoreClassExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>
 * Title: IStoreClassService
 * </p>
 * <p>
 * Description: 店铺类型管理service
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-29下午7:09:13
 * @version 1.0
 */
public abstract interface IStoreClassService
{

	/**
	 * 
	 * <p>
	 * Title: add
	 * </p>
	 * <p>
	 * Description: 添加
	 * </p>
	 * 
	 * @param StoreClass
	 * @return
	 */
	public Long add (StoreClass example);

	/**
	 * 
	 * <p>
	 * Title: getByKey
	 * </p>
	 * <p>
	 * Description: 根据id查询单个对象
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public StoreClass getByKey (Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByKey
	 * </p>
	 * <p>
	 * Description: 根据id单个删除
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	public Integer deleteByKey (Long id);

	/**
	 * 
	 * <p>
	 * Title: deleteByExample
	 * </p>
	 * <p>
	 * Description: 根据条件删除
	 * </p>
	 * 
	 * @param example
	 * @return
	 */
	public Integer deleteByExample (StoreClassExample example);

	/**
	 * 
	 * <p>
	 * Title: updateByObject
	 * </p>
	 * <p>
	 * Description: 修改
	 * </p>
	 * 
	 * @param record
	 * @return
	 */
	public Integer updateByObject (StoreClass record);

	public Pagination getObjectListWithPage (StoreClassExample example);

	public List <StoreClass> getObjectList (StoreClassExample example);

	public Integer getObjectListCount (StoreClassExample example);

	public List <StoreClass> selectChilds (Map map);
}
