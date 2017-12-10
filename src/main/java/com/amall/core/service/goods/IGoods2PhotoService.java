package com.amall.core.service.goods;

import java.util.List;
import com.amall.core.bean.Goods2Photo;
import com.amall.core.bean.Goods2PhotoExample;

public interface IGoods2PhotoService
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
	public Integer add (Goods2Photo example);

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
	public Integer deleteByExample (Goods2PhotoExample example);

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
	public Integer updateByObject (Goods2Photo record);

	public List <Goods2Photo> getObjectList (Goods2PhotoExample example);

	public Integer getObjectListCount (Goods2PhotoExample example);
}
