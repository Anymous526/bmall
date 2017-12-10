package com.amall.core.lee;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: LeeRuleBean
 * @Description: TODO
 * @author lx
 * @date 2016年2月24日 下午3:52:59
 *
 */
public class LeeRuleBean {

	/**
	 * 会员等级
	 */
	private Integer level;
	/**
	 * 条件
	 */
	private BigDecimal amount;
	/**
	 * 送礼品金
	 */
	private Integer gold;
	/**
	 * 直接互助奖
	 */
	private BigDecimal hzLee;
	/**
	 * 间接互助奖
	 */
	private BigDecimal itLee;
	/**
	 * 分红奖
	 */
	private BigDecimal fhLee;
	/**
	 * 充值奖
	 */
	private BigDecimal rechargeLee;
	/**
	 * 开店资格
	 */
	private Boolean beOpenShop;
	
	private String name;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Integer getGold() {
		return gold;
	}

	public void setGold(Integer gold) {
		this.gold = gold;
	}

	public BigDecimal getHzLee() {
		return hzLee;
	}

	public void setHzLee(BigDecimal hzLee) {
		this.hzLee = hzLee;
	}

	public BigDecimal getItLee() {
		return itLee;
	}

	public void setItLee(BigDecimal itLee) {
		this.itLee = itLee;
	}

	public BigDecimal getFhLee() {
		return fhLee;
	}

	public void setFhLee(BigDecimal fhLee) {
		this.fhLee = fhLee;
	}

	public BigDecimal getRechargeLee() {
		return rechargeLee;
	}

	public void setRechargeLee(BigDecimal rechargeLee) {
		this.rechargeLee = rechargeLee;
	}

	public Boolean getBeOpenShop() {
		return beOpenShop;
	}

	public void setBeOpenShop(Boolean beOpenShop) {
		this.beOpenShop = beOpenShop;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}
	

}
