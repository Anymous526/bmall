package com.amall.core.lee;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: LeeConfig
 * @Description: TODO
 * @author lx
 * @date 2016年2月24日 下午3:53:08
 *
 */
public class LeeConfig {
	
	
	/**
	 * 天使会员
	 */
	private LeeRuleBean v_zero;
	
	public static final String V_ZERO_NAME = "合伙人";
	
	/**
	 * 初级合伙人
	 */
	private LeeRuleBean v_tow;
	
	public static final String V_tow_NAME = "消费商";

	/**
	 * 超级合伙人
	 */
	private LeeRuleBean v_three;
	
	public static final String V_THREE_NAME = "联盟商家";
	
	private LeeRuleBean v_five;
	public static final String V_five_NAME = "高级联盟商家";
	
	private LeeRuleBean v_seven;
	public static final String v_seven_NAME = "超级联盟商家";
	
	
	/**
	 * 平台分红收入类型:互助奖
	 */
	public static final Integer LEEHZTYPE = 1;
	/**
	 * 平台分红收入类型:分红奖
	 */
	public static final Integer LEEFHTYPE = 2;
	/**
	 * 平台分红收入类型:充值奖
	 */
	public static final Integer LEERECHARGETYPE = 3;

	/**
	 * 用户分红层数
	 */
	public Integer benefitSize; 

	/**
	 * 分红提现比例
	 */
	private BigDecimal benefitRate;
	
	/**
	 * 充值金额与平台赠送礼品金比例
	 */
	private BigDecimal recharegeGiveGoldRate;

	public LeeRuleBean getV_zero() {
		return v_zero;
	}

	public void setV_zero(LeeRuleBean v_zero) {
		this.v_zero = v_zero;
	}


	

	public LeeRuleBean getV_three() {
		return v_three;
	}

	public void setV_three(LeeRuleBean v_three) {
		this.v_three = v_three;
	}




	public BigDecimal getBenefitRate()
	{
		return benefitRate;
	}

	public void setBenefitRate(BigDecimal benefitRate)
	{
		this.benefitRate = benefitRate;
	}

	public BigDecimal getRecharegeGiveGoldRate()
	{
		return recharegeGiveGoldRate;
	}

	public void setRecharegeGiveGoldRate(BigDecimal recharegeGiveGoldRate)
	{
		this.recharegeGiveGoldRate = recharegeGiveGoldRate;
	}

	public Integer getBenefitSize()
	{
		return benefitSize;
	}

	public void setBenefitSize(Integer benefitSize)
	{
		this.benefitSize = benefitSize;
	}

	public LeeRuleBean getV_tow() {
		return v_tow;
	}

	public void setV_tow(LeeRuleBean v_tow) {
		this.v_tow = v_tow;
	}

	public LeeRuleBean getV_five() {
		return v_five;
	}

	public void setV_five(LeeRuleBean v_five) {
		this.v_five = v_five;
	}

	public LeeRuleBean getV_seven() {
		return v_seven;
	}

	public void setV_seven(LeeRuleBean v_seven) {
		this.v_seven = v_seven;
	}

}
