package com.amall.core.web.express.kuaidi100;

public final class Kuadi100Conifg
{

	private Kuadi100Conifg(){}
	
	private static String CALLBACK_URL = "/kuaidi100BackCall.htm";
	
	private static String KEY = "ELEaGPZu4437";
	
	private static String CHARACTER_UTF8 = "UTF-8";
	
	private static String SUBSCRIPTION_URL = "http://www.kuaidi100.com/poll";
	
	private static String SUBSCRIPTION_URL_NAME = "callbackurl";
	
	private static String SCHEMA_NAME = "schema";
	
	private static String SCHEMA = "json";
	
	private static String PARAM_NAME = "param";
	
	public static String getSCHEMA_NAME()
	{
		return SCHEMA_NAME;
	}

	public static String getSCHEMA()
	{
		return SCHEMA;
	}

	public static String getPARAM_NAME()
	{
		return PARAM_NAME;
	}

	public static String getCALLBACK_URL()
	{
		return CALLBACK_URL;
	}

	public static String getKEY()
	{
		return KEY;
	}

	public static String getSUBSCRIPTION_URL_NAME()
	{
		return SUBSCRIPTION_URL_NAME;
	}

	public static String getCHARACTER_UTF8()
	{
		return CHARACTER_UTF8;
	}

	public static void setCALLBACK_URL(String cALLBACK_URL)
	{
		CALLBACK_URL = cALLBACK_URL;
	}

	public static String getSUBSCRIPTION_URL()
	{
		return SUBSCRIPTION_URL;
	}
	
	
	
}
