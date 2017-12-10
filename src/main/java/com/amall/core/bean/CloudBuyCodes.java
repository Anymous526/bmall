package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class CloudBuyCodes implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long cloudGoodsId;

    private Date addTime;

    private Long userId;

    private Integer selectNumber;

    private String codes;
    
    private Integer buyCount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCloudGoodsId() {
        return cloudGoodsId;
    }

    public void setCloudGoodsId(Long cloudGoodsId) {
        this.cloudGoodsId = cloudGoodsId;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getBuyCount()
	{
		return buyCount;
	}

	public void setBuyCount(Integer buyCount)
	{
		this.buyCount = buyCount;
	}

	public Integer getSelectNumber() {
        return selectNumber;
    }

    public void setSelectNumber(Integer selectNumber) {
        this.selectNumber = selectNumber;
    }

    public String getCodes() {
        return codes;
    }

    public void setCodes(String codes) {
        this.codes = codes == null ? null : codes.trim();
    }
}