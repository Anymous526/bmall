package com.amall.core.bean;

public class GoodsClassWithBLOBs extends GoodsClass {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String seoDescription;	//商品搜索描述

    private String seoKeywords;		//商品搜索关键字

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }
}