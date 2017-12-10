package com.amall.core.solr;

import java.io.Serializable;

/**
 * 搜索商品分类VO
* @ClassName: SearchGoodsClassVo 
* @Description: TODO
* @author lx
* @date 2016年1月6日 上午11:46:57 
*
 */
public class GoodsClassVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long iconAccId;
	private String className;
	private Long firstGcImgId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIconAccId() {
		return iconAccId;
	}

	public void setIconAccId(Long iconAccId) {
		this.iconAccId = iconAccId;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public Long getFirstGcImgId() {
		return firstGcImgId;
	}

	public void setFirstGcImgId(Long firstGcImgId) {
		this.firstGcImgId = firstGcImgId;
	}

}
