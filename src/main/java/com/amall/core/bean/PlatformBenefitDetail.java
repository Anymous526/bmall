package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PlatformBenefitDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date addTime;

	private BigDecimal fee;

	/* 分利用户等级 */
	private Integer level;

	/* 分利类型 */
	private Integer type;//1==升级；2==普通商品分红；3==充值；4==后台手动升级超级合伙人；5==感恩豆交易手续费；6==O2O商品分红；10==未发放城市补助；

	/* 平台收入id */
	private Long platformEarningId;

	/* 分利用户 */
	private Long userId;

	public PlatformBenefitDetail() {
	}
	
	
	public PlatformBenefitDetail(Date addTime, BigDecimal fee, Integer level,
			Integer type, Long platformEarningId, Long userId) {
		super();
		this.addTime = addTime;
		this.fee = fee;
		this.level = level;
		this.type = type;
		this.platformEarningId = platformEarningId;
		this.userId = userId;
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

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Long getPlatformEarningId() {
		return platformEarningId;
	}

	public void setPlatformEarningId(Long platformEarningId) {
		this.platformEarningId = platformEarningId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}
}