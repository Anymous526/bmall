package com.amall.service.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.Accessory;
import com.amall.core.bean.GoodsExample;
import com.amall.core.bean.SysConfig;
import com.amall.core.service.image.IAccessoryService;
import com.amall.core.web.tools.CommUtil;

public class AccessoryTest extends SpringJunitTest{
	
	@Autowired
	private IAccessoryService accessoryService;
	
	@Test
	public void add(){
		
		Accessory acc = new  Accessory();
		acc.setId(1L);
		acc.setAddtime(new Date());
		SysConfig config = new SysConfig();
		config.setId(1L);
		
		//acc.setConfigId(1L);
		
		acc.setHeight(100);
		acc.setWidth(100);
		acc.setSize(10.0F);
		acc.setConfig(config);
		accessoryService.add(acc);
		
	}
	
	
	@Test
	public void getOne(){
		
		GoodsExample goodsExample = new GoodsExample();
		goodsExample.createCriteria().andIdEqualTo(1L).andZtcStatusLessThanOrEqualTo(1);
		
		Accessory acc = accessoryService.getByKey(1L);
		System.out.println(acc);
		System.out.println(acc.getUser());
		System.out.println(acc.getConfig());
		System.out.println(acc.getConfigId());
		System.out.println(acc.getGoods_list().size());
		System.out.println(acc.getGoods_main_list().size());
	}
	
	@Test
	public void testgetAccListOfGoodsByPhotoId(){
		List<Accessory> list = this.accessoryService.getAccListOfGoodsByPhotoId(CommUtil.null2Long(2));
		
		System.out.println(list.size());
		
	}

}
