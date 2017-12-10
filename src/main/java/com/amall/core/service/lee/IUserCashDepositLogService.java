package com.amall.core.service.lee;

import java.util.List;

import com.amall.core.bean.UserCashDepositLogExample;
import com.amall.core.web.page.Pagination;
import com.amall.core.bean.UserCashDepositLog;

public interface IUserCashDepositLogService{
	
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param UserCashDepositLog
	 * @return
	 */
	public Integer add(UserCashDepositLog example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public UserCashDepositLog getByKey(Long id);
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
	public Integer deleteByExample(UserCashDepositLogExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(UserCashDepositLog record);
	
	public Pagination getObjectListWithPage(UserCashDepositLogExample example);
	
	public List<UserCashDepositLog> getObjectList(UserCashDepositLogExample example);
	
	public Integer getObjectListCount(UserCashDepositLogExample example);
	
}
