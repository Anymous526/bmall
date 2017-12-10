package com.amall.core.solr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
/**
 * 分类搜索返回的VO
* @ClassName: SearchGoodsClassVo 
* @Description: TODO
* @author lx
* @date 2016年1月7日 下午5:02:29 
*
 */
public class SearchGoodsClassVo implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	//分类搜索下的品牌
	private List<GoodsBrandVo> listSearchGoodsBrandsVo = null;
	//分类搜索下的规格
	private Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> listSpecs = null;
	//分类搜索下的商品
	private List<GoodsVo> listSearchGoodsVo = null;
	//查询到商品的总记录数
	private int totalRows;
	
	public List<GoodsBrandVo> getListSearchGoodsBrandsVo() {
		return listSearchGoodsBrandsVo;
	}
	public void setListSearchGoodsBrandsVo(List<GoodsBrandVo> listSearchGoodsBrandsVo) {
		this.listSearchGoodsBrandsVo = listSearchGoodsBrandsVo;
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
	public int getTotalRows() {
		return totalRows;
	}
	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}
	
}
