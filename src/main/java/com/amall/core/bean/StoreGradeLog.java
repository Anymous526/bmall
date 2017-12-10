package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: StoreGradeLog</p>
 * <p>Description: 店铺审核日志</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午4:19:39
 * @version 1.0
 */

public class StoreGradeLog implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean logEdit;

    private String storeGradeInfo;		//审核信息

    private Integer storeGradeStatus;	//审核状态

    private Long storeId;

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

    public Boolean getLogEdit() {
        return logEdit;
    }

    public void setLogEdit(Boolean logEdit) {
        this.logEdit = logEdit;
    }

    public String getStoreGradeInfo() {
        return storeGradeInfo;
    }

    public void setStoreGradeInfo(String storeGradeInfo) {
        this.storeGradeInfo = storeGradeInfo == null ? null : storeGradeInfo.trim();
    }

    public Integer getStoreGradeStatus() {
        return storeGradeStatus;
    }

    public void setStoreGradeStatus(Integer storeGradeStatus) {
        this.storeGradeStatus = storeGradeStatus;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
    
    
    
    private StoreWithBLOBs store;

	public StoreWithBLOBs getStore() {
		return store;
	}

	public void setStore(StoreWithBLOBs store) {
		this.store = store;
		this.storeId = store.getId();
	}
    
}