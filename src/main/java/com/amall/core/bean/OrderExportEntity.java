package com.amall.core.bean;

import java.io.Serializable;

/**
 * @author ding
 *
 */
public class OrderExportEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String stroeName;
	
	private String orderId;
	
	private String trueName;
	
	private String addTime;
	
	public String totalPrice;
	
	private int status;
	
	private String goodsName;
	
	private String  info;
	
	private String province;
	
	private String city;
	
	private String area;
	
	private long storeId;
	
	private String beanNum;
	
	private String beanAmout;
	
	private String count;
	
	private String trueNames;//收货人姓名
	
	private String telephones;	//收货人联系方式
	
	

	
	public String getTrueNames() {
		return trueNames;
	}

	public void setTrueNames(String trueNames) {
		this.trueNames = trueNames;
	}

	public String getTelephones() {
		return telephones;
	}

	public void setTelephones(String telephones) {
		this.telephones = telephones;
	}

	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getBeanNum() {
		return beanNum;
	}

	public void setBeanNum(String beanNum) {
		this.beanNum = beanNum;
	}

	public String getBeanAmout() {
		return beanAmout;
	}

	public void setBeanAmout(String beanAmout) {
		this.beanAmout = beanAmout;
	}


	
	
	public String getStroeName() {
		return stroeName;
	}

	public void setStroeName(String stroeName) {
		this.stroeName = stroeName;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTrueName() {
		return trueName;
	}

	public void setTrueName(String trueName) {
		this.trueName = trueName;
	}

	public String getAddTime() {
		return addTime;
	}

	public void setAddTime(String addTime) {
		this.addTime = addTime;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public long getStoreId() {
		return storeId;
	}

	public void setStoreId(long storeId) {
		this.storeId = storeId;
	}

	
	
	
}
