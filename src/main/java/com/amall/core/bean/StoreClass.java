package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StoreClass implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private String classname;	//类型名称

	private Integer level;		//等级

	private Integer sequence;	//排序

	private Long parentId;

	private BigDecimal descriptionEvaluate;

	private BigDecimal serviceEvaluate;

	private BigDecimal shipEvaluate;

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

	public BigDecimal getDescriptionEvaluate() {
		return descriptionEvaluate;
	}

	public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
		this.descriptionEvaluate = descriptionEvaluate;
	}

	public BigDecimal getServiceEvaluate() {
		return serviceEvaluate;
	}

	public void setServiceEvaluate(BigDecimal serviceEvaluate) {
		this.serviceEvaluate = serviceEvaluate;
	}

	public BigDecimal getShipEvaluate() {
		return shipEvaluate;
	}

	public void setShipEvaluate(BigDecimal shipEvaluate) {
		this.shipEvaluate = shipEvaluate;
	}

	private StoreClass parent;
	private List<StoreClass> childs = new ArrayList<StoreClass>();


	
	
	
	
	public StoreClass getParent() {
		return parent;
	}

	public void setParent(StoreClass parent) {
		this.parent = parent;
		if(parent != null)
			this.parentId = parent.getId();
	}

	public List<StoreClass> getChilds() {
		return childs;
	}

	public void setChilds(List<StoreClass> childs) {
		this.childs = childs;
	}
	
}