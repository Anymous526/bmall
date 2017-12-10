package com.amall.core.service.storevisit;

import java.util.List;
import com.amall.core.bean.StoreVisit;
import com.amall.core.bean.StoreVisitExample;

/**
 * 
 * <p>
 * Title: IStoreVisitService
 * </p>
 * <p>
 * Description: 活动信息管理service
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-30下午6:29:29
 * @version 1.0
 */
public abstract interface IStoreVisitService
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
	 * @param StoreVisit
	 * @return
	 */
	public Integer add (StoreVisit example);

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
	public StoreVisit getByKey (Long id);

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
	public Integer deleteByExample (StoreVisitExample example);

	public List <StoreVisit> getObjectList (StoreVisitExample example);

	public Integer getObjectListCount (StoreVisitExample example);
}
