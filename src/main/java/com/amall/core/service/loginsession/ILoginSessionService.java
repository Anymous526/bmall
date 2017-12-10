package com.amall.core.service.loginsession;

import java.util.List;

import com.amall.core.bean.LoginSession;
import com.amall.core.bean.LoginSessionExample;


public abstract interface ILoginSessionService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param LoginSession
	 * @return
	 */
	public Integer add(LoginSession example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public LoginSession getByKey(Long id);
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
	public Integer deleteByExample(LoginSessionExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(LoginSession record);
	
	public List<LoginSession> getObjectList(LoginSessionExample example);
	
	public Integer getObjectListCount(LoginSessionExample example);
	
	public LoginSession getLoginSessionOfUsername(String username);
}
