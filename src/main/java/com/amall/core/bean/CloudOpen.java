package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CloudOpen implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Long cloudGoodsId;

    private Long userId;

    private Integer cloudCode;

    private Long showOrderId;
    
    private Date joinTime;
    
    private Integer buyCount;
    
    private Long orderId;
    
    /* 临时变量 */
    private List<Integer> codes;
    
    /* 订单临时变量 */
    private CloudGoodsOrder order;

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

    public Long getCloudGoodsId() {
        return cloudGoodsId;
    }

    public void setCloudGoodsId(Long cloudGoodsId) {
        this.cloudGoodsId = cloudGoodsId;
    }

    public CloudGoodsOrder getOrder()
	{
		return order;
	}

	public void setOrder(CloudGoodsOrder order)
	{
		this.order = order;
	}

	public Long getOrderId()
	{
		return orderId;
	}

	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}

	public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getJoinTime()
	{
		return joinTime;
	}

	public void setJoinTime(Date joinTime)
	{
		this.joinTime = joinTime;
	}

	public Integer getBuyCount()
	{
		return buyCount;
	}

	public void setBuyCount(Integer buyCount)
	{
		this.buyCount = buyCount;
	}

	public Integer getCloudCode() {
        return cloudCode;
    }

    public void setCloudCode(Integer cloudCode) {
        this.cloudCode = cloudCode;
    }

    public Long getShowOrderId() {
        return showOrderId;
    }

    public void setShowOrderId(Long showOrderId) {
        this.showOrderId = showOrderId;
    }
    
    public List<Integer> getCodes()
	{
		return codes;
	}

	public void setCodes(List<Integer> codes)
	{
		this.codes = codes;
	}



	private User user;
    
    private CloudGoods cloudGoods;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public CloudGoods getCloudGoods()
	{
		return cloudGoods;
	}

	public void setCloudGoods(CloudGoods cloudGoods)
	{
		this.cloudGoods = cloudGoods;
	}
}