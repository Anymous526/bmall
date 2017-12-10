package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: Navigation</p>
 * <p>Description: 免费导航设置信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月6日上午11:00:30
 * @version 1.0
 */
public class Navigation implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean display;	//是否显示

    private Integer location;

    private Integer newWin;		//是否新窗口打开

    private Integer sequence;

    private Boolean sysnav;		//是否只读

    private String title;

    private String type;

    private Long typeId;		//导航类型外键id

    private String url;		//外部url链接

    private String originalUrl;  
    

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

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getNewWin() {
        return newWin;
    }

    public void setNewWin(Integer newWin) {
        this.newWin = newWin;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getSysnav() {
        return sysnav;
    }

    public void setSysnav(Boolean sysnav) {
        this.sysnav = sysnav;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl == null ? null : originalUrl.trim();
    }
    
    
    
    private List<IntegralGoods> igs = new ArrayList<IntegralGoods>();     //与免费兑换页商品 一对多关联


	public List<IntegralGoods> getIntegralGoods() {
		return igs;
	}

	public void setIntegralGoods(List<IntegralGoods> integralGoods) {
		this.igs = integralGoods;
	}
    
    
}