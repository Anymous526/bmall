package com.amall.core.web.tools;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap; 
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.common.mail.MailSenderService;
import com.amall.core.bean.SysConfig;
import com.amall.core.bean.Template;
import com.amall.core.bean.TemplateExample;
import com.amall.core.service.store.ITemplateService;
import com.amall.core.service.system.ISysConfigService;
import com.amall.core.service.user.IUserService;
import com.cloopen.rest.sdk.CCPRestSDK;

/**
 * 
 * <p>Title: MsgTools</p>
 * <p>Description: 消息工具类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  tangxiang
 * @date	2015-4-29下午2:19:55
 * @version 1.0
 */
@Component
public class MsgTools {

	static Logger logger  =  Logger.getLogger(MsgTools.class);
	
	@Autowired
	private ISysConfigService configService;
	
	@Autowired
	private ITemplateService templateService;

	@Autowired
	private IUserService userService;
	
	@Autowired
	private MailSenderService mailSenderService;
	
	private static String url;
	
	private static String port;
	
	private static String smsAccountSid;
	
	private static String smsAuthToken;
	
	private static String smsAppId;
	
	/**
	 * 初始化短信平台服务器信息
	 * @return
	 */
	private CCPRestSDK setSmsService()
	{
		url = configService.getSysConfig().getSmsUrl();
		port = this.configService.getSysConfig().getSmsPort();
		smsAccountSid = this.configService.getSysConfig().getSmsAccountSid();
		smsAuthToken = this.configService.getSysConfig().getSmsAuthToken();
		smsAppId = this.configService.getSysConfig().getSmsAppId();
		
		CCPRestSDK restAPI = new CCPRestSDK();
		restAPI.init(url, port);// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount(smsAccountSid, smsAuthToken);// 初始化主帐号名称和主帐号令牌
		restAPI.setAppId(smsAppId);// 初始化应用ID
		return restAPI;
	}
	
	/**
	 * 验证吗发送 云平台CCP的 
	 * @param mobile 手机号
	 * @param randomNumber 随机数
	 * @param timeLimit 时限
	 * @return
	 */
	public boolean sendValidateCodeOfSMS(String mobile, String content)
	{
		HashMap<String, Object> result = null;
		
		TemplateExample templateExample = new TemplateExample();
		
		SysConfig sysConfig = this.configService.getSysConfig();
		
		//判断模版是否开启
		if(!sysConfig.getSmsenbale())
		{
			return false;
		}
		
		//选择验证码短信模版
		templateExample.createCriteria().andTypeEqualTo(Globals.SEND_SMS).andTemplateNumberEqualTo(Globals.SMS_VERIFICATION_CODE);
		List<Template> list = this.templateService.getObjectList(templateExample);
		
		if(list.isEmpty())
		{
			return false;
		}
		
		result = setSmsService().sendTemplateSMS(mobile, Globals.SMS_VERIFICATION_CODE ,new String[]{content, sysConfig.getSmsExceedTime()});

		logger.info("send sms ok : " + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet)
			{
				Object object = data.get(key);
				logger.info("send sms : " + key + " = " + object);
			}
			
			return true;
		}else{
			//异常返回输出错误码和错误信息
			logger.info("send sms error , errorCode : " + result.get("statusCode") + " error info : " + result.get("statusMsg"));
			return false;
		}
	}
	
	/**
	 * 验证吗发送
	 * @param mobile 手机号
	 * @param randomNumber 随机数
	 * @param timeLimit 时限
	 * @return
	 */
	public boolean sendSMS(String mobile, String content)
	{

		//发送内容
			
			// 创建StringBuffer对象用来操作字符串
			StringBuffer sb = new StringBuffer(this.configService.getSysConfig().getSmsUrl());

			// 向StringBuffer追加用户名
			sb.append("name=").append(this.configService.getSysConfig().getSmsAccountSid());

			// 向StringBuffer追加密码（登陆网页版，在管理中心--基本资料--接口密码，是28位的）
			sb.append("&pwd=").append(this.configService.getSysConfig().getSmsAuthToken());

			// 向StringBuffer追加手机号码
			sb.append("&mobile=").append(mobile);

			// 向StringBuffer追加消息内容转URL标准码
			try
			{
				sb.append("&content="+URLEncoder.encode(content,"UTF-8"));

				//追加发送时间，可为空，为空为及时发送
				sb.append("&stime=");
				
				//type为固定值pt  extno为扩展码，必须为数字 可为空
				sb.append("&type=pt&extno=");
				// 创建url对象
				URL url = new URL(sb.toString());

				// 打开url连接
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();

				// 设置url请求方式 ‘get’ 或者 ‘post’
				connection.setRequestMethod("POST");

				// 发送
				InputStream is = url.openStream();
				
				logger.info("发送短信 ： " + sb.toString());
				//转换返回值
				String returnStr = convertStreamToString(is);
				
				logger.info("发送成功 ： " + returnStr);
				// 返回结果为‘0，20140009090990,1，提交成功’ 发送成功   具体见说明文档
			} catch (Exception e)
			{
				e.printStackTrace();
				logger.info("短信程序异常 ： " + e.getMessage());
				return false;
			}
			// 返回发送结果
			
			return true;
	}
	
	/**
	 * 
	 * <p>Title: sendEmail</p>
	 * <p>Description: 发送用户名 +密码 +内容到邮件</p>
	 * @param email  邮箱地址
	 * @param subject
	 * @param content 内容
	 * @return   boolean
	 */
	public boolean sendEmail(String email, String subject, String content) {
		boolean ret = true;
		String username = "";
		String password = "";
		String smtp_server = "";
		String from_mail_address = "";
		username = this.configService.getSysConfig().getEmailusername();
		password = this.configService.getSysConfig().getEmailpws();
		smtp_server = this.configService.getSysConfig().getEmailhost();
		from_mail_address = this.configService.getSysConfig().getEmailuser();
		String to_mail_address = email;
		if ((username != null) && (password != null) && (!username.equals(""))
				&& (!password.equals("")) && (smtp_server != null)
				&& (!smtp_server.equals("")) && (to_mail_address != null)
				&& (!to_mail_address.trim().equals(""))) {
			
			JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
			mailSender.setHost(smtp_server); 
			mailSender.setUsername(from_mail_address);
			mailSender.setPassword(password);
			mailSender.setDefaultEncoding("UTF-8");
			
			Properties pro = new Properties();
			pro.setProperty("mail.smtp.auth", "true");
			pro.setProperty("mail.smtp.timeout", "25000");
			mailSender.setJavaMailProperties(pro);
			
			SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			simpleMailMessage.setFrom(from_mail_address);
			
			mailSenderService.setMailSender(mailSender);
			mailSenderService.setSimpleMailMessage(simpleMailMessage);
			
			mailSenderService.setTo(email); 
			
			try{ 
				if(StringUtils.isNotEmpty(subject) && StringUtils.isNotEmpty(content)){
					mailSenderService.setSubject(subject);
					mailSenderService.setContent(content);
					mailSenderService.sendText();
				}else{
					//注册发送
					mailSenderService.setSubject("感谢您注册天使商城");  
					mailSenderService.setTemplateName("com/amall/common/mail/mail.vm");
					Map model=new HashMap();  
					model.put("username", email);  
					model.put("url", "www.amall.com");  
					mailSenderService.sendWithTemplate(model);  
				}
				return true;
			}catch(Exception e){
				return false;
			}
			
		} else {
			ret = false;
		}
		return ret;
	}
	
	/**
	 * 转换返回值类型为UTF-8格式.
	 * @param is
	 * @return
	 */
	public String convertStreamToString(InputStream is) {    
        StringBuilder sb1 = new StringBuilder();    
        byte[] bytes = new byte[4096];  
        int size = 0;  
        
        try {    
        	while ((size = is.read(bytes)) > 0) {  
                String str = new String(bytes, 0, size, "UTF-8");  
                sb1.append(str);  
            }  
        } catch (IOException e) {    
            e.printStackTrace();    
        } finally {    
            try {    
                is.close();    
            } catch (IOException e) {    
               e.printStackTrace();    
            }    
        }    
        return sb1.toString();    
    }
}
