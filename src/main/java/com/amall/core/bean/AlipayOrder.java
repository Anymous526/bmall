package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class AlipayOrder implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private String orderId;  //订单ID，如果一次支付多个订单那么这是一个合并订单

    private BigDecimal totalFee; //总共支付的金钱

    private Long userId;  //买家amall帐号ID

    private Long paymentId;    //平台收款帐号

    private String payType;    //支付的方式 ： 如 支付宝，微信等

    private String payCardId;  //买家支付帐号如 银行卡号， 支付宝号 等等

    private String cardType;   //支付卡类型 如中国银行，招商银行等  ** 1：表示是天使余额升级会员

    private String bankSerialNum;   //银行交易流水号  

    private Integer payCode;   //支付返回码

    private Boolean isRefund;  //是否退款

    private BigDecimal refundFee;   //退款金额，不能大于支付金额

    private Long sellerUserId;   //卖家amall帐号ID
    
    private User user;   //买家用户对象
    
    private User sellerUser;  //买家用户对象
    
    private Payment payment;  //平台支付方式对象

    private Date txnTime;  // 交易时间
    
	private Boolean appPay;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public BigDecimal getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getPayCardId() {
        return payCardId;
    }

    public void setPayCardId(String payCardId) {
        this.payCardId = payCardId == null ? null : payCardId.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getBankSerialNum() {
        return bankSerialNum;
    }

    public void setBankSerialNum(String bankSerialNum) {
        this.bankSerialNum = bankSerialNum == null ? null : bankSerialNum.trim();
    }

    public Integer getPayCode() {
        return payCode;
    }

    public void setPayCode(Integer payCode) {
        this.payCode = payCode;
    }

    public Boolean getIsRefund() {
        return isRefund;
    }

    public void setIsRefund(Boolean isRefund) {
        this.isRefund = isRefund;
    }

    public BigDecimal getRefundFee() {
        return refundFee;
    }

    public void setRefundFee(BigDecimal refundFee) {
        this.refundFee = refundFee;
    }

    public Long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(Long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public User getSellerUser()
	{
		return sellerUser;
	}

	public void setSellerUser(User sellerUser)
	{
		this.sellerUser = sellerUser;
	}

	public Payment getPayment()
	{
		return payment;
	}

	public void setPayment(Payment payment)
	{
		this.payment = payment;
	}

	public Date getTxnTime() {
		return txnTime;
	}

	public void setTxnTime(Date txnTime) {
		this.txnTime = txnTime;
	}
    
    public Boolean getAppPay() {
        return appPay;
    }

    public void setAppPay(Boolean appPay) {
        this.appPay = appPay;
    }
}