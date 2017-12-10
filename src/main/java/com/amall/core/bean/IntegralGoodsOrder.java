package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * 免费兑换 订单
 * @author ljx
 *
 */
public class IntegralGoodsOrder implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;			//兑换时间

    private Boolean deletestatus;

    private String igoOrderSn;		//兑换单号

    private Date igoPayTime;		//付款时间

    private String igoPayment;		

    private String igoShipCode;		//物流单号

    private Date igoShipTime;		//发货日期

    private Integer igoStatus;		//订单状态，如已付款、未付款、已发货等

    private Integer igoTotalIntegral;		//改为记录兑换商品的件数
    private Integer igoTotalGold;   //订单总礼品金数

    private BigDecimal igoTransFee;		//运费

    private Long igoAddrId;

    private Long igoUserId;

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

    public String getIgoOrderSn() {
        return igoOrderSn;
    }

    public void setIgoOrderSn(String igoOrderSn) {
        this.igoOrderSn = igoOrderSn == null ? null : igoOrderSn.trim();
    }

    public Date getIgoPayTime() {
        return igoPayTime;
    }

    public void setIgoPayTime(Date igoPayTime) {
        this.igoPayTime = igoPayTime;
    }

    public String getIgoPayment() {
        return igoPayment;
    }

    public void setIgoPayment(String igoPayment) {
        this.igoPayment = igoPayment == null ? null : igoPayment.trim();
    }

    public String getIgoShipCode() {
        return igoShipCode;
    }

    public void setIgoShipCode(String igoShipCode) {
        this.igoShipCode = igoShipCode == null ? null : igoShipCode.trim();
    }

    public Date getIgoShipTime() {
        return igoShipTime;
    }

    public void setIgoShipTime(Date igoShipTime) {
        this.igoShipTime = igoShipTime;
    }

    public Integer getIgoStatus() {
        return igoStatus;
    }

    public void setIgoStatus(Integer igoStatus) {
        this.igoStatus = igoStatus;
    }

    public Integer getIgoTotalIntegral() {
        return igoTotalIntegral;
    }

    public void setIgoTotalIntegral(Integer igoTotalIntegral) {
        this.igoTotalIntegral = igoTotalIntegral;
    }
    
    public Integer getIgoTotalGold() {
		return igoTotalGold;
	}

	public void setIgoTotalGold(Integer igoTotalGold) {
		this.igoTotalGold = igoTotalGold;
	}

	public BigDecimal getIgoTransFee() {
        return igoTransFee;
    }

    public void setIgoTransFee(BigDecimal igoTransFee) {
        this.igoTransFee = igoTransFee;
    }

    public Long getIgoAddrId() {
        return igoAddrId;
    }

    public void setIgoAddrId(Long long1) {
        this.igoAddrId = long1;
    }

    public Long getIgoUserId() {
        return igoUserId;
    }

    public void setIgoUserId(Long igoUserId) {
        this.igoUserId = igoUserId;
    }
    
    
    private User igoUser;
    private OrderAddress igoAddr;
    private List<IntegralGoodsCart> igoGcs = new ArrayList<IntegralGoodsCart>();
    
    private Long igId;				//兑换商品外键id
    private IntegralGoods ig ;      //兑换商品       与兑换订单一对一
    
    private Long ecId;			
    private ExpressCompany ec;		//快递公司
    
	public Long getIgId() {
		return igId;
	}

	public void setIgId(Long igId) {
		this.igId = igId;
	}

	public IntegralGoods getIg() {
		return ig;
	}

	public void setIg(IntegralGoods ig) {
		this.ig = ig;
		/*if(ig != null)
			this.igId = ig.getId();*/
	}

	public User getIgoUser() {
		return igoUser;
	}

	public void setIgoUser(User igoUser) {
		this.igoUser = igoUser;
		if(igoUser != null)
			this.igoUserId = igoUser.getId();
	}

	public OrderAddress getIgoAddr() {
		return igoAddr;
	}

	public void setIgoAddr(OrderAddress igoAddr) {
		this.igoAddr = igoAddr;
		if(igoAddr != null)
			this.igoAddrId = igoAddr.getId();
	}

	public List<IntegralGoodsCart> getIgoGcs() {
		return igoGcs;
	}

	public void setIgoGcs(List<IntegralGoodsCart> igoGcs) {
		this.igoGcs = igoGcs;
	}

	public Long getEcId() {
		return ecId;
	}

	public void setEcId(Long ecId) {
		this.ecId = ecId;
	}

	public ExpressCompany getEc() {
		return ec;
	}

	public void setEc(ExpressCompany ec) {
		this.ec = ec;
	}
    
}