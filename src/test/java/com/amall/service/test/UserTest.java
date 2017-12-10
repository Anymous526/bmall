package com.amall.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.Store;
import com.amall.core.bean.User;
import com.amall.core.service.user.IUserService;

public class UserTest extends SpringJunitTest {

	@Autowired
	private IUserService userService;
	
	@Test
	public void getUserByKey() {
		User uuu =userService.getByKey(1L);
		System.out.println(uuu);
	}
	
}
