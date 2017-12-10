package com.amall.core.bean;

import java.math.BigDecimal;

public class PromoteDreamSet {
    private Long id;

    private Integer limitNumber;

    private Integer remainNumber;

    private BigDecimal rate;

    private Integer promoteNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLimitNumber() {
        return limitNumber;
    }

    public void setLimitNumber(Integer limitNumber) {
        this.limitNumber = limitNumber;
    }

    public Integer getRemainNumber() {
        return remainNumber;
    }

    public void setRemainNumber(Integer remainNumber) {
        this.remainNumber = remainNumber;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Integer getPromoteNumber() {
        return promoteNumber;
    }

    public void setPromoteNumber(Integer promoteNumber) {
        this.promoteNumber = promoteNumber;
    }
}