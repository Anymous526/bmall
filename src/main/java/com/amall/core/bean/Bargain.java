package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Bargain implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date bargainTime;   //特价开始时间

    private Integer maximum;   //特价最多商品数

    private BigDecimal rebate;  //特价折扣

    private String state;
    
    private Date bargainEndTime;//如果为限时特价，折扣特价，则表示为特价结束时间.天天特价没有特价结束时间
    
    private Integer mark;//区分天天特价、限时特价、折扣特卖。为0表示天天特价，为1表示限时特价，为2表示折扣特卖
    
    private String bargainTitle;//特价标题
    
    private String bargainStatus;//发布状态
    
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

    public Date getBargainTime() {
        return bargainTime;
    }

    public void setBargainTime(Date bargainTime) {
        this.bargainTime = bargainTime;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public Date getBargainEndTime() {
		return bargainEndTime;
	}

	public void setBargainEndTime(Date bargainEndTime) {
		this.bargainEndTime = bargainEndTime;
	}

	public Integer getMark() {
		return mark;
	}

	public void setMark(Integer mark) {
		this.mark = mark;
	}

	public String getBargainTitle() {
		return bargainTitle;
	}

	public void setBargainTitle(String bargainTitle) {
		this.bargainTitle = bargainTitle;
	}

	public String getBargainStatus() {
		return bargainStatus;
	}

	public void setBargainStatus(String bargainStatus) {
		this.bargainStatus = bargainStatus;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}
    
}