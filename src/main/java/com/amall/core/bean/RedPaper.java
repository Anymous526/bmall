package com.amall.core.bean;

import java.util.Date;

public class RedPaper {
    private Long id;
    /** 红包发送时间**/
    private Date addtime;
    /** 发送红包用户ID**/
    private Long sendUserId;
    /** 接收红包用户ID**/
    private Long reciveUserId;
    /** 红包礼品金数**/
    private Integer gold;
    /** 接收时间**/
    private Date reciveTime;
    /** 发送的红包ID**/
    private Long userRedPackgeId;
    
    private int sort;
    
    /** 发送红包用户**/
    private User sendUser;
    /** 接收红包用户**/
    private User reciveUser;
    /** 发送的红包**/
    private RedPackge userRedPackge;

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

    public Long getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(Long sendUserId) {
        this.sendUserId = sendUserId;
    }

    public Long getReciveUserId() {
        return reciveUserId;
    }

    public void setReciveUserId(Long reciveUserId) {
        this.reciveUserId = reciveUserId;
    }

    public Integer getGold() {
        return gold;
    }

    public void setGold(Integer gold) {
        this.gold = gold;
    }

    public Date getReciveTime() {
        return reciveTime;
    }

    public void setReciveTime(Date reciveTime) {
        this.reciveTime = reciveTime;
    }

    public Long getUserRedPackgeId() {
        return userRedPackgeId;
    }

    public void setUserRedPackgeId(Long userRedPackgeId) {
        this.userRedPackgeId = userRedPackgeId;
    }

	public int getSort() {
		return sort;
	}

	public void setSort(int sort) {
		this.sort = sort;
	}

	public User getSendUser() {
		return sendUser;
	}

	public void setSendUser(User sendUser) {
		this.sendUser = sendUser;
	}

	public User getReciveUser() {
		return reciveUser;
	}

	public void setReciveUser(User reciveUser) {
		this.reciveUser = reciveUser;
	}

	public RedPackge getUserRedPackge() {
		return userRedPackge;
	}

	public void setUserRedPackge(RedPackge userRedPackge) {
		this.userRedPackge = userRedPackge;
	}
}