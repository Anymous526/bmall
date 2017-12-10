package com.amall.core.bean;

import java.io.Serializable;



public class StoreWithBLOBs extends Store implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String storeInfo;				//店铺信息

    private String storeSeoDescription;		//店铺搜索描述

    private String storeSeoKeywords;		//店铺搜索关键字

    private String violationReseaon;		//违规原因
    
    private String refuseReason;			//拒绝原因

	private String weixinWelecomeContent;
    

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }

    public String getStoreSeoDescription() {
        return storeSeoDescription;
    }

    public void setStoreSeoDescription(String storeSeoDescription) {
        this.storeSeoDescription = storeSeoDescription == null ? null : storeSeoDescription.trim();
    }

    public String getStoreSeoKeywords() {
        return storeSeoKeywords;
    }

    public void setStoreSeoKeywords(String storeSeoKeywords) {
        this.storeSeoKeywords = storeSeoKeywords == null ? null : storeSeoKeywords.trim();
    }

    public String getViolationReseaon() {
        return violationReseaon;
    }

    public void setViolationReseaon(String violationReseaon) {
        this.violationReseaon = violationReseaon == null ? null : violationReseaon.trim();
    }
    
    public String getRefuseReason() {
		return refuseReason;
	}

	public void setRefuseReason(String refuseReason) {
		this.refuseReason = refuseReason == null ? null : refuseReason.trim();
	}
    
    public String getWeixinWelecomeContent() {
        return weixinWelecomeContent;
    }

    public void setWeixinWelecomeContent(String weixinWelecomeContent) {
        this.weixinWelecomeContent = weixinWelecomeContent == null ? null : weixinWelecomeContent.trim();
    }

	@Override
	public String toString() {
		return "StoreWithBLOBs [storeInfo=" + storeInfo + ", storeSeoDescription=" + storeSeoDescription
				+ ", storeSeoKeywords=" + storeSeoKeywords + ", violationReseaon=" + violationReseaon
				+ ", refuseReason=" + refuseReason + ", weixinWelecomeContent=" + weixinWelecomeContent + "]";
	}

    
}