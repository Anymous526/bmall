package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GroupClass implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer gcLevel;

    private String gcName;

    private Integer gcSequence;

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

    public Integer getGcLevel() {
        return gcLevel;
    }

    public void setGcLevel(Integer gcLevel) {
        this.gcLevel = gcLevel;
    }

    public String getGcName() {
        return gcName;
    }

    public void setGcName(String gcName) {
        this.gcName = gcName == null ? null : gcName.trim();
    }

    public Integer getGcSequence() {
        return gcSequence;
    }

    public void setGcSequence(Integer gcSequence) {
        this.gcSequence = gcSequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    private GroupClass parent;
    private List<GroupClass> childs = new ArrayList<GroupClass>();
    private List<GroupGoods> ggs = new ArrayList<GroupGoods>();

	public GroupClass getParent() {
		return parent;
	}

	public void setParent(GroupClass parent) {
		this.parent = parent;
		this.parentId = parent.getId();
	}

	public List<GroupClass> getChilds() {
		return childs;
	}

	public void setChilds(List<GroupClass> childs) {
		this.childs = childs;
	}

	public List<GroupGoods> getGgs() {
		return ggs;
	}

	public void setGgs(List<GroupGoods> ggs) {
		this.ggs = ggs;
	}
    
}