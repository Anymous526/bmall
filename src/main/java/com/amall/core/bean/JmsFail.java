package com.amall.core.bean;

import java.util.Date;

public class JmsFail {
    private Long id;

    private Long orderItemId;

    private Long userId;
    
    private Date addTime;
    
    private OrderFormItem orderItem;
    
    private User user;
    
    private Long storeId;
    
    private Store store;
    
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOrderItemId() {
        return orderItemId;
    }

    public void setOrderItemId(Long orderItemId) {
        this.orderItemId = orderItemId;
    }

    public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getAddTime()
	{
		return addTime;
	}

	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public OrderFormItem getOrderItem()
	{
		return orderItem;
	}

	public void setOrderItem(OrderFormItem orderItem)
	{
		this.orderItem = orderItem;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Long getStoreId()
	{
		return storeId;
	}

	public void setStoreId(Long storeId)
	{
		this.storeId = storeId;
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