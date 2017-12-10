package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class MutualBenefit implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private BigDecimal mutualFee;

    private Long getUserId;

    private Long giveUserId;
    
    private User getUser;
    
    private User giveUser;

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

    public BigDecimal getMutualFee() {
        return mutualFee;
    }

    public void setMutualFee(BigDecimal mutualFee) {
        this.mutualFee = mutualFee;
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Long getGiveUserId() {
        return giveUserId;
    }

    public void setGiveUserId(Long giveUserId) {
        this.giveUserId = giveUserId;
    }

	public User getGetUser()
	{
		return getUser;
	}

	public void setGetUser(User getUser)
	{
		this.getUser = getUser;
		if(getUser != null){
			this.getUserId = getUser.getId();
		}
	}

	public User getGiveUser()
	{
		return giveUser;
	}

	public void setGiveUser(User giveUser)
	{
		this.giveUser = giveUser;
		if(giveUser != null){
			this.giveUserId = giveUser.getId();
		}
	}
    
}