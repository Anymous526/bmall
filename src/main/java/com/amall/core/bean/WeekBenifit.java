package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

public class WeekBenifit
{

	private Long id;

	private Long week;

	private Date addtime;

	private BigDecimal totalamount;

	private BigDecimal dou;

	private Long users;


	public WeekBenifit ( )
	{
		super ();
	}


	public WeekBenifit (Long week , Date addtime , BigDecimal totalamount , BigDecimal dou , Long users)
	{
		super ();
		this.week = week;
		this.addtime = addtime;
		this.totalamount = totalamount;
		this.dou = dou;
		this.users = users;
	}


	public Long getId ( )
		{
			return id;
		}


	public void setId (	Long id)
		{
			this.id = id;
		}


	public Long getWeek ( )
		{
			return week;
		}


	public void setWeek (	Long week)
		{
			this.week = week;
		}


	public Date getAddtime ( )
		{
			return addtime;
		}


	public void setAddtime (Date addtime)
		{
			this.addtime = addtime;
		}


	public BigDecimal getTotalamount ( )
		{
			return totalamount;
		}


	public void setTotalamount (BigDecimal totalamount)
		{
			this.totalamount = totalamount;
		}


	public BigDecimal getDou ( )
		{
			return dou;
		}


	public void setDou (BigDecimal dou)
		{
			this.dou = dou;
		}


	public Long getUsers ( )
		{
			return users;
		}


	public void setUsers (	Long users)
		{
			this.users = users;
		}
}