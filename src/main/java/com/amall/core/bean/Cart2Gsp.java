package com.amall.core.bean;

import java.io.Serializable;

public class Cart2Gsp implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long cartId;

    private Long gspId;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getGspId() {
        return gspId;
    }

    public void setGspId(Long gspId) {
        this.gspId = gspId;
    }
}