package com.amall.core.service;


import com.amall.core.bean.EasemobUser;


public interface IEasemobUserService {
	
	/**
	 * 新增一个环信用户
	 * @param user userid 必填 。nickname 选填。 其他无需填写
	 * @return
	 */
	Long insertEasemobUser(EasemobUser user);

	EasemobUser getUser(Long amallUserId);
	
	Object deleteUserBacth(Long limit);
}
