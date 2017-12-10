package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 买就送
 * @author ljx
 *
 */
public class DeliveryGoods implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer dStatus;   //状态

    private Long dAdminUserId;   

    private Long dDeliveryGoodsId;   //买就送 商品id

    private Long dGoodsId;		//商品id

    private Date dBeginTime; //开始时间

    private Date dEndTime;		//结束时间

    private Date dAuditTime;  

    private Date dRefuseTime;

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

    public Integer getdStatus() {
        return dStatus;
    }

    public void setdStatus(Integer dStatus) {
        this.dStatus = dStatus;
    }

    public Long getdAdminUserId() {
        return dAdminUserId;
    }

    public void setdAdminUserId(Long dAdminUserId) {
        this.dAdminUserId = dAdminUserId;
    }

    public Long getdDeliveryGoodsId() {
        return dDeliveryGoodsId;
    }

    public void setdDeliveryGoodsId(Long dDeliveryGoodsId) {
        this.dDeliveryGoodsId = dDeliveryGoodsId;
    }

    public Long getdGoodsId() {
        return dGoodsId;
    }

    public void setdGoodsId(Long dGoodsId) {
        this.dGoodsId = dGoodsId;
    }

    public Date getdBeginTime() {
        return dBeginTime;
    }

    public void setdBeginTime(Date dBeginTime) {
        this.dBeginTime = dBeginTime;
    }

    public Date getdEndTime() {
        return dEndTime;
    }

    public void setdEndTime(Date dEndTime) {
        this.dEndTime = dEndTime;
    }

    public Date getdAuditTime() {
        return dAuditTime;
    }

    public void setdAuditTime(Date dAuditTime) {
        this.dAuditTime = dAuditTime;
    }

    public Date getdRefuseTime() {
        return dRefuseTime;
    }

    public void setdRefuseTime(Date dRefuseTime) {
        this.dRefuseTime = dRefuseTime;
    }
    
    
    private GoodsWithBLOBs dDeliveryGoods;
    private GoodsWithBLOBs dGoods;
    private User dAdminUser;

	public GoodsWithBLOBs getdDeliveryGoods() {
		return dDeliveryGoods;
	}

	public void setdDeliveryGoods(GoodsWithBLOBs dDeliveryGoods) {
		this.dDeliveryGoods = dDeliveryGoods;
	}

	public GoodsWithBLOBs getdGoods() {
		return dGoods;
	}

	public void setdGoods(GoodsWithBLOBs dGoods) {
		this.dGoods = dGoods;
	}

	public User getdAdminUser() {
		return dAdminUser;
	}

	public void setdAdminUser(User dAdminUser) {
		this.dAdminUser = dAdminUser;
	}
    
    
}