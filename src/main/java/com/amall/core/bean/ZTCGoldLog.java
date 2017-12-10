package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: ZTCGoldLog</p>
 * <p>Description: 直通车金币使用日志</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月6日上午9:21:22
 * @version 1.0
 */
public class ZTCGoldLog implements Serializable{
	
	/** serialVersionUID*/
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String zglContent;  //日志内容

    private Integer zglGold;  //金币数量

    private Integer zglType;  //类型

    private Long zglGoodsId;  //商品外键id

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

    public String getZglContent() {
        return zglContent;
    }

    public void setZglContent(String zglContent) {
        this.zglContent = zglContent == null ? null : zglContent.trim();
    }

    public Integer getZglGold() {
        return zglGold;
    }

    public void setZglGold(Integer zglGold) {
        this.zglGold = zglGold;
    }

    public Integer getZglType() {
        return zglType;
    }

    public void setZglType(Integer zglType) {
        this.zglType = zglType;
    }

    public Long getZglGoodsId() {
        return zglGoodsId;
    }

    public void setZglGoodsId(Long zglGoodsId) {
        this.zglGoodsId = zglGoodsId;
    }
    
    
    
    private Goods zglGoods;

	public Goods getZglGoods() {
		return zglGoods;
	}

	public void setZglGoods(Goods zglGoods) {
		this.zglGoods = zglGoods;
		this.zglGoodsId = zglGoods.getId();
	}

}