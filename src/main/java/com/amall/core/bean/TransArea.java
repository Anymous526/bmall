package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: TransArea</p>
 * <p>Description: 运费地区</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月2日上午11:06:00
 * @version 1.0
 */
public class TransArea implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String areaname;	//区域名称

    private Integer level;		//等级

    private Integer sequence;	//序号

    private Long parentId;		//父级id

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
    
    
    private TransArea parent;
    private List<TransArea> childs = new ArrayList<TransArea>();

	public TransArea getParent() {
		return parent;
	}

	public void setParent(TransArea parent) {
		this.parent = parent;
		if(parent!=null)
			this.parentId = parent.getId();
	}

	public List<TransArea> getChilds() {
		return childs;
	}

	public void setChilds(List<TransArea> childs) {
		this.childs = childs;
	}
    
}