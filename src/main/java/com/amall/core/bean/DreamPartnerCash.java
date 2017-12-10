package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DreamPartnerCash implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;   //申请时间

    private Long applyUserId; //提现申请人
 
    private Boolean approveStatus; //提现审批状态

    private BigDecimal applyFee; //提现人数

    private Long operationUserId; //操作员

    private Date payTime;  //支付提现时间

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

    public Long getApplyUserId() {
        return applyUserId;
    }

    public void setApplyUserId(Long applyUserId) {
        this.applyUserId = applyUserId;
    }

    public Boolean getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(Boolean approveStatus) {
        this.approveStatus = approveStatus;
    }

    public BigDecimal getApplyFee() {
        return applyFee;
    }

    public void setApplyFee(BigDecimal applyFee) {
        this.applyFee = applyFee;
    }

    public Long getOperationUserId() {
        return operationUserId;
    }

    public void setOperationUserId(Long operationUserId) {
        this.operationUserId = operationUserId;
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
    
    private User applyUser;
    
    private User operationUser;

	public User getApplyUser()
	{
		return applyUser;
	}

	public void setApplyUser(User applyUser)
	{
		this.applyUser = applyUser;
	}

	public User getOperationUser()
	{
		return operationUser;
	}

	public void setOperationUser(User operationUser)
	{
		this.operationUser = operationUser;
	}
    
}