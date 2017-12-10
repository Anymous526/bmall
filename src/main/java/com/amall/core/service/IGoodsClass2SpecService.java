package com.amall.core.service;


import java.util.List;

import com.amall.core.bean.GoodsClass2Spec;
import com.amall.core.bean.GoodsClass2SpecExample;

/**
 * 
 * <p>Title: IPaymentService</p>
 * <p>Description: 商品类型管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  tangxiang
 * @date	2015-8-13
 * @version 1.0
 */
public interface IGoodsClass2SpecService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Payment
	 * @return
	 */
	public int add(GoodsClass2Spec example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public GoodsClass2Spec getByKey(Long id);
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
	public Integer deleteByExample(GoodsClass2SpecExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(GoodsClass2Spec record);
	
	public List<GoodsClass2Spec> getObjectList(GoodsClass2SpecExample example);
	
	public Integer getObjectListCount(GoodsClass2SpecExample example);

}
