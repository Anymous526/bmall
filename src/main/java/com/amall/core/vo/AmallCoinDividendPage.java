package com.amall.core.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AmallCoinDividendPage implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private List<AmallCoinDividend> dividends = new ArrayList<AmallCoinDividend>();
	
	private Integer PageNo;
	
	private Integer PageSize = 20;
	
	private Integer totalCount;
	
	private BigDecimal totalFee;

	public List<AmallCoinDividend> getDividends()
	{
		return dividends;
	}

	public void setDividends(List<AmallCoinDividend> dividends)
	{
		this.dividends = dividends;
	}

	public Integer getPageNo()
	{
		return PageNo;
	}

	public void setPageNo(Integer pageNo)
	{
		PageNo = pageNo;
	}

	public Integer getPageSize()
	{
		return PageSize;
	}

	public void setPageSize(Integer pageSize)
	{
		PageSize = pageSize;
	}

	public Integer getTotalCount()
	{
		return totalCount;
	}

	public void setTotalCount(Integer totalCount)
	{
		this.totalCount = totalCount;
	}

	public BigDecimal getTotalFee()
	{
		return totalFee;
	}

	public void setTotalFee(BigDecimal totalFee)
	{
		this.totalFee = totalFee;
	}
	
}
