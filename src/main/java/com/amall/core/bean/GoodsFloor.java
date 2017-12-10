package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 商品楼层信息
 * @author ljx
 *
 */
public class GoodsFloor implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String gfCss;	//楼层样式

    private Boolean gfDisplay;	//是否显示

    private Integer gfGoodsCount;	//楼层商品总数

    private Integer gfLevel;		//楼层等级

    private String gfName;		//楼层名称

    private Integer gfSequence;		//楼层序号

    private Long parentId;		//父级楼层外键id

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

    public String getGfCss() {
        return gfCss;
    }

    public void setGfCss(String gfCss) {
        this.gfCss = gfCss == null ? null : gfCss.trim();
    }

    public Boolean getGfDisplay() {
        return gfDisplay;
    }

    public void setGfDisplay(Boolean gfDisplay) {
        this.gfDisplay = gfDisplay;
    }

    public Integer getGfGoodsCount() {
        return gfGoodsCount;
    }

    public void setGfGoodsCount(Integer gfGoodsCount) {
        this.gfGoodsCount = gfGoodsCount;
    }

    public Integer getGfLevel() {
        return gfLevel;
    }

    public void setGfLevel(Integer gfLevel) {
        this.gfLevel = gfLevel;
    }

    public String getGfName() {
        return gfName;
    }

    public void setGfName(String gfName) {
        this.gfName = gfName == null ? null : gfName.trim();
    }

    public Integer getGfSequence() {
        return gfSequence;
    }

    public void setGfSequence(Integer gfSequence) {
        this.gfSequence = gfSequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
    
    //楼层标示,使用字符串来匹配   区分不同页面
    private String gfMark;

	public String getGfMark() {
		return gfMark;
	}

	public void setGfMark(String gfMark) {
		this.gfMark = gfMark;
	}
    
   
    
}