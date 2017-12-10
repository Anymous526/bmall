package com.amall.core.bean;

public class CloudStatisticsAuto {
    private Long id;

    private Long cloudGoodsId;

    private Long cloudGoodsAutoId;

    private Boolean isOpen;

    private Boolean isPass;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCloudGoodsId() {
        return cloudGoodsId;
    }

    public void setCloudGoodsId(Long cloudGoodsId) {
        this.cloudGoodsId = cloudGoodsId;
    }

    public Long getCloudGoodsAutoId() {
        return cloudGoodsAutoId;
    }

    public void setCloudGoodsAutoId(Long cloudGoodsAutoId) {
        this.cloudGoodsAutoId = cloudGoodsAutoId;
    }

    public Boolean getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Boolean isOpen) {
        this.isOpen = isOpen;
    }

    public Boolean getIsPass() {
        return isPass;
    }

    public void setIsPass(Boolean isPass) {
        this.isPass = isPass;
    }
}