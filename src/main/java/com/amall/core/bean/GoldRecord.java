package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;

public class GoldRecord implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date goldAdminTime;

    private Integer goldCount;  //金币数

    private Integer goldMoney;  //人民币金额
    /*
    #if($!obj.goldPayStatus==2)
        收款完成才增加GoldLog，并且GoldLog中的glType=0
        #end
        #if($!obj.goldPayStatus==1)
        等待审核
        #end
        #if($!obj.goldPayStatus==0)
        等待支付
        #end*/
    private Integer goldPayStatus;//金币支付状态
   /* #if($!obj.goldPayment=="outline")
        #set($goldPayment="线下支付")
      #end
      #if($!obj.goldPayment=="alipay")
        #set($goldPayment="支付宝")
      #end
      #if($!obj.goldPayment=="tenpay")
        #set($goldPayment="财付通")
      #end
      #if($!obj.goldPayment=="bill")
        #set($goldPayment="快钱")
      #end
      #if($!obj.goldPayment=="chinabank")
        #set($goldPayment="银联在线")
      #end*/
    private String goldPayment;  //描述

    private String goldSn;		//获取途径  //system:系统管理员  login：登陆用户

    /**
     * 当goldPayStatus==2.goldStatus才为1
     */
    private Integer goldStatus;  //金币状态

    private Long goldAdminId;  //User表的Id

    private Long goldUserId;   //User表的Id

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

    public Date getGoldAdminTime() {
        return goldAdminTime;
    }

    public void setGoldAdminTime(Date goldAdminTime) {
        this.goldAdminTime = goldAdminTime;
    }

    public Integer getGoldCount() {
        return goldCount;
    }

    public void setGoldCount(Integer goldCount) {
        this.goldCount = goldCount;
    }

    public Integer getGoldMoney() {
        return goldMoney;
    }

    public void setGoldMoney(Integer goldMoney) {
        this.goldMoney = goldMoney;
    }

    public Integer getGoldPayStatus() {
        return goldPayStatus;
    }

    public void setGoldPayStatus(Integer goldPayStatus) {
        this.goldPayStatus = goldPayStatus;
    }

    public String getGoldPayment() {
        return goldPayment;
    }

    public void setGoldPayment(String goldPayment) {
        this.goldPayment = goldPayment == null ? null : goldPayment.trim();
    }

    public String getGoldSn() {
        return goldSn;
    }

    public void setGoldSn(String goldSn) {
        this.goldSn = goldSn == null ? null : goldSn.trim();
    }

    public Integer getGoldStatus() {
        return goldStatus;
    }

    public void setGoldStatus(Integer goldStatus) {
        this.goldStatus = goldStatus;
    }

    public Long getGoldAdminId() {
        return goldAdminId;
    }

    public void setGoldAdminId(Long goldAdminId) {
        this.goldAdminId = goldAdminId;
    }

    public Long getGoldUserId() {
        return goldUserId;
    }

    public void setGoldUserId(Long goldUserId) {
        this.goldUserId = goldUserId;
    }
    
    
    
    private GoldLog log;
    private User goldAdmin;
    private User goldUser;
    
	public GoldLog getLog() {
		return log;
	}

	public void setLog(GoldLog log) {
		this.log = log;
	}

	public User getGoldAdmin() {
		return goldAdmin;
	}

	public void setGoldAdmin(User goldAdmin) {
		this.goldAdmin = goldAdmin;
		if(goldAdmin!=null)
		{
			this.setGoldAdminId(goldAdmin.getId());
		}
	}

	public User getGoldUser() {
		return goldUser;
	}

	public void setGoldUser(User goldUser) {
		this.goldUser = goldUser;
		if(goldUser.getId() !=null){
			this.goldUserId = goldUser.getId();
		}
		
	}
}