package com.amall.core.web.virtual;

import java.util.Date;

/**
 * 
 * <p>Title: ShopData</p>
 * <p>Description: 数据库数据备份信息</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author  ljx
 * @date	2015-4-27下午6:34:14
 * @version 1.0
 */
public class ShopData {
	//备份名称
	private String name;
	//备份路径
	private String phyPath;
	//大小
	private double size;
	//总大小
	private int boundSize;
	//保存日期
	private Date addTime;

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhyPath() {
		return this.phyPath;
	}

	public void setPhyPath(String phyPath) {
		this.phyPath = phyPath;
	}

	public double getSize() {
		return this.size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public Date getAddTime() {
		return this.addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public int getBoundSize() {
		return this.boundSize;
	}

	public void setBoundSize(int boundSize) {
		this.boundSize = boundSize;
	}
}
