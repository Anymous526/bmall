package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 积分商品购物车
 * @author ljx
 *
 */
public class IntegralGoodsCart implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer count;

    private Integer integral;

    private BigDecimal transFee;

    private Long goodsId;

    private Long orderId;

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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getTransFee() {
        return transFee;
    }

    public void setTransFee(BigDecimal transFee) {
        this.transFee = transFee;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
    
    
    
    
    private IntegralGoodsOrderWithBLOBs order;
    private IntegralGoods goods;


	public IntegralGoodsOrderWithBLOBs getOrder() {
		return order;
	}

	public void setOrder(IntegralGoodsOrderWithBLOBs order) {
		this.order = order;
	}

	public IntegralGoods getGoods() {
		return goods;
	}

	public void setGoods(IntegralGoods goods) {
		this.goods = goods;
	}
    
    
	
    
}