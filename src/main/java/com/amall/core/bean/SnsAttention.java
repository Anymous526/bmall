package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class SnsAttention implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long fromuserId;

    private Long touserId;

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

    public Long getFromuserId() {
        return fromuserId;
    }

    public void setFromuserId(Long fromuserId) {
        this.fromuserId = fromuserId;
    }

    public Long getTouserId() {
        return touserId;
    }

    public void setTouserId(Long touserId) {
        this.touserId = touserId;
    }
}