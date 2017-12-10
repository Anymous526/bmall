package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PlatformEarningDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addTime;

	private BigDecimal earningFee;

	private Integer type;

	private Long giveUserId;

	private BigDecimal originalFee;

	private User giveUser;

	public PlatformEarningDetail() {
	}

	public PlatformEarningDetail(Date addTime, BigDecimal earningFee,
			Integer type, Long giveUserId, BigDecimal originalFee) {
		super();
		this.addTime = addTime;
		this.earningFee = earningFee;
		this.type = type;
		this.giveUserId = giveUserId;
		this.originalFee = originalFee;
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

	public BigDecimal getEarningFee() {
		return earningFee;
	}

	public void setEarningFee(BigDecimal earningFee) {
		this.earningFee = earningFee;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getGiveUserId() {
		return giveUserId;
	}

	public void setGiveUserId(Long giveUserId) {
		this.giveUserId = giveUserId;
	}

	public BigDecimal getOriginalFee() {
		return originalFee;
	}

	public void setOriginalFee(BigDecimal originalFee) {
		this.originalFee = originalFee;
	}

	public User getGiveUser() {
		return giveUser;
	}

	public void setGiveUser(User giveUser) {
		this.giveUser = giveUser;
		if (giveUser != null) {
			this.giveUserId = giveUser.getId();
		}
	}

}