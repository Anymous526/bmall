package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class CloudShowOrder implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Long cloudGoodsId;

    private Long userId;

    private Long photoOne;

    private Long photoTwo;

    private Long photoThree;

    private String context;

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

    public Long getPhotoOne() {
        return photoOne;
    }

    public void setPhotoOne(Long photoOne) {
        this.photoOne = photoOne;
    }

    public Long getPhotoTwo() {
        return photoTwo;
    }

    public void setPhotoTwo(Long photoTwo) {
        this.photoTwo = photoTwo;
    }

    public Long getPhotoThree() {
        return photoThree;
    }

    public void setPhotoThree(Long photoThree) {
        this.photoThree = photoThree;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context == null ? null : context.trim();
    }
    
    private User user;
    
    private CloudGoods cloudGoods;
    
    private Accessory accessory_one;
    
    private Accessory accessory_two;
    
    private Accessory accessory_three;

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

	public Accessory getAccessory_one()
	{
		return accessory_one;
	}

	public void setAccessory_one(Accessory accessory_one)
	{
		this.accessory_one = accessory_one;
	}

	public Accessory getAccessory_two()
	{
		return accessory_two;
	}

	public void setAccessory_two(Accessory accessory_two)
	{
		this.accessory_two = accessory_two;
	}

	public Accessory getAccessory_three()
	{
		return accessory_three;
	}

	public void setAccessory_three(Accessory accessory_three)
	{
		this.accessory_three = accessory_three;
	}
    
}