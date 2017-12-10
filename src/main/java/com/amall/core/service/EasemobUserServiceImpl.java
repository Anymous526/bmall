package com.amall.core.service;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amall.core.bean.EasemobUser;
import com.amall.core.bean.User;
import com.amall.core.dao.EasemobUserMapper;
import com.amall.core.dao.UserMapper;
import com.amall.core.im.IMAssembly;
import com.amall.core.im.api.IMUserAPI;
import com.amall.core.im.comm.ClientContext;
import com.amall.core.im.comm.EasemobRestAPIFactory;
import com.amall.core.im.comm.body.IMUserBody;
import com.amall.core.im.comm.utils.PassWordUtils;

@Service
@Transactional
public class EasemobUserServiceImpl implements IEasemobUserService {

	private final static Logger log = LoggerFactory.getLogger(IMAssembly.class);

	static EasemobRestAPIFactory factory = ClientContext.getInstance()
			.init(ClientContext.INIT_FROM_PROPERTIES).getAPIFactory();

	static IMUserAPI userAPI = (IMUserAPI) factory
			.newInstance(EasemobRestAPIFactory.USER_CLASS);

	@Resource
	EasemobUserMapper easemobUserDao;

	@Resource
	UserMapper userDao;
	
	@Override
	public Long insertEasemobUser(EasemobUser eUser) {

		User user = userDao.selectByPrimaryKey(eUser.getUserId());
		if (user == null) {
			log.warn("User ID does not exist,ID is :{}", eUser.getUserId());
			return null;
		}
		EasemobUser easemobUser = new EasemobUser();

		easemobUser.setUserId(user.getId());

		easemobUser.setUsername(user.getUsername());

		String password = PassWordUtils.getPassword();
		easemobUser.setPassword(password);
		
		String nickname = StringUtils.isEmpty(eUser.getNickname()) ? user
				.getUsername() : eUser.getNickname();
		// 设置nickname 为用户名称
		easemobUser.setNickname(nickname);

		Long key = easemobUserDao.insertEasemobUser(easemobUser);

		if (null == key || key.intValue() == 0) {
			log.error("New Easemob User Fail,User Name is :{}",
					user.getUsername());
		} else {
			// 密码存储在环信未加密
			IMUserBody imUser = new IMUserBody(user.getUsername(), password,
					nickname);
			userAPI.createNewIMUserSingle(imUser);
		}
		return null;
	}

	@Override
	public EasemobUser getUser(Long amallUserId) {
		EasemobUser user = easemobUserDao.getUser(amallUserId);
		if (user != null) {
			return user;
		}

		User amallUser = userDao.selectByPrimaryKey(amallUserId);
		if (null == amallUser) {
			log.warn("User ID does not exist,ID is :{}", amallUserId);
			return null;
		}

		EasemobUser eaUser = new EasemobUser();
		eaUser.setUserId(amallUserId);
		insertEasemobUser(eaUser);

		EasemobUser easemobUser = easemobUserDao.getUser(amallUser.getId());

		if (null == easemobUser) {
			log.error("Easemob User creation failed,User Name id :{}",
					amallUser.getUsername());
			return null;
		}
		return easemobUser;
	}

	@Override
	public Object deleteUserBacth(Long limit) {
		return userAPI.deleteIMUserBatch(limit);
	}

}
