package com.amall.core.service.predeposit;

import java.util.List;

import com.amall.core.bean.PredepositCashExample;
import com.amall.core.bean.PredepositCashWithBLOBs;
import com.amall.core.web.page.Pagination;

/**
 * 
 * <p>Title: IPredepositCashService</p>
 * <p>Description: 预存现金管理service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-30下午11:58:48
 * @version 1.0
 */
public abstract interface IPredepositCashService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PredepositCash
	 * @return
	 */
	public Long add(PredepositCashWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PredepositCashWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(PredepositCashExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PredepositCashWithBLOBs record);
	
	public Pagination getObjectListWithPage(PredepositCashExample example);
	
	public List<PredepositCashWithBLOBs> getObjectList(PredepositCashExample example);
	
	public Integer getObjectListCount(PredepositCashExample example);
}
