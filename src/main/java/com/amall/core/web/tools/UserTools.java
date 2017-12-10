package com.amall.core.web.tools;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.concurrent.SessionRegistry;
import org.springframework.stereotype.Component;

import com.amall.core.bean.User;
import com.amall.core.bean.UserExample;
import com.amall.core.bean.UserExample.Criteria;
import com.amall.core.service.user.IUserService;

/**
 * 
 * <p>Title: UserTools</p>
 * <p>Description: 用户工具类，判断用户是否在线</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-24下午4:33:20
 * @version 1.0
 */
@Component
public class UserTools {

	@Autowired
	private SessionRegistry sessionRegistry;

	@Autowired
	private IUserService userSerivce;
	
	/**
	 * 
	 * <p>Title: query_user</p>
	 * <p>Description: 查询所有在线用户/p>
	 * @return
	 */
	public List<User> query_user() {
//		List users = new ArrayList();
		Object[] objs = this.sessionRegistry.getAllPrincipals();
		List<String> l = new ArrayList<String>();
		for (int i = 0; i < objs.length; i++) {
			l.add(CommUtil.null2String(objs[i]));
			
		/*	User user = this.userSerivce.getObjByProperty("userName",
					CommUtil.null2String(objs[i]));
			users.add(user);*/
		}
		UserExample example = new UserExample();
		example.clear();
		Criteria or = example.createCriteria().andUsernameIn(l);
		List<User> users = userSerivce.getObjectList(example);
		return users;
	}
	/**
	 * 
	 * <p>Title: userOnLine</p>
	 * <p>Description: 根据传入的用户名，判断该用户是否在线 </p>
	 * @param userName 用户名称
	 * @return  boolean  
	 */
	public boolean userOnLine(String userName) {
		boolean ret = false;
		List<User> users = query_user();
		for (User user : users) {
			if ((user != null) && (user.getUsername().equals(userName.trim()))) {
				ret = true;
			}
		}
		return ret;
	}
}
