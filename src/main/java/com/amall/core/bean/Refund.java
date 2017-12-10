package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: RefundLog</p>
 * <p>Description: 退款信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月25日下午6:51:59
 * @version 1.0
 */

public class Refund implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;  //状态

    private BigDecimal refund;  //退款金额

    private String refundId;

    private String refundLog;

    private String refundType;	//退款类型
    
    private Long goodsId;

    private Long ofId;  //运单号

    private Long refundUserId;

    private String imgPaths;  // 图片路径
    
    private Integer status;  // 状态（0：拒绝，1：同意）
    
    private BigDecimal factRefund; // 实际退款
    
    private RefundItem refundItem;
    
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

  
   

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId == null ? null : refundId.trim();
    }

    public String getRefundLog() {
        return refundLog;
    }

    public void setRefundLog(String refundLog) {
        this.refundLog = refundLog == null ? null : refundLog.trim();
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType == null ? null : refundType.trim();
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public Long getRefundUserId() {
        return refundUserId;
    }

    public void setRefundUserId(Long refundUserId) {
        this.refundUserId = refundUserId;
    }
    
    
    private User refundUser;
    private RefundItem itemRefundItem;
    private OrderFormWithBLOBs of;
    private List<Accessory> imgs;
    		
	public User getRefundUser() {
		return refundUser;
	}

	public void setRefundUser(User refundUser) {
		this.refundUser = refundUser;
		if(refundUser!=null)
		{
			this.setRefundUserId(refundUser.getId());
		}
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getImgPaths() {
		return imgPaths;
	}

	public void setImgPaths(String imgPaths) {
		this.imgPaths = imgPaths;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public BigDecimal getFactRefund() {
		return factRefund;
	}

	public void setFactRefund(BigDecimal factRefund) {
		this.factRefund = factRefund;
	}

	public RefundItem getItemRefundItem() {
		return itemRefundItem;
	}

	public void setItemRefundItem(RefundItem itemRefundItem) {
		this.itemRefundItem = itemRefundItem;
	}

	public List<Accessory> getImgs() {
		return imgs;
	}

	public void setImgs(List<Accessory> imgs) {
		this.imgs = imgs;
	}

	public BigDecimal getRefund() {
		return refund;
	}

	public void setRefund(BigDecimal refund) {
		this.refund = refund;
	}

	public RefundItem getRefundItem()
	{
		return refundItem;
	}

	public void setRefundItem(RefundItem refundItem)
	{
		this.refundItem = refundItem;
	}

	public OrderFormWithBLOBs getOf() {
		return of;
	}

	public void setOf(OrderFormWithBLOBs of) {
		this.of = of;
		if(of!=null)
		this.ofId = of.getId();
	}
    
}