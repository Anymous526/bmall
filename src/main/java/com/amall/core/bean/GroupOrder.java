package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 
 * <p>Title: GroupOrder</p>
 * <p>Description: 团购订单表</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  李越
 * @date	2015年8月5日上午10:51:16
 * @version 1.0
 */
public class GroupOrder {
    private Long id;//主键Id

    private Date addtime;//生成时间

    private Integer orderStatus;//订单状态.应该与对应OrderForm中的状态一直

    private Long userId;//用户的Id，多对一，对应User实体中的Id

    private BigDecimal totalprice;//团购订单价格

    private Long cartDetailId;//amall_goods_cart_detail中的Id，对应CartDetail实体类的Id字段，外键

    private Long ofId;//amall_orderform中的Id，对应OrderForm实体类的Id字段，外键

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

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getTotalprice() {
        return totalprice;
    }

    public void setTotalprice(BigDecimal totalprice) {
        this.totalprice = totalprice;
    }

    public Long getCartDetailId() {
        return cartDetailId;
    }

    public void setCartDetailId(Long cartDetailId) {
        this.cartDetailId = cartDetailId;
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }
    
    private User user;//团购订单对应的User
    private CartDetail cartDetail;//团购订单对应的CartDetail
    private OrderFormWithBLOBs orderForm;//团购订单对应的OrderFormWithBLOBs

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public CartDetail getCartDetail() {
		return cartDetail;
	}

	public void setCartDetail(CartDetail cartDetail) {
		this.cartDetail = cartDetail;
	}

	public OrderFormWithBLOBs getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(OrderFormWithBLOBs orderForm) {
		this.orderForm = orderForm;
	}
    
    
    
    
    
    
    
    
}