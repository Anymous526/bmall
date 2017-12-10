package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * 
 * <p>Title: GoodsReturn</p>
 * <p>Description: 退货信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月6日上午10:54:26
 * @version 1.0
 */

public class GoodsReturn implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String returnId;

    private Long ofId;

    private Long userId;

    private String returnInfo;

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

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId == null ? null : returnId.trim();
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo == null ? null : returnInfo.trim();
    }
    
    
    
    private User user;
    
    private OrderFormWithBLOBs of;
    
    private List<GoodsReturnItem> items = new ArrayList<GoodsReturnItem>();
    
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user!=null)
		this.userId = user.getId();
	}

	public List<GoodsReturnItem> getItems() {
		return items;
	}

	public void setItems(List<GoodsReturnItem> items) {
		this.items = items;
	}

	public OrderFormWithBLOBs getOf() {
		return of;
	}

	public void setOf(OrderFormWithBLOBs of) {
		this.of = of;
		if(of!=null)
		this.ofId = of.getId();
	}

}