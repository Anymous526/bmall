package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * <p>Title: Advert</p>
 * <p>Description: 广告信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月6日下午2:13:11
 * @version 1.0
 */

public class Advert implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date adBeginTime;	//广告开始时间

    private Integer adClickNum;	//  点击率

    private Date adEndTime;      //广告结束时间

    private Integer adGold;		//广告所需金币

    private Integer adSlideSequence; //幻灯片序号

    //amall_advert中字段ad_status的默认值从1改为0,1表示审核通过,0表示待审核,新增广告的时候应该默认是待审核状态
    private Integer adStatus;    //广告状态

    private String adText;		//默认文字

    private String adTitle;		//广告标题

    private String adUrl;		//广告链接

    private Long adAccId;		//图片外键id		

    private Long adApId;		//广告位置外键id

    private Long adUserId;		//广告用户外键id

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

    public Date getAdBeginTime() {
        return adBeginTime;
    }

    public void setAdBeginTime(Date adBeginTime) {
        this.adBeginTime = adBeginTime;
    }

    public Integer getAdClickNum() {
        return adClickNum;
    }

    public void setAdClickNum(Integer adClickNum) {
        this.adClickNum = adClickNum;
    }

    public Date getAdEndTime() {
        return adEndTime;
    }

    public void setAdEndTime(Date adEndTime) {
        this.adEndTime = adEndTime;
    }

    public Integer getAdGold() {
        return adGold;
    }

    public void setAdGold(Integer adGold) {
        this.adGold = adGold;
    }

    public Integer getAdSlideSequence() {
        return adSlideSequence;
    }

    public void setAdSlideSequence(Integer adSlideSequence) {
        this.adSlideSequence = adSlideSequence;
    }

    public Integer getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(Integer adStatus) {
        this.adStatus = adStatus;
    }

    public String getAdText() {
        return adText;
    }

    public void setAdText(String adText) {
        this.adText = adText == null ? null : adText.trim();
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle == null ? null : adTitle.trim();
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl == null ? null : adUrl.trim();
    }

    public Long getAdAccId() {
        return adAccId;
    }

    public void setAdAccId(Long adAccId) {
        this.adAccId = adAccId;
    }

    public Long getAdApId() {
        return adApId;
    }

    public void setAdApId(Long adApId) {
        this.adApId = adApId;
    }

    public Long getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(Long adUserId) {
        this.adUserId = adUserId;
    }
    
    
    
    
    
    private Accessory adAcc;     //广告图片
	private User adUser;		//广告用户
	private AdvertPositionWithBLOBs adAp;  //广告位置

	public Accessory getAdAcc() {
		return adAcc;
	}

	public void setAdAcc(Accessory adAcc) {
		this.adAcc = adAcc;
		if(adAcc!=null)
			this.adAccId = adAcc.getId();
	}

	public User getAdUser() {
		return adUser;
	}

	public void setAdUser(User adUser) {
		this.adUser = adUser;
		if(adUser !=null)
			this.adUserId = adUser.getId();
	}

	public AdvertPositionWithBLOBs getAdAp() {
		return adAp;
	}

	public void setAdAp(AdvertPositionWithBLOBs adAp) {
		this.adAp = adAp;
		if(adAp !=null)
			this.adApId = adAp.getId();
	}

	
}