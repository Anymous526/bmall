package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class StoreVisit implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date visitTime; //访问时间

    private String userIp; //访问IP

    private Long storeId; //访问的店铺id

    private Long userId; //访问用户id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Date visitTime) {
        this.visitTime = visitTime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp == null ? null : userIp.trim();
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    private StoreWithBLOBs store;
    
    private User user;

	public StoreWithBLOBs getStore()
	{
		return store;
	}

	public void setStore(StoreWithBLOBs store)
	{
		this.store = store;
	}

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
    
}