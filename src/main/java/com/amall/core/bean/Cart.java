package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 购物车主表，商品ID不在这里,在CartDetail表两个表通过goodscartID连接
 * @author tangxiang
 *
 */
public class Cart implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 一次选择商品结算需要支付的金额，不是购物条目表里面的总价
     */
    private BigDecimal payment;

    /**
     * 购物车状态，true带表这是一个有效购物车。false代表购物车已经失效不可使用
     */
    private Boolean status;

    /**
     * UID码购物车编号
     */
    private String goodsCartId;
    
    /**
     * 表示购物车生成订单之后的Id号.对应OrderForm的主键Id。用，号隔开
     */
    private String ofId;//表示购物车生成订单之后的Id号
    
    /**
     * 提交订单的时候。遍历所有CartDetail，拿到所有CartDetail的goodsId
     */
    private String goodsIds;//保存所有goodsId，保存所有该订单存在的goodsId商品号.goodsId使用,分隔
    
    

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getPayment() {
        return payment;
    }

    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getGoodsCartId() {
        return goodsCartId;
    }

    public void setGoodsCartId(String goodsCartId) {
        this.goodsCartId = goodsCartId == null ? null : goodsCartId.trim();
    }

	public String getOfId() {
		return ofId;
	}

	public void setOfId(String ofId) {
		this.ofId = ofId;
	}

	public String getGoodsIds() {
		return goodsIds;
	}

	public void setGoodsIds(String goodsIds) {
		this.goodsIds = goodsIds;
	}


    private List<GoodsWithBLOBs> goodslist=new ArrayList<GoodsWithBLOBs>();//根据goodsIds得到goodslist
    
    /**
     * Cart和CartDetail通过amall_goods_cart_detail中的cart_id字段关联在一起.即CartDetail中的cart_id是Cart的主键Id
     */
    private List<CartDetail> cartDetailList=new ArrayList<CartDetail>();


	public List<GoodsWithBLOBs> getGoodslist() {
		return goodslist;
	}

	public void setGoodslist(List<GoodsWithBLOBs> goodslist) {
		this.goodslist = goodslist;
	}

	public List<CartDetail> getCartDetailList() {
		return cartDetailList;
	}

	public void setCartDetailList(List<CartDetail> cartDetailList) {
		this.cartDetailList = cartDetailList;
	}
    
    
    
    
    
}