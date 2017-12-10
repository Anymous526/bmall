package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: GoldLog</p>
 * <p>Description: 金币管理相关日志</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月23日下午7:46:02
 * @version 1.0
 */
public class GoldLog implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date glAdminTime;	//日志时间

    private Integer glCount;	//总数.对应GoldRecord中的金币数

    private Integer glMoney;	//人民币.对应GoldRecord中的人民币金额

    private String glPayment; // 支付方式.对应GoldRecord中的支付方式

    private Integer glType;	//支付类型

    private Long glAdminId; //对应User的id

    private Long glUserId; //对应User的id

    private Long grId; //对应GoldRecord的Id

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

    public Date getGlAdminTime() {
        return glAdminTime;
    }

    public void setGlAdminTime(Date glAdminTime) {
        this.glAdminTime = glAdminTime;
    }

    public Integer getGlCount() {
        return glCount;
    }

    public void setGlCount(Integer glCount) {
        this.glCount = glCount;
    }

    public Integer getGlMoney() {
        return glMoney;
    }

    public void setGlMoney(Integer glMoney) {
        this.glMoney = glMoney;
    }

    public String getGlPayment() {
        return glPayment;
    }

    public void setGlPayment(String glPayment) {
        this.glPayment = glPayment == null ? null : glPayment.trim();
    }

    public Integer getGlType() {
        return glType;
    }

    public void setGlType(Integer glType) {
        this.glType = glType;
    }

    public Long getGlAdminId() {
        return glAdminId;
    }

    public void setGlAdminId(Long glAdminId) {
        this.glAdminId = glAdminId;
    }

    public Long getGlUserId() {
        return glUserId;
    }

    public void setGlUserId(Long glUserId) {
        this.glUserId = glUserId;
    }

    public Long getGrId() {
        return grId;
    }

    public void setGrId(Long grId) {
        this.grId = grId;
    }
    
    
    private User glUser;
    private User glAdmin;
    private GoldRecord gr;

	public User getGlUser() {
		return glUser;
	}

	public void setGlUser(User glUser) {
		this.glUser = glUser;
		if(glUser!=null)
			this.glUserId = glUser.getId();
	}

	public User getGlAdmin() {
		return glAdmin;
	}

	public void setGlAdmin(User glAdmin) {
		this.glAdmin = glAdmin;
		if(glAdmin!=null)
			this.glAdminId = glAdmin.getId();
	}

	public GoldRecord getGr() {
		return gr;
	}

	public void setGr(GoldRecord gr) {
		this.gr = gr;
		if(gr!=null)
			this.grId = gr.getId();
	}
    
    
}