package com.amall.common.constant;

import java.io.IOException;
import java.util.Map;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang.StringUtils;
import org.nutz.json.Json;

/**
 * 微信工具类
 * 
 * @author tangxiang
 *
 */
public abstract class WxLoginUtil
{

	// 应用ID
	public static final String appid = "wx08306f46e810acff";

	// 应用密钥
	public static final String appsecret = "519c8a7e0588bcd30df604a011ee67e0";

	// 获取access_tokecn的URL
	public static String access_token_url = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code&appid=" + appid + "&secret=" + appsecret + "&code=";

	// 刷新access_tokecn的URL
	public static String refresh_token_url = "https://api.weixin.qq.com/sns/oauth2/refresh_token?grant_type=refresh_token&refresh_token=";

	// 获取用户信息
	public static String user_info_url = "https://api.weixin.qq.com/sns/userinfo?access_token=";

	// 过期时间，目前默认是7200秒
	public static String expired_area = "7200";

	// 刷新token过期时间，目前默认是30天 - 2小时
	public static String refresh_expired_area = "2584800";

	// 最新的时间戳
	public static String timestamp;

	// 最新刷新的时间戳
	public static String refresh_timestamp;

	// 全局缓存的访问口令
	public static String access_token;

	// 全局缓存的访问口令
	public static String refresh_token;

	public static String getUserInfo (String token , String openid)
		{
			try
			{
				String url = user_info_url + token + "&openid=" + openid;
				return getHttpResponseText (url , "get");
			}
			catch (Exception e)
			{
				return null;
			}
		}

	public static String getUnionID (String userInfo)
		{
			try
			{
				return getValueOfJsonStr ("unionID" , userInfo);
			}
			catch (Exception e)
			{
				return null;
			}
		}

	public static String getAccessTokenResult (String code)
		{
			String url = access_token_url + code;
			return getHttpResponseText (url , "get");
		}

	public static boolean getAccessToken (String code)
		{
			Long nowTime = System.currentTimeMillis ();
			/* 判断是否全局缓存过期 */
			// if(!isExpired(nowTime, Long.valueOf(timestamp)))
			// {
			// return false;
			// }
			String url = access_token_url + code;
			System.out.println (url);
			String result = getHttpResponseText (url , "get");
			System.out.println (result);
			String new_access_token = getValueOfJsonStr ("access_token" , result);
			String refresh = getValueOfJsonStr ("refresh_token" , result);
			String expires_in = getValueOfJsonStr ("expires_in" , result);
			if (new_access_token != null && expires_in != null)
			{
				if (!expires_in.equals (expired_area))
				{
					expired_area = expires_in;
				}
				refresh_token = refresh;
				access_token = new_access_token;
				timestamp = nowTime.toString ();
			}
			return true;
		}

	public static boolean refreshToken ( )
		{
			Long nowTime = System.currentTimeMillis ();
			String url = refresh_token_url + refresh_token;
			String result = getHttpResponseText (url , "get");
			String new_access_token = getValueOfJsonStr ("access_token" , result);
			String expires_in = getValueOfJsonStr ("expires_in" , result);
			String refresh = getValueOfJsonStr ("refresh_token" , result);
			if (new_access_token != null && expires_in != null)
			{
				if (!expires_in.equals (expired_area))
				{
					expired_area = expires_in;
				}
				access_token = new_access_token;
				refresh_token = refresh;
				timestamp = nowTime.toString ();
			}
			return true;
		}

	/**
	 * @Title: isExpired
	 * @Description: 判断是否过期
	 * @param nowTime
	 * @param oldTime
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月6日
	 */
	private static boolean isExpired (Long nowTime , Long oldTime)
		{
			long time = (nowTime - oldTime) / 1000;
			/* 提前600秒过期，避免时间提前到期引起调用失败 */
			if (time >= (Integer.valueOf (expired_area) - 600))
			{
				return true;
			}
			return false;
		}

	/**
	 * @Title: getValueOfJsonStr
	 * @Description: 从json字符串中获取指定key的值
	 * @param name
	 * @param jsonStr
	 * @return
	 * @throws
	 * @author tangxiang
	 * @date 2015年11月6日
	 */
	public static String getValueOfJsonStr (String name , String jsonStr)
		{
			if (StringUtils.isNotEmpty (jsonStr))
			{
				Map <?, ?>  m = Json.fromJson (Map.class , jsonStr);
				return m.get (name).toString ();
			}
			return null;
		}

	/**
	 * http post访问,返回相应串
	 * 
	 * @param url
	 * @return
	 */
	public static String getHttpResponseText (String url , String type)
		{
			HttpClient client = new HttpClient ();
			HttpMethod method = null;
			// post请求
			if (type.equalsIgnoreCase ("post"))
			{
				method = new PostMethod (url);
			}
			else
			{
				// get请求
				method = new GetMethod (url);
			}
			method.setRequestHeader ("Accept-Language" , "zh-cn");
			method.setRequestHeader ("User-Agent" , "Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.0.3) Gecko/2008092417 Firefox/3.0.3");
			method.setRequestHeader ("Accept-Charset" , "utf-8");
			method.setRequestHeader ("Keep-Alive" , "1000");
			method.setRequestHeader ("Connection" , "Keep-Alive");
			method.setRequestHeader ("Cache-Control" , "no-cache");
			int status;
			try
			{
				status = client.executeMethod (method);
				if (status == 200)
				{
					String text = method.getResponseBodyAsString ();
				}
			}
			catch (Exception e)
			{
				e.printStackTrace ();
			}
			try
			{
				return new String (method.getResponseBody () , "utf-8");
			}
			catch (IOException e)
			{
				e.printStackTrace ();
			}
			return null;
		}

}
