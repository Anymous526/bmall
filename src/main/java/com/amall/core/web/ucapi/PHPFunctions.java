package com.amall.core.web.ucapi;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

public abstract class PHPFunctions {
	
	/**
	 * 
	 * <p>Title: urlencode</p>
	 * <p>Description: 对传入的参数进行URL编码</p>
	 * @param value  String类型的参数
	 * @return   编码后的内容
	 */
	protected String urlencode(String value) {
		try {
			return URLEncoder.encode(value, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			return e.getMessage();
		}
	}
	
	/**
	 * 
	 * <p>Title: md5</p>
	 * <p>Description: 对传入的Stringmd5方式编码加密</p>
	 * @param input  String类型的参数
	 * @return
	 */
	protected String md5(String input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
			return null;
		}
		return byte2hex(md.digest(input.getBytes()));
	}
	/**
	 * 
	 * <p>Title: md5</p>
	 * <p>Description: 对传入的数值进行md5 加密</p>
	 * @param input
	 * @return   加密后的字符串
	 */
	protected String md5(long input) {
		return md5(String.valueOf(input));
	}
	
	/**
	 * 
	 * <p>Title: base64_decode</p>
	 * <p>Description: Base64解密</p>
	 * @param input
	 * @return
	 */
	protected String base64_decode(String input) {
		try {
			return new String(Base64.decode(input.toCharArray()), "iso-8859-1");
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	
	/**
	 * 
	 * <p>Title: base64_encode</p>
	 * <p>Description: Base64加密</p>
	 * @param input
	 * @return
	 */
	protected String base64_encode(String input) {
		try {
			return new String(Base64.encode(input.getBytes("iso-8859-1")));
		} catch (Exception e) {
			return e.getMessage();
		}
	}

	protected String byte2hex(byte[] b) {
		StringBuffer hs = new StringBuffer();
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = Integer.toHexString(b[n] & 0xFF);
			if (stmp.length() == 1)
				hs.append("0").append(stmp);
			else
				hs.append(stmp);
		}
		return hs.toString();
	}

	protected String substr(String input, int begin, int length) {
		return input.substring(begin, begin + length);
	}
	
	/**
	 * 
	 * <p>Title: substr</p>
	 * <p>Description: 对传入的字符串截取      如果开始数大于0 就直接截取， 否则 接取字符串长度+开始数</p>
	 * @param input  要截取的字符串
	 * @param begin  开始数
	 * @return
	 */
	protected String substr(String input, int begin) {
		if (begin > 0) {
			return input.substring(begin);
		}
		return input.substring(input.length() + begin);
	}
	
	/**
	 * 
	 * <p>Title: microtime</p>
	 * <p>Description: 获得系统的毫秒时间</p>
	 * @return
	 */
	protected long microtime() {
		return System.currentTimeMillis();
	}
	
	/**
	 * 
	 * <p>Title: time</p>
	 * <p>Description: 秒</p>
	 * @return
	 */
	protected long time() {
		return System.currentTimeMillis() / 1000L;
	}

	protected String sprintf(String format, long input) {
		String temp = "0000000000" + input;
		return temp.substring(temp.length() - 10);
	}
	
	/**
	 * 
	 * <p>Title: call_user_func</p>
	 * <p>Description: 获得用户的链接方式</p>
	 * @param function 链接方式  uc_api_mysql   /  uc_api_post   
	 * @param model    user
	 * @param action   动作， 如login， register
	 * @param args    map类型的参数
	 * @return
	 */
	protected String call_user_func(String function, String model,
			String action, Map<String, Object> args) {
		
		//对链接方式进行判断  之后调用不同的方法
		if ("uc_api_mysql".equals(function)) {
			return uc_api_mysql(model, action, args);
		}
		if ("uc_api_post".equals(function)) {
			return uc_api_post(model, action, args);
		}
		return "";
	}

	public abstract String uc_api_post(String paramString1,
			String paramString2, Map<String, Object> paramMap);

	public abstract String uc_api_mysql(String paramString1,
			String paramString2, Map paramMap);
}
