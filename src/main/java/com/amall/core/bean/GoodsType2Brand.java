package com.amall.core.bean;

import java.io.Serializable;

public class GoodsType2Brand implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
    private Long typeId;

    private Long brandId;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }
}