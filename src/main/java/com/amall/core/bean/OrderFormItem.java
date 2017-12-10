package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class OrderFormItem implements Serializable {
	/** serialVersionUID */
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Long goodsId;

    private String goodsName;

    private Date addTime;

    private Integer goodsCount;

    private Boolean directBuy;

    private BigDecimal goodsPrice;

    private Integer refund;  // 状态

    private Long goodsPhoto;

    private Long orderId;

    private Boolean leeStatus;   //是否已经同步到分利   true:已同步, false:未同步 
    
    private Boolean itemStatus;	//商品是否已经评价 0未评价，1已评价

	private String specInfo;
    
    private Accessory goodsMainPhoto;//商品照片
    
    private OrderForm orderForm;
    
    private BigDecimal goodsRate;

    private Integer refundServer;
    private Boolean updateorder;	//用于标识是否调整过费用

    public Boolean getUpdateorder() {
		return updateorder;
	}

	public void setUpdateorder(Boolean updateorder) {
		this.updateorder = updateorder;
	}

	private Goods goods;
	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public Accessory getGoodsMainPhoto() {
		return goodsMainPhoto;
	}

	public void setGoodsMainPhoto(Accessory goodsMainPhoto) {
		this.goodsMainPhoto = goodsMainPhoto;
	}

	public OrderForm getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderForm orderForm) {
		this.orderForm = orderForm;
	}

	public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Boolean getDirectBuy() {
        return directBuy;
    }

    public void setDirectBuy(Boolean directBuy) {
        this.directBuy = directBuy;
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Integer getRefund() {
        return refund;
    }

    public void setRefund(Integer refund) {
        this.refund = refund;
    }

    public Long getGoodsPhoto() {
        return goodsPhoto;
    }

    public void setGoodsPhoto(Long goodsPhoto) {
        this.goodsPhoto = goodsPhoto;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Boolean getLeeStatus() {
        return leeStatus;
    }

    public void setLeeStatus(Boolean leeStatus) {
        this.leeStatus = leeStatus;
    }

    public Boolean getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(Boolean itemStatus) {
		this.itemStatus = itemStatus;
	}
    
    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo == null ? null : specInfo.trim();
    }

	public BigDecimal getGoodsRate()
	{
		return goodsRate;
	}

	public void setGoodsRate(BigDecimal goodsRate)
	{
		this.goodsRate = goodsRate;
	}

	public Integer getRefundServer()
	{
		return refundServer;
	}

	public void setRefundServer(Integer refundServer)
	{
		this.refundServer = refundServer;
	}
    
    
}