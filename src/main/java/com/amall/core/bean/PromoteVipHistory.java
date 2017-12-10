package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PromoteVipHistory {
    private Long id;

    private Date addTime;

    /**
     * 推广排名年
     */
    private Integer year;

    /**
     * 推广排名月
     */
    private Integer month;

    /**
     * 排名
     */
    private Integer rank;

    /**
     * 用户等级，指推广人的等级
     */
    private Integer userLevel;

    /**
     * 推广人truename
     */
    private String userName;

    /**
     * 推广的总金额
     */
    private BigDecimal promoteFee;

    /**
     * 推广的vip1数量
     */
    private Integer promoteVip1Number;

    /**
     * 推广的vip2数量
     */
    private Integer promoteVip2Number;

    /**
     * 推广人的主键
     */
    private Long userId;

    /**
     * 当月推广获得的分利
     */
    private BigDecimal benefitFee;

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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public Integer getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(Integer userLevel) {
        this.userLevel = userLevel;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public BigDecimal getPromoteFee() {
        return promoteFee;
    }

    public void setPromoteFee(BigDecimal promoteFee) {
        this.promoteFee = promoteFee;
    }

    public Integer getPromoteVip1Number() {
        return promoteVip1Number;
    }

    public void setPromoteVip1Number(Integer promoteVip1Number) {
        this.promoteVip1Number = promoteVip1Number;
    }

    public Integer getPromoteVip2Number() {
        return promoteVip2Number;
    }

    public void setPromoteVip2Number(Integer promoteVip2Number) {
        this.promoteVip2Number = promoteVip2Number;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBenefitFee() {
        return benefitFee;
    }

    public void setBenefitFee(BigDecimal benefitFee) {
        this.benefitFee = benefitFee;
    }
}