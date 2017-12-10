package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class userMoneyDetail implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long userId;

    private BigDecimal canCarry;

    private BigDecimal manageMoney;

    private BigDecimal detailFee;

    private Date addTime;

    private Long detailId;

    private Integer detailTx;

    private String remark;

    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getCanCarry() {
        return canCarry;
    }

    public void setCanCarry(BigDecimal canCarry) {
        this.canCarry = canCarry;
    }

    public BigDecimal getManageMoney() {
        return manageMoney;
    }

    public void setManageMoney(BigDecimal manageMoney) {
        this.manageMoney = manageMoney;
    }

    public BigDecimal getDetailFee() {
        return detailFee;
    }

    public void setDetailFee(BigDecimal detailFee) {
        this.detailFee = detailFee;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getDetailId() {
        return detailId;
    }

    public void setDetailId(Long detailId) {
        this.detailId = detailId;
    }

    public Integer getDetailTx() {
        return detailTx;
    }

    public void setDetailTx(Integer detailTx) {
        this.detailTx = detailTx;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}