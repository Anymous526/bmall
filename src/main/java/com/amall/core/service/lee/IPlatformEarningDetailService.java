package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.PlatformEarningDetailExample;
import com.amall.core.bean.PlatformEarningDetail;
import com.amall.core.web.page.Pagination;

public interface IPlatformEarningDetailService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PlatformEarningDetail
	 * @return
	 */
	public Long add(PlatformEarningDetail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PlatformEarningDetail getByKey(Long id);
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
	public Integer deleteByExample(PlatformEarningDetailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PlatformEarningDetail record);
	
	public Pagination getObjectListWithPage(PlatformEarningDetailExample example);
	
	public List<PlatformEarningDetail> getObjectList(PlatformEarningDetailExample example);
	
	public Integer getObjectListCount(PlatformEarningDetailExample example);
	
}
