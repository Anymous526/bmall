package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ShopBenefit implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private BigDecimal shopFee;

    private Long getUserId;

    private Long giveShopId;

    private Long orderId;
    
    private User getUser;
    
    private StoreWithBLOBs giveShop;
    
    private OrderForm order;

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

    public BigDecimal getShopFee() {
        return shopFee;
    }

    public void setShopFee(BigDecimal shopFee) {
        this.shopFee = shopFee;
    }

    public Long getGetUserId() {
        return getUserId;
    }

    public void setGetUserId(Long getUserId) {
        this.getUserId = getUserId;
    }

    public Long getGiveShopId() {
        return giveShopId;
    }

    public void setGiveShopId(Long giveShopId) {
        this.giveShopId = giveShopId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

	public User getGetUser()
	{
		return getUser;
	}

	public void setGetUser(User getUser)
	{
		this.getUser = getUser;
	}

	public StoreWithBLOBs getGiveShop()
	{
		return giveShop;
	}

	public void setGiveShop(StoreWithBLOBs giveShop)
	{
		this.giveShop = giveShop;
	}

	public OrderForm getOrder()
	{
		return order;
	}

	public void setOrder(OrderForm order)
	{
		this.order = order;
	}
    
}