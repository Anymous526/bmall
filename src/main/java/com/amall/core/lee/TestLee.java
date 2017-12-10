package com.amall.core.lee;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;

import com.amall.core.bean.User;
import com.amall.core.service.user.IUserService;

public class TestLee {

	@Autowired
	private LeeService leeService;
	
	@Autowired
	private IUserService userService;
	
	public void hzLee(){
		BigDecimal upgradeAmount = new BigDecimal(100);
		User user = userService.getByKey(Long.valueOf(32824));
		leeService.hzLee(user, upgradeAmount);
	}
	
	public static void main(String[] args) {
//		LeeConfig leeConfig = LeeConfigurationBuilder.getInstance().parseConfiguration();
//		System.out.println(leeConfig.getV_zero().getHzLee());
//		System.out.println(leeConfig.getV_one().getHzLee());
//		System.out.println(leeConfig.getV_two().getHzLee());
		
//		new TestLee().hzLee();
		
		
		BigDecimal a1 = BigDecimal.valueOf(0.10);
		BigDecimal a2 = BigDecimal.valueOf(0);
		
		System.out.println(a1.compareTo(a2));
	}
}
