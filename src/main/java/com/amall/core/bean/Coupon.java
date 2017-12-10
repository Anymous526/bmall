package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: Coupon</p>
 * <p>Description: 优惠券信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月6日上午11:59:36
 * @version 1.0
 */

public class Coupon implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private BigDecimal couponAmount;    //优惠券发放额度

    private Date couponBeginTime;		//优惠券使用开始时间

    private Integer couponCount;		//优惠券发放总数

    private Date couponEndTime;			//优惠券使用结束时间

    private String couponName;			//优惠券名称

    private BigDecimal couponOrderAmount; 

    private Long couponAccId;           //优惠券图片外键id

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

    public BigDecimal getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(BigDecimal couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Date getCouponBeginTime() {
        return couponBeginTime;
    }

    public void setCouponBeginTime(Date couponBeginTime) {
        this.couponBeginTime = couponBeginTime;
    }

    public Integer getCouponCount() {
        return couponCount;
    }

    public void setCouponCount(Integer couponCount) {
        this.couponCount = couponCount;
    }

    public Date getCouponEndTime() {
        return couponEndTime;
    }

    public void setCouponEndTime(Date couponEndTime) {
        this.couponEndTime = couponEndTime;
    }

    public String getCouponName() {
        return couponName;
    }

    public void setCouponName(String couponName) {
        this.couponName = couponName == null ? null : couponName.trim();
    }

    public BigDecimal getCouponOrderAmount() {
        return couponOrderAmount;
    }

    public void setCouponOrderAmount(BigDecimal couponOrderAmount) {
        this.couponOrderAmount = couponOrderAmount;
    }

    public Long getCouponAccId() {
        return couponAccId;
    }

    public void setCouponAccId(Long couponAccId) {
        this.couponAccId = couponAccId;
    }
    
    
    private Accessory couponAcc;
    private List<CouponInfo> couponinfos = new ArrayList<CouponInfo>();

	public Accessory getCouponAcc() {
		return couponAcc;
	}

	public void setCouponAcc(Accessory couponAcc) {
		this.couponAcc = couponAcc;
		this.couponAccId = couponAcc.getId();
	}

	public List<CouponInfo> getCouponinfos() {
		return couponinfos;
	}

	public void setCouponinfos(List<CouponInfo> couponinfos) {
		this.couponinfos = couponinfos;
	}
	
}