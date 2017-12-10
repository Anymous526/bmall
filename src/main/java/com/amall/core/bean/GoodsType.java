package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsType implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String name;

    private Integer sequence;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
    
    
    
    
    private List<GoodsTypeProperty> properties = new ArrayList<GoodsTypeProperty>();
    private List<GoodsClassWithBLOBs> gcs = new ArrayList<GoodsClassWithBLOBs>();
    private List<GoodsBrand> gbs = new ArrayList<GoodsBrand>();
    private List<GoodsSpecification> gss = new ArrayList<GoodsSpecification>();

	public List<GoodsTypeProperty> getProperties() {
		return properties;
	}

	public void setProperties(List<GoodsTypeProperty> properties) {
		this.properties = properties;
	}

	public List<GoodsClassWithBLOBs> getGcs() {
		return gcs;
	}

	public void setGcs(List<GoodsClassWithBLOBs> gcs) {
		this.gcs = gcs;
	}

	public List<GoodsBrand> getGbs() {
		return gbs;
	}

	public void setGbs(List<GoodsBrand> gbs) {
		this.gbs = gbs;
	}

	public List<GoodsSpecification> getGss() {
		return gss;
	}

	public void setGss(List<GoodsSpecification> gss) {
		this.gss = gss;
	}
    
}