package com.amall.core.service.store;

import java.util.List;
import com.amall.core.bean.StoreExample;
import com.amall.core.bean.StoreWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>
 * Title: IStoreService
 * </p>
 * <p>
 * Description: 店铺管理service
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-4-29上午11:38:10
 * @version 1.0
 */
public abstract interface IStoreService
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
	 * @param Store
	 * @return
	 */
	public Long add (StoreWithBLOBs example);

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
	public StoreWithBLOBs getByKey (Long id);

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
	public Integer deleteByExample (StoreExample example);

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
	public Integer updateByObject (StoreWithBLOBs record);

	public Pagination getObjectListWithPage (StoreExample example);

	public List <StoreWithBLOBs> getObjectList (StoreExample example);

	public Integer getObjectListCount (StoreExample example);

	public int getStoreValidation (String storeName , String storeOwerCard , String telephone);

	public StoreWithBLOBs getStoreValidation1 (String storeName , String storeOwerCard , String telephone);

	public int getStoreNameValidation (String storeName);

	public int getStoreOwerCardValidation (String storeOwerCard);

	public int getStoreTelephoneValidation (String storeTelpehone);
}
