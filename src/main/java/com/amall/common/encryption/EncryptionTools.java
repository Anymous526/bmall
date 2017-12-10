package com.amall.common.encryption;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amall.core.web.tools.CommUtil;

public class EncryptionTools
{
	/**
	 * 内容
	 */
	private static final String CONTEXT_NAME = "context=";
	
	/**
	 * text加密内容
	 */
	private static final String TEXT_NAME = "text=";
	
	/**
	 * AES加密解密key
	 */
	private static final String KEY_NAME = "key=";
	
	/**
	 * 签名
	 */
	private static final String SIGN_NAME = "sign=";
	
	/**
	 * 接收内容分隔符
	 */
	private static final String SPLIT_VALUE = "&";
	
	
	 /** 
     * 把数组所有元素排序，并按照“参数=参数值”的模式用“&”字符拼接成字符串
     * @param params 需要排序并参与字符拼接的参数组
     * @return 拼接后字符串
     */
    public static String createLinkString(Map<String, String> params) {

        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);

        String prestr = "";

        for (int i = 0; i < keys.size(); i++) 
        {
            String key = keys.get(i);
            String value = params.get(key);

            if (i == keys.size() - 1) {//拼接时，不包括最后一个&字符
                prestr = prestr + key + "=" + value;
            } else {
                prestr = prestr + key + "=" + value + "&";
            }
        }

        return prestr;
    }
    
    /** 
     * 除去数组中的空值
     * @param sArray 签名参数组
     * @return 去掉空值与签名参数后的新签名参数组
     */
    public static Map<String, String> paraFilter(Map<String, String> sArray) {

        Map<String, String> result = new HashMap<String, String>();

        if (sArray == null || sArray.size() <= 0) 
        {
            return result;
        }

        for (String key : sArray.keySet()) 
        {
            String value = sArray.get(key);
            if (value == null || value.equals("")) 
            {
                continue;
            }
            result.put(key, value);
        }

        return result;
    }
    
    /**
     * @Title: onlyRSAEncrypt
     * @Description: 使用RSA加密内容，结构 context=xxx&sign=xxx
     * 				 默认使用1024长度的RSAkey,所以内容bytes不能超过117长度(可以通过分片加密来解决问题，暂时不做)
     * @param params
     * @return
     * @return String
     * @author tangxiang
     * @date 2015年8月25日 下午8:34:10 
     */
    public static String onlyRSAEncrypt(Map<String, String> params)
    {
    	Map<String, String> newParams = new HashMap<String, String>(); 
    	
    	/* 拼接加密明文 */
    	String plaintext = createLinkString(paraFilter(params));
    	
    	System.err.println(plaintext.getBytes().length);
    	
    	if(plaintext.getBytes().length > 117)
    	{
    		return null;
    	}
    	
    	/* 使用RSA加密明文 */
    	byte[] ciphertextRSA = Algorithm.encryptByRSAPublicKey(plaintext.getBytes());
    	
    	/* 使用base64加密做字节对齐，便于网络传输 */
    	byte[] ciphertextBase64 = Algorithm.encryptByBase64(ciphertextRSA);
    	
    	newParams.put("context", Algorithm.byteArrayToHEXString(ciphertextBase64));
    	newParams.put("sign", Algorithm.byteArrayToHEXString(Algorithm.signatureSHA2(ciphertextBase64)));
    	
    	return createLinkString(newParams);
    	
    }
    
    /**
     * @Title: onlyRSADecrypt
     * @Description: 使用RSA解密内容，成功返回字符串，失败返回null
     * @param ciphertextRSA
     * @return
     * @return String
     * @author tangxiang
     * @date 2015年8月26日 上午9:23:46 
     */
    public static String onlyRSADecrypt(String ciphertextRSA)
    {
    	/* 签名验证，成功返回内容，失败返回null */
    	String context = signVerify(ciphertextRSA);
    	
    	if(context == null)
    	{
    		return null;
    	}
    	
    	byte[] contextText = Algorithm.decryptByBase64(Algorithm.hexStringToBytes(context));
    	
    	byte[] plaintext = Algorithm.decryptByRSAPrivateKey(contextText);
    	
    	return new String(plaintext);
    }
    
    /**
     * @Title: completeEncrypt
     * @Description: 完整加密 RSA + AES + SHA256 + Base64
     * @param params
     * @return
     * @return String
     * @author tangxiang
     * @date 2015年8月26日 上午9:29:24 
     */
    public static String completeEncrypt(Map<String, String> params)
    {
    	Map<String, String> newParams = new HashMap<String, String>(); 
    	
    	/* 拼接加密明文 */
    	String plaintext = createLinkString(paraFilter(params));
    	
    	/* 生成长度16位的随机对称Key */
    	String key = CommUtil.randomString(6);
    	Algorithm.setKey(key);
    	
    	/* 使用DES加密内容 */
    	byte[] ciphertextDES;
		try
		{
			ciphertextDES = Algorithm.encryptByAES(plaintext.getBytes("UTF-8"), Algorithm.getAesKey());
			/* 使用RSA加密Key */
	    	byte[] keyRSA = Algorithm.encryptByRSAPublicKey(key.getBytes());
	    	
	    	
	    	/* 拼接新字符串 */
	    	newParams.put("text", Algorithm.byteArrayToHEXString(ciphertextDES));
	    	newParams.put("key", Algorithm.byteArrayToHEXString(keyRSA));
	    	String context = createLinkString(newParams);
	    	
	    	/* base64加密内容便于传输 */
	    	byte[] ciphertextBase64 = Algorithm.encryptByBase64(context.getBytes());
	    	
	    	/* 使用sha256签名数据，保证完整性 */
	    	byte[] signByte = Algorithm.signatureSHA2(ciphertextBase64);
	    	
	    	/* 生成传输字符串 */
	    	newParams.clear();
	    	newParams.put("context", Algorithm.byteArrayToHEXString(ciphertextBase64));
	    	newParams.put("sign", Algorithm.byteArrayToHEXString(signByte));
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
    	
    	
    	return createLinkString(newParams);
    }
    
    /**
     * @Title: completeDecrypt
     * @Description: 完全加密解密
     * @param string
     * @return
     * @return String
     * @author tangxiang
     * @date 2015年8月29日 上午11:59:19 
     */
    public static String completeDecrypt(String string)
    {
    	/* 签名验证，成功返回内容，失败返回null */
    	String context = signVerify(string);
    	
    	if(context == null)
    	{
    		return null;
    	}
    	
    	String contextText = new String(Algorithm.decryptByBase64(Algorithm.hexStringToBytes(context)));
    	String[] array = contextText.split(SPLIT_VALUE);
    	String hexText = array[1].substring(array[1].indexOf(TEXT_NAME) + TEXT_NAME.length() , array[1].length());
		String hexKey = array[0].substring(array[0].indexOf(KEY_NAME) + KEY_NAME.length() , array[0].length());
    	
		/* 使用RSA解密Key */
		String key = new String(Algorithm.decryptByRSAPrivateKey(Algorithm.hexStringToBytes(hexKey)));
		
		/* 使用key解密内容 */
		Algorithm.setKey(key);
    	byte[] plaintext = Algorithm.decryptByAES(Algorithm.hexStringToBytes(hexText), Algorithm.getAesKey());
    	
    	try
		{
			return new String(plaintext, "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
    	
    	return null;
    }
    
    
    /**
     * @Title: signVerify
     * @Description: 签名验证，成功返回内容，失败返回null
     * @param str
     * @return
     * @return String
     * @author tangxiang
     * @date 2015年8月26日 上午10:02:46 
     */
    public static String signVerify(String str)
    {
    	String[] array = str.split(SPLIT_VALUE);
    	
    	if(array == null || array.length != 2)
    	{
    		return null;
    	}
    	
    	String context = array[0].substring(array[0].indexOf(CONTEXT_NAME) + CONTEXT_NAME.length() , array[0].length());
    	
    	String sign = array[1].substring(array[1].indexOf(SIGN_NAME) + SIGN_NAME.length() , array[1].length());
    	
    	/* 验证数据完整性 */
    	String newSign = Algorithm.byteArrayToHEXString(Algorithm.signatureSHA2(
    			Algorithm.hexStringToBytes(context)));
    	
    	if(!newSign.equals(sign))
    	{
    		return null;
    	}
    	
    	return context;
    }
    
    /**
     * @Title: pwdSHA2Sign
     * @Description: 密码签名
     * @param pwd
     * @return
     * @return String
     * @author tangxiang
     * @date 2015年8月31日 上午9:32:40 
     */
    public static String pwdSHA2Sign(String pwd)
    {
    	return Algorithm.byteArrayToHEXString(Algorithm.signatureSHA2(pwd.getBytes()));
    }
    
    /** 
    * @Title: sha2Sign 
    * @Description: sha2 签名
    * @param str
    * @return
    * @throws 
    * @author tangxiang
    * @date 2015年10月13日
    */
    public static String sha2Sign(String str)
    {
    	return pwdSHA2Sign(str);
    }
}
