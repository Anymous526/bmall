package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: WaterMark</p>
 * <p>Description: 图片水印 设置信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午2:39:33
 * @version 1.0
 */
public class WaterMark implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Float wmImageAlpha;		//透明度

    private Boolean wmImageOpen;	//是否开启水印图片

    private Integer wmImagePos;		//图片水印位置

    private String wmText;		//水印文字

    private String wmTextColor;	//颜色

    private String wmTextFont;	//字体

    private Integer wmTextFontSize; //字体大小

    private Boolean wmTextOpen;		//是否开启水印文字

    private Integer wmTextPos;	//文字水印位置

    private Long storeId;	//店铺外键id

    private Long wmImageId;	//图片外键id

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

    public Float getWmImageAlpha() {
        return wmImageAlpha;
    }

    public void setWmImageAlpha(Float wmImageAlpha) {
        this.wmImageAlpha = wmImageAlpha;
    }

    public Boolean getWmImageOpen() {
        return wmImageOpen;
    }

    public void setWmImageOpen(Boolean wmImageOpen) {
        this.wmImageOpen = wmImageOpen;
    }

    public Integer getWmImagePos() {
        return wmImagePos;
    }

    public void setWmImagePos(Integer wmImagePos) {
        this.wmImagePos = wmImagePos;
    }

    public String getWmText() {
        return wmText;
    }

    public void setWmText(String wmText) {
        this.wmText = wmText == null ? null : wmText.trim();
    }

    public String getWmTextColor() {
        return wmTextColor;
    }

    public void setWmTextColor(String wmTextColor) {
        this.wmTextColor = wmTextColor == null ? null : wmTextColor.trim();
    }

    public String getWmTextFont() {
        return wmTextFont;
    }

    public void setWmTextFont(String wmTextFont) {
        this.wmTextFont = wmTextFont == null ? null : wmTextFont.trim();
    }

    public Integer getWmTextFontSize() {
        return wmTextFontSize;
    }

    public void setWmTextFontSize(Integer wmTextFontSize) {
        this.wmTextFontSize = wmTextFontSize;
    }

    public Boolean getWmTextOpen() {
        return wmTextOpen;
    }

    public void setWmTextOpen(Boolean wmTextOpen) {
        this.wmTextOpen = wmTextOpen;
    }

    public Integer getWmTextPos() {
        return wmTextPos;
    }

    public void setWmTextPos(Integer wmTextPos) {
        this.wmTextPos = wmTextPos;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getWmImageId() {
        return wmImageId;
    }

    public void setWmImageId(Long wmImageId) {
        this.wmImageId = wmImageId;
    }
    
    
    
    private Accessory wmImage;
    private Store store;

	public Accessory getWmImage() {
		return wmImage;
	}

	public void setWmImage(Accessory wmImage) {
		this.wmImage = wmImage;
		this.wmImageId = wmImage.getId();
	}

	public Store getStore() {
		return store;
	}

	public void setStore(Store store) {
		this.store = store;
		this.storeId = store.getId();
	}
	
    
}