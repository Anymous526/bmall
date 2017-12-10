package com.amall.core.bean;

import java.util.Date;

public class SellerAccount {
    private Long id;

    private Date addtime;
    
    //权限资源
    private String resource;
    
    //权限资源类型(PC,ANDROID,IOS)
    private String type;
    
    //商家店铺
    private Long storeId;
    
    //子账号
    private Long userId;
    
    //子账号所属商家
    private Long belongUserId;
    
    //子账号状态(1,启用,2,停用)
    private Integer status;

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

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource == null ? null : resource.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
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

    public Long getBelongUserId() {
        return belongUserId;
    }

    public void setBelongUserId(Long belongUserId) {
        this.belongUserId = belongUserId;
    }
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    private User user;
    private User belongUser; 
    private StoreWithBLOBs store;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		if(user !=null)
			this.userId= user.getId();
	}
	
	public User getBelongUser() {
		return belongUser;
	}

	public void setBelongUser(User belongUser) {
		this.belongUser = belongUser;
		if(belongUser != null){
			this.belongUserId = belongUser.getId();
		}
	}

	public void setStore(StoreWithBLOBs store) {
		this.store = store;
		if(store!=null){
			this.storeId = store.getId();
		}
	}

	public StoreWithBLOBs getStore() {
		return store;
	}
}