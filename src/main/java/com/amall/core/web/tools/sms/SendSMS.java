package com.amall.core.web.tools.sms;


import java.math.BigDecimal;


public interface SendSMS
{
	
	/** 
	* @Title: sendMessage 
	* @Description: 发送短信验证码
	* @param mobile
	* @param randomCode
	* @param validity
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年4月5日
	*/
	public boolean sendMessage(String mobile, String randomCode, int validity);
	
	public boolean sendDreamSuccessMessage(String mobile, String name);
	
	public boolean sendDreamRegMessage(String mobile, String name);
	
	/**
	 * 天使会员
	* @Title: sendActiveVipSuccessMessage 
	* @Description: TODO
	* @param  mobile
	* @param  name
	* @param @return    
	* @return boolean  
	* @throws
	 */
	public boolean sendActiveVip0SuccessMessage(String mobile, String name);
	
	/**
	 * 初级会员
	* @Title: sendActiveVip1SuccessMessage 
	* @Description: TODO
	* @param  mobile
	* @param  name
	* @param @return    
	* @return boolean  
	* @throws
	 */
	public boolean sendActiveVip1SuccessMessage(String mobile, String name);
	
	/**
	 * 联盟商家
	* @Title: sendActiveVip2SuccessMessage 
	* @Description: TODO
	* @param  mobile
	* @param  name
	* @param @return    
	* @return boolean  
	* @throws
	 */
	public boolean sendActiveVip2SuccessMessage(String mobile, String name);
	/**
	 * 充值成功短信
	* @Title: sendRechargeSuccessMessage 
	* @Description: TODO
	* @param  mobile
	* @param  name
	* @param @return    
	* @return boolean  
	* @throws
	 */
	public boolean sendRechargeSuccessMessage(String mobile, BigDecimal payAmount);
}
