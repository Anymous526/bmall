package com.amall.core.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DouDetail implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

    private Long userId;

  /*  private Long dealUserId;*/

    private Date addtime;

    private Integer dealDouNum;

    private Integer totalDouNum;

    private BigDecimal price;

    private Boolean type;

    private String userName;
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}


	public Date getAddtime() {
		return addtime;
	}

	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Integer getDealDouNum() {
		return dealDouNum;
	}

	public void setDealDouNum(Integer dealDouNum) {
		this.dealDouNum = dealDouNum;
	}

	public Integer getTotalDouNum() {
		return totalDouNum;
	}

	public void setTotalDouNum(Integer totalDouNum) {
		this.totalDouNum = totalDouNum;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Boolean getType() {
		return type;
	}

	public void setType(Boolean type) {
		this.type = type;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}



   
}