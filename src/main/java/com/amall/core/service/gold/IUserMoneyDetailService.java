package com.amall.core.service.gold;

import java.util.List;

import com.amall.core.bean.doulog;
import com.amall.core.bean.doulogExample;
import com.amall.core.bean.userMoneyDetail;
import com.amall.core.bean.userMoneyDetailExample;
import com.amall.core.web.page.Pagination;

public abstract interface IUserMoneyDetailService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param GoldLog
	 * @return
	 */
	public int add(userMoneyDetail example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public userMoneyDetail getByKey(Long id);
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
	public int deleteByExample(userMoneyDetailExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(userMoneyDetail record);
	
	public Pagination getObjectListWithPage(userMoneyDetailExample example);
	
	public List<userMoneyDetail> getObjectList(userMoneyDetailExample example);
	
	public Integer getObjectListCount(userMoneyDetailExample example);
}
