package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Predeposit implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;//提交时间

    private Boolean deletestatus;

    private BigDecimal pdAmount;//充值金额

    private Integer pdPayStatus;//支付状态

    private String pdPayment;//支付方式

    private String pdRemittanceBank;//汇款银行

    private Date pdRemittanceTime;//汇款日期

    private String pdRemittanceUser;//汇款人姓名

    private String pdSn;//预存款编号

    private Integer pdStatus;//预存款状态

    private Long pdAdminId;

    private Long pdUserId;
    
    private Long logId;

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

    public BigDecimal getPdAmount() {
        return pdAmount;
    }

    public void setPdAmount(BigDecimal pdAmount) {
        this.pdAmount = pdAmount;
    }

    public Integer getPdPayStatus() {
        return pdPayStatus;
    }

    public void setPdPayStatus(Integer pdPayStatus) {
        this.pdPayStatus = pdPayStatus;
    }

    public String getPdPayment() {
        return pdPayment;
    }

    public void setPdPayment(String pdPayment) {
        this.pdPayment = pdPayment == null ? null : pdPayment.trim();
    }

    public String getPdRemittanceBank() {
        return pdRemittanceBank;
    }

    public void setPdRemittanceBank(String pdRemittanceBank) {
        this.pdRemittanceBank = pdRemittanceBank == null ? null : pdRemittanceBank.trim();
    }

    public Date getPdRemittanceTime() {
        return pdRemittanceTime;
    }

    public void setPdRemittanceTime(Date pdRemittanceTime) {
        this.pdRemittanceTime = pdRemittanceTime;
    }

    public String getPdRemittanceUser() {
        return pdRemittanceUser;
    }

    public void setPdRemittanceUser(String pdRemittanceUser) {
        this.pdRemittanceUser = pdRemittanceUser == null ? null : pdRemittanceUser.trim();
    }

    public String getPdSn() {
        return pdSn;
    }

    public void setPdSn(String pdSn) {
        this.pdSn = pdSn == null ? null : pdSn.trim();
    }

    public Integer getPdStatus() {
        return pdStatus;
    }

    public void setPdStatus(Integer pdStatus) {
        this.pdStatus = pdStatus;
    }

    public Long getPdAdminId() {
        return pdAdminId;
    }

    public void setPdAdminId(Long pdAdminId) {
        this.pdAdminId = pdAdminId;
    }

    public Long getPdUserId() {
        return pdUserId;
    }

    public void setPdUserId(Long pdUserId) {
        this.pdUserId = pdUserId;
    }
    
    public Long getLogId() {
		return logId;
	}

	public void setLogId(Long logId) {
		this.logId = logId;
	}





	private User pdUser;//会员
	private User pdAdmin;//操作管理员
	private PredepositLog log;

	public User getPdUser() {
		return pdUser;
	}

	public void setPdUser(User pdUser) {
		this.pdUser = pdUser;
		if(pdUser!=null)
		{
			this.pdUserId = pdUser.getId();
		}
	}

	public User getPdAdmin() {
		return pdAdmin;
	}

	public void setPdAdmin(User pdAdmin) {
		this.pdAdmin = pdAdmin;
		if(pdAdmin!=null)
		{
			this.pdAdminId = pdAdmin.getId();
		}
	}

	public PredepositLog getLog() {
		return log;
	}

	public void setLog(PredepositLog log) {
		this.log = log;
	}
}