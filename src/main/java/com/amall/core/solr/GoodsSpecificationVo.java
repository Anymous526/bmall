package com.amall.core.solr;

import java.io.Serializable;

/**
 * 商品规格
* @ClassName: SearchGoodsSpecificationVo 
* @Description: TODO
* @author lx
* @date 2016年1月7日 上午10:18:08 
*
 */
public class GoodsSpecificationVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long goodsSpecificationPKId;
	private String goodsSpecificationName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsSpecificationPKId() {
		return goodsSpecificationPKId;
	}

	public void setGoodsSpecificationPKId(Long goodsSpecificationPKId) {
		this.goodsSpecificationPKId = goodsSpecificationPKId;
	}

	public String getGoodsSpecificationName() {
		return goodsSpecificationName;
	}

	public void setGoodsSpecificationName(String goodsSpecificationName) {
		this.goodsSpecificationName = goodsSpecificationName;
	}

}
