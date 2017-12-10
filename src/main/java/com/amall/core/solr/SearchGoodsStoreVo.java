package com.amall.core.solr;

import java.io.Serializable;
import java.util.List;
/**
 * 店铺搜索VO
* @ClassName: SearchGoodsStoreVo 
* @Description: TODO
* @author lx
* @date 2016年1月8日 下午5:01:38 
*
 */
public class SearchGoodsStoreVo implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO
	*/ 
	private static final long serialVersionUID = 1L;
	private List<GoodsStoreVo> listGoodsStoreVo;

	public List<GoodsStoreVo> getListGoodsStoreVo() {
		return listGoodsStoreVo;
	}

	public void setListGoodsStoreVo(List<GoodsStoreVo> listGoodsStoreVo) {
		this.listGoodsStoreVo = listGoodsStoreVo;
	}
	
	
	
}
