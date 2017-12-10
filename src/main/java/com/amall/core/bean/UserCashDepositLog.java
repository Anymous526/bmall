package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class UserCashDepositLog implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private BigDecimal fee;

    private Long userId;

    private String cardId;

    private String cardName;

    private String cardType;

    private Boolean deleteStatus;

    private Boolean isWithdraw;

    private String address;

    private Date txTime;
    
    private Long adminUserId;
    
    private User adminUser;
    
    private User user;
	
    private String refuseMessage;
	
    private String cardCity;
    
    public String getCardCity() {
		return cardCity;
	}

	public void setCardCity(String cardCity) {
		this.cardCity = cardCity;
	}

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

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId == null ? null : cardId.trim();
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public Boolean getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Boolean getIsWithdraw() {
        return isWithdraw;
    }

    public void setIsWithdraw(Boolean isWithdraw) {
        this.isWithdraw = isWithdraw;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Date getTxTime() {
        return txTime;
    }

    public void setTxTime(Date txTime) {
        this.txTime = txTime;
    }

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Long getAdminUserId()
	{
		return adminUserId;
	}

	public void setAdminUserId(Long adminUserId)
	{
		this.adminUserId = adminUserId;
	}

	public User getAdminUser()
	{
		return adminUser;
	}

	public void setAdminUser(User adminUser)
	{
		this.adminUser = adminUser;
	}
    public String getRefuseMessage() {
        return refuseMessage;
    }

    public void setRefuseMessage(String refuseMessage) {
        this.refuseMessage = refuseMessage == null ? null : refuseMessage.trim();
    }

}