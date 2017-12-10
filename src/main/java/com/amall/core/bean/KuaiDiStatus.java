package com.amall.core.bean;

import java.util.Date;

/**
 * 快递状态
 * <p>Title: KuaiDiStatus</p>
 * <p>Description: 用于保存快递的状态如:在途,揽件,疑难等</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	guoxiangjun
 * @date	2015年8月12日上午10:25:59
 * @version 1.0
 */
public class KuaiDiStatus {
	
	private Long  id;
	private String kuaidiNum;
	private String company;
	private String status;
	private Date time;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKuaidiNum() {
		return kuaidiNum;
	}
	public void setKuaidiNum(String kuaidiNum) {
		this.kuaidiNum = kuaidiNum;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

}
