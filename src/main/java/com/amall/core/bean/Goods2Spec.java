package com.amall.core.bean;

import java.io.Serializable;

public class Goods2Spec implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
    private Long goodsId;

    private Long specId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
}