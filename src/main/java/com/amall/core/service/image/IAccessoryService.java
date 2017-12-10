package com.amall.core.service.image;

import java.util.List;

import com.amall.core.bean.Accessory;
import com.amall.core.bean.AccessoryExample;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IAccessoryService</p>
 * <p>Description: 图片管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29下午6:59:04
 * @version 1.0
 */
public abstract interface IAccessoryService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Accessory
	 * @return
	 */
	public Long add(Accessory example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public Accessory getByKey(Long id);
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
	public Integer deleteByExample(AccessoryExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(Accessory record);
	
	public Pagination getObjectListWithPage(AccessoryExample example);
	
	public List<Accessory> getObjectList(AccessoryExample example);
	
	public List<Accessory> getObjectListWithBLOBs(AccessoryExample example);
	
	public Integer getObjectListCount(AccessoryExample example);
	
	/**
	 * @todo 通过goods_id获取商品图片集合
	 * @return List<Accessory>
	 * @author wsw
	 * @date 2015年6月18日 下午4:50:58
	 * @param id
	 * @return
	 */
	public List<Accessory> getAccListOfGoodsByPhotoId(Long id);
	
}
