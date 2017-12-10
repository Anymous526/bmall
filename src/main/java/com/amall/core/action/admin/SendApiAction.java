package com.amall.core.action.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.amall.core.service.ISmsVerificationService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserConfigService;
import com.amall.core.web.tools.CommUtil;
import com.amall.core.web.tools.SendSMSVerification;
import com.amall.core.web.tools.sms.HttpRequest;
import com.amall.core.web.tools.sms.SMSCallback;
import com.amall.core.web.tools.sms.SendSMS;

@Controller
public class SendApiAction
{

	Logger logger = Logger.getLogger (SendApiAction.class);

	@Autowired
	private SendSMSVerification sendSMSVerification;

	@Autowired
	private ISysConfigService configService;

	@Autowired
	private IUserConfigService userConfigService;

	@Autowired
	private ISmsVerificationService verificationService;

	@Autowired
	private SendSMS sendSMS;

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

	private void init ( )
		{
			account = configService.getSysConfig ().getSmsAccountSid ();
			pswd = configService.getSysConfig ().getSmsAuthToken ();
			url = configService.getSysConfig ().getSmsUrl ();
			isInit = true;
		}

	@RequestMapping({ "admin/sends_sms.htm" })
	public void send_sms (HttpServletRequest request , HttpServletResponse response , String phoneNum , String content) throws IOException
		{
			// boolean existExample = true; // 是否存在实例
			int l = 0;
			
			String [ ] chrstr = null;
			if (phoneNum == null || phoneNum.equals (""))
			{
				response.getWriter ().print ("1"); // 手机号为空
			}
			else
			{
				chrstr = phoneNum.split (",");
			}
			if (null != chrstr && chrstr.length > 0)
			{
				for (int i = 0 ; i < chrstr.length ; i++)
				{
					// 判断该手机号是否存在注册成功用户中
					if (this.sendSMSVerification.isExistPhoneInUser (chrstr[i]))
					{
						String length = this.configService.getSysConfig ().getVerificationCodeLength ();
						String code = CommUtil.randomNumberString (Integer.valueOf (length));	// 验证码
						String validTime = this.configService.getSysConfig ().getSmsExceedTime ();
						System.out.println ("code -> " + code);
						if (i <= chrstr.length)
						{
							if (this.sendMessage (chrstr[i] , content , Integer.valueOf (validTime)))
							{
								response.getWriter ().print ("3");	// 成功
							}
							else
							{
								response.getWriter ().print ("2");	// 存在失败记录
							}
						}
						else
						{
							response.getWriter ().print ("3");	// 成功
						}
					}
					else
					{
						l++;
						continue;
					}
				}
			}
			response.getWriter ().print ("3");	// 成功
		}

	public boolean sendMessage (final String mobile , final String context , final int validity)
		{
			return execute (new SMSCallback ()
			{

				@Override
				public boolean doSendSMS ( )
					{
						Map <String, Object> map = new HashMap <> ();
						map.put ("account" , account);
						map.put ("pswd" , pswd);
						map.put ("mobile" , mobile);
						map.put ("msg" , context);
						map.put ("needstatus" , needstatus);
						return send (map);
					}
			});
		}

	private boolean execute (SMSCallback callback)
		{
			if (!isInit)
			{
				init ();
			}
			return callback.doSendSMS ();
		}

	private boolean send (Map <String, Object> map)
		{
			HttpRequest httpRequest;
			try
			{
				httpRequest = new HttpRequest ();
				String result = httpRequest.sendGet (url , map);
				logger.info ("result : " + result);
				String code = result.split (",")[1];
				if ("0".equals (code))
				{
					return true;
				}
				else
				{
					logger.info (" send error code : " + code);
				}
			}
			catch (Exception e)
			{
				logger.error (" send Exception : " , e);
			}
			return false;
		}
}
