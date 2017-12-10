package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class SystemMsgRecord implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addTime; //添加时间

    private Date readTime; //发送时间

    private Long userId;

    private Boolean readStatus;
    
    private Long msgId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getReadTime() {
        return readTime;
    }

    public void setReadTime(Date readTime) {
        this.readTime = readTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Boolean getReadStatus() {
        return readStatus;
    }

    public void setReadStatus(Boolean readStatus) {
        this.readStatus = readStatus;
    }
    
    public Long getMsgId()
	{
		return msgId;
	}

	public void setMsgId(Long msgId)
	{
		this.msgId = msgId;
	}



	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}
    
	private SystemMsg msg;

	public SystemMsg getMsg()
	{
		return msg;
	}

	public void setMsg(SystemMsg msg)
	{
		this.msg = msg;
	}
	
}