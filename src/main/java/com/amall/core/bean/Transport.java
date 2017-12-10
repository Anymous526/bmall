package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>Title: Transport</p>
 * <p>Description: 快递模板相关信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月29日上午11:06:19
 * @version 1.0
 */

public class Transport implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean transEms;		//EMS

    private Boolean transExpress;	//快递

    private Boolean transMail;		//平邮

    private String transName;		//模板名称

    private Long storeId;

    private Integer transTime;	//发货时间

    private Integer transType;		//计价方式  0按件数   1 按重量  2 按体积

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

    public Boolean getTransEms() {
        return transEms;
    }

    public void setTransEms(Boolean transEms) {
        this.transEms = transEms;
    }

    public Boolean getTransExpress() {
        return transExpress;
    }

    public void setTransExpress(Boolean transExpress) {
        this.transExpress = transExpress;
    }

    public Boolean getTransMail() {
        return transMail;
    }

    public void setTransMail(Boolean transMail) {
        this.transMail = transMail;
    }

    public String getTransName() {
        return transName;
    }

    public void setTransName(String transName) {
        this.transName = transName == null ? null : transName.trim();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getTransTime() {
        return transTime;
    }

    public void setTransTime(Integer transTime) {
        this.transTime = transTime;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }
    
    
    
    private Store store;

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		if(store !=null )
			this.storeId = store.getId();
	}
    
    
}