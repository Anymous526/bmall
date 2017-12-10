package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DreamPartner implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private Date approveTime; //审批通过时间

    private Long referrerUserId; //直接推荐人id

    private Long applyUserId; //申请人id

    private Boolean approveStatus; //申请状态 true:申请通过， false：等待审批

    private BigDecimal totalFee; //总额度

    private BigDecimal userFee; //已经提现的额度

    private Date lastUserFeeTime; //上次提现时间
    
    private Long cardFrontId; //证件照前面

    private Long cardBackId; //证件照后面
    
    private String type; //不是数据库字段 用来表示改用户属于几级推荐 

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

    public Date getApproveTime() {
        return approveTime;
    }

    public void setApproveTime(Date approveTime) {
        this.approveTime = approveTime;
    }

    public Long getReferrerUserId() {
        return referrerUserId;
    }

    public void setReferrerUserId(Long referrerUserId) {
        this.referrerUserId = referrerUserId;
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

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public BigDecimal getUserFee() {
        return userFee;
    }

    public void setUserFee(BigDecimal userFee) {
        this.userFee = userFee;
    }

    public String getType()
	{
		return type;
	}

	public void setType(String type)
	{
		this.type = type;
	}

	public Date getLastUserFeeTime() {
        return lastUserFeeTime;
    }

    public void setLastUserFeeTime(Date lastUserFeeTime) {
        this.lastUserFeeTime = lastUserFeeTime;
    }
    
    public Long getCardFrontId()
	{
		return cardFrontId;
	}

	public void setCardFrontId(Long cardFrontId)
	{
		this.cardFrontId = cardFrontId;
	}

	public Long getCardBackId()
	{
		return cardBackId;
	}

	public void setCardBackId(Long cardBackId)
	{
		this.cardBackId = cardBackId;
	}

	private User applyUser; //申请梦想会员ID
    
    private User referrerUser; //梦想会员推荐人
    
    private Accessory cardBack; //证件背面
    
    private Accessory cardFront; //证件前面

	public User getApplyUser()
	{
		return applyUser;
	}

	public void setApplyUser(User applyUser)
	{
		this.applyUser = applyUser;
	}

	public User getReferrerUser()
	{
		return referrerUser;
	}

	public void setReferrerUser(User referrerUser)
	{
		this.referrerUser = referrerUser;
	}

	public Accessory getCardBack()
	{
		return cardBack;
	}

	public void setCardBack(Accessory cardBack)
	{
		this.cardBack = cardBack;
	}

	public Accessory getCardFront()
	{
		return cardFront;
	}

	public void setCardFront(Accessory cardFront)
	{
		this.cardFront = cardFront;
	}
    
}