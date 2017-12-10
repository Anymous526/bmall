package com.amall.core.bean;


public class EvaluateWithBLOBs extends Evaluate {
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private String evaluateAdminInfo;  //管理员操作说明

    private String evaluateInfo;	//买家评价信息

    private String evaluateSellerInfo;	//卖家评价信息

    private String goodsSpec;

    public String getEvaluateAdminInfo() {
        return evaluateAdminInfo;
    }

    public void setEvaluateAdminInfo(String evaluateAdminInfo) {
        this.evaluateAdminInfo = evaluateAdminInfo == null ? null : evaluateAdminInfo.trim();
    }

    public String getEvaluateInfo() {
        return evaluateInfo;
    }

    public void setEvaluateInfo(String evaluateInfo) {
        this.evaluateInfo = evaluateInfo == null ? null : evaluateInfo.trim();
    }

    public String getEvaluateSellerInfo() {
        return evaluateSellerInfo;
    }

    public void setEvaluateSellerInfo(String evaluateSellerInfo) {
        this.evaluateSellerInfo = evaluateSellerInfo == null ? null : evaluateSellerInfo.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }
}