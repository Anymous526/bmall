 package com.amall.core.web.pay.alipay;
 
  import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;

import com.amall.core.web.pay.util.MD5;
import com.amall.core.web.pay.util.httpclient.HttpProtocolHandler;
import com.amall.core.web.pay.util.httpclient.HttpRequest;
import com.amall.core.web.pay.util.httpclient.HttpResponse;
import com.amall.core.web.pay.util.httpclient.HttpResultType;
 
 public class AlipaySubmit
 {
   private static final String ALIPAY_GATEWAY_NEW = "https://mapi.alipay.com/gateway.do?";
 
   private static Map<String, String> buildRequestPara(AlipayConfig config, Map<String, String> sParaTemp)
   {
     Map sPara = AlipayCore.paraFilter(sParaTemp);
 
     String mysign = AlipayCore.buildMysign(config, sPara);
 
     sPara.put("sign", mysign);
     if (!((String)sPara.get("service")).equals("alipay.wap.trade.create.direct"))
     {
       if (!((String)sPara.get("service")).equals(
         "alipay.wap.auth.authAndExecute"))
         sPara.put("sign_type", config.getSign_type());
     }
     return sPara;
   }
 
   public static String buildRequest(Map<String, String> sParaTemp, String strMethod, String strButtonName) {
       //待请求参数数组
       Map<String, String> sPara = buildRequestPara(sParaTemp);
       List<String> keys = new ArrayList<String>(sPara.keySet());

       StringBuffer sbHtml = new StringBuffer();

       sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" action=\"" + ALIPAY_GATEWAY_NEW
                     + "_input_charset=" + AlipayConfig.input_charset + "\" method=\"" + strMethod
                     + "\">");

       for (int i = 0; i < keys.size(); i++) {
           String name = (String) keys.get(i);
           String value = (String) sPara.get(name);

           sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
       }

       //submit按钮控件请不要含有name属性
       sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + "\" style=\"display:none;\"></form>");
       sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");

       return sbHtml.toString();
   }
   /**
    * 生成要请求给支付宝的参数数组
    * @param sParaTemp 请求前的参数数组
    * @return 要请求的参数数组
    */
   private static Map<String, String> buildRequestPara(Map<String, String> sParaTemp) {
       //除去数组中的空值和签名参数
       Map<String, String> sPara = AlipayCore.paraFilter(sParaTemp);
       //生成签名结果
       String mysign = buildRequestMysign(sPara);

       //签名结果与签名方式加入请求提交参数组中
       sPara.put("sign", mysign);
       sPara.put("sign_type", AlipayConfig.sign_type);

       return sPara;
   }
   
   /**
    * 生成签名结果
    * @param sPara 要签名的数组
    * @return 签名结果字符串
    */
	public static String buildRequestMysign(Map<String, String> sPara) {
   	String prestr = AlipayCore.createLinkString(sPara); //把数组所有元素，按照“参数=参数值”的模式用“&”字符拼接成字符串
       String mysign = "";
       if(AlipayConfig.sign_type.equals("MD5") ) {
       	mysign = MD5.sign(prestr, AlipayConfig.key, AlipayConfig.input_charset);
       }
       return mysign;
   }
   
   public static String buildForm(AlipayConfig config, Map<String, String> sParaTemp, String gateway, String strMethod, String strButtonName)
   {
     Map sPara = buildRequestPara(config, sParaTemp);
     List keys = new ArrayList(sPara.keySet());
     StringBuffer sbHtml = new StringBuffer();
     sbHtml.append("<form id=\"alipaysubmit\" name=\"alipaysubmit\" enctype=\"multipart/form-data\" action=\"" + 
       gateway + 
       "_input_charset=" + 
       config.getInput_charset() + 
       "\" method=\"" + strMethod + "\">");
 
     for (int i = 0; i < keys.size(); i++) {
       String name = (String)keys.get(i);
       String value = (String)sPara.get(name);
 
       sbHtml.append("<input type=\"hidden\" name=\"" + name + 
         "\" value=\"" + value + "\"/>");
     }
 
     sbHtml.append("<input type=\"submit\" value=\"" + strButtonName + 
       "\" style=\"display:none;\"></form>");
     sbHtml.append("<script>document.forms['alipaysubmit'].submit();</script>");
 
     return sbHtml.toString();
   }
 
   private static NameValuePair[] generatNameValuePair(Map<String, String> properties)
   {
     NameValuePair[] nameValuePair = new NameValuePair[properties.size()];
     int i = 0;
     for (Map.Entry entry : properties.entrySet()) {
       nameValuePair[(i++)] = 
         new NameValuePair((String)entry.getKey(), 
         (String)entry.getValue());
     }
 
     return nameValuePair;
   }
 
   public static String sendPostInfo(AlipayConfig config, Map<String, String> sParaTemp, String gateway)
     throws Exception
   {
     Map sPara = buildRequestPara(config, sParaTemp);
 
     HttpProtocolHandler httpProtocolHandler = 
       HttpProtocolHandler.getInstance();
 
     HttpRequest request = new HttpRequest(HttpResultType.BYTES);
 
     request.setCharset(config.getInput_charset());
 
     request.setParameters(generatNameValuePair(sPara));
     request.setUrl(gateway + "_input_charset=" + config.getInput_charset());
 
     HttpResponse response = httpProtocolHandler.execute(request);
     if (response == null) {
       return null;
     }
 
     String strResult = response.getStringResult();
 
     return strResult;
   }
 
   public static String buildRequest(AlipayConfig config, String type, Map<String, String> sParaTemp, String strParaFileName, String strFilePath)
     throws HttpException, IOException
   {
     Map sPara = buildRequestPara(config, sParaTemp);
     HttpProtocolHandler httpProtocolHandler = 
       HttpProtocolHandler.getInstance();
     HttpRequest request = new HttpRequest(HttpResultType.BYTES);
 
     request.setCharset(config.getInput_charset());
     request.setParameters(generatNameValuePair(sPara));
     if (type.equals("web")) {
       request.setUrl("https://mapi.alipay.com/gateway.do?_input_charset=" + 
         config.getInput_charset());
     }
     if (type.equals("wap")) {
       request.setUrl("http://wappaygw.alipay.com/service/rest.htm?_input_charset=" + 
         config.getInput_charset());
     }
     HttpResponse response = httpProtocolHandler.execute(request, 
       strParaFileName, strFilePath);
     if (response == null) {
       return null;
     }
     String strResult = response.getStringResult();
     return strResult;
   }
 
   public static String getRequestToken(AlipayConfig config, String text)
     throws Exception
   {
     String request_token = "";
 
     String[] strSplitText = text.split("&");
 
     Map paraText = new HashMap();
     for (int i = 0; i < strSplitText.length; i++)
     {
       int nPos = strSplitText[i].indexOf("=");
 
       int nLen = strSplitText[i].length();
 
       String strKey = strSplitText[i].substring(0, nPos);
 
       String strValue = strSplitText[i].substring(nPos + 1, nLen);
 
       paraText.put(strKey, strValue);
     }
 
     if (paraText.get("res_data") != null) {
       String res_data = (String)paraText.get("res_data");
 
       if (config.getSign_type().equals("0001")) {
         res_data = RSA.decrypt(res_data, AlipayConfig.getPrivate_key(), 
           config.getInput_charset());
       }
 
       Document document = DocumentHelper.parseText(res_data);
       request_token = document.selectSingleNode(
         "//direct_trade_create_res/request_token").getText();
     }
     return request_token;
   }
 }

