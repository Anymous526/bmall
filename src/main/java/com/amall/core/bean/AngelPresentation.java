package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class AngelPresentation implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private String giveContent;

    private String getContent;

    private Long getUserId;

    private Integer angelGold;

    private Long giveUserId;

    private Date txTime;
    
    private User giveUser;
    
    private User getUser;

    /**
     * 交易状态：0-待领取，1-已领取，2-已退还
     */
    private Integer txStatus;

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

    public String getGiveContent() {
        return giveContent;
    }

    public void setGiveContent(String giveContent) {
        this.giveContent = giveContent == null ? null : giveContent.trim();
    }

    public String getGetContent() {
        return getContent;
    }

    public void setGetContent(String getContent) {
        this.getContent = getContent == null ? null : getContent.trim();
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Integer getAngelGold() {
        return angelGold;
    }

    public void setAngelGold(Integer angelGold) {
        this.angelGold = angelGold;
    }

    public Long getGiveUserId() {
        return giveUserId;
    }

    public void setGiveUserId(Long giveUserId) {
        this.giveUserId = giveUserId;
    }

    public Date getTxTime() {
        return txTime;
    }

    public void setTxTime(Date txTime) {
        this.txTime = txTime;
    }

    public Integer getTxStatus() {
        return txStatus;
    }

    public void setTxStatus(Integer txStatus) {
        this.txStatus = txStatus;
    }

	public User getGiveUser()
	{
		return giveUser;
	}

	public void setGiveUser(User giveUser)
	{
		this.giveUser = giveUser;
	}

	public User getGetUser()
	{
		return getUser;
	}

	public void setGetUser(User getUser)
	{
		this.getUser = getUser;
	}
    
    
}