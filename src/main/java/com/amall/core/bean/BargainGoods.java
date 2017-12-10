
package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 * 
 * <p>Title: BargainGoods</p>
 * <p>Description: 特价商品信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午7:35:43
 * @version 1.0
 */
public class BargainGoods implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private BigDecimal bgPrice;//商品的Goods价格*折扣

    private Integer bgStatus;	//审核状态    0待审核    -1审核拒绝     1 审核通过

    private Date bgTime;//特价时间bargain_time

    private Long bgAdminUserId;

    private Long bgGoodsId;

    private Integer bgCount;

    private BigDecimal bgRebate;//商品的折扣

    private Date auditTime;
    
    private Long alImgId;	//图片外键Id
    
    private Integer mark;//区分天天特价、限时特价、折扣特卖。为0表示天天特价，为1表示限时特价，为2表示折扣特卖
    
    private String bargainGoodsStatus;
    
    private Date closeTime;

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

    public BigDecimal getBgPrice() {
        return bgPrice;
    }

    public void setBgPrice(BigDecimal bgPrice) {
        this.bgPrice = bgPrice;
    }

    public Integer getBgStatus() {
        return bgStatus;
    }

    public void setBgStatus(Integer bgStatus) {
        this.bgStatus = bgStatus;
    }

    public Date getBgTime() {
        return bgTime;
    }

    public void setBgTime(Date bgTime) {
        this.bgTime = bgTime;
    }

    public Long getBgAdminUserId() {
        return bgAdminUserId;
    }

    public void setBgAdminUserId(Long bgAdminUserId) {
        this.bgAdminUserId = bgAdminUserId;
    }

    public Long getBgGoodsId() {
        return bgGoodsId;
    }

    public void setBgGoodsId(Long bgGoodsId) {
        this.bgGoodsId = bgGoodsId;
    }

    public Integer getBgCount() {
        return bgCount;
    }

    public void setBgCount(Integer bgCount) {
        this.bgCount = bgCount;
    }

    public BigDecimal getBgRebate() {
        return bgRebate;
    }

    public void setBgRebate(BigDecimal bgRebate) {
        this.bgRebate = bgRebate;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
    
    
    
    private Date bgEndTime;
    
    public Date getBgEndTime() {
		return bgEndTime;
	}

	public void setBgEndTime(Date bgEndTime) {
		this.bgEndTime = bgEndTime;
	}

	

	public Long getAlImgId() {
		return alImgId;
	}

	public void setAlImgId(Long alImgId) {
		this.alImgId = alImgId;
	}


	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}



	private User bgAdminUser;
    private GoodsWithBLOBs bgGoods;
    private Accessory alImg;

	public User getBgAdminUser() {
		return bgAdminUser;
	}

	public void setBgAdminUser(User bgAdminUser) {
		this.bgAdminUser = bgAdminUser;
		if(bgAdminUser != null)
			this.bgAdminUserId = bgAdminUser.getId();
	}

	public GoodsWithBLOBs getBgGoods() {
		return bgGoods;
	}

	public void setBgGoods(GoodsWithBLOBs bgGoods) {
		this.bgGoods = bgGoods;
		if(bgGoods!=null){
			this.bgGoodsId = bgGoods.getId();
		}
	}

	public Accessory getAlImg() {
		return alImg;
	}

	public void setAlImg(Accessory alImg) {
		this.alImg = alImg;
	}

	public String getBargainGoodsStatus() {
		return bargainGoodsStatus;
	}

	public void setBargainGoodsStatus(String bargainGoodsStatus) {
		this.bargainGoodsStatus = bargainGoodsStatus;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
    
}