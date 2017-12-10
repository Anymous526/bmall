package com.amall.core.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * <p>Title: GoodsSpecification</p>
 * <p>Description: 商品所属模块楼层</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ygq
 * @date	2016年2月25日下午1:55:59
 * @version 1.0
 */
public class GoodsModuleFloor implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Integer id;

    private Boolean deletestatus;
    
    private Integer sequence;

    private String floorname;

    private Integer moduleId;

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getFloorname() {
        return floorname;
    }

    public void setFloorname(String floorname) {
        this.floorname = floorname == null ? null : floorname.trim();
    }

    public Integer getModuleId() {
        return moduleId;
    }

    public void setModuleId(Integer moduleId) {
        this.moduleId = moduleId;
    }
    
    private List<GoodsWithBLOBs> goodsList;
    private List<Area> areas;

	public List<GoodsWithBLOBs> getGoodsList() {
		return goodsList;
	}

	public void setGoodsList(List<GoodsWithBLOBs> goodsList) {
		this.goodsList = goodsList;
	}

	public List<Area> getAreas() {
		return areas;
	}

	public void setAreas(List<Area> areas) {
		this.areas = areas;
	}
	
    
}
