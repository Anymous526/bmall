package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: AdvertPosition</p>
 * <p>Description: 广告位信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月6日下午3:19:52
 * @version 1.0
 */
public class AdvertPosition implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String apAccUrl;  //广告图片链接地址

    private Integer apHeight;	//广告图片高度

    private Integer apPrice;	//价格

    private Integer apSaleType;	//出售类型

    private Integer apShowType;	//展示方式

    private Integer apStatus;	//是否启用

    private Integer apSysType;  //系统广告

    private String apText;	//默认文字

    private String apTitle;		//标题

    private String apType;		//广告类型

    private Integer apUseStatus;	//广告位用户状态

    private Integer apWidth;		//广告位宽度

    private Long apAccId;			//广告位图片外键id
    
    private String apMark;         //新增字段，广告位标识位置（首页、团购页、订制页还是新品页）

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

    public String getApAccUrl() {
        return apAccUrl;
    }

    public void setApAccUrl(String apAccUrl) {
        this.apAccUrl = apAccUrl == null ? null : apAccUrl.trim();
    }

    public Integer getApHeight() {
        return apHeight;
    }

    public void setApHeight(Integer apHeight) {
        this.apHeight = apHeight;
    }

    public Integer getApPrice() {
        return apPrice;
    }

    public void setApPrice(Integer apPrice) {
        this.apPrice = apPrice;
    }

    public Integer getApSaleType() {
        return apSaleType;
    }

    public void setApSaleType(Integer apSaleType) {
        this.apSaleType = apSaleType;
    }

    public Integer getApShowType() {
        return apShowType;
    }

    public void setApShowType(Integer apShowType) {
        this.apShowType = apShowType;
    }

    public Integer getApStatus() {
        return apStatus;
    }

    public void setApStatus(Integer apStatus) {
        this.apStatus = apStatus;
    }

    public Integer getApSysType() {
        return apSysType;
    }

    public void setApSysType(Integer apSysType) {
        this.apSysType = apSysType;
    }

    public String getApText() {
        return apText;
    }

    public void setApText(String apText) {
        this.apText = apText == null ? null : apText.trim();
    }

    public String getApTitle() {
        return apTitle;
    }

    public void setApTitle(String apTitle) {
        this.apTitle = apTitle == null ? null : apTitle.trim();
    }

    public String getApType() {
        return apType;
    }

    public void setApType(String apType) {
        this.apType = apType == null ? null : apType.trim();
    }

    public Integer getApUseStatus() {
        return apUseStatus;
    }

    public void setApUseStatus(Integer apUseStatus) {
        this.apUseStatus = apUseStatus;
    }

    public Integer getApWidth() {
        return apWidth;
    }

    public void setApWidth(Integer apWidth) {
        this.apWidth = apWidth;
    }

    public Long getApAccId() {
        return apAccId;
    }

    public void setApAccId(Long apAccId) {
        this.apAccId = apAccId;
    }
    
	public String getApMark() {
		return apMark;
	}

	public void setApMark(String apMark) {
		this.apMark = apMark;
	}











	private Accessory apAcc;  //广告图片

	public Accessory getApAcc() {
		return apAcc;
	}

	public void setApAcc(Accessory apAcc) {
		this.apAcc = apAcc;
		if(apAcc!=null)
		{
			this.apAccId = apAcc.getId();
		}
	}
    
    
    
}