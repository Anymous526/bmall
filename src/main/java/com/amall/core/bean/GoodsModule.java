package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * <p>Title: GoodsSpecification</p>
 * <p>Description: 商品所属模块</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ygq
 * @date	2016年2月25日下午1:55:59
 * @version 1.0
 */
public class GoodsModule implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Boolean deletestatus;

    private String modulename;

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

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }
    
    private List<GoodsModuleFloor> floors = new ArrayList<GoodsModuleFloor>();

	public List<GoodsModuleFloor> getFloors() {
		return floors;
	}

	public void setFloors(List<GoodsModuleFloor> floors) {
		this.floors = floors;
	}
    
    
}