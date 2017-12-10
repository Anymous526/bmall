package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class CloudBuyerDetail implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Long cloudGoodsId;

    private Long userId;

    private String cloudCodesDetail;

    private Integer userSelectNumber;
    
    private Integer buyCounts;

    private Boolean isOpen;
    
    private List<Integer> codes;

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

    public Boolean getIsOpen()
	{
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen)
	{
		this.isOpen = isOpen;
	}

	public Long getCloudGoodsId() {
        return cloudGoodsId;
    }

    public void setCloudGoodsId(Long cloudGoodsId) {
        this.cloudGoodsId = cloudGoodsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCloudCodesDetail() {
        return cloudCodesDetail;
    }

    public void setCloudCodesDetail(String cloudCodesDetail) {
        this.cloudCodesDetail = cloudCodesDetail == null ? null : cloudCodesDetail.trim();
    }

    public Integer getUserSelectNumber() {
        return userSelectNumber;
    }

    public void setUserSelectNumber(Integer userSelectNumber) {
        this.userSelectNumber = userSelectNumber;
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

	public Integer getBuyCounts()
	{
		return buyCounts;
	}

	public void setBuyCounts(Integer buyCounts)
	{
		this.buyCounts = buyCounts;
	}
	
}