package com.amall.core.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



/**
 * 
 * <p>Title: Complaint</p>
 * <p>Description: 投诉管理信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月24日下午5:20:54
 * @version 1.0
 */
public class Complaint implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date appealTime;	//申诉时间

    private Date handleTime;	//仲裁时间

    private Integer status;		//投诉状态 0 新投诉  1待申诉 2 对话中， 3 待仲裁  4 以完成

    private String type;      //类型

    private Long csId;

    private Long fromAcc1Id;

    private Long fromAcc2Id;

    private Long fromAcc3Id;

    private Long fromUserId;

    private Long handleUserId;		//仲裁管理员 外键id

    private Long ofId;

    private Long toAcc1Id;

    private Long toAcc2Id;

    private Long toAcc3Id;

    private Long toUserId;	//申诉人外键id

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

    public Date getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(Date appealTime) {
        this.appealTime = appealTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getCsId() {
        return csId;
    }

    public void setCsId(Long csId) {
        this.csId = csId;
    }

    public Long getFromAcc1Id() {
        return fromAcc1Id;
    }

    public void setFromAcc1Id(Long fromAcc1Id) {
        this.fromAcc1Id = fromAcc1Id;
    }

    public Long getFromAcc2Id() {
        return fromAcc2Id;
    }

    public void setFromAcc2Id(Long fromAcc2Id) {
        this.fromAcc2Id = fromAcc2Id;
    }

    public Long getFromAcc3Id() {
        return fromAcc3Id;
    }

    public void setFromAcc3Id(Long fromAcc3Id) {
        this.fromAcc3Id = fromAcc3Id;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(Long handleUserId) {
        this.handleUserId = handleUserId;
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public Long getToAcc1Id() {
        return toAcc1Id;
    }

    public void setToAcc1Id(Long toAcc1Id) {
        this.toAcc1Id = toAcc1Id;
    }

    public Long getToAcc2Id() {
        return toAcc2Id;
    }

    public void setToAcc2Id(Long toAcc2Id) {
        this.toAcc2Id = toAcc2Id;
    }

    public Long getToAcc3Id() {
        return toAcc3Id;
    }

    public void setToAcc3Id(Long toAcc3Id) {
        this.toAcc3Id = toAcc3Id;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }
    
    
    
    
    
    
    
    private User toUser;
    private User fromUser;
    private ComplaintSubject cs;
    private User handleUser;
    private Accessory fromAcc1;
    private Accessory fromAcc2;
    private Accessory fromAcc3;
    private Accessory toAcc1;
    private Accessory toAcc2;
    private Accessory toAcc3;
    private OrderFormWithBLOBs of;
    private List<ComplaintGoods> cgs = new ArrayList<ComplaintGoods>();

	public User getToUser() {
		return toUser;
	}

	public void setToUser(User toUser) {
		this.toUser = toUser;
		if(toUser != null)
			this.toUserId = toUser.getId();
	}

	public User getFromUser() {
		return fromUser;
	}

	public void setFromUser(User fromUser) {
		this.fromUser = fromUser;
		if(fromUser != null)
			this.fromUserId = fromUser.getId();
			
	}

	public ComplaintSubject getCs() {
		return cs;
	}

	public void setCs(ComplaintSubject cs) {
		this.cs = cs;
		if(cs != null)
			this.csId = cs.getId();
	}

	public User getHandleUser() {
		return handleUser;
	}

	public void setHandleUser(User handleUser) {
		this.handleUser = handleUser;
		if(handleUser != null)
			this.handleUserId = handleUser.getId();
	}

	public Accessory getFromAcc1() {
		return fromAcc1;
	}

	public void setFromAcc1(Accessory fromAcc1) {
		this.fromAcc1 = fromAcc1;
		if(fromAcc1 !=null)
			this.fromAcc1Id = fromAcc1.getId();
	}

	public Accessory getFromAcc2() {
		return fromAcc2;
	}

	public void setFromAcc2(Accessory fromAcc2) {
		this.fromAcc2 = fromAcc2;
		if(fromAcc2 !=null)
			this.fromAcc2Id = fromAcc2.getId();
	}

	public Accessory getFromAcc3() {
		return fromAcc3;
	}

	public void setFromAcc3(Accessory fromAcc3) {
		this.fromAcc3 = fromAcc3;
		if(fromAcc3 !=null)
			this.fromAcc3Id = fromAcc3.getId();
	}


	public Accessory getToAcc1() {
		return toAcc1;
	}

	public void setToAcc1(Accessory toAcc1) {
		this.toAcc1 = toAcc1;
		if(toAcc1 != null)
			this.toAcc1Id = toAcc1.getId();
	}

	public Accessory getToAcc2() {
		return toAcc2;
	}

	public void setToAcc2(Accessory toAcc2) {
		this.toAcc2 = toAcc2;
		if(toAcc2 != null)
			this.toAcc2Id = toAcc2.getId();
	}

	public Accessory getToAcc3() {
		return toAcc3;
	}

	public void setToAcc3(Accessory toAcc3) {
		this.toAcc3 = toAcc3;
		if(toAcc3 != null)
			this.toAcc3Id = toAcc3.getId();
	}

	public OrderFormWithBLOBs getOf() {
		return of;
	}

	public void setOf(OrderFormWithBLOBs of) {
		this.of = of;
		if(of !=null)
			this.ofId = of.getId();
	}

	public List<ComplaintGoods> getCgs() {
		return cgs;
	}

	public void setCgs(List<ComplaintGoods> cgs) {
		this.cgs = cgs;
	}
    
}