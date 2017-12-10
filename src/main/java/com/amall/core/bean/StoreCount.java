package com.amall.core.bean;

import java.util.Date;
/**
 * 
 * <p>Title: StoreCount</p>
 * <p>Description: 店铺每周销售和访问量统计实体类</p>
 * @author	ygq
 * @date	2016年3月17日下午14:19:21
 * @version 1.0
 */
public class StoreCount {
    private Long id;

    private Date addtime;

    private Integer lastWeekSale; //上周销量

    private Integer thisWeekSale; //这周销量

    private Integer lastWeekVisit; //上周访问量

    private Integer thisWeekVisit; //这周访问量

    private Date storeTime; //店铺统计时间

    private Long storeId; //店铺id

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

    public Integer getLastWeekSale() {
        return lastWeekSale;
    }

    public void setLastWeekSale(Integer lastWeekSale) {
        this.lastWeekSale = lastWeekSale;
    }

    public Integer getThisWeekSale() {
        return thisWeekSale;
    }

    public void setThisWeekSale(Integer thisWeekSale) {
        this.thisWeekSale = thisWeekSale;
    }

    public Integer getLastWeekVisit() {
        return lastWeekVisit;
    }

    public void setLastWeekVisit(Integer lastWeekVisit) {
        this.lastWeekVisit = lastWeekVisit;
    }

    public Integer getThisWeekVisit() {
        return thisWeekVisit;
    }

    public void setThisWeekVisit(Integer thisWeekVisit) {
        this.thisWeekVisit = thisWeekVisit;
    }

    public Date getStoreTime() {
        return storeTime;
    }

    public void setStoreTime(Date storeTime) {
        this.storeTime = storeTime;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}