package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

public class WeekBenifitDetail {
    private Long id;

    private Long week;

    private Date addtime;

    private Long userId;

    private Long parentUserId;

    private Long orders;

    public Long getOrders() {
		return orders;
	}


	public void setOrders(Long orders) {
		this.orders = orders;
	}

	private BigDecimal amount;

    private BigDecimal dou;

    private Long users;

    private Boolean buyedstatus;

    private BigDecimal consumerMoney;

    private BigDecimal consumerDou;

    
    
    public WeekBenifitDetail ( )
	{
		super ();
	}
    

	public WeekBenifitDetail (Long week , Date addtime , Long userId , Long parentUserId , BigDecimal consumerMoney , BigDecimal consumerDou)
	{
		super ();
		this.week = week;
		this.addtime = addtime;
		this.userId = userId;
		this.parentUserId = parentUserId;
		this.consumerMoney = consumerMoney;
		this.consumerDou = consumerDou;
	}




	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getWeek() {
        return week;
    }

    public void setWeek(Long week) {
        this.week = week;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getParentUserId() {
        return parentUserId;
    }

    public void setParentUserId(Long parentUserId) {
        this.parentUserId = parentUserId;
    }

    public Long getOrder() {
        return orders;
    }

    public void setOrder(Long orders) {
        this.orders = orders;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getDou() {
        return dou;
    }

    public void setDou(BigDecimal dou) {
        this.dou = dou;
    }

    public Long getUsers() {
        return users;
    }

    public void setUsers(Long users) {
        this.users = users;
    }

    public Boolean getBuyedstatus() {
        return buyedstatus;
    }

    public void setBuyedstatus(Boolean buyedstatus) {
        this.buyedstatus = buyedstatus;
    }

    public BigDecimal getConsumerMoney() {
        return consumerMoney;
    }

    public void setConsumerMoney(BigDecimal consumerMoney) {
        this.consumerMoney = consumerMoney;
    }

    public BigDecimal getConsumerDou() {
        return consumerDou;
    }

    public void setConsumerDou(BigDecimal consumerDou) {
        this.consumerDou = consumerDou;
    }
}