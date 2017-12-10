package com.amall.core.solr;

import java.io.Serializable;

/**
 * 规格值
* @ClassName: SearchGoodsSpecificationPropertyVo 
* @Description: TODO
* @author lx
* @date 2016年1月7日 上午10:33:50 
*
 */
public class GoodsSpecificationPropertyVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long goodsSpecPropertyPKId;
	private String goodsSpecPropertyDeletestatus;
	private String goodsSpecPropertyValue;
	private Long specId;
	private Long specimageId;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsSpecPropertyPKId() {
		return goodsSpecPropertyPKId;
	}

	public void setGoodsSpecPropertyPKId(Long goodsSpecPropertyPKId) {
		this.goodsSpecPropertyPKId = goodsSpecPropertyPKId;
	}

	public String getGoodsSpecPropertyDeletestatus() {
		return goodsSpecPropertyDeletestatus;
	}

	public void setGoodsSpecPropertyDeletestatus(String goodsSpecPropertyDeletestatus) {
		this.goodsSpecPropertyDeletestatus = goodsSpecPropertyDeletestatus;
	}

	public String getGoodsSpecPropertyValue() {
		return goodsSpecPropertyValue;
	}

	public void setGoodsSpecPropertyValue(String goodsSpecPropertyValue) {
		this.goodsSpecPropertyValue = goodsSpecPropertyValue;
	}

	public Long getSpecId() {
		return specId;
	}

	public void setSpecId(Long specId) {
		this.specId = specId;
	}

	public Long getSpecimageId() {
		return specimageId;
	}

	public void setSpecimageId(Long specimageId) {
		this.specimageId = specimageId;
	}


}
