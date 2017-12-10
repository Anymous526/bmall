package com.amall.core.solr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 商品品牌搜索VO
* @ClassName: SearchGoodsBrandVo 
* @Description: TODO
* @author lx
* @date 2016年1月8日 下午4:01:07 
*
 */
public class SearchGoodsBrandVo implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private GoodsBrandVo goodsBrandVo = null;
	private Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> listSpecs = null;
	private List<GoodsVo> listSearchGoodsVo = null;
	//查询到商品的总记录数
	private int totalRows;

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public GoodsBrandVo getGoodsBrandVo() {
		return goodsBrandVo;
	}

	public void setGoodsBrandVo(GoodsBrandVo goodsBrandVo) {
		this.goodsBrandVo = goodsBrandVo;
	}

	public Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> getListSpecs() {
		return listSpecs;
	}

	public void setListSpecs(Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> listSpecs) {
		this.listSpecs = listSpecs;
	}

	public List<GoodsVo> getListSearchGoodsVo() {
		return listSearchGoodsVo;
	}

	public void setListSearchGoodsVo(List<GoodsVo> listSearchGoodsVo) {
		this.listSearchGoodsVo = listSearchGoodsVo;
	}

}
