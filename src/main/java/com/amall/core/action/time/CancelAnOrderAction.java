package com.amall.core.action.time;


import org.apache.log4j.Logger;

import org.springframework.stereotype.Component;


@Component("CancelAnOrderjob")
public class CancelAnOrderAction {
	Logger log = Logger.getLogger(CancelAnOrderAction.class);



	public void execute() {
		
		queryOrder();
	}

	/***
	 * 获取所有未支付订单
	 * 
	 * @return
	 */
	public void queryOrder() {
		
	
	}
}
