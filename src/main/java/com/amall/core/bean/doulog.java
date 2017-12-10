package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class doulog  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Date addtime;

    private Date dealtime;

    private Long userId;

    private Integer dealUserId;

    private Integer totalDouNum;

    private Integer dealDouNum;

    private BigDecimal price;

    private Short type;
    
    private BigDecimal tax;
    
    private User buyUser; 

    private User selleUser;
    
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

    public Date getDealtime() {
        return dealtime;
    }

    public void setDealtime(Date dealtime) {
        this.dealtime = dealtime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getDealUserId() {
        return dealUserId;
    }

    public void setDealUserId(Integer dealUserId) {
        this.dealUserId = dealUserId;
    }

    public Integer getTotalDouNum() {
        return totalDouNum;
    }

    public void setTotalDouNum(Integer totalDouNum) {
        this.totalDouNum = totalDouNum;
    }

    public Integer getDealDouNum() {
        return dealDouNum;
    }

    public void setDealDouNum(Integer dealDouNum) {
        this.dealDouNum = dealDouNum;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Short getType() {
        return type;
    }

    public void setType(Short type) {
        this.type = type;
    }

	public BigDecimal getTax() {
		return tax;
	}

	public void setTax(BigDecimal tax) {
		this.tax = tax;
	}

	public User getBuyUser() {
		return buyUser;
	}

	public void setBuyUser(User buyUser) {
		this.buyUser = buyUser;
	}

	public User getSelleUser() {
		return selleUser;
	}

	public void setSelleUser(User selleUser) {
		this.selleUser = selleUser;
	}
    
    
}