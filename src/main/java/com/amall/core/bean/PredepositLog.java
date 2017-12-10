package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;



/**
 * 
 * <p>Title: PredepositLog</p>
 * <p>Description: 提现日志</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月25日下午7:34:17
 * @version 1.0
 */
public class PredepositLog implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;		//申请事件

    private Boolean deletestatus;

    private BigDecimal pdLogAmount;	//

    private String pdOpType;

    private String pdType;

    private Long pdLogAdminId;	

    private Long pdLogUserId;

    private Long predepositId;

    private String pdLogInfo;

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

    public BigDecimal getPdLogAmount() {
        return pdLogAmount;
    }

    public void setPdLogAmount(BigDecimal pdLogAmount) {
        this.pdLogAmount = pdLogAmount;
    }

    public String getPdOpType() {
        return pdOpType;
    }

    public void setPdOpType(String pdOpType) {
        this.pdOpType = pdOpType == null ? null : pdOpType.trim();
    }

    public String getPdType() {
        return pdType;
    }

    public void setPdType(String pdType) {
        this.pdType = pdType == null ? null : pdType.trim();
    }

    public Long getPdLogAdminId() {
        return pdLogAdminId;
    }

    public void setPdLogAdminId(Long pdLogAdminId) {
        this.pdLogAdminId = pdLogAdminId;
    }

    public Long getPdLogUserId() {
        return pdLogUserId;
    }

    public void setPdLogUserId(Long pdLogUserId) {
        this.pdLogUserId = pdLogUserId;
    }

    public Long getPredepositId() {
        return predepositId;
    }

    public void setPredepositId(Long predepositId) {
        this.predepositId = predepositId;
    }

    public String getPdLogInfo() {
        return pdLogInfo;
    }

    public void setPdLogInfo(String pdLogInfo) {
        this.pdLogInfo = pdLogInfo == null ? null : pdLogInfo.trim();
    }
    
    
    
    
    private User pdLoguser;
    private User pdLogadmin;
    private Predeposit predeposit;

	public User getPdLoguser() {
		return pdLoguser;
	}

	public void setPdLoguser(User pdLoguser) {
		this.pdLoguser = pdLoguser;
		if(pdLoguser!=null)
		{
			this.pdLogUserId = pdLoguser.getId();
		}
	}

	public User getPdLogadmin() {
		return pdLogadmin;
	}

	public void setPdLogadmin(User pdLogadmin) {
		this.pdLogadmin = pdLogadmin;
		if(pdLogadmin!=null)
		{
			this.pdLogAdminId = pdLogadmin.getId();
		}
	}

	public Predeposit getPredeposit() {
		return predeposit;
	}

	public void setPredeposit(Predeposit predeposit) {
		this.predeposit = predeposit;
		if(predeposit!=null)
		{
			this.predepositId = predeposit.getId();
		}
	}
    
    
    
}