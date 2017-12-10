package com.amall.core.service.goods;

import java.util.List;
import com.amall.core.bean.Goods2Spec;
import com.amall.core.bean.Goods2SpecExample;

public interface IGoods2SpecService
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
	 * @param Res
	 * @return
	 */
	public Integer add (Goods2Spec example);

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
	public Integer deleteByExample (Goods2SpecExample example);

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
	public Integer updateByObject (Goods2Spec record);

	public List <Goods2Spec> getObjectList (Goods2SpecExample example);

	public Integer getObjectListCount (Goods2SpecExample example);
}
