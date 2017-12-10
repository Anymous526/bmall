package com.amall.core.service.user;

import java.util.List;
import java.util.Map;

import com.amall.core.bean.BuZhu;
import com.amall.core.bean.BuZhuExample;
import com.amall.core.bean.FengHong;
import com.amall.core.bean.FengHongExample;
import com.amall.core.bean.Role;
import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.web.page.Pagination;
/**
 * 
 * <p>Title: IUserService</p>
 * <p>Description: 用户管理信息service</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-29上午11:34:31
 * @version 1.0
 */
public interface IUserService{
	/**
	 * 
	 * <p>Title: add</p>
	 * <p>Description: 添加</p>
	 * @param User
	 * @return
	 */
	public Long add(User example);
	
	/**
	 * 
	 * <p>Title: getByKey</p>
	 * <p>Description: 根据id查询单个对象</p>
	 * @param id
	 * @return
	 */
	public User getByKey(Long id);
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
	public Integer deleteByExample(UserExample example);
	
	/**
	 * 
	 * <p>Title: updateByObject</p>
	 * <p>Description: 修改</p>
	 * @param record
	 * @return
	 */
	public Integer updateByObject(User record);
	
	public Pagination getObjectListWithPage(UserExample example);
	
	public List<User> getObjectList(UserExample example);
	
	public User getUserOfUserName(String username);
	
	public Integer getObjectListCount(UserExample example);
	
	public Integer updateUsers(User record);
	/**
	 * 
	 * <p>Title: findRoleByUserId</p>
	 * <p>Description:根据map对象得到角色 </p>
	 * @param map
	 * @return
	 */
	List<Role> findRoleByUserId(Map map);
	/**
	 * 
	 * <p>Title: insertUserRole</p>
	 * <p>Description:插入amall_user_role表中 </p>
	 * @param map
	 * @return
	 */
	int insertUserRole(Map map);
	/**
	 * 查询用户会员数
	 * @param userId
	 * @return
	 */
	public Integer findTotalMember(Long userId);
	
	/***
	 * 城市代理商补助
	 * @param map
	 * @return
	 */
	List<BuZhu> selectBuZhu(BuZhuExample example);
	
	/***
	 * 城市代理商分红
	 */
	List<FengHong> selectFengHong(FengHongExample example);
}
