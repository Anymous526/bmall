package com.amall.core.solr;

import java.io.Serializable;

/**
 * 商品
 * 
 * @ClassName: SearchGoodsVo
 * @Description: TODO
 * @author lx
 * @date 2016年1月7日 下午3:23:10
 *
 */
public class GoodsVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long goodsPKId;
	private String goodsDeletestatus;
	private Double goodsFee;
	private Integer goodsInventory;
	private String goodsName;
	private Double goodsPrice;
	private Integer goodsSalenum;
	private String goodsSerial;
	private Integer goodsStatus;
	private Double goodsTransfee;
	private String seoKeywords;
	private Double storePrice;
	private Long gcId;
	private Long goodsBrandId;
	private Long goodsMainPhotoId;
	private Long goodsStoreId;
	private Integer bargainStatus;
	private Double goodsCurrentPrice;
	private String goodsInfo;
	private Long storeNavId;
	
	private String deliveryStatus;
	private String activityStatus;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsPKId() {
		return goodsPKId;
	}

	public void setGoodsPKId(Long goodsPKId) {
		this.goodsPKId = goodsPKId;
	}

	public String getGoodsDeletestatus() {
		return goodsDeletestatus;
	}

	public void setGoodsDeletestatus(String goodsDeletestatus) {
		this.goodsDeletestatus = goodsDeletestatus;
	}

	public Double getGoodsFee() {
		return goodsFee;
	}

	public void setGoodsFee(Double goodsFee) {
		this.goodsFee = goodsFee;
	}

	public Integer getGoodsInventory() {
		return goodsInventory;
	}

	public void setGoodsInventory(Integer goodsInventory) {
		this.goodsInventory = goodsInventory;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Double getGoodsPrice() {
		return goodsPrice;
	}

	public void setGoodsPrice(Double goodsPrice) {
		this.goodsPrice = goodsPrice;
	}

	public Integer getGoodsSalenum() {
		return goodsSalenum;
	}

	public void setGoodsSalenum(Integer goodsSalenum) {
		this.goodsSalenum = goodsSalenum;
	}

	public String getGoodsSerial() {
		return goodsSerial;
	}

	public void setGoodsSerial(String goodsSerial) {
		this.goodsSerial = goodsSerial;
	}

	public Integer getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(Integer goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public Double getGoodsTransfee() {
		return goodsTransfee;
	}

	public void setGoodsTransfee(Double goodsTransfee) {
		this.goodsTransfee = goodsTransfee;
	}

	public String getSeoKeywords() {
		return seoKeywords;
	}

	public void setSeoKeywords(String seoKeywords) {
		this.seoKeywords = seoKeywords;
	}

	public Double getStorePrice() {
		return storePrice;
	}

	public void setStorePrice(Double storePrice) {
		this.storePrice = storePrice;
	}

	public Long getGcId() {
		return gcId;
	}

	public void setGcId(Long gcId) {
		this.gcId = gcId;
	}

	public Long getGoodsBrandId() {
		return goodsBrandId;
	}

	public void setGoodsBrandId(Long goodsBrandId) {
		this.goodsBrandId = goodsBrandId;
	}

	public Long getGoodsMainPhotoId() {
		return goodsMainPhotoId;
	}

	public void setGoodsMainPhotoId(Long goodsMainPhotoId) {
		this.goodsMainPhotoId = goodsMainPhotoId;
	}

	public Long getGoodsStoreId() {
		return goodsStoreId;
	}

	public void setGoodsStoreId(Long goodsStoreId) {
		this.goodsStoreId = goodsStoreId;
	}

	public Integer getBargainStatus() {
		return bargainStatus;
	}

	public void setBargainStatus(Integer bargainStatus) {
		this.bargainStatus = bargainStatus;
	}

	public Double getGoodsCurrentPrice() {
		return goodsCurrentPrice;
	}

	public void setGoodsCurrentPrice(Double goodsCurrentPrice) {
		this.goodsCurrentPrice = goodsCurrentPrice;
	}

	public String getGoodsInfo() {
		return goodsInfo;
	}

	public void setGoodsInfo(String goodsInfo) {
		this.goodsInfo = goodsInfo;
	}

	public Long getStoreNavId() {
		return storeNavId;
	}

	public void setStoreNavId(Long storeNavId) {
		this.storeNavId = storeNavId;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}

}
