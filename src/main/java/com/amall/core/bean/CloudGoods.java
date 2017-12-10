package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author tangxiang
 *
 */
public class CloudGoods implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    /**
     * 兑购开始时间
     */
    private Date beginTime;

    /**
     * 点击次数
     */
    private Integer clickCount;

    /**
     * 商品描述
     */
    private String igContent;

    /**
     * 兑购结束时间
     */
    private Date endTime;

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
     * 商品流水号
     */
    private String goodsSn;

    /**
     * 商品标签
     */
    private String goodsTag;

    /**
     * 是否上架
     */
    private Boolean isShow;

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
     * 是否流拍
     */
    private Boolean isPassed;

    /**
     * 中奖用户id
     */
    private Long userId;

    /**
     * 揭奖时间
     */
    private Date openWinnerTime;
    
    /**
     * 购买数量限制
     */
    private Integer exchangeLimit;
    
    /**
     * 购买云码数量
     */
    private Integer buyerCodeCount;
    
    /**
     * 开奖码
     */
    private Integer openWinnerCode;
    
    
    /**
     * 中奖人购买的份数  临时变量
     */
    private Integer WinnerBuyCodes;
    
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

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Integer getOpenWinnerCode()
	{
		return openWinnerCode;
	}

	public void setOpenWinnerCode(Integer openWinnerCode)
	{
		this.openWinnerCode = openWinnerCode;
	}

	public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public String getIgContent() {
        return igContent;
    }

    public void setIgContent(String igContent) {
        this.igContent = igContent == null ? null : igContent.trim();
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public Integer getExchangeLimit()
	{
		return exchangeLimit;
	}

	public void setExchangeLimit(Integer exchangeLimit)
	{
		this.exchangeLimit = exchangeLimit;
	}

	public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getGoodsTag() {
        return goodsTag;
    }

    public void setGoodsTag(String goodsTag) {
        this.goodsTag = goodsTag == null ? null : goodsTag.trim();
    }

    public Integer getBuyerCodeCount()
	{
		return buyerCodeCount;
	}

	public void setBuyerCodeCount(Integer buyerCodeCount)
	{
		this.buyerCodeCount = buyerCodeCount;
	}

	public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
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

    public Boolean getIsPassed() {
        return isPassed;
    }

    public void setIsPassed(Boolean isPassed) {
        this.isPassed = isPassed;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOpenWinnerTime() {
        return openWinnerTime;
    }

    public void setOpenWinnerTime(Date openWinnerTime) {
        this.openWinnerTime = openWinnerTime;
    }
    
    private User user;
    
    private Accessory accessory;
    
    private GoodsClassWithBLOBs gc;

	public Accessory getAccessory()
	{
		return accessory;
	}

	public void setAccessory(Accessory accessory)
	{
		this.accessory = accessory;
	}

	public GoodsClassWithBLOBs getGc()
	{
		return gc;
	}

	public void setGc(GoodsClassWithBLOBs gc)
	{
		this.gc = gc;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public Integer getWinnerBuyCodes()
	{
		return WinnerBuyCodes;
	}

	public void setWinnerBuyCodes(Integer winnerBuyCodes)
	{
		WinnerBuyCodes = winnerBuyCodes;
	}
    
}