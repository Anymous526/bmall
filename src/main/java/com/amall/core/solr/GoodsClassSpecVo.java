package com.amall.core.solr;

import java.io.Serializable;

/**
 * 商品分类-规格
 * 
 * @ClassName: SearchGoodsClassSpecVo
 * @Description: TODO
 * @author lx
 * @date 2016年1月7日 上午9:44:16
 *
 */
public class GoodsClassSpecVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long goodsClassSpecPKId;
	private Long classId;
	private Long specificationId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsClassSpecPKId() {
		return goodsClassSpecPKId;
	}

	public void setGoodsClassSpecPKId(Long goodsClassSpecPKId) {
		this.goodsClassSpecPKId = goodsClassSpecPKId;
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public Long getSpecificationId() {
		return specificationId;
	}

	public void setSpecificationId(Long specificationId) {
		this.specificationId = specificationId;
	}

}
