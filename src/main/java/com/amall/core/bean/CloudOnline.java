package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class CloudOnline implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Long cloudGoodsId;

    private Long userId;

    private Integer cloudCodesCount;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getCloudCodesCount() {
        return cloudCodesCount;
    }

    public void setCloudCodesCount(Integer cloudCodesCount) {
        this.cloudCodesCount = cloudCodesCount;
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