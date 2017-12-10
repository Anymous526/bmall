package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * <p>Title: Evaluate</p>
 * <p>Description: 评价信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月1日下午2:42:35
 * @version 1.0
 */

public class Evaluate implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;		//买家评价时间

    private Boolean deletestatus;

    private Integer evaluateBuyerVal;		//买家评价   评价等级   好  中  差

    private Date evaluateSellerTime;	//卖家评价时间

    private Integer evaluateSellerVal;	//卖家评价信息

    private Integer evaluateStatus;		//评价状态     2  取消评价      1  禁止显示      0  正常显示

    private String evaluateType;		//评价类型

    private Long evaluateGoodsId;   //评价商品 外键id

    private Long evaluateSellerUserId;	//卖家用户外键id

    private Long evaluateUserId;	//评价用户外键id

    private Long ofId;			//订单外键id
    
    private Long img1id;
    
    private Long img2id;
    
    private Long img3id;

	private BigDecimal descriptionEvaluate;

    private BigDecimal serviceEvaluate;

    private BigDecimal shipEvaluate;

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

    public Integer getEvaluateBuyerVal() {
        return evaluateBuyerVal;
    }

    public void setEvaluateBuyerVal(Integer evaluateBuyerVal) {
        this.evaluateBuyerVal = evaluateBuyerVal;
    }

    public Date getEvaluateSellerTime() {
        return evaluateSellerTime;
    }

    public void setEvaluateSellerTime(Date evaluateSellerTime) {
        this.evaluateSellerTime = evaluateSellerTime;
    }

    public Integer getEvaluateSellerVal() {
        return evaluateSellerVal;
    }

    public void setEvaluateSellerVal(Integer evaluateSellerVal) {
        this.evaluateSellerVal = evaluateSellerVal;
    }

    public Integer getEvaluateStatus() {
        return evaluateStatus;
    }

    public void setEvaluateStatus(Integer evaluateStatus) {
        this.evaluateStatus = evaluateStatus;
    }

    public String getEvaluateType() {
        return evaluateType;
    }

    public void setEvaluateType(String evaluateType) {
        this.evaluateType = evaluateType == null ? null : evaluateType.trim();
    }

    public Long getEvaluateGoodsId() {
        return evaluateGoodsId;
    }

    public void setEvaluateGoodsId(Long evaluateGoodsId) {
        this.evaluateGoodsId = evaluateGoodsId;
    }

    public Long getEvaluateSellerUserId() {
        return evaluateSellerUserId;
    }

    public void setEvaluateSellerUserId(Long evaluateSellerUserId) {
        this.evaluateSellerUserId = evaluateSellerUserId;
    }

    public Long getEvaluateUserId() {
        return evaluateUserId;
    }

    public void setEvaluateUserId(Long evaluateUserId) {
        this.evaluateUserId = evaluateUserId;
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }
    
    public Long getImg1id() {
		return img1id;
	}

	public void setImg1id(Long img1id) {
		this.img1id = img1id;
	}

	public Long getImg2id() {
		return img2id;
	}
	
	public void setImg2id(Long img2id) {
		this.img2id = img2id;
	}

	public Long getImg3id() {
		return img3id;
	}

	public void setImg3id(Long img3id) {
		this.img3id = img3id;
	}

    public BigDecimal getDescriptionEvaluate() {
        return descriptionEvaluate;
    }

    public void setDescriptionEvaluate(BigDecimal descriptionEvaluate) {
        this.descriptionEvaluate = descriptionEvaluate;
    }

    public BigDecimal getServiceEvaluate() {
        return serviceEvaluate;
    }

    public void setServiceEvaluate(BigDecimal serviceEvaluate) {
        this.serviceEvaluate = serviceEvaluate;
    }

    public BigDecimal getShipEvaluate() {
        return shipEvaluate;
    }

    public void setShipEvaluate(BigDecimal shipEvaluate) {
        this.shipEvaluate = shipEvaluate;
    }
    
    
    private OrderFormWithBLOBs of;
    private User evaluate_user;
    private User evaluate_seller_user;
    private GoodsWithBLOBs evaluate_goods;		//被评价商品
    private Integer useful;
    private Integer parise;
    private Accessory img1;
    private Accessory img2;
    private Accessory img3;
    
	public Accessory getImg1() {
		return img1;
	}

	public void setImg1(Accessory img1) {
		this.img1 = img1;
		if(img1 != null){
			this.img1id = img1.getId();
		}
	}

	public Accessory getImg2() {
		return img2;
	}

	public void setImg2(Accessory img2) {
		this.img2 = img2;
		if(img2 != null){
			this.img2id = img2.getId();
		}
	}

	public Accessory getImg3() {
		return img3;
	}

	public void setImg3(Accessory img3) {
		this.img3 = img3;
		if(img3 != null){
			this.img3id = img3.getId();
		}
	}

	public Integer getUseful() {
		return useful;
	}

	public void setUseful(Integer useful) {
		this.useful = useful;
	}


	public Integer getParise() {
		return parise;
	}

	public void setParise(Integer parise) {
		this.parise = parise;
	}

	public OrderFormWithBLOBs getOf() {
		return of;
	}

	public void setOf(OrderFormWithBLOBs of) {
		this.of = of;
		if(of!=null)
			this.ofId = of.getId();
	}

	public User getEvaluate_user() {
		return evaluate_user;
	}

	public GoodsWithBLOBs getEvaluate_goods() {
		return evaluate_goods;
	}

	public void setEvaluate_goods(GoodsWithBLOBs evaluate_goods) {
		this.evaluate_goods = evaluate_goods;
		if(evaluate_goods !=null)
			this.evaluateGoodsId = evaluate_goods.getId();
	}

	public void setEvaluate_user(User evaluate_user) {
		this.evaluate_user = evaluate_user;
		if(evaluate_user!=null)
			this.evaluateUserId = evaluate_user.getId();
	}

	public User getEvaluate_seller_user() {
		return evaluate_seller_user;
	}

	public void setEvaluate_seller_user(User evaluate_seller_user) {
		this.evaluate_seller_user = evaluate_seller_user;
		if(evaluate_seller_user !=null)
			this.evaluateSellerUserId = evaluate_seller_user.getId();
	}
    
}