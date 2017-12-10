package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ActivityGoods implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer agStatus;

    private Long actId;

    private Long agAdminId;

    private Long agGoodsId;

    private BigDecimal agPrice;

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

    public Integer getAgStatus() {
        return agStatus;
    }

    public void setAgStatus(Integer agStatus) {
        this.agStatus = agStatus;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public Long getAgAdminId() {
        return agAdminId;
    }

    public void setAgAdminId(Long agAdminId) {
        this.agAdminId = agAdminId;
    }

    public Long getAgGoodsId() {
        return agGoodsId;
    }

    public void setAgGoodsId(Long agGoodsId) {
        this.agGoodsId = agGoodsId;
    }

    public BigDecimal getAgPrice() {
        return agPrice;
    }

    public void setAgPrice(BigDecimal agPrice) {
        this.agPrice = agPrice;
    }
    
    
    
    private User agAdmin;
    private GoodsWithBLOBs agGoods;
    private Activity act;

	public User getAgAdmin() {
		return agAdmin;
	}

	public void setAgAdmin(User agAdmin) {
		this.agAdmin = agAdmin;
		this.agAdminId = agAdmin.getId();
	}


	public GoodsWithBLOBs getAgGoods() {
		return agGoods;
	}

	public void setAgGoods(GoodsWithBLOBs agGoods) {
		this.agGoods = agGoods;
		this.agGoodsId = agGoods.getId();
	}

	public Activity getAct() {
		return act;
	}

	public void setAct(Activity act) {
		this.act = act;
		this.actId = act.getId();
	}
    
}