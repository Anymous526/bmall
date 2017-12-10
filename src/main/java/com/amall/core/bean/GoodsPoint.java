package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 商品评分信息
 * @author ljx
 *
 */
public class GoodsPoint implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private BigDecimal descriptionEvaluate;  //描述

    private BigDecimal descriptionEvaluateHalfyear;

    private Integer descriptionEvaluateHalfyearCount1;

    private Integer descriptionEvaluateHalfyearCount2;

    private Integer descriptionEvaluateHalfyearCount3;

    private Integer descriptionEvaluateHalfyearCount4;

    private Integer descriptionEvaluateHalfyearCount5;

    private BigDecimal serviceEvaluate;	//服务

    private BigDecimal serviceEvaluateHalfyear;

    private Integer serviceEvaluateHalfyearCount1;

    private Integer serviceEvaluateHalfyearCount2;

    private Integer serviceEvaluateHalfyearCount3;

    private Integer serviceEvaluateHalfyearCount4;

    private Integer serviceEvaluateHalfyearCount5;

    private BigDecimal shipEvaluate;		//快递

    private BigDecimal shipEvaluateHalfyear;

    private Integer shipEvaluateHalfyearCount1;

    private Integer shipEvaluateHalfyearCount2;

    private Integer shipEvaluateHalfyearCount3;

    private Integer shipEvaluateHalfyearCount4;

    private Integer shipEvaluateHalfyearCount5;

    private Date stattime;

    private BigDecimal goodsEvaluate1;

    private Long goodsId;		//商品外键id

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

    public BigDecimal getDescriptionEvaluate() {
        return descriptionEvaluate;
    }

    public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
        this.descriptionEvaluate = descriptionEvaluate;
    }

    public BigDecimal getDescriptionEvaluateHalfyear() {
        return descriptionEvaluateHalfyear;
    }

    public void setDescriptionEvaluateHalfyear(BigDecimal descriptionEvaluateHalfyear) {
        this.descriptionEvaluateHalfyear = descriptionEvaluateHalfyear;
    }

    public Integer getDescriptionEvaluateHalfyearCount1() {
        return descriptionEvaluateHalfyearCount1;
    }

    public void setDescriptionEvaluateHalfyearCount1(Integer descriptionEvaluateHalfyearCount1) {
        this.descriptionEvaluateHalfyearCount1 = descriptionEvaluateHalfyearCount1;
    }

    public Integer getDescriptionEvaluateHalfyearCount2() {
        return descriptionEvaluateHalfyearCount2;
    }

    public void setDescriptionEvaluateHalfyearCount2(Integer descriptionEvaluateHalfyearCount2) {
        this.descriptionEvaluateHalfyearCount2 = descriptionEvaluateHalfyearCount2;
    }

    public Integer getDescriptionEvaluateHalfyearCount3() {
        return descriptionEvaluateHalfyearCount3;
    }

    public void setDescriptionEvaluateHalfyearCount3(Integer descriptionEvaluateHalfyearCount3) {
        this.descriptionEvaluateHalfyearCount3 = descriptionEvaluateHalfyearCount3;
    }

    public Integer getDescriptionEvaluateHalfyearCount4() {
        return descriptionEvaluateHalfyearCount4;
    }

    public void setDescriptionEvaluateHalfyearCount4(Integer descriptionEvaluateHalfyearCount4) {
        this.descriptionEvaluateHalfyearCount4 = descriptionEvaluateHalfyearCount4;
    }

    public Integer getDescriptionEvaluateHalfyearCount5() {
        return descriptionEvaluateHalfyearCount5;
    }

    public void setDescriptionEvaluateHalfyearCount5(Integer descriptionEvaluateHalfyearCount5) {
        this.descriptionEvaluateHalfyearCount5 = descriptionEvaluateHalfyearCount5;
    }

    public BigDecimal getServiceEvaluate() {
        return serviceEvaluate;
    }

    public void setServiceEvaluate(BigDecimal serviceEvaluate) {
        this.serviceEvaluate = serviceEvaluate;
    }

    public BigDecimal getServiceEvaluateHalfyear() {
        return serviceEvaluateHalfyear;
    }

    public void setServiceEvaluateHalfyear(BigDecimal serviceEvaluateHalfyear) {
        this.serviceEvaluateHalfyear = serviceEvaluateHalfyear;
    }

    public Integer getServiceEvaluateHalfyearCount1() {
        return serviceEvaluateHalfyearCount1;
    }

    public void setServiceEvaluateHalfyearCount1(Integer serviceEvaluateHalfyearCount1) {
        this.serviceEvaluateHalfyearCount1 = serviceEvaluateHalfyearCount1;
    }

    public Integer getServiceEvaluateHalfyearCount2() {
        return serviceEvaluateHalfyearCount2;
    }

    public void setServiceEvaluateHalfyearCount2(Integer serviceEvaluateHalfyearCount2) {
        this.serviceEvaluateHalfyearCount2 = serviceEvaluateHalfyearCount2;
    }

    public Integer getServiceEvaluateHalfyearCount3() {
        return serviceEvaluateHalfyearCount3;
    }

    public void setServiceEvaluateHalfyearCount3(Integer serviceEvaluateHalfyearCount3) {
        this.serviceEvaluateHalfyearCount3 = serviceEvaluateHalfyearCount3;
    }

    public Integer getServiceEvaluateHalfyearCount4() {
        return serviceEvaluateHalfyearCount4;
    }

    public void setServiceEvaluateHalfyearCount4(Integer serviceEvaluateHalfyearCount4) {
        this.serviceEvaluateHalfyearCount4 = serviceEvaluateHalfyearCount4;
    }

    public Integer getServiceEvaluateHalfyearCount5() {
        return serviceEvaluateHalfyearCount5;
    }

    public void setServiceEvaluateHalfyearCount5(Integer serviceEvaluateHalfyearCount5) {
        this.serviceEvaluateHalfyearCount5 = serviceEvaluateHalfyearCount5;
    }

    public BigDecimal getShipEvaluate() {
        return shipEvaluate;
    }

    public void setShipEvaluate(BigDecimal shipEvaluate) {
        this.shipEvaluate = shipEvaluate;
    }

    public BigDecimal getShipEvaluateHalfyear() {
        return shipEvaluateHalfyear;
    }

    public void setShipEvaluateHalfyear(BigDecimal shipEvaluateHalfyear) {
        this.shipEvaluateHalfyear = shipEvaluateHalfyear;
    }

    public Integer getShipEvaluateHalfyearCount1() {
        return shipEvaluateHalfyearCount1;
    }

    public void setShipEvaluateHalfyearCount1(Integer shipEvaluateHalfyearCount1) {
        this.shipEvaluateHalfyearCount1 = shipEvaluateHalfyearCount1;
    }

    public Integer getShipEvaluateHalfyearCount2() {
        return shipEvaluateHalfyearCount2;
    }

    public void setShipEvaluateHalfyearCount2(Integer shipEvaluateHalfyearCount2) {
        this.shipEvaluateHalfyearCount2 = shipEvaluateHalfyearCount2;
    }

    public Integer getShipEvaluateHalfyearCount3() {
        return shipEvaluateHalfyearCount3;
    }

    public void setShipEvaluateHalfyearCount3(Integer shipEvaluateHalfyearCount3) {
        this.shipEvaluateHalfyearCount3 = shipEvaluateHalfyearCount3;
    }

    public Integer getShipEvaluateHalfyearCount4() {
        return shipEvaluateHalfyearCount4;
    }

    public void setShipEvaluateHalfyearCount4(Integer shipEvaluateHalfyearCount4) {
        this.shipEvaluateHalfyearCount4 = shipEvaluateHalfyearCount4;
    }

    public Integer getShipEvaluateHalfyearCount5() {
        return shipEvaluateHalfyearCount5;
    }

    public void setShipEvaluateHalfyearCount5(Integer shipEvaluateHalfyearCount5) {
        this.shipEvaluateHalfyearCount5 = shipEvaluateHalfyearCount5;
    }

    public Date getStattime() {
        return stattime;
    }

    public void setStattime(Date stattime) {
        this.stattime = stattime;
    }

    public BigDecimal getGoodsEvaluate1() {
        return goodsEvaluate1;
    }

    public void setGoodsEvaluate1(BigDecimal goodsEvaluate1) {
        this.goodsEvaluate1 = goodsEvaluate1;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }
    
    private GoodsWithBLOBs goods;

	public GoodsWithBLOBs getGoods() {
		return goods;
	}

	public void setGoods(GoodsWithBLOBs goods) {
		this.goods = goods;
		if(goods !=null)
			this.goodsId = goods.getId();
	}
    
    
    
}