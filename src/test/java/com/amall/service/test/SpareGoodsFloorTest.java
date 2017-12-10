package com.amall.service.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.SpareGoodsFloor;
import com.amall.core.service.spare.ISpareGoodsFloorService;

public class SpareGoodsFloorTest extends SpringJunitTest{
	
	@Autowired
	private ISpareGoodsFloorService goodsFloorService;
	
	@Test
	public void add(){
		SpareGoodsFloor goodsFloor = new SpareGoodsFloor();
		goodsFloor.setId(2L);;
		goodsFloor.setAddtime(new Date());
		goodsFloor.setSequence(1);
		goodsFloor.setDeletestatus(false);
		goodsFloorService.add(goodsFloor);
	}
	
	@Test
	public void getOne(){
		SpareGoodsFloor gfs = goodsFloorService.getByKey(1L);
		System.out.println(gfs);
	}
	
	
	
}
