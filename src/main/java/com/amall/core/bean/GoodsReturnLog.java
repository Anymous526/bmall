package com.amall.core.bean;

import java.util.Date;

/**
 * 
 * <p>Title: GoodsReturnLog</p>
 * <p>Description: 退货日志</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月6日上午10:55:16
 * @version 1.0
 */
public class GoodsReturnLog {
	private Long id;

	private Date addtime;

	private Boolean deletestatus;

	private Long grId;

	private Long ofId;

	private Long returnUserId;


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

	public Long getGrId() {
		return grId;
	}

	public void setGrId(Long grId) {
		this.grId = grId;
	}

	public Long getOfId() {
		return ofId;
	}

	public void setOfId(Long ofId) {
		this.ofId = ofId;
	}

	public Long getReturnUserId() {
		return returnUserId;
	}

	public void setReturnUserId(Long returnUserId) {
		this.returnUserId = returnUserId;
	}

	
	
	
	
	private GoodsReturn gr;
	private OrderFormWithBLOBs of;
	private User returnUser;
	
	public GoodsReturn getGr() {
		return gr;
	}

	public void setGr(GoodsReturn gr) {
		this.gr = gr;
		if(gr!=null)
		this.grId = gr.getId();
	}
	
	public OrderFormWithBLOBs getOf() {
		return of;
	}

	public void setOf(OrderFormWithBLOBs of) {
		this.of = of;
		if(of!=null)
		this.ofId = of.getId();
	}

	public User getReturnUser() {
		return returnUser;
	}

	public void setReturnUser(User returnUser) {
		this.returnUser = returnUser;
		if(returnUser!=null)
		this.returnUserId = returnUser.getId();
	}

}