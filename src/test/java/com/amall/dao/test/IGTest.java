package com.amall.dao.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.IntegralGoods;
import com.amall.core.bean.IntegralGoodsExample;
import com.amall.core.dao.IntegralGoodsMapper;

public class IGTest extends SpringJunitTest{

	@Autowired
	private IntegralGoodsMapper goodsMapper;
	
	public void testGet(){
		IntegralGoods p = goodsMapper.selectByPrimaryKey(1L);
		System.out.println(p);
	}
}
