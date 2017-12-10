package com.amall.core.lucene;

import java.util.ArrayList;
import java.util.List;

import com.amall.core.bean.GoodsWithBLOBs;
import com.amall.core.bean.StoreWithBLOBs;


/**
 * 
 * <p>Title: LuceneResult</p>
 * <p>Description: 商品、店铺 搜索结果封装类</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月11日下午4:28:37
 * @version 1.0
 */
public class LuceneResult {
	private List<LuceneVo> vo_list = new ArrayList<LuceneVo>() ;
	private int pages;		//总页数
	private int rows;		//总记录数
	private int currentPage;	//当前页号
	private int pageSize;		//分页尺寸
	private List<GoodsWithBLOBs> goods_list = new ArrayList<GoodsWithBLOBs>();  
	private List<StoreWithBLOBs> store_list = new ArrayList<StoreWithBLOBs>();

	public int getPages() {
		return this.pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getRows() {
		return this.rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getCurrentPage() {
		return this.currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<LuceneVo> getVo_list() {
		return this.vo_list;
	}

	public void setVo_list(List<LuceneVo> vo_list) {
		this.vo_list = vo_list;
	}
	/**获取搜索后的商品结果  */
	public List<GoodsWithBLOBs> getGoods_list() {
		return goods_list;
	}
	/**设置搜索后的商品结果  */
	public void setGoods_list(List<GoodsWithBLOBs> goods_list) {
		this.goods_list = goods_list;
	}
	
	/**获取搜索后的店铺结果  */
	public List<StoreWithBLOBs> getStore_list() {
		return store_list;
	}

	/**设置搜索后的店铺结果  */
	public void setStore_list(List<StoreWithBLOBs> store_list) {
		this.store_list = store_list;
	}

	
}
