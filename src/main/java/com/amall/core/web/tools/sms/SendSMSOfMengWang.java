package com.amall.core.web.tools.sms;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.amall.common.constant.Globals;
import com.amall.core.bean.SysConfig;
import com.amall.core.service.system.ISysConfigService;

/**
 * 梦网 SMS
 * @author tangxiang
 *
 */
@Component
public class SendSMSOfMengWang{

	static Logger logger  =  Logger.getLogger(SendSMSOfMengWang.class);
	
	private String ip = null;
	
	private String port = null;
	
	private String sameSend = "/MWGate/wmgw.asmx/MongateSendSubmit";
	
	@Autowired
	private ISysConfigService configService;
	
	private Params params;
	
	/**
	 * send SMS mode 1,
	 * to send the same message
	 */
	public boolean sendMsgOfOne(String phones, String content) {
		
		if(phones.length() < 11)
		{
			return false;
		}
		
		doConfiguring();
		params.setPszMobis(phones);
		params.setPszMsg(content);
		int num = phones.split(",").length;
		params.setIMobiCount(String.valueOf(num));
		String result = MongateSendSubmitForGet();
		
		if(result != null && !"".equals(result) && result.length() > 10)
		{
			logger.info("menghuang send sms successful, phones " + phones + "  result code : " + result);
			return true;
		}
		
		logger.info("menghuang send sms error, phones " + phones + "  result code : "  + result);
		
		return false;
	}

	/**
	 * send SMS mode 2,
	 * send different messages
	 */
	public boolean sendMsgOfTwo(String phones, String content) {
		return false;
	}

	/**
	 * provisioning services information
	 */
	public void doConfiguring() {
		SysConfig config = configService.getSysConfig();
		params = new Params();
		params.setUserId(config.getSmsAccountSid());
		params.setPassword(config.getSmsAuthToken());
		params.setPszSubPort("*");
		params.setMsgId(String.valueOf(Globals.NUBER_ZERO));
		ip = config.getSmsUrl();
		port = config.getSmsPort();
	}

	/**
	 * 短信息发送接口
	 * 返回值：错误描述对应说明
			发送成功：信息编号，如：-8485643440204283743或1485643440204283743
			错误返回：-1	参数为空。信息、电话号码等有空指针，登陆失败
					-2	电话号码个数超过100
					-10	申请缓存空间失败
					-11	电话号码中有非数字字符
					-12	有异常电话号码
					-13	电话号码个数与实际个数不相等
					-14	实际号码个数超过100
					-101	发送消息等待超时
					-102	发送或接收消息失败
					-103	接收消息超时
					-200	其他错误
					-999	web服务器内部错误
	 */
	private String MongateSendSubmitForGet() {
		String result =null;
		try {
			 String Message=null;
			 String host = "http://" + ip + ":" + port;
			 Message = executeGet(params, host + sameSend);
			 
			 if(Message != null && Message != "")
			  {
		          Document doc=DocumentHelper.parseText(Message);
		          Element el = doc.getRootElement();
		          result = el.getText();
			  } 
		} catch (Exception e) 
		{
			logger.info("menghuang send sms exception, phones : " + params.getPszMobis());
		}
		return result;
	}
	
	/**
	 *　使用get请求
	 * @param obj
	 * @param httpUrl
	 * @return
	 * @throws Exception
	 */
	private String executeGet(Object obj, String httpUrl) throws Exception {

		String result = "";
		Class cls = obj.getClass();
		Field[] fields = cls.getDeclaredFields();
		StringBuffer sb = new StringBuffer();

		String fieldName = null;
		String fieldNameUpper = null;
		Method getMethod = null;
		String value = null;
		for (int i = 0; i < fields.length; i++)   {
			fieldName = fields[i].getName();
			fieldNameUpper = Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
			getMethod = cls.getMethod("get" + fieldNameUpper);
			value = (String) getMethod.invoke(obj);
			if(value != null) {
				//GET请求，进行UTF-8编码
				sb.append("&").append(fieldName).append("=").append(URLEncoder.encode(value, "UTF-8"));
			}
		}

		if (!sb.equals("")) {
	            String paramStr = sb.toString().replaceFirst("&", "?");
	            httpUrl += paramStr;
	    }
	    HttpGet httpget = new HttpGet(httpUrl);
	    
		
		HttpClient httpclient = new DefaultHttpClient();
	    
		HttpEntity entity = httpclient.execute(httpget).getEntity();
		
		if(entity != null && entity.getContentLength() != -1) {
			result=EntityUtils.toString(entity);
		}

		httpclient.getConnectionManager().shutdown();
		return result;

	}
	
}
