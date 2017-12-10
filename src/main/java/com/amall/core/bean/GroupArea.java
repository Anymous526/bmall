package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupArea implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer gaLevel;

    private String gaName;

    private Integer gaSequence;

    private Long parentId;

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

    public Integer getGaLevel() {
        return gaLevel;
    }

    public void setGaLevel(Integer gaLevel) {
        this.gaLevel = gaLevel;
    }

    public String getGaName() {
        return gaName;
    }

    public void setGaName(String gaName) {
        this.gaName = gaName == null ? null : gaName.trim();
    }

    public Integer getGaSequence() {
        return gaSequence;
    }

    public void setGaSequence(Integer gaSequence) {
        this.gaSequence = gaSequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    
    private List<GroupArea> childs=new ArrayList<GroupArea>();
    private GroupArea parent;

	public List<GroupArea> getChilds() {
		return childs;
	}

	public void setChilds(List<GroupArea> childs) {
		this.childs = childs;
	}

	public GroupArea getParent() {
		return parent;
	}

	public void setParent(GroupArea parent) {
		this.parent = parent;
		this.parentId = parent.getId();
	}
    
    
}