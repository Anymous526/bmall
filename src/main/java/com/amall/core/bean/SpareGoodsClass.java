package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SpareGoodsClass implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;

    private Integer level;

    private Integer sequence;

    private Long parentId;

    private Boolean viewinfloor;
    
    private Long floorId;//插进来的，外键表示SpareGoodsFloor的Id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getViewinfloor() {
        return viewinfloor;
    }

    public void setViewinfloor(Boolean viewinfloor) {
        this.viewinfloor = viewinfloor;
    }
    
    
    public Long getFloorId() {
		return floorId;
	}

	public void setFloorId(Long floorId) {
		this.floorId = floorId;
	}






	private SpareGoodsFloor floor;
    private SpareGoodsClass parent;
    private List<SpareGoodsWithBLOBs> sgs = new ArrayList<SpareGoodsWithBLOBs>();
    private List<SpareGoodsClass> childs=new ArrayList <SpareGoodsClass>();
	public SpareGoodsFloor getFloor() {
		return floor;
	}

	public void setFloor(SpareGoodsFloor floor) {
		this.floor = floor;
	}

	public SpareGoodsClass getParent() {
		return parent;
	}

	public void setParent(SpareGoodsClass parent) {
		this.parent = parent;
	}

	public List<SpareGoodsWithBLOBs> getSgs() {
		return sgs;
	}

	public void setSgs(List<SpareGoodsWithBLOBs> sgs) {
		this.sgs = sgs;
	}

	public List<SpareGoodsClass> getChilds() {
		return childs;
	}

	public void setChilds(List<SpareGoodsClass> childs) {
		this.childs = childs;
	}
    
    
}