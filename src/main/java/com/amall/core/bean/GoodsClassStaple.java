package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: GoodsClassStaple</p>
 * <p>Description: 用户常用商品分类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月22日下午6:37:57
 * @version 1.0
 */
public class GoodsClassStaple implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String name;

    private Long gcId;		//商品类型外键id

    private Long storeId;	//店铺外键 id

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

    public Long getGcId() {
        return gcId;
    }

    public void setGcId(Long gcId) {
        this.gcId = gcId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    
    
    private Store store;
    private GoodsClassWithBLOBs gc;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		this.storeId = store.getId();
	}

	public GoodsClassWithBLOBs getGc() {
		return gc;
	}

	public void setGc(GoodsClassWithBLOBs gc) {
		this.gc = gc;
		this.gcId = gc.getId();
	}
    
}