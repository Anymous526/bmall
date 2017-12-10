package com.amall.core.solr;

import java.io.Serializable;
import java.util.List;

public class SearchGoodsSpecVo implements Serializable {

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private List<GoodsClassVo> listGoodsClassVo = null;
	private List<GoodsBrandVo> listGoodsBrandVo = null;
	private List<GoodsVo> listGoodsVo = null;
	//查询到商品的总记录数
	private int totalRows;

	public int getTotalRows() {
		return totalRows;
	}

	public void setTotalRows(int totalRows) {
		this.totalRows = totalRows;
	}

	public List<GoodsClassVo> getListGoodsClassVo() {
		return listGoodsClassVo;
	}

	public void setListGoodsClassVo(List<GoodsClassVo> listGoodsClassVo) {
		this.listGoodsClassVo = listGoodsClassVo;
	}

	public List<GoodsBrandVo> getListGoodsBrandVo() {
		return listGoodsBrandVo;
	}

	public void setListGoodsBrandVo(List<GoodsBrandVo> listGoodsBrandVo) {
		this.listGoodsBrandVo = listGoodsBrandVo;
	}

	public List<GoodsVo> getListGoodsVo() {
		return listGoodsVo;
	}

	public void setListGoodsVo(List<GoodsVo> listGoodsVo) {
		this.listGoodsVo = listGoodsVo;
	}

}
