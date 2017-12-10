package com.amall.core.web.tools.sms;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.core.service.system.ISysConfigService;
import com.cloopen.rest.sdk.CCPRestSDK;


public class SendYunTongXunSMS
{
	static Logger logger  =  Logger.getLogger(SendYunTongXunSMS.class);
	
	@Autowired
	private ISysConfigService configService;
	
	private static CCPRestSDK restAPI = new CCPRestSDK();
	
	static
	{
		restAPI.init("app.cloopen.com", "8883");// 初始化服务器地址和端口，格式如下，服务器地址不需要写https://
		restAPI.setAccount("8a48b5514eaf512c014eafceb62f01bb", "1dc2dd10903c491db1e81527e5b31bcd");// 初始化主帐号和主帐号TOKEN
	}
	
	public boolean sendMessage(String mobile, String randomCode, int validity)
	{
		return sendYunTongXunOfVerificationCode(mobile, randomCode, validity);
	}
	
	private boolean sendYunTongXunOfVerificationCode(String mobile, String randomCode, int validity)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("8a48b5514eaf512c014eafd1b20901c7");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"52853" ,new String[]{randomCode, String.valueOf(validity)});
		
		return processResult(result);
	}
	
	public boolean sendDreamSuccessMessage(String mobile, String name)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("aaf98f895147cd2a01516ab91791550b");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"54150" ,new String[]{name});
		
		return processResult(result);
	}
	
	public boolean sendDreamRegMessage(String mobile, String name)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("aaf98f895147cd2a01516ab91791550b");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"53262" ,new String[]{name});
		
		return processResult(result);
	}
	
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
	public boolean sendActiveVip0SuccessMessage(String mobile, String name)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("8a48b5514eaf512c014eafd1b20901c7");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"69850" ,new String[]{name});
		
		return processResult(result);
	}
	
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
	public boolean sendActiveVip1SuccessMessage(String mobile, String name)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("8a48b5514eaf512c014eafd1b20901c7");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"69851" ,new String[]{name});
		
		return processResult(result);
	}
	
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
	public boolean sendActiveVip2SuccessMessage(String mobile, String name)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("8a48b5514eaf512c014eafd1b20901c7");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"69853" ,new String[]{name});
		
		return processResult(result);
	}
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
	public boolean sendRechargeSuccessMessage(String mobile, BigDecimal payAmount)
	{
		HashMap<String, Object> result = null;
		restAPI.setAppId("8a48b5514eaf512c014eafd1b20901c7");// 初始化应用ID
		result = restAPI.sendTemplateSMS(mobile,"69862" ,new String[]{payAmount.toString()});
		
		return processResult(result);
	}
	
	/**
 	* @author tangxiang
 	* 功能:	1xinxi.cn HTTP接口 发送短信
 	* 说明:	http://sms.1xinxi.cn/asmx/smsservice.aspx?name=登录名&pwd=接口密码&mobile=手机号码&content=内容&sign=签名&stime=发送时间&type=pt&extno=自定义扩展码
 	*
 	*/
	private boolean send1xinxi(String mobile, String context)
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
			sb.append("&content="+URLEncoder.encode(context,"UTF-8"));

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
	
	private boolean processResult(Map result)
	{
		logger.info("SDKTestSendTemplateSMS result=" + result);
		if("000000".equals(result.get("statusCode"))){
			//正常返回输出data包体信息（map）
			HashMap<String,Object> data = (HashMap<String, Object>) result.get("data");
			Set<String> keySet = data.keySet();
			for(String key:keySet){
				Object object = data.get(key);
				logger.info(key +" = "+object);
			}
			return true;
		}else{
			//异常返回输出错误码和错误信息
			logger.info("错误码=" + result.get("statusCode") +" 错误信息= "+result.get("statusMsg"));
			return false;
		}
	}
	
}
