package com.amall.core.bean;

import java.io.Serializable;

public class CloudCodes implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long cloudGoodsId;

    private Integer code;

    public Long getCloudGoodsId() {
        return cloudGoodsId;
    }

    public void setCloudGoodsId(Long cloudGoodsId) {
        this.cloudGoodsId = cloudGoodsId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}