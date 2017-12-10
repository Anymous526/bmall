package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * <p>Title: PredepositCash</p>
 * <p>Description: 提现信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月6日上午11:05:14
 * @version 1.0
 */
public class PredepositCash implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;//提交时间

    private Boolean deletestatus;

    private String cashAccount;//收款账号

    private BigDecimal cashAmount;//提现金额

    private String cashBank;//收款银行

    private Integer cashPayStatus;//支付状态

    private String cashPayment;//支付方式

    private String cashSn;//预存款编号

    private Integer cashStatus;//提现状态(0.等待支付 1.已完成 2.已拒绝,-1.已关闭)

    private String cashUsername;//收款人姓名

    private Long cashAdminId;	//操作管理员外键id

    private Long cashUserId;

    private String cashBankCity; //银行所在城市
    
    public String getCashBankCity() {
		return cashBankCity;
	}

	public void setCashBankCity(String cashBankCity) {
		this.cashBankCity = cashBankCity;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount == null ? null : cashAccount.trim();
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getCashBank() {
        return cashBank;
    }

    public void setCashBank(String cashBank) {
        this.cashBank = cashBank == null ? null : cashBank.trim();
    }

    public Integer getCashPayStatus() {
        return cashPayStatus;
    }

    public void setCashPayStatus(Integer cashPayStatus) {
        this.cashPayStatus = cashPayStatus;
    }

    public String getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(String cashPayment) {
        this.cashPayment = cashPayment == null ? null : cashPayment.trim();
    }

    public String getCashSn() {
        return cashSn;
    }

    public void setCashSn(String cashSn) {
        this.cashSn = cashSn == null ? null : cashSn.trim();
    }

    public Integer getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(Integer cashStatus) {
        this.cashStatus = cashStatus;
    }

    public String getCashUsername() {
        return cashUsername;
    }

    public void setCashUsername(String cashUsername) {
        this.cashUsername = cashUsername == null ? null : cashUsername.trim();
    }

    public Long getCashAdminId() {
        return cashAdminId;
    }

    public void setCashAdminId(Long cashAdminId) {
        this.cashAdminId = cashAdminId;
    }

    public Long getCashUserId() {
        return cashUserId;
    }

    public void setCashUserId(Long cashUserId) {
        this.cashUserId = cashUserId;
    }
    
    
    private User cashUser;//会员名称
    private User cashAdmin;//操作管理员

	public User getCashUser() {
		return cashUser;
	}

	public void setCashUser(User cashUser) {
		this.cashUser = cashUser;
		if(cashUser!=null)
		{
			this.cashUserId = cashUser.getId();
		}	
	}

	public User getCashAdmin() {
		return cashAdmin;
	}

	public void setCashAdmin(User cashAdmin) {
		this.cashAdmin = cashAdmin;
		if(cashAdmin!=null)
		{
			this.cashAdminId = cashAdmin.getId();
		}
	}

	
	
	
    
	
}