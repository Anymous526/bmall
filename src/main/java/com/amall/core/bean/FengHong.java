package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class FengHong implements Serializable{
	 /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addTime;

    private BigDecimal fenhongFee;

    public String getGetUserName() {
		return getUserName;
	}

	public void setGetUserName(String getUserName) {
		this.getUserName = getUserName;
	}

	private Long getUserId;

    private Long giveShopId;

    private Long orderId;
    
    private String getUserName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public BigDecimal getFenhongFee() {
        return fenhongFee;
    }

    public void setFenhongFee(BigDecimal fenhongFee) {
        this.fenhongFee = fenhongFee;
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Long getGiveShopId() {
        return giveShopId;
    }

    public void setGiveShopId(Long giveShopId) {
        this.giveShopId = giveShopId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}