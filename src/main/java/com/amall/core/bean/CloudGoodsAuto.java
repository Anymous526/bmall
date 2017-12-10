package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;

public class CloudGoodsAuto {
    private Long id;

    private Date addtime;
    
    /**
     * 商品描述
     */
    private String igContent;
    /**
     * 兑购码数量
     */
    private Integer goodsCount;
    /**
     * 商品单价
     */
    private Integer goodsNumber;
    /**
     * 商品名称
     */
    private String goodsName;
    /**
     * 商品rmb原价
     */
    private BigDecimal goodsPrice;
    /**
     * 商品标签
     */
    private String goodsTag;
    /**
     * 商品图片id
     */
    private Long goodsImgId;
    /**
     * 商品类型id
     */
    private Long goodsClassId;
    /**
     * 商品包装清单
     */
    private String goodsPackList;
    /**
     * 购买数量限制
     */
    private Integer exchangeLimit;
    /**
     * 兑购商品id
     */
    private Long cloudGoodsId;
    /**
     * 兑购间隔时间
     */
    private Integer timeInterval;
    /**
     * 是否启用自动发布
     */
    private Boolean isEnable;
    /**
     * 开奖商品数量
     */
    private Integer openGoodsNumber;
    /**
     * 剩余商品数量
     */
    private Integer remainGoodsNumber;
    /**
     * 流拍商品数量
     */
    private Integer passGoodsNumber;

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

    public String getIgContent() {
        return igContent;
    }

    public void setIgContent(String igContent) {
        this.igContent = igContent == null ? null : igContent.trim();
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsNumber() {
        return goodsNumber;
    }

    public void setGoodsNumber(Integer goodsNumber) {
        this.goodsNumber = goodsNumber;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag == null ? null : goodsTag.trim();
    }

    public Long getGoodsImgId() {
        return goodsImgId;
    }

    public void setGoodsImgId(Long goodsImgId) {
        this.goodsImgId = goodsImgId;
    }

    public Long getGoodsClassId() {
        return goodsClassId;
    }

    public void setGoodsClassId(Long goodsClassId) {
        this.goodsClassId = goodsClassId;
    }

    public String getGoodsPackList() {
        return goodsPackList;
    }

    public void setGoodsPackList(String goodsPackList) {
        this.goodsPackList = goodsPackList == null ? null : goodsPackList.trim();
    }

    public Integer getExchangeLimit() {
        return exchangeLimit;
    }

    public void setExchangeLimit(Integer exchangeLimit) {
        this.exchangeLimit = exchangeLimit;
    }

    public Long getCloudGoodsId() {
        return cloudGoodsId;
    }

    public void setCloudGoodsId(Long cloudGoodsId) {
        this.cloudGoodsId = cloudGoodsId;
    }

    public Integer getTimeInterval() {
        return timeInterval;
    }

    public void setTimeInterval(Integer timeInterval) {
        this.timeInterval = timeInterval;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }

    public Integer getOpenGoodsNumber() {
        return openGoodsNumber;
    }

    public void setOpenGoodsNumber(Integer openGoodsNumber) {
        this.openGoodsNumber = openGoodsNumber;
    }

    public Integer getRemainGoodsNumber() {
        return remainGoodsNumber;
    }

    public void setRemainGoodsNumber(Integer remainGoodsNumber) {
        this.remainGoodsNumber = remainGoodsNumber;
    }

    public Integer getPassGoodsNumber() {
        return passGoodsNumber;
    }

    public void setPassGoodsNumber(Integer passGoodsNumber) {
        this.passGoodsNumber = passGoodsNumber;
    }
    
    private Accessory accessory;

	public Accessory getAccessory() {
		return accessory;
	}

	public void setAccessory(Accessory accessory) {
		this.accessory = accessory;
	}
    
    
}