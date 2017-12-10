package com.amall.mapper.test;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.amall.common.junit.SpringJunitTest;
import com.amall.core.bean.GoodsCart;
import com.amall.core.bean.OrderForm;
import com.amall.core.bean.OrderFormExample;
import com.amall.core.service.orderForm.IOrderFormService;
import com.amall.core.web.tools.CommUtil;

public class MapperTest{
	
	@Autowired
	private IOrderFormService orderFormService;
	
	
	@Test
	public void test(){
		/*OrderForm orderForm = this.orderFormService.getByKey(Long.valueOf(4));
		
		List<GoodsCart> goodsCarts = orderForm.getGcs();
		Assert.assertNull(goodsCarts);*/
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		
		
		System.out.println(CommUtil.formatDate(String.valueOf(calendar.get(calendar.YEAR)-1)+"-12-31"));
		
		System.out.println();

		System.out.println(CommUtil.formatDate("2014-12-31"));
	}

}
