package com.amall.core.lucene;

/**
 * 
 * <p>Title: LuceneVo</p>
 * <p>Description: 全文检索vo</p>
 * <p>Company: www.hg-sem.com</p> 
 * @author	ljx
 * @date	2015年7月11日下午3:47:19
 * @version 1.0
 */
public class LuceneVo {
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String TYPE = "type";
	public static final String CONTENT = "content";
	public static final String URL = "url";
	public static final String STORE_PRICE = "store_price";
	public static final String ADD_TIME = "add_time";
	public static final String GOODS_SALENUM = "goods_salenum";
	private Long vo_id;
	private String vo_type; // 类型
	private String vo_title; // 标题
	private String vo_content; // 内容
	private String vo_url; // url 路径
	private double vo_store_price; // 店铺价格
	private long vo_add_time; // 添加时间
	private int vo_goods_salenum; // 商品销售量

	public long getVo_add_time() {
		return this.vo_add_time;
	}

	public void setVo_add_time(long vo_add_time) {
		this.vo_add_time = vo_add_time;
	}

	public int getVo_goods_salenum() {
		return this.vo_goods_salenum;
	}

	public void setVo_goods_salenum(int vo_goods_salenum) {
		this.vo_goods_salenum = vo_goods_salenum;
	}

	public double getVo_store_price() {
		return this.vo_store_price;
	}

	public void setVo_store_price(double vo_store_price) {
		this.vo_store_price = vo_store_price;
	}

	public Long getVo_id() {
		return this.vo_id;
	}

	public void setVo_id(Long vo_id) {
		this.vo_id = vo_id;
	}

	public String getVo_type() {
		return this.vo_type;
	}

	public void setVo_type(String vo_type) {
		this.vo_type = vo_type;
	}

	public String getVo_title() {
		return this.vo_title;
	}

	public void setVo_title(String vo_title) {
		this.vo_title = vo_title;
	}

	public String getVo_content() {
		return this.vo_content;
	}

	public void setVo_content(String vo_content) {
		this.vo_content = vo_content;
	}

	public String getVo_url() {
		return this.vo_url;
	}

	public void setVo_url(String vo_url) {
		this.vo_url = vo_url;
	}
}
