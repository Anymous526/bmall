package com.amall.dao.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.SysConfigExample;
import com.amall.core.bean.SysConfigWithBLOBs;
import com.amall.core.dao.SysConfigMapper;

public class SysConfigTest extends SpringJunitTest{
	
	@Autowired 
	private SysConfigMapper configMapper;
	
	@Test
	public void getSysConfig(){
			SysConfigExample configExample = new SysConfigExample();
			List<SysConfigWithBLOBs> configs = this.configMapper.selectByExampleWithBLOBs(configExample);
			
			System.out.println(configs);
	}
}
