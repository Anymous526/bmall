package com.amall.core.bean;

import java.io.Serializable;

public class Goods2Photo implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
    private Long goodsId;

    private Long photoId;

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(Long photoId) {
        this.photoId = photoId;
    }
}