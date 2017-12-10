package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: OrderForm</p>
 * <p>Description: 订单信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日上午11:12:02
 * @version 1.0
 */

public class OrderForm implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;		//下单时间

    private Boolean deletestatus;

    private Date finishtime;

    private BigDecimal goodsAmount;		//商品总计 ,order_print.html中有"<li>总计:￥$!obj.goodsAmount</li>"

    private String invoice;		//发票台头

    private Integer invoicetype;	//发票类型

    private String orderId;			//订单号

    private Integer orderStatus;		//订单状态

    private Date paytime;			//支付时间

    private BigDecimal refund;		//退款金额

    private String refundType;		//退款方式

    private String shipcode;		//物流单号
    
    private Date shiptime;			//发货时间

    private BigDecimal shipPrice;		//运费金额

    private BigDecimal totalprice;		//订单总金额

    private Long addrId;

    private Long paymentId;		//支付方式

    private Long storeId;

    private Long userId;

    private Boolean autoConfirmEmail;   //是否发送邮件

    private Boolean autoConfirmSms;		//是否发送短信

    private String transport;

    private String outOrderId;

    private Long ecId;

    private Long ciId;//保存购物车的Cart实体类的主键Id。对应amall_goods_cart的主键Id

    private String returnShipcode;	//物流单号

    private Long returnEcId;	//物流公司外键id

    private Date returnShiptime;	//退货物流时间

    private String orderType;		//订单状态
    
    private Long alipayorderId;  //多个OrderForm生成一个新的订单，新的订单的Id号。外键amall_alipayorder的主键Id
    
    private Long refundId;
    
    private BigDecimal beanNum;

    private BigDecimal beanAmount;
    
    private Refund refundEntity;
    
    private AlipayOrder  alipayOrder;
    
    
    public Refund getRefundEntity() {
		return refundEntity;
	}

	public void setRefundEntity(Refund refundEntity) {
		this.refundEntity = refundEntity;
	}

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

    public Date getFinishtime() {
        return finishtime;
    }

    public void setFinishtime(Date finishtime) {
        this.finishtime = finishtime;
    }

    public BigDecimal getGoodsAmount() {
        return goodsAmount;
    }

    public void setGoodsAmount(BigDecimal goodsAmount) {
        this.goodsAmount = goodsAmount;
    }

    public String getInvoice() {
        return invoice;
    }

    public void setInvoice(String invoice) {
        this.invoice = invoice == null ? null : invoice.trim();
    }

    public Integer getInvoicetype() {
        return invoicetype;
    }

    public void setInvoicetype(Integer invoicetype) {
        this.invoicetype = invoicetype;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getPaytime() {
        return paytime;
    }

    public void setPaytime(Date paytime) {
        this.paytime = paytime;
    }

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    public String getShipcode() {
        return shipcode;
    }

    public void setShipcode(String shipcode) {
        this.shipcode = shipcode == null ? null : shipcode.trim();
    }

    public Date getShiptime() {
        return shiptime;
    }

    public void setShiptime(Date shiptime) {
        this.shiptime = shiptime;
    }

    public BigDecimal getShipPrice() {
        return shipPrice;
    }

    public void setShipPrice(BigDecimal shipPrice) {
        this.shipPrice = shipPrice;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Long getAddrId() {
        return addrId;
    }

    public void setAddrId(Long addrId) {
        this.addrId = addrId;
    }

    public Long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Long paymentId) {
        this.paymentId = paymentId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getAutoConfirmEmail() {
        return autoConfirmEmail;
    }

    public void setAutoConfirmEmail(Boolean autoConfirmEmail) {
        this.autoConfirmEmail = autoConfirmEmail;
    }

    public Boolean getAutoConfirmSms() {
        return autoConfirmSms;
    }

    public void setAutoConfirmSms(Boolean autoConfirmSms) {
        this.autoConfirmSms = autoConfirmSms;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport == null ? null : transport.trim();
    }

    public String getOutOrderId() {
        return outOrderId;
    }

    public void setOutOrderId(String outOrderId) {
        this.outOrderId = outOrderId == null ? null : outOrderId.trim();
    }

    public Long getEcId() {
        return ecId;
    }

    public void setEcId(Long ecId) {
        this.ecId = ecId;
    }

    public Long getCiId() {
        return ciId;
    }

    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    public String getReturnShipcode() {
        return returnShipcode;
    }

    public void setReturnShipcode(String returnShipcode) {
        this.returnShipcode = returnShipcode == null ? null : returnShipcode.trim();
    }

    public Long getReturnEcId() {
        return returnEcId;
    }

    public void setReturnEcId(Long returnEcId) {
        this.returnEcId = returnEcId;
    }

    public Date getReturnShiptime() {
        return returnShiptime;
    }

    public void setReturnShiptime(Date returnShiptime) {
        this.returnShiptime = returnShiptime;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }
    
    public Long getAlipayorderId() {
		return alipayorderId;
	}

	public void setAlipayorderId(Long alipayorderId) {
		this.alipayorderId = alipayorderId;
	}






	private ExpressCompany ec;
	private ExpressCompany returnEc;
	private Store store;//对应的店铺
	private OrderAddress addr;
	private User user;
	/**
	 * 这个ci好像没有用到，配置的时候与Cart注意区分。目前项目中配置的时候是CouponInfo的ciId
	 */
	private CouponInfo ci;//优惠券.在order_view.html中用到：<span class="frspan">使用优惠券：$!{obj.ci.couponSn}
	private List<OrderFormLog> ofls = new ArrayList<OrderFormLog>();
	private List<GoodsReturnLog> grls = new ArrayList<GoodsReturnLog>();
	private List<EvaluateWithBLOBs> evas = new ArrayList<EvaluateWithBLOBs>();
	private List<ComplaintWithBLOBs> complaints = new ArrayList<ComplaintWithBLOBs>();
    private List<OrderFormItem> items = new ArrayList<OrderFormItem>();
    private Cart cart;//Cart购物车
    
    private Long groupId;
    private Group group;
    
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		if(store !=null)
			this.storeId = store.getId();
	}


	public OrderAddress getAddr()
	{
		return addr;
	}

	public void setAddr(OrderAddress addr)
	{
		this.addr = addr;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user !=null)
			this.userId = user.getId();
	}

	public CouponInfo getCi() {
		return ci;
	}

	public void setCi(CouponInfo ci) {
		this.ci = ci;
		if(ci !=null)
		this.ciId = ci.getId();
	}

	public List<OrderFormLog> getOfls() {
		return ofls;
	}

	public void setOfls(List<OrderFormLog> ofls) {
		this.ofls = ofls;
	}

	public List<OrderFormItem> getItems()
	{
		return items;
	}

	public void setItems(List<OrderFormItem> items)
	{
		this.items = items;
	}

	public List<GoodsReturnLog> getGrls() {
		return grls;
	}

	public void setGrls(List<GoodsReturnLog> grls) {
		this.grls = grls;
	}

	public List<EvaluateWithBLOBs> getEvas() {
		return evas;
	}

	public void setEvas(List<EvaluateWithBLOBs> evas) {
		this.evas = evas;
	}

	public List<ComplaintWithBLOBs> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<ComplaintWithBLOBs> complaints) {
		this.complaints = complaints;
	}

	public ExpressCompany getEc() {
		return ec;
	}

	public void setEc(ExpressCompany ec) {
		this.ec = ec;
		if(ec!=null)
		{
			this.setEcId(ec.getId());
		}
	}

	public ExpressCompany getReturnEc() {
		return returnEc;
	}

	public void setReturnEc(ExpressCompany returnEc) {
		this.returnEc = returnEc;
	}


	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Long getRefundId() {
		return refundId;
	}

	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}

	public BigDecimal getBeanNum() {
		return beanNum;
	}

	public void setBeanNum(BigDecimal beanNum) {
		this.beanNum = beanNum;
	}

	public BigDecimal getBeanAmount() {
		return beanAmount;
	}

	public void setBeanAmount(BigDecimal beanAmount) {
		this.beanAmount = beanAmount;
	}

	public AlipayOrder getAlipayOrder() {
		return alipayOrder;
	}

	public void setAlipayOrder(AlipayOrder alipayOrder) {
		this.alipayOrder = alipayOrder;
	}







	
	
	
}