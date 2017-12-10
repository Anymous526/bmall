package com.amall.core.service.cloud;

import java.util.List;
import com.amall.core.bean.CloudOnline;
import com.amall.core.bean.CloudOnlineExample;
import com.amall.core.web.page.Pagination;

public abstract interface ICloudOnlineService
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
	 * @param CloudOnline
	 * @return
	 */
	public Integer add (CloudOnline example);

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
	public CloudOnline getByKey (Long id);

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
	public Integer deleteByExample (CloudOnlineExample example);

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
	public Integer updateByObject (CloudOnline record);

	public Pagination getObjectListWithPage (CloudOnlineExample example);

	public List <CloudOnline> getObjectList (CloudOnlineExample example);

	public Integer getObjectListCount (CloudOnlineExample example);

	public List <CloudOnline> getCloudOnlineOfUserId (long userId);

	public CloudOnline getCloudOnlineOfUserIdAndGoodsId (long userId , long goodsId);
}
