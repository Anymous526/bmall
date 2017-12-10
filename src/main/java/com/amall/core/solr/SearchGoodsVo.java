package com.amall.core.solr;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class SearchGoodsVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private List<GoodsVo> listGoodsVo = null;
	private List<GoodsBrandVo> listGoodsBrandVo = null;
	private List<GoodsClassVo> listGoodsClassVo = null;
	private Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> mapSpecs = null;
	//查询到商品的总记录数
	private int totalRows;

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<GoodsVo> getListGoodsVo() {
		return listGoodsVo;
	}

	public void setListGoodsVo(List<GoodsVo> listGoodsVo) {
		this.listGoodsVo = listGoodsVo;
	}

	public List<GoodsBrandVo> getListGoodsBrandVo() {
		return listGoodsBrandVo;
	}

	public void setListGoodsBrandVo(List<GoodsBrandVo> listGoodsBrandVo) {
		this.listGoodsBrandVo = listGoodsBrandVo;
	}

	public List<GoodsClassVo> getListGoodsClassVo() {
		return listGoodsClassVo;
	}

	public void setListGoodsClassVo(List<GoodsClassVo> listGoodsClassVo) {
		this.listGoodsClassVo = listGoodsClassVo;
	}

	public Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> getMapSpecs() {
		return mapSpecs;
	}

	public void setMapSpecs(Map<GoodsSpecificationVo, List<GoodsSpecificationPropertyVo>> mapSpecs) {
		this.mapSpecs = mapSpecs;
	}

}
