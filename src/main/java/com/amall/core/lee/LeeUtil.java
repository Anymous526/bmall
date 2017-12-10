package com.amall.core.lee;

/**
 * 
* @ClassName: LeeUtil 
* @Description: TODO
* @author lx
* @date 2016年2月25日 下午5:07:30 
*
 */
public final class LeeUtil {
	
	private static LeeConfig config;
	
	private static boolean isInit = false;
	
	private static void initConfig()
	{
		config = LeeConfigurationBuilder.getInstance().parseConfiguration();
		
		if(config == null)
		{
			System.err.println("load lee config error.");
			System.exit(1);
		}
	}
	
	/** 
	* @Title: getVipInstance 
	* @Description: 根据vip等级获取vip配置参数
	* @param level
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年2月29日
	*/
	public static LeeRuleBean getVipInstance(int level)
	{
		if(!isInit)
		{
			initConfig();
		}
		
		if(level == config.getV_tow().getLevel().intValue())
		{
			return config.getV_tow();
		}
		else if(level == config.getV_three().getLevel().intValue())
		{
			return config.getV_three();
		}
		else if(level == config.getV_zero().getLevel().intValue())
		{
			return config.getV_zero();
		}else if(level == config.getV_five().getLevel().intValue()){
			return config.getV_five();
		}else if(level == config.getV_seven().getLevel().intValue()){
			return config.getV_seven();
		}
		else
		{
			return null;
		}
	}
	
	/** 
	* @Title: getConfigInstance 
	* @Description: 获取配置实列
	* @return
	* @throws 
	* @author tangxiang
	* @date 2016年2月29日
	*/
	public static LeeConfig getConfigInstance()
	{
		if(!isInit)
		{
			initConfig();
		}
		
		return config;
	}
	
}
