package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class RechargeLog implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private BigDecimal rechargeFee;

    private Long userId;

    private String payType;

    private Long payId;
    
    private User user;
    
    private AlipayOrder payOrder;
    
    private List<RechargeBenefit> rechargeBenefits;
    
    private Integer rechargeGold;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getRechargeFee() {
        return rechargeFee;
    }

    public void setRechargeFee(BigDecimal rechargeFee) {
        this.rechargeFee = rechargeFee;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public Long getPayId() {
        return payId;
    }

    public void setPayId(Long payId) {
        this.payId = payId;
    }

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
		if(user != null){
			this.userId = user.getId();
		}
	}

	public AlipayOrder getPayOrder()
	{
		return payOrder;
	}

	public void setPayOrder(AlipayOrder payOrder)
	{
		this.payOrder = payOrder;
	}

	public List<RechargeBenefit> getRechargeBenefits() {
		return rechargeBenefits;
	}

	public void setRechargeBenefits(List<RechargeBenefit> rechargeBenefits) {
		this.rechargeBenefits = rechargeBenefits;
	}
	
    public Integer getRechargeGold() {
        return rechargeGold;
    }

    public void setRechargeGold(Integer rechargeGold) {
        this.rechargeGold = rechargeGold;
    }   
}