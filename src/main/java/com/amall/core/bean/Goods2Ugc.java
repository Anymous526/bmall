package com.amall.core.bean;

import java.io.Serializable;

public class Goods2Ugc implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
    private Long goodsId;

    private Long classId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getClassId() {
        return classId;
    }

    public void setClassId(Long classId) {
        this.classId = classId;
    }
}