package com.amall.core.web.tools.sms;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.service.system.ISysConfigService;

@Component
public class SendCLSMS implements SendSMS
{
	static Logger logger  =  Logger.getLogger(SendCLSMS.class);
	
	/**
	 * 用户名
	 */
	private static String account;
	
	/**
	 * 用户密码
	 */
	private static String pswd;
	
	/**
	 * 是否需要状态报告
	 */
	private static boolean needstatus = false;
	
	/**
	 * 初始化状态
	 */
	private static boolean isInit = false;
	
	/**
	 * 验证码url
	 */
	private static String url;
	
	@Autowired
	private ISysConfigService configService;

	private void init()
	{
		account = configService.getSysConfig().getSmsAccountSid();
		pswd = configService.getSysConfig().getSmsAuthToken();
		url = configService.getSysConfig().getSmsUrl();
		isInit = true;
	}
	
	private boolean execute(SMSCallback callback)
	{
		if(!isInit)
		{
			init();
		}
		
		return callback.doSendSMS();
	}
	
	@Override
	public boolean sendMessage(final String mobile, final String randomCode, final int validity)
	{
		return execute(new SMSCallback()
		{
			
			@Override
			public boolean doSendSMS()
			{
				Map<String, Object> map = new HashMap<>();
				map.put("account", account);
				map.put("pswd", pswd);
				map.put("mobile", mobile);
				map.put("msg", "您的验证码是" + randomCode + "，请于 " + validity + "分钟内输入，祝您在天使A猫购物愉快！");
				map.put("needstatus", needstatus);
				
				return send(map);
			}
		});
		
	}

	@Override
	public boolean sendDreamSuccessMessage(String mobile, String name)
	{
		return false;
	}

	@Override
	public boolean sendDreamRegMessage(String mobile, String name)
	{
		return false;
	}

	@Override
	public boolean sendActiveVip0SuccessMessage(String mobile, String name)
	{
		return false;
	}

	@Override
	public boolean sendActiveVip1SuccessMessage(String mobile, String name)
	{
		return false;
	}

	@Override
	public boolean sendActiveVip2SuccessMessage(String mobile, String name)
	{
		return false;
	}

	@Override
	public boolean sendRechargeSuccessMessage(String mobile, BigDecimal payAmount)
	{
		return false;
	}
	
	private boolean send(Map<String, Object> map)
	{
		HttpRequest httpRequest;
		try
		{
			httpRequest = new HttpRequest();
			String result = httpRequest.sendGet(url, map);
			
			logger.info("result : " + result);
			
			String code = result.split(",")[1];
			
			if("0".equals(code))
			{
				return true;
			}
			else
			{
				logger.info(" send error code : " + code);
			}
			
		} catch (Exception e)
		{
			logger.error(" send Exception : ", e);
		}
		
		return false;
	}
	
}
