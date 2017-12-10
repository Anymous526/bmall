package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: Activity</p>
 * <p>Description: 活动相关信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午6:37:22
 * @version 1.0
 */
public class Activity implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date acBeginTime;	//开始时间

    private Date acEndTime;		//结束时间

    private Integer acSequence;	//序号

    private Integer acStatus;	//审核状态

    private String acTitle;		//活动标题

    private Long acAccId;

    private BigDecimal acRebate;

    private String acContent;		//活动内容

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

    public Date getAcBeginTime() {
        return acBeginTime;
    }

    public void setAcBeginTime(Date acBeginTime) {
        this.acBeginTime = acBeginTime;
    }

    public Date getAcEndTime() {
        return acEndTime;
    }

    public void setAcEndTime(Date acEndTime) {
        this.acEndTime = acEndTime;
    }

    public Integer getAcSequence() {
        return acSequence;
    }

    public void setAcSequence(Integer acSequence) {
        this.acSequence = acSequence;
    }

    public Integer getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(Integer acStatus) {
        this.acStatus = acStatus;
    }

    public String getAcTitle() {
        return acTitle;
    }

    public void setAcTitle(String acTitle) {
        this.acTitle = acTitle == null ? null : acTitle.trim();
    }

    public Long getAcAccId() {
        return acAccId;
    }

    public void setAcAccId(Long acAccId) {
        this.acAccId = acAccId;
    }

    public BigDecimal getAcRebate() {
        return acRebate;
    }

    public void setAcRebate(BigDecimal acRebate) {
        this.acRebate = acRebate;
    }

    public String getAcContent() {
        return acContent;
    }

    public void setAcContent(String acContent) {
        this.acContent = acContent == null ? null : acContent.trim();
    }
    
    
    private List<ActivityGoods> ags;
    private Accessory acAcc;

	public List<ActivityGoods> getAgs() {
		return ags;
	}

	public void setAgs(List<ActivityGoods> ags) {
		this.ags = ags;
	}

	public Accessory getAcAcc() {
		return acAcc;
	}

	public void setAcAcc(Accessory acAcc) {
		this.acAcc = acAcc;
		this.acAccId = acAcc.getId();
	}
    
    
    
}