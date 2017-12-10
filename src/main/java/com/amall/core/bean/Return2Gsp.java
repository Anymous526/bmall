package com.amall.core.bean;

import java.io.Serializable;

public class Return2Gsp implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
    private Long itemId;

    private Long gspId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGspId() {
        return gspId;
    }

    public void setGspId(Long gspId) {
        this.gspId = gspId;
    }
}