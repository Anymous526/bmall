package com.amall.core.bean;

import java.util.Date;

public class RedPackge {
    private Long id;
    /** 生成红包时间**/
    private Date addTime;
    /** 生成红包用户ID**/
    private Long userId;
    /** 生成红包个数**/
    private Integer redNumber;
    /** 生成红包总金额**/
    private Integer totalGold;
    /** 发送状态（0：系统发送，1：用户发送）**/
    private Integer sendType;
    /** 生成形式（0：随机，1：等额）**/
    private String redPackgeType;
    /** 剩余红包数**/
    private Integer redPackgeRemain;
    /** 升级的等级**/
    private Integer upgradeLevel;
    
    private User user;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getRedNumber() {
        return redNumber;
    }

    public void setRedNumber(Integer redNumber) {
        this.redNumber = redNumber;
    }

    public Integer getTotalGold() {
        return totalGold;
    }

    public void setTotalGold(Integer totalGold) {
        this.totalGold = totalGold;
    }

    public Integer getSendType() {
        return sendType;
    }

    public void setSendType(Integer sendType) {
        this.sendType = sendType;
    }

    public String getRedPackgeType() {
        return redPackgeType;
    }

    public void setRedPackgeType(String redPackgeType) {
        this.redPackgeType = redPackgeType == null ? null : redPackgeType.trim();
    }

    public Integer getRedPackgeRemain() {
        return redPackgeRemain;
    }

    public void setRedPackgeRemain(Integer redPackgeRemain) {
        this.redPackgeRemain = redPackgeRemain;
    }

    public Integer getUpgradeLevel() {
        return upgradeLevel;
    }

    public void setUpgradeLevel(Integer upgradeLevel) {
        this.upgradeLevel = upgradeLevel;
    }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}