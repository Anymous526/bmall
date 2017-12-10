package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class CashDeposit implements Serializable{
    
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date createTime;

    private Integer cashStatus;

    private Date paymentTime;

    private Long payOrderId;

    private Long refundId;
    
    private Long sellerUserId;
    
    /* 临时变量 */
    private String orderId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    public Integer getCashStatus()
	{
		return cashStatus;
	}

	public void setCashStatus(Integer cashStatus)
	{
		this.cashStatus = cashStatus;
	}

	public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Long getPayOrderId() {
        return payOrderId;
    }

    public void setPayOrderId(Long payOrderId) {
        this.payOrderId = payOrderId;
    }

    public Long getRefundId() {
        return refundId;
    }

    public void setRefundId(Long refundId) {
        this.refundId = refundId;
    }
    
    public Long getSellerUserId()
	{
		return sellerUserId;
	}

	public void setSellerUserId(Long sellerUserId)
	{
		this.sellerUserId = sellerUserId;
	}


	private AlipayOrder alipayOrder;
    
    private Refund refund;
    
    private User sellerUser;

	public User getSellerUser()
	{
		return sellerUser;
	}

	public void setSellerUser(User sellerUser)
	{
		this.sellerUser = sellerUser;
	}

	public AlipayOrder getAlipayOrder()
	{
		return alipayOrder;
	}

	public void setAlipayOrder(AlipayOrder alipayOrder)
	{
		this.alipayOrder = alipayOrder;
	}

	public Refund getRefund()
	{
		return refund;
	}

	public void setRefund(Refund refund)
	{
		this.refund = refund;
	}

    public String getOrderId()
    {
        return orderId;
    }

    public void setOrderId(String orderId)
    {
        this.orderId = orderId;
    }
    
    
}