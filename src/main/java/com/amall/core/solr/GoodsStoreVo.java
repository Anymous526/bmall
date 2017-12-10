package com.amall.core.solr;

import java.io.Serializable;

/**
 * 店铺
 * 
 * @ClassName: GoodsStoreVo
 * @Description: TODO
 * @author lx
 * @date 2016年1月8日 下午4:54:58
 *
 */
public class GoodsStoreVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private String goodsStoreDeletestatus;
	private String storeAddress;
	private String storeCredit;
	private String storeName;
	private String storeOwer;
	private String storeStatus;
	private String storeTelephone;
	private String template;
	private String validity;
	private Integer areaId;
	private Integer cardId;
	private Integer gradeId;
	private Integer storeLogoId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGoodsStoreDeletestatus() {
		return goodsStoreDeletestatus;
	}

	public void setGoodsStoreDeletestatus(String goodsStoreDeletestatus) {
		this.goodsStoreDeletestatus = goodsStoreDeletestatus;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public String getStoreCredit() {
		return storeCredit;
	}

	public void setStoreCredit(String storeCredit) {
		this.storeCredit = storeCredit;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreOwer() {
		return storeOwer;
	}

	public void setStoreOwer(String storeOwer) {
		this.storeOwer = storeOwer;
	}

	public String getStoreStatus() {
		return storeStatus;
	}

	public void setStoreStatus(String storeStatus) {
		this.storeStatus = storeStatus;
	}

	public String getStoreTelephone() {
		return storeTelephone;
	}

	public void setStoreTelephone(String storeTelephone) {
		this.storeTelephone = storeTelephone;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getCardId() {
		return cardId;
	}

	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}

	public Integer getGradeId() {
		return gradeId;
	}

	public void setGradeId(Integer gradeId) {
		this.gradeId = gradeId;
	}

	public Integer getStoreLogoId() {
		return storeLogoId;
	}

	public void setStoreLogoId(Integer storeLogoId) {
		this.storeLogoId = storeLogoId;
	}

}
