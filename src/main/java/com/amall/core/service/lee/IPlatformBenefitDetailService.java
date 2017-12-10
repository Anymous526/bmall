package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.PlatformBenefitDetailExample;
import com.amall.core.bean.PlatformBenefitDetail;
import com.amall.core.web.page.Pagination;

public interface IPlatformBenefitDetailService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param PlatformBenefitDetail
	 * @return
	 */
	public Long add(PlatformBenefitDetail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public PlatformBenefitDetail getByKey(Long id);
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
	public Integer deleteByExample(PlatformBenefitDetailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(PlatformBenefitDetail record);
	
	public Pagination getObjectListWithPage(PlatformBenefitDetailExample example);
	
	public List<PlatformBenefitDetail> getObjectList(PlatformBenefitDetailExample example);
	
	public Integer getObjectListCount(PlatformBenefitDetailExample example);
	
}
