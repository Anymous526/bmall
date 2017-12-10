package com.amall.core.solr;

import java.io.Serializable;

/**
 * 搜索商品分类-品牌VO
 * 
 * @ClassName: SearchGoodsTypeBrandVo
 * @Description: TODO
 * @author lx
 * @date 2016年1月6日 下午3:25:52
 *
 */
public class GoodsTypeBrandVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long goodsTypeBrandBrandId;
	private Long goodsTypeBrandTypeId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getGoodsTypeBrandBrandId() {
		return goodsTypeBrandBrandId;
	}

	public void setGoodsTypeBrandBrandId(Long goodsTypeBrandBrandId) {
		this.goodsTypeBrandBrandId = goodsTypeBrandBrandId;
	}

	public Long getGoodsTypeBrandTypeId() {
		return goodsTypeBrandTypeId;
	}

	public void setGoodsTypeBrandTypeId(Long goodsTypeBrandTypeId) {
		this.goodsTypeBrandTypeId = goodsTypeBrandTypeId;
	}

}
