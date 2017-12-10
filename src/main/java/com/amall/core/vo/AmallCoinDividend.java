package com.amall.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;

public class AmallCoinDividend implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	/*
	 * 分红的礼品金
	 */
	private BigDecimal dividendGold;
	
	/**
	 * 店铺名称
	 */
	private String shopName;
	
	/**
	 * 分红类型
	 */
	private String dividendType;
	
	/**
	 * 分红时间
	 */
	private String dividendDate;
	
	/**
	 * 用户名
	 */
	private String realName;

	public BigDecimal getDividendGold()
	{
		return dividendGold;
	}

	public void setDividendGold(BigDecimal dividendGold)
	{
		this.dividendGold = dividendGold;
	}

	public String getShopName()
	{
		return shopName;
	}

	public void setShopName(String shopName)
	{
		this.shopName = shopName;
	}

	public String getDividendType()
	{
		return dividendType;
	}

	public void setDividendType(String dividendType)
	{
		this.dividendType = dividendType;
	}

	public String getDividendDate()
	{
		return dividendDate;
	}

	public void setDividendDate(String dividendDate)
	{
		this.dividendDate = dividendDate;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}
	
}
