package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class CloudGoodsOrder implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private Boolean deletestatus;

    private String msg;

    private String orderId;

    private String shipCode;

    private String shipContent;

    private Date shipTime;

    private Integer orderStatus;

    private BigDecimal shipTransFee;

    private Long cloudsGoodsId;
    
    private Long addressId;

    private Long userId;
    
    /* 快递id */
    private Long ecId;
    
    private User user;
    
    private CloudGoods cloudGoods;
    
    private OrderAddress address;
    
    private ExpressCompany ec;

    public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public CloudGoods getCloudGoods()
	{
		return cloudGoods;
	}

	public ExpressCompany getEc()
	{
		return ec;
	}

	public void setEc(ExpressCompany ec)
	{
		this.ec = ec;
	}

	public void setCloudGoods(CloudGoods cloudGoods)
	{
		this.cloudGoods = cloudGoods;
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

	public OrderAddress getAddress()
	{
		return address;
	}

	public void setAddress(OrderAddress address)
	{
		this.address = address;
	}

	public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getShipCode() {
        return shipCode;
    }

    public void setShipCode(String shipCode) {
        this.shipCode = shipCode == null ? null : shipCode.trim();
    }

    public String getShipContent() {
        return shipContent;
    }

    public void setShipContent(String shipContent) {
        this.shipContent = shipContent == null ? null : shipContent.trim();
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public BigDecimal getShipTransFee() {
        return shipTransFee;
    }

    public void setShipTransFee(BigDecimal shipTransFee) {
        this.shipTransFee = shipTransFee;
    }

    public Long getCloudsGoodsId() {
        return cloudsGoodsId;
    }

    public void setCloudsGoodsId(Long cloudsGoodsId) {
        this.cloudsGoodsId = cloudsGoodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public Long getAddressId()
	{
		return addressId;
	}

	public void setAddressId(Long addressId)
	{
		this.addressId = addressId;
	}

	public Long getEcId()
	{
		return ecId;
	}

	public void setEcId(Long ecId)
	{
		this.ecId = ecId;
	}

	
}