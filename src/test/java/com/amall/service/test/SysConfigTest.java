package com.amall.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.SysConfigExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.service.system.ISysConfigService;

public class SysConfigTest extends SpringJunitTest {
	@Autowired
	private ISysConfigService configService;
	
	@Test
	public void getSys() {
		SysConfig s = configService.getByKey(1L);
		System.out.print(s);
	}
	
	@Test
	public void getSysConfig(){
		
		SysConfigWithBLOBs bs = configService.getSysConfig();
		
		System.out.println(bs);
	}
}
