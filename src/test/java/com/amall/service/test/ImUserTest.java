package com.amall.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amall.core.im.IMAssembly;
import com.amall.core.service.IEasemobUserService;
import com.amall.core.service.user.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:application-context.xml" }) 
public class ImUserTest {

	@Test
	public void test(){
		IMAssembly im = IMAssembly.newInstance();
		im.deleteIMUserBatch(500L);
	}

}
