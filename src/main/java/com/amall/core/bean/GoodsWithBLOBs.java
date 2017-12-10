package com.amall.core.bean;



public class GoodsWithBLOBs extends Goods {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String goodsDetails;		//商品描述

    private String goodsInventoryDetail;	//商品详细规格 属性      如   短 红    短绿     长红   长绿

    private String goodsProperty;    //商品类型规格属性  json字符串   

    private String seoDescription;

    private String ztcAdminContent;

    public String getGoodsDetails() {
        return goodsDetails;
    }

    public void setGoodsDetails(String goodsDetails) {
        this.goodsDetails = goodsDetails == null ? null : goodsDetails.trim();
    }

    public String getGoodsInventoryDetail() {
        return goodsInventoryDetail;
    }

    public void setGoodsInventoryDetail(String goodsInventoryDetail) {
        this.goodsInventoryDetail = goodsInventoryDetail == null ? null : goodsInventoryDetail.trim();
    }

    public String getGoodsProperty() {
        return goodsProperty;
    }

    public void setGoodsProperty(String goodsProperty) {
        this.goodsProperty = goodsProperty == null ? null : goodsProperty.trim();
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getZtcAdminContent() {
        return ztcAdminContent;
    }

    public void setZtcAdminContent(String ztcAdminContent) {
        this.ztcAdminContent = ztcAdminContent == null ? null : ztcAdminContent.trim();
    }   
    
    
    
    private String aftermarket;		//售后保障内容

	public String getAftermarket() {
		return aftermarket;
	}

	public void setAftermarket(String aftermarket) {
		this.aftermarket = aftermarket;
	}
    
}