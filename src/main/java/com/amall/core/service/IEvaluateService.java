package com.amall.core.service;

import java.util.List;
import com.amall.core.bean.EvaluateExample;
import com.amall.core.bean.EvaluateWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>
 * Title: IEvaluateService
 * </p>
 * <p>
 * Description: 评价管理service
 * </p>
 * <p>
 * Company: www.hg-sem.com
 * </p>
 * 
 * @author ljx
 * @date 2015-5-1上午12:34:07
 * @version 1.0
 */
public abstract interface IEvaluateService
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
	 * @param Evaluate
	 * @return
	 */
	public Long add (EvaluateWithBLOBs example);

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
	public EvaluateWithBLOBs getByKey (Long id);

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
	public Integer deleteByExample (EvaluateExample example);

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
	public Integer updateByObject (EvaluateWithBLOBs record);

	public Pagination getObjectListWithPage (EvaluateExample example);

	public List <EvaluateWithBLOBs> getObjectList (EvaluateExample example);

	public Integer getObjectListCount (EvaluateExample example);

	public List <EvaluateWithBLOBs> selectByOfLeftJoinStoreId (Long id);

	List <EvaluateWithBLOBs> selectByDistinctGoods ( );
}
