package com.amall.core.bean;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>Title: Report</p>
 * <p>Description: 举报 信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年6月25日下午7:18:34
 * @version 1.0
 */
public class Report implements Serializable{
    /** serialVersionUID*/
	private static final long serialVersionUID = 1L;
	
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date handleTime;

    private Integer result;

    private Integer status;

    private Long acc1Id;

    private Long acc2Id;

    private Long acc3Id;

    private Long goodsId;

    private Long subjectId;

    private Long userId;
    
    private Long storeId;

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

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAcc1Id() {
        return acc1Id;
    }

    public void setAcc1Id(Long acc1Id) {
        this.acc1Id = acc1Id;
    }

    public Long getAcc2Id() {
        return acc2Id;
    }

    public void setAcc2Id(Long acc2Id) {
        this.acc2Id = acc2Id;
    }

    public Long getAcc3Id() {
        return acc3Id;
    }

    public void setAcc3Id(Long acc3Id) {
        this.acc3Id = acc3Id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    
    public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}



	private GoodsWithBLOBs goods;
    private User user;
    private ReportSubject subject;
    private Accessory acc1;
    private Accessory acc2;
    private Accessory acc3;
    private StoreWithBLOBs store;

	public GoodsWithBLOBs getGoods() {
		return goods;
	}

	public void setGoods(GoodsWithBLOBs goods) {
		this.goods = goods;
		this.goodsId = goods.getId();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
		this.userId = user.getId();
	}

	public ReportSubject getSubject() {
		return subject;
	}

	public void setSubject(ReportSubject subject) {
		this.subject = subject;
		if(subject != null){
			this.subjectId = subject.getId();
		}
	}

	public Accessory getAcc1() {
		return acc1;
	}

	public void setAcc1(Accessory acc1) {
		this.acc1 = acc1;
		if(acc1 != null){
			this.acc1Id = acc1.getId();
		}
	}

	public Accessory getAcc2() {
		return acc2;
	}

	public void setAcc2(Accessory acc2) {
		this.acc2 = acc2;
		if(acc2 != null){
			this.acc2Id = acc2.getId();	
		}
	}

	public Accessory getAcc3() {
		return acc3;
	}

	public void setAcc3(Accessory acc3) {
		this.acc3 = acc3;
		if(acc3 != null){
			this.acc3Id = acc3.getId();	
		}
		
	}

	public StoreWithBLOBs getStore() {
		return store;
	}

	public void setStore(StoreWithBLOBs store) {
		this.store = store;
	}
    
    
}