package com.amall.core.web.tools.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

import com.amall.core.web.tools.CommUtil;
import com.unionpay.acp.sdk.HttpClient;
import com.unionpay.acp.sdk.SDKConfig;
import com.unionpay.acp.sdk.SDKUtil;

public class UnopUtil {
	public static final String  ENCODING = "UTF-8";
	public static final String 	VERSION = "5.0.0";
	
	public static final String  FRONT_URL = "http://211.154.154.196/unionpay_result.htm";//http://localhost:8080/UnopPay
	//public static final String  FRONT_URL = "http://211.154.154.196:9089/amall/unionpay_result.htm";//http://localhost:8080/UnopPay
	public static final String  BACK_URL= "http://211.154.154.196/unionpay_back_notify.htm";//http://localhost:8080/UnopPay
	public static final String REFUND_BACK_URL = "http://211.154.154.196/unionpay_refund_back_notify.htm";//http://localhost:8080/UnopPay
	public static String txnTime = null;
	public static String merId = "777290058113147";//商户号码
	public static String txnType = "01";		   // 交易类型
	public static String queryId = null;		   		// 银行流水号
	public static String txnAmt= "1";//默认的交易金额,单位为分
	public static String reqReserved = null; // 自定义域
	
	public static String orderId=System.currentTimeMillis()+"";//默认的订单号
	/**
	 * http://localhost:8080/ACPTest/acp_front_url.do
	 */
	//后台服务对应的写法参照 FrontRcvResponse.java
	
	//public static String backUrl = "http://localhost:8080/UnopPay";//默认返回地址
	
	
	public static Map<String,String> initMap(){
		   /*
		    * 组装请求报文
		    */
		   Map<String, String> contentData = new HashMap<String, String>();
		   //　商户代码  -- 自填
		   contentData.put("merId", merId);//M
		   // 订单发送时间 -- 商户发送交易时间
		   contentData.put("txnTime",CommUtil.formatTime("yyyyMMddHHmmss",new Date()));//M
		   // 渠道类型 -- 05：语音，07：互联网，08：移动
		   contentData.put("channelType", "07");//M
		   // 接入类型 -- 0：普通商户直连接入2：平台类商户接入
		   contentData.put("accessType", "0");//M
		   contentData.put("bizType", "000201");//M
		   // 交易币种 -- 默认为156 
		   contentData.put("currencyCode", "156");//M
		   // 交易子类 -- 01：自助消费，通过地址的方式区分前台消费和后台消费（含无跳转支付）03：分期付款
		   contentData.put("txnSubType", "01");//M
		   //商户自定义保留域，交易应答时会原样返回
		   contentData.put("reqReserved", "");//O
		   contentData.put("reserved", "");//O
		  // 交易金额 -- 单位为分
		   contentData.put("txnAmt", "1");//M
		// 版本号 -- 固定填写
		   contentData.put("version", VERSION);//M
		   // 编码类型  --默认取值：UTF-8
		   contentData.put("encoding", ENCODING);//M
		   // 签名方法 --取值：01（表示采用的是RSA）
		   contentData.put("signMethod", "01");//M
		   contentData.put("reqReserved", reqReserved);
		   // 订单接收超时时间 -- PC 1、前台类消费交易时上送2、认证支付2.0，后台交易时可选
		   //icontentData.put("orderTimeout", String.valueOf((1000*60*5)));//O
		   // 支付超时时间 -- PC超过此时间用户支付成功的交易，不通知商户，系统自动退款，大约5个工作日金额返还到用户账户
		 //  contentData.put("payTimeout", "");//O
		   // 持卡人IP -- 前台交易，有IP防钓鱼要求的商户上送
		//   contentData.put("customerIp", "");//C
		   
		   
		   return contentData;
	}
	
	public static Map<String,String> buildParamMap(SDKConfig config){
		Map<String, String> contentData = initMap();
		   // 前台通知地址 -- 前台返回商户结果时使用，前台类交易需上送
		   contentData.put("frontUrl", FRONT_URL);//C
		   
		   // 失败交易前台跳转地址 -- 前台消费交易若商户上送此字段，则在支付失败时，页面跳转至商户该URL（不带交易信息，仅跳转）
		   contentData.put("frontFailUrl", FRONT_URL);//O
		   // 商户订单号 -- 商户端生成
		   contentData.put("orderId", orderId);//M
		   // 交易类型  -- 取值：01 
		   contentData.put("txnType", txnType);//M
		// 支持支付方式 -- 仅仅pc使用，使用哪种支付方式 由收单机构填写，取值为以下内容的一种或多种，通过逗号（，）分割。取值参考数据字典
		   contentData.put("supPayType", "0001,0201");//O  网银支付 
		   // 默认支付方式  -- 取值参考数据字典
		   contentData.put("defaultPayType", "0201");//O
		   contentData.put("customerIp", "127.0.0.1");
		// 后台通知地址
		   contentData.put("backUrl", BACK_URL);
		return contentData;
	}
	
	/**
	 * java main方法 数据提交　 数据组装进行提交 包含签名
	 * 
	 * @param contentData
	 * @return 返回报文 map
	 */
	public static Map<String, String> submitDate(Map<String, ?> contentData,String requestUrl) {
		Map<String, String> submitFromData = (Map<String, String>) signData(contentData);
		return submitUrl(submitFromData,requestUrl);
	}
	
	
	public static Map<String, String> setFormDate(){
		Map<String, String> data = initMap();
		data.put("txnType", "04");
		data.put("txnSubType", "00");
		//原消费的queryId，可以从查询接口或者通知接口中获取
		// 待查询交易的流水号 
		//data.put("queryId", queryId);// C 
		// 商户订单号，8-40位数字字母，重新产生，不同于原消费
		data.put("orderId", orderId);
		//原消费的queryId，可以从查询接口或者通知接口中获取
		data.put("origQryId", queryId);
		data = signData(data);
		// 后台通知地址
		data.put("backUrl", REFUND_BACK_URL);
		return data;
	}
	
	/**
	 * @param contentData
	 * @return　签名后的map对象
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> signData(Map<String, ?> contentData) {
		Entry<String, String> obj = null;
		Map<String, String> submitFromData = new HashMap<String, String>();
		for (Iterator<?> it = contentData.entrySet().iterator(); it.hasNext();) {
			obj = (Entry<String, String>) it.next();
			String value = obj.getValue();
			if (StringUtils.isNotBlank(value)) {
				// 对value值进行去除前后空处理
				submitFromData.put(obj.getKey(), value.trim());
	
			}
		}
		/**
		 * 签名
		 */
		SDKUtil.sign(submitFromData, ENCODING);

		return submitFromData;
	}
	
	/**
	 * java main方法 数据提交 提交到后台
	 * 
	 * @param contentData
	 * @return 返回报文 map
	 */
	public static Map<String, String> submitUrl(Map<String, String> submitFromData,String requestUrl) {
		String resultString = "";
		System.out.println("requestUrl====" + requestUrl);
		System.out.println("submitFromData====" + submitFromData.toString());
		HttpClient hc = new HttpClient(requestUrl, 30000, 30000);
		try {
			int status = hc.send(submitFromData, ENCODING);
			if (200 == status) {
				resultString = hc.getResult();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Map<String, String> resData = new HashMap<String, String>();
		/**
		 * 验证签名
		 */
		if (null != resultString && !"".equals(resultString)) {
			// 将返回结果转换为map
			resData = SDKUtil.convertResultStringToMap(resultString);
			if (SDKUtil.validate(resData, ENCODING)) {
				System.out.println("验证签名成功");
			} else {
				System.out.println("验证签名失败");
			}
			// 打印返回报文
			System.out.println("打印返回报文：" + resultString);
		}
		return resData;
	}
	

	
	
	
	
	/**
	 * 构造HTTP POST交易表单的方法示例
	 * 
	 * @param action
	 *            表单提交地址
	 * @param hiddens
	 *            以MAP形式存储的表单键值
	 * @return 构造好的HTTP POST交易表单
	 */
	public static String createHtml(String action, Map<String, String> hiddens) {
		StringBuffer sf = new StringBuffer();
		sf.append("<html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"/></head><body>");
		sf.append("<form id = \"pay_form\" action=\"" + action
				+ "\" method=\"post\">");
		if (null != hiddens && 0 != hiddens.size()) {
			Set<Entry<String, String>> set = hiddens.entrySet();
			Iterator<Entry<String, String>> it = set.iterator();
			while (it.hasNext()) {
				Entry<String, String> ey = it.next();
				String key = ey.getKey();
				String value = ey.getValue();
				sf.append("<input type=\"hidden\" name=\"" + key + "\" id=\""
						+ key + "\" value=\"" + value + "\"/>");
			}
		}
		sf.append("</form>");
		sf.append("</body>");
		sf.append("<script type=\"text/javascript\">");
		sf.append("document.all.pay_form.submit();");
		sf.append("</script>");
		sf.append("</html>");
		return sf.toString();
	}
}
