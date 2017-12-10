package com.amall.core.action.buyer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.amall.core.service.integral.IIntegralGoodsOrderService;
import com.amall.core.service.integral.IIntegralGoodsService;
import com.amall.core.service.integral.IIntegralLogService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.service.user.IUserService;

@Controller
public class GoldIntegralExchangeAction {
	@Autowired
	   private ISysConfigService configService;
	 
	   @Autowired
	   private IUserConfigService userConfigService;
	 
	   @Autowired
	   private IIntegralGoodsService integralGoodsService;
	 
	   @Autowired
	   private IIntegralGoodsOrderService integralGoodsOrderService;
	 
	   @Autowired
	   private IUserService userService;
	 
	   @Autowired
	   private IIntegralLogService integralLogService;
	   

	  
	   
	
}
