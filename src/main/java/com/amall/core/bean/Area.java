package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Area implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String areaname;

	private Integer level;		//级别

	private Integer sequence;	//序号

	private Long parentId;

	private Boolean common;

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

	public String getAreaname() {
		return areaname;
	}

	public void setAreaname(String areaname) {
		this.areaname = areaname == null ? null : areaname.trim();
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

	public Boolean getCommon() {
		return common;
	}

	public void setCommon(Boolean common) {
		this.common = common;
	}

	
	
	private Area parent; // 父级
	private List<Area> childs = new ArrayList<Area>();

	public Area getParent() {
		return parent;
	}

	public void setParent(Area parent) {
		this.parent = parent;
		if(parent !=null)
			this.parentId = parent.getId();
	}

	public List<Area> getChilds() {
		return childs;
	}

	public void setChilds(List<Area> childs) {
		this.childs = childs;
	}

/*	@Override
	public String toString() {
		return "Area [id=" + id + ", areaname=" + areaname + ", level=" + level
				+ ", parentId=" + parentId + ", common=" + common + ", parent="
				+ parent + ", childs=" + childs + "]";
	}*/
	
	
	
	
}