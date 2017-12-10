package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

public class PromoteVipItem {
    private Long id;

    private Date addTime;

    /**
     * 被推广人升级的等级
     */
    private Integer upgradeLevel;

    /**
     * 被推广人的主键
     */
    private Long upgradeUserId;

    /**
     * 被推广人的truename
     */
    private String upgradeUserName;

    /**
     * 被推广人升级缴纳的金额
     */
    private BigDecimal upgradeFee;

    /**
     * 推广人的主键
     */
    private Long promoteUserId;

    /**
     * 推广的年
     */
    private Integer year;

    /**
     * 推广的月
     */
    private Integer month;

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

    public Integer getUpgradeLevel() {
        return upgradeLevel;
    }

    public void setUpgradeLevel(Integer upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }

    public Long getUpgradeUserId() {
        return upgradeUserId;
    }

    public void setUpgradeUserId(Long upgradeUserId) {
        this.upgradeUserId = upgradeUserId;
    }

    public String getUpgradeUserName() {
        return upgradeUserName;
    }

    public void setUpgradeUserName(String upgradeUserName) {
        this.upgradeUserName = upgradeUserName == null ? null : upgradeUserName.trim();
    }

    public BigDecimal getUpgradeFee() {
        return upgradeFee;
    }

    public void setUpgradeFee(BigDecimal upgradeFee) {
        this.upgradeFee = upgradeFee;
    }

    public Long getPromoteUserId() {
        return promoteUserId;
    }

    public void setPromoteUserId(Long promoteUserId) {
        this.promoteUserId = promoteUserId;
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
}