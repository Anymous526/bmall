package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

public class Revenue {
    private Long id;

    private Long storeId;

    private String goodsName;

    private BigDecimal storeIncome;

    private Date accountTime;

    private BigDecimal leePrice;

    private BigDecimal rate;

    private Long orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getStoreIncome() {
        return storeIncome;
    }

    public void setStoreIncome(BigDecimal storeIncome) {
        this.storeIncome = storeIncome;
    }

    public Date getAccountTime() {
        return accountTime;
    }

    public void setAccountTime(Date accountTime) {
        this.accountTime = accountTime;
    }

    public BigDecimal getLeePrice() {
        return leePrice;
    }

    public void setLeePrice(BigDecimal leePrice) {
        this.leePrice = leePrice;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}