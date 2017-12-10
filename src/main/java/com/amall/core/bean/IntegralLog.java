package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class IntegralLog implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer integral;

    private String type;

    private Long integralUserId;

    private Long operateUserId;

    private String content;
    
    private String orderId;

    
    
    public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getIntegralUserId() {
        return integralUserId;
    }

    public void setIntegralUserId(Long integralUserId) {
        this.integralUserId = integralUserId;
    }

    public Long getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Long operateUserId) {
        this.operateUserId = operateUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
    
    
    
    private User operateUser;
    private User integralUser;

	public User getOperateUser() {
		return operateUser;
	}

	public void setOperateUser(User operateUser) {
		this.operateUser = operateUser;
	}

	public User getIntegralUser() {
		return integralUser;
	}

	public void setIntegralUser(User integralUser) {
		this.integralUser = integralUser;
		this.integralUserId=integralUser.getId();
		this.deletestatus=integralUser.getDeletestatus();
	}
    
}