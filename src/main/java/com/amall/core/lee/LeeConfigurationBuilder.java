package com.amall.core.lee;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Properties;

import org.apache.commons.lang.StringUtils;

import com.amall.common.constant.Globals;

/**
 * 
* @ClassName: LeeConfigurationBuilder 
* @Description: TODO
* @author lx
* @date 2016年2月24日 下午3:53:13 
*
 */
public class LeeConfigurationBuilder {
	/**
	 * This class instance.
	 */
	private static LeeConfigurationBuilder INSTANCE = new LeeConfigurationBuilder();

	private static final String SYSTEM_PROPERTY_LEE_PROPERTIES_FILENAME = "lee.properties.filename";

	private static final String LEE_RESOURCE = "properties/lee.properties";

	private final String leePropertiesFilename;

	/**
	 * Hidden constructor, this class can't be instantiated.
	 */
	private LeeConfigurationBuilder() {
		leePropertiesFilename = System.getProperty(SYSTEM_PROPERTY_LEE_PROPERTIES_FILENAME, LEE_RESOURCE);
	}

	/**
	 * Return this class instance.
	 *
	 * @return this class instance.
	 */
	public static LeeConfigurationBuilder getInstance() {
		return INSTANCE;
	}

	/**
	 * Parses the Config and builds a new {@link RedisConfig}.
	 *
	 * @return the converted {@link RedisConfig}.
	 */
	public LeeConfig parseConfiguration() {
		return parseConfiguration(getClass().getClassLoader());
	}

	/**
	 * Parses the Config and builds a new {@link RedisConfig}.
	 *
	 * @param the
	 *            {@link ClassLoader} used to load the
	 *            {@code memcached.properties} file in classpath.
	 * @return the converted {@link RedisConfig}.
	 */
	public LeeConfig parseConfiguration(ClassLoader classLoader) {
		Properties config = new Properties();

		InputStream input = classLoader.getResourceAsStream(leePropertiesFilename);
		if (input != null) {
			try {
				config.load(input);
			} catch (IOException e) {
				throw new RuntimeException("An error occurred while reading classpath property '"
						+ leePropertiesFilename + "', see nested exceptions", e);
			} finally {
				try {
					input.close();
				} catch (IOException e) {
					// close quietly
				}
			}
		}

		LeeConfig leeConfig = new LeeConfig();
		
		/* 会员配置读取设置 */
		String v0Rules = config.getProperty("v_zero");
		String V2Rules = config.getProperty("v_two");
		String v3Rules = config.getProperty("v_Three");
		String v5Rules = config.getProperty("v_Five");
		String v7Rules = config.getProperty("v_Seven");
		
		LeeRuleBean leeRuleBeanZero = new LeeRuleBean();
		LeeRuleBean leeRuleBeanTow = new LeeRuleBean();
		LeeRuleBean leeRuleBeanThree = new LeeRuleBean();
		LeeRuleBean leeRuleBeanFive = new LeeRuleBean();
		LeeRuleBean leeRuleBeanSeven = new LeeRuleBean();
		setLeeUserRuleBean(leeRuleBeanZero, v0Rules);
		setLeeUserRuleBean(leeRuleBeanTow, V2Rules);
		setLeeUserRuleBean(leeRuleBeanThree, v3Rules);
		setLeeUserRuleBean(leeRuleBeanFive, v5Rules);
		setLeeUserRuleBean(leeRuleBeanSeven, v7Rules);
		leeConfig.setV_zero(leeRuleBeanZero);
		leeConfig.setV_tow(leeRuleBeanTow);
		leeConfig.setV_three(leeRuleBeanThree);
		leeConfig.setV_five(leeRuleBeanFive);
		leeConfig.setV_seven(leeRuleBeanSeven);
		
		/* 公用配置读取设置 */
		BigDecimal benefitRate = new BigDecimal(config.getProperty("benefit_rate"));
		BigDecimal recharegeGiveGoldRate = new BigDecimal(config.getProperty("recharege_give_gold_rate"));
		Integer benefitSize = Integer.valueOf(config.getProperty("benefit_size"));
		
		leeConfig.setBenefitRate(benefitRate);
		leeConfig.setBenefitSize(benefitSize);
		leeConfig.setRecharegeGiveGoldRate(recharegeGiveGoldRate);
		
		return leeConfig;
	}
	
	private void setLeeUserRuleBean(LeeRuleBean ruleBean, String ruleStr)
	{
		String[] rule = StringUtils.split(ruleStr, ",");
		int level = Integer.parseInt(rule[0]);
		ruleBean.setLevel(level);
		
		if(level == 0)
		{
			ruleBean.setName(LeeConfig.V_ZERO_NAME);
		}else if(level == 2){
			ruleBean.setName(LeeConfig.V_tow_NAME);
		}
		else if(level == 3)
		{
			ruleBean.setName(LeeConfig.V_THREE_NAME);
		}
		else if(level == 5)
		{
			ruleBean.setName(LeeConfig.V_five_NAME);
		}
		else if(level == 7){
			ruleBean.setName(LeeConfig.v_seven_NAME);
		}
			
		ruleBean.setAmount(new BigDecimal(rule[1]));
		ruleBean.setGold(Integer.parseInt(rule[2]));
		ruleBean.setHzLee(new BigDecimal(rule[3]));
		ruleBean.setItLee(new BigDecimal(rule[4]));
		ruleBean.setFhLee(new BigDecimal(rule[5]));
		ruleBean.setRechargeLee(new BigDecimal(rule[6]));
		Integer beOpenShopTwo = Integer.parseInt(rule[7]);
		if(beOpenShopTwo > Globals.NUBER_ZERO){
			ruleBean.setBeOpenShop(Boolean.TRUE);
		}else{
			ruleBean.setBeOpenShop(Boolean.FALSE);
		}
	}

}
