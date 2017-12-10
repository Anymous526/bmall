package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StoreEarningDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime;

    private BigDecimal fee;

    private Long storeId;

    private Long orderId;
    //分利金额
    private BigDecimal benefitFee;

    private BigDecimal rate;

    private Long orderItemId;
    
    private OrderForm order;
    
    private OrderFormItem orderItem;
    
    private Store store;

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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public BigDecimal getBenefitFee() {
        return benefitFee;
    }

    public void setBenefitFee(BigDecimal benefitFee) {
        this.benefitFee = benefitFee;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

	public OrderForm getOrder()
	{
		return order;
	}

	public void setOrder(OrderForm order)
	{
		this.order = order;
	}

	public OrderFormItem getOrderItem()
	{
		return orderItem;
	}

	public void setOrderItem(OrderFormItem orderItem)
	{
		this.orderItem = orderItem;
	}

	public Store getStore()
	{
		return store;
	}

	public void setStore(Store store)
	{
		this.store = store;
	}
    
}