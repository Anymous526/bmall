package com.amall.core.dao;

import com.amall.core.bean.EasemobUser;

public interface EasemobUserMapper {
	
	Long insertEasemobUser(EasemobUser user);

	EasemobUser getUser(Long amallUserId);


}
