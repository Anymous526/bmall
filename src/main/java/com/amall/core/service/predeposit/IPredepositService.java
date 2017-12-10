package com.amall.core.service.predeposit;

import java.util.List;

import com.amall.core.bean.Predeposit;
import com.amall.core.bean.PredepositExample;
import com.amall.core.bean.PredepositWithBLOBs;
import com.amall.core.web.page.Pagination;

public abstract interface IPredepositService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param Predeposit
	 * @return
	 */
	public Long add(PredepositWithBLOBs example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PredepositWithBLOBs getByKey(Long id);
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
	public Integer deleteByExample(PredepositExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PredepositWithBLOBs record);
	
	public Pagination getObjectListWithPage(PredepositExample example);
	
	public List<Predeposit> getObjectList(PredepositExample example);
	
	public Integer getObjectListCount(PredepositExample example);
}
