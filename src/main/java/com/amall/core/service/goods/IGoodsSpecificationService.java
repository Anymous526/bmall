package com.amall.core.service.goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.amall.core.bean.GoodsSpecProperty;
import com.amall.core.bean.GoodsSpecification;
import com.amall.core.bean.GoodsSpecificationExample;
import com.amall.core.web.page.Pagination;

public abstract interface IGoodsSpecificationService
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
	 * @param GoodsSpecification
	 * @return
	 */
	public Long add (GoodsSpecification example);

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
	public GoodsSpecification getByKey (Long id);

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
	public Integer deleteByExample (GoodsSpecificationExample example);

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
	public Integer updateByObject (GoodsSpecification record);

	public Pagination getObjectListWithPage (GoodsSpecificationExample example);

	public List <GoodsSpecification> getObjectList (GoodsSpecificationExample example);

	public Integer getObjectListCount (GoodsSpecificationExample example);

	public List <GoodsSpecification> selectGoodsSpecification (Map map);// 第三张表，根据GoodsType得到GoodsSpecification

	public List <GoodsSpecification> selectSpec (HashMap map);

	public List <GoodsSpecProperty> selectSpecAll (HashMap map);
}
