package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class StoreStat implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer allGoods;	//所有商品数量

    private Integer allStore;	//所有店铺数量

    private Integer allUser;	//所有用户数量

    private Date nextTime;

    private BigDecimal orderAmount;	//订单数量

    private Integer storeUpdate;

    private Integer weekComplaint;

    private Integer weekGoods;

    private Integer weekOrder;

    private Integer weekReport;

    private Integer weekStore;

    private Integer weekUser;

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

    public Integer getAllGoods() {
        return allGoods;
    }

    public void setAllGoods(Integer allGoods) {
        this.allGoods = allGoods;
    }

    public Integer getAllStore() {
        return allStore;
    }

    public void setAllStore(Integer allStore) {
        this.allStore = allStore;
    }

    public Integer getAllUser() {
        return allUser;
    }

    public void setAllUser(Integer allUser) {
        this.allUser = allUser;
    }

    public Date getNextTime() {
        return nextTime;
    }

    public void setNextTime(Date nextTime) {
        this.nextTime = nextTime;
    }

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Integer getStoreUpdate() {
        return storeUpdate;
    }

    public void setStoreUpdate(Integer storeUpdate) {
        this.storeUpdate = storeUpdate;
    }

    public Integer getWeekComplaint() {
        return weekComplaint;
    }

    public void setWeekComplaint(Integer weekComplaint) {
        this.weekComplaint = weekComplaint;
    }

    public Integer getWeekGoods() {
        return weekGoods;
    }

    public void setWeekGoods(Integer weekGoods) {
        this.weekGoods = weekGoods;
    }

    public Integer getWeekOrder() {
        return weekOrder;
    }

    public void setWeekOrder(Integer weekOrder) {
        this.weekOrder = weekOrder;
    }

    public Integer getWeekReport() {
        return weekReport;
    }

    public void setWeekReport(Integer weekReport) {
        this.weekReport = weekReport;
    }

    public Integer getWeekStore() {
        return weekStore;
    }

    public void setWeekStore(Integer weekStore) {
        this.weekStore = weekStore;
    }

    public Integer getWeekUser() {
        return weekUser;
    }

    public void setWeekUser(Integer weekUser) {
        this.weekUser = weekUser;
    }
}