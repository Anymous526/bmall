package com.amall.service.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.GoodsClassWithBLOBs;
import com.amall.core.service.goods.IGoodsClassService;

public class GoodsClassTest extends SpringJunitTest{

	@Autowired
	private IGoodsClassService goodsClassService;
	
	@Test
	public void getOne() {
		GoodsClassWithBLOBs byKey = goodsClassService.getByKey(2L);
		System.out.println(byKey);
	}

}
