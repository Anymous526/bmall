package com.amall.core.bean;

import java.util.Date;

import com.amall.core.web.BaseQuery;

/**
 * 
 * <p>Title: GoodsSpecProperty</p>
 * <p>Description: 商品规格属性信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月3日下午7:41:51
 * @version 1.0
 */

public class GoodsSpecProperty extends BaseQuery{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer sequence;

    private String value;

    private Long specId;

    private Long specimageId;

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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Long getSpecimageId() {
        return specimageId;
    }

    public void setSpecimageId(Long specimageId) {
        this.specimageId = specimageId;
    }
    
    
    private GoodsSpecification spec;
    private Accessory specImage;
    
	public GoodsSpecification getSpec() {
		return spec;
	}

	public void setSpec(GoodsSpecification spec) {
		this.spec = spec;
		if(spec != null)
			this.specId = spec.getId();
	}

	public Accessory getSpecImage() {
		return specImage;
	}

	public void setSpecImage(Accessory specImage) {
		this.specImage = specImage;
		if(specImage !=null)
			this.specimageId = specImage.getId();
	}
    
	
}