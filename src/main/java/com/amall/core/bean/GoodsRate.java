package com.amall.core.bean;

/**
 * 商品感恩金、感恩豆利率实体类
 * @author Administrator
 *
 */
public class GoodsRate
{

	private String rate;   // 小数

	private String percentRate;  // 百分比


	public GoodsRate (String rate , String percentRate)
	{
		super ();
		this.rate = rate;
		this.percentRate = percentRate;
	}


	public String getRate ( )
		{
			return rate;
		}


	public void setRate (	String rate)
		{
			this.rate = rate;
		}


	public String getPercentRate ( )
		{
			return percentRate;
		}


	public void setPercentRate (String percentRate)
		{
			this.percentRate = percentRate;
		}
}
