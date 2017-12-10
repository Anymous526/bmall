package com.amall.core.service;

import java.util.List;
import com.amall.core.bean.RedPaper;
import com.amall.core.bean.RedPaperExample;

public interface IRedPaperService
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
	 * @param Favorite
	 * @return
	 */
	public Integer add (RedPaper example);

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
	public RedPaper getByKey (Long id);

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
	public Integer deleteByExample (RedPaperExample example);

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
	public Integer updateByObject (RedPaper record);

	public List <RedPaper> getObjectList (RedPaperExample example);

	public Integer getObjectListCount (RedPaperExample example);
}
