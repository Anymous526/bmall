package com.amall.core.bean;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
/**
 * 退货信息
 * @author 
 *
 */
public class RefundGoods {
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private BigDecimal refund;

    private String refundLog;  // 退货说明

    private String refundType;	// 退货类型

    private Long ofId;  	// 订单号

    private Long refundUserId;

    private Long goodsId;

    private String imgPaths;

    private Integer status;

    private BigDecimal factRefund;  
    
    private String kuaidiNum;  // 物流单号
    
    private Long kuaidiId; // 快递公司ＩＤ
    
    private List<Accessory> imgs;

    private RefundItem itemRefundItem; // 退货原因

    private ExpressCompany company;   //快递公司
    
    
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

    public BigDecimal getRefund() {
        return refund;
    }

    public void setRefund(BigDecimal refund) {
        this.refund = refund;
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
        this.imgPaths = imgPaths == null ? null : imgPaths.trim();
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

	public List<Accessory> getImgs() {
		return imgs;
	}

	public void setImgs(List<Accessory> imgs) {
		this.imgs = imgs;
	}


	public RefundItem getItemRefundItem() {
		return itemRefundItem;
	}

	public void setItemRefundItem(RefundItem itemRefundItem) {
		this.itemRefundItem = itemRefundItem;
	}

	public String getKuaidiNum() {
		return kuaidiNum;
	}

	public void setKuaidiNum(String kuaidiNum) {
		this.kuaidiNum = kuaidiNum;
	}

	public Long getKuaidiId() {
		return kuaidiId;
	}

	public void setKuaidiId(Long kuaidiId) {
		this.kuaidiId = kuaidiId;
	}

	public ExpressCompany getCompany() {
		return company;
	}

	public void setCompany(ExpressCompany company) {
		this.company = company;
	}
}