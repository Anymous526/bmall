package com.amall.core.bean;

import java.io.Serializable;

public class GoodsModuleFloorNext implements Serializable{
	private static final long serialVersionUID = 1L;
    private Integer id;

    private Boolean deletestatus;

    private Integer floorid;

    private Integer areaid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Integer getFloorid() {
        return floorid;
    }

    public void setFloorid(Integer floorid) {
        this.floorid = floorid;
    }

    public Integer getAreaid() {
        return areaid;
    }

    public void setAreaid(Integer areaid) {
        this.areaid = areaid;
    }
}