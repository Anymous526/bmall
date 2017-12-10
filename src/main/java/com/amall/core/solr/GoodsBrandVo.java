package com.amall.core.solr;

import java.io.Serializable;

/**
 * 搜索商品品牌VO
 * 
 * @ClassName: SearchGoodsBrandVo
 * @Description: TODO
 * @author lx
 * @date 2016年1月6日 下午2:58:09
 *
 */
public class GoodsBrandVo implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long audit;
	private String goodsBrandName;
	private Long brandlogoId;
	private Long categoryId;
	private String firstWord;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAudit() {
		return audit;
	}

	public void setAudit(Long audit) {
		this.audit = audit;
	}

	public String getGoodsBrandName() {
		return goodsBrandName;
	}

	public void setGoodsBrandName(String goodsBrandName) {
		this.goodsBrandName = goodsBrandName;
	}

	public Long getBrandlogoId() {
		return brandlogoId;
	}

	public void setBrandlogoId(Long brandlogoId) {
		this.brandlogoId = brandlogoId;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getFirstWord() {
		return firstWord;
	}

	public void setFirstWord(String firstWord) {
		this.firstWord = firstWord;
	}

}
