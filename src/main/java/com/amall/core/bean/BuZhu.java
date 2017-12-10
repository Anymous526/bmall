package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BuZhu implements Serializable{

	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addTime;

    private BigDecimal buzhuFee;

    private Long getUserId;

    private Long giveUserId;

    private String getUserName;

    public String getGetUserName() {
		return getUserName;
	}

	public void setGetUserName(String getUserName) {
		this.getUserName = getUserName;
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

    public BigDecimal getBuzhuFee() {
        return buzhuFee;
    }

    public void setBuzhuFee(BigDecimal buzhuFee) {
        this.buzhuFee = buzhuFee;
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
}